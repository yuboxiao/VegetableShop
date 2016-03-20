package com.whut.vs.widgets;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalBitmap;
import android.content.Context;
import android.graphics.Matrix;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.whut.vegetableshop.R;


/**
 * @author xiongbin
 * @date 2015-07-08
 * @company 国程融通
 */
public class LoopSlidingView extends RelativeLayout {

	private FinalBitmap mFinalBitmap;
	private ViewPager mViewPager;
	private MyPagerAdapter mPagerAdapter;
	private List<ImageView> views = new ArrayList<ImageView>();
	private List<View> viewDots = new ArrayList<View>();
	private int currIndex = 0;//正播放的图片位置
	
	private LinearLayout bottomLayout;
	private Context mContext;
	
	private int pace;
	private Handler mHandler = new Handler();
	private Runnable mRunnable = new Runnable() {
		
		@Override
		public void run() {
			if (currIndex == 0) {
				pace = 1;
			}
			if (currIndex == views.size() - 1) {
				pace = -1;
			}
			currIndex += pace;
			mViewPager.setCurrentItem(currIndex);
			setViewDotsBackground();
			mHandler.postDelayed(mRunnable, 4000);
		}
	};

	public LoopSlidingView(Context context) {
		this(context, null);
	}

	public LoopSlidingView(Context context, AttributeSet attrs) {
		super(context, attrs);
		mContext = context;
		mViewPager = new ViewPager(context);
		RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		addView(mViewPager,params1);
		
		RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
		params2.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		params2.addRule(RelativeLayout.CENTER_HORIZONTAL);
		//params.rightMargin = 10;
		params2.bottomMargin = 10;
		bottomLayout = new LinearLayout(context);
		addView(bottomLayout,params2);	

		initFinalBitmap();
	}
	
	private void initFinalBitmap(){
		mFinalBitmap = FinalBitmap.create(mContext);
		//加载失败显示的图片
		mFinalBitmap.configLoadfailImage(R.drawable.white);
		//加载中显示的图片
		mFinalBitmap.configLoadingImage(R.drawable.white);
	}
	
	/****
	 * 添加需要轮播的图片集合
	 * @param data
	 */
	public void setImage(List<String> data){
		views.clear();
		viewDots.clear();
		bottomLayout.removeAllViews();
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(20,20);
		params.rightMargin = 10;
		params.leftMargin = 10;
		
		for(int i = 0;i < data.size();i++){
			ImageView view = new ImageView(mContext);
			mFinalBitmap.display(view, data.get(i));
			views.add(view);
			
			View viewDot = new View(mContext);
			if (i == 0) {
				viewDot.setBackgroundResource(R.drawable.icon_gallery_point_white);
			} else {
				viewDot.setBackgroundResource(R.drawable.icon_gallery_point_grey);
			}
			viewDots.add(viewDot);
			bottomLayout.addView(viewDot,params);
		}		
		mPagerAdapter = new MyPagerAdapter(views);
		mViewPager.setAdapter(mPagerAdapter);
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
		mViewPager.setCurrentItem(currIndex);
		mHandler.postDelayed(mRunnable, 4000);// 开启定时轮播
	}
	
	
	/****
	 * 释放资源
	 */
	public void destory(){
		mHandler.removeCallbacks(mRunnable);
	}
	
	/****
	 * 设置导航点背景颜色
	 */
	private void setViewDotsBackground(){
		for (int i = 0; i < viewDots.size(); i++) {
			if (i == currIndex) {
				viewDots.get(i).setBackgroundResource(R.drawable.icon_gallery_point_white);
			} else {
				viewDots.get(i).setBackgroundResource(R.drawable.icon_gallery_point_grey);
			}
		}
	}
	
	private class MyPagerAdapter extends PagerAdapter {
		private List<? extends View> views;

		public MyPagerAdapter(List<? extends View> views) {
			this.views = views;
		}

		@Override
		public int getCount() {
			return views.size();
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			ImageView view = (ImageView) views.get(position);
			view.setScaleType(ScaleType.FIT_XY);//使图片不按比例扩大/缩小到view的大小
			ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
			container.addView(view, 0, params);
			return views.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(views.get(position));
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}
		
	}
	
	private class MyOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageSelected(int arg0) {
			currIndex = arg0;
			setViewDotsBackground();
		}
		
	}

	
}
