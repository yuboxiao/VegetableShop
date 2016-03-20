package com.whut.vs.ui;

import java.util.ArrayList;
import java.util.List;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.GoodsListViewPagerAdapter;
import com.whut.vs.ui.fragments.NewGoodsFragment;
import com.whut.vs.ui.fragments.HotSaleFragment;
import com.whut.vs.ui.fragments.PriceFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

/*** 
 * @author xiongbin
 * @date 2016-3-18
 * @description 商品列表页面
 */
public class GoodsListActivity extends FragmentActivity {

	private ViewPager mPager;//页卡内容
    private List<Fragment> fragments; // Tab页面列表
    private TextView t1, t2, t3;// 页卡头标
    private int currIndex = 0;// 当前页卡编号

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goods_list);

		init();
	}

	private void init() {
		t1 = (TextView) findViewById(R.id.tv_goods_list_top_bar_left);
		t2 = (TextView) findViewById(R.id.tv_goods_list_top_bar_center);
		t3 = (TextView) findViewById(R.id.tv_goods_list_top_bar_right);

		t1.setOnClickListener(new MyOnClickListener(0));
		t2.setOnClickListener(new MyOnClickListener(1));
		t3.setOnClickListener(new MyOnClickListener(2));

		setViewColorAndBkg(t1,R.color.blue, R.drawable.layout_goods_list_top_bar_left_shape1);
		setViewColorAndBkg(t2, R.color.black, R.drawable.layout_goods_list_top_bar_center_shape2);
		setViewColorAndBkg(t3, R.color.black, R.drawable.layout_goods_list_top_bar_right_shape2);

		// 初始化ViewPager
		mPager = (ViewPager) findViewById(R.id.viewpager_goods_list);
		fragments = new ArrayList<Fragment>();
		fragments.add(new NewGoodsFragment());
		fragments.add(new HotSaleFragment());
		fragments.add(new PriceFragment());
		mPager.setAdapter(new GoodsListViewPagerAdapter(getSupportFragmentManager(),fragments));
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}


	/***
	 * 设置按钮字体和背景
	 * @param textColor
	 * @param textBkg
	 */
	private void setViewColorAndBkg(TextView tv,int textColor,int viewBkg) {
		tv.setTextColor(getResources().getColor(textColor));
		tv.setBackgroundResource(viewBkg);
	}

	/**
	 * 头标点击监听
	 */
	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	};

	/**
	 * 页卡切换监听
	 */
	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int selectedIndex) {
			switch (selectedIndex) {
			case 0:
				setViewColorAndBkg(t1,R.color.blue, R.drawable.layout_goods_list_top_bar_left_shape1);
				setViewColorAndBkg(t2, R.color.black, R.drawable.layout_goods_list_top_bar_center_shape2);
				setViewColorAndBkg(t3, R.color.black, R.drawable.layout_goods_list_top_bar_right_shape2);
				break;
			case 1:
				setViewColorAndBkg(t2,R.color.blue, R.drawable.layout_goods_list_top_bar_center_shape1);
				setViewColorAndBkg(t1, R.color.black, R.drawable.layout_goods_list_top_bar_left_shape2);
				setViewColorAndBkg(t3, R.color.black, R.drawable.layout_goods_list_top_bar_right_shape2);
				break;
			case 2:
				setViewColorAndBkg(t3,R.color.blue, R.drawable.layout_goods_list_top_bar_right_shape1);
				setViewColorAndBkg(t1, R.color.black, R.drawable.layout_goods_list_top_bar_left_shape2);
				setViewColorAndBkg(t2, R.color.black, R.drawable.layout_goods_list_top_bar_center_shape2);
				break;
			default:
				break;
			}
			currIndex = selectedIndex;
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
