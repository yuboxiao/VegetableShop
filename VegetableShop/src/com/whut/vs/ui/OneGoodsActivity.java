package com.whut.vs.ui;
import java.util.ArrayList;
import java.util.List;
import com.whut.vegetableshop.R;
import com.whut.vs.application.SApplication;
import com.whut.vs.ui.fragments.OneGoodsDetailFragment;
import com.whut.vs.ui.fragments.OneGoodsInfoFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
/**
 * 一个商品Activity 包含：<br/>
 * 1.商品简介Fragment   <br/>
 * 2.商品详情Fragment   <br/>
 * @author yubo
 */
public class OneGoodsActivity extends FinalActivity implements OnClickListener {

	private static final int ONE_GOODS_INFO_PAGE = 0;
	private static final int ONE_GOODS_DETAIL_PAGE= 1;
	
	private List<Fragment> mOneGoodsFragmentList;
	
	@ViewInject(id = R.id.vp_one_goods)
	private ViewPager mVpOneGoods;
	// 商品简介页
	@ViewInject(id = R.id.tv_one_goods_center_goods)
	private TextView tvOneGoodsInfo;
	// 商品详情页
	@ViewInject(id = R.id.tv_one_goods_center_detail)
	private TextView tvOneGoodsDetail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_goods);
		SApplication.getInstance().addActivity(this);
		init();
	}

	/**
	 * 初始化工作 <br/> 
	 * 1.添加fragmentList <br/> 
	 * 2.设置tv的点击监听   <br/> 
	 * 3.初始化viewpager  <br/> 
	 */
	private void init() {
		mOneGoodsFragmentList = new ArrayList<Fragment>();
		mOneGoodsFragmentList.add(new OneGoodsInfoFragment());
		mOneGoodsFragmentList.add(new OneGoodsDetailFragment());
		
		tvOneGoodsInfo.setOnClickListener(this);
		tvOneGoodsDetail.setOnClickListener(this);
		//默认商品简介页面被选中
		mVpOneGoods.setCurrentItem(ONE_GOODS_INFO_PAGE);
		mVpOneGoods.setAdapter(new OneGoodsInfoPagerAdapter(getSupportFragmentManager(),mOneGoodsFragmentList));
		mVpOneGoods.setOnPageChangeListener(new OneGoodsPagerChangeListener());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_one_goods_center_goods:
			setCheckedPageState(ONE_GOODS_INFO_PAGE);
			mVpOneGoods.setCurrentItem(ONE_GOODS_INFO_PAGE);
			break;

		case R.id.tv_one_goods_center_detail:
			setCheckedPageState(ONE_GOODS_DETAIL_PAGE);
			mVpOneGoods.setCurrentItem(ONE_GOODS_DETAIL_PAGE);
			break;
		}
	}
	
	public class OneGoodsInfoPagerAdapter extends FragmentPagerAdapter{

		private List<Fragment> mOneGoodsFragmentList;
		
		public OneGoodsInfoPagerAdapter(FragmentManager fm,List<Fragment> OneGoodsFragmentList) {
			super(fm);
			this.mOneGoodsFragmentList = OneGoodsFragmentList;
		}
		@Override
		public Fragment getItem(int position) {
			return mOneGoodsFragmentList.get(position);
		}
		@Override
		public int getCount() {
			return mOneGoodsFragmentList.size();
		}
	}
	
	public class  OneGoodsPagerChangeListener implements OnPageChangeListener{
		@Override
		public void onPageScrollStateChanged(int arg0) {}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}
		@Override
		public void onPageSelected(int index) {
			if(index == ONE_GOODS_INFO_PAGE || index == ONE_GOODS_DETAIL_PAGE){
				setCheckedPageState(index);
			}
		}
	}
	
	
	/**
	 * 给tab标签设置样式: <br/>
	 * 0代表商品简介页被选中 <br/>
	 * 1代表商品详情页被选中 <br/>
	 * @param checkedIndex 页面index 
	 */
	public void setCheckedPageState(int checkedIndex){
		switch (checkedIndex) {
		case ONE_GOODS_INFO_PAGE:
			tvOneGoodsInfo.setTextColor(Color.WHITE);
			tvOneGoodsDetail.setTextColor(Color.parseColor("#FF8888"));
			break;
		case ONE_GOODS_DETAIL_PAGE:
			tvOneGoodsInfo.setTextColor(Color.parseColor("#FF8888"));
			tvOneGoodsDetail.setTextColor(Color.WHITE);
			break;
		}
	}
}