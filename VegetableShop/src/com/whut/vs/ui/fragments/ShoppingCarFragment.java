package com.whut.vs.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.GoodsListViewPagerAdapter;
import com.whut.vs.ui.FillInOrderActivity;
import com.whut.vs.ui.MainActivity;

/**
 * @description 主页面的购物车Fragment
 * @author tianbiao
 */
public class ShoppingCarFragment extends Fragment implements View.OnClickListener{
	
	private final static int LOGIN_REQUEST_CODE = 1;
	
	private View rootView;
	private Activity parentActivity;
	
	private ViewPager shoppingcar_viewpager;
	
	private List<Fragment> lists = new ArrayList<Fragment>();
	
	//控件
	private Button shoppingcar_but1;
	private Button shoppingcar_but2;
	private Button shoppingCarAccount;
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.layout_shopping_car, null);
			FinalActivity.initInjectedView(this, rootView);
		}
		

		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}
		
		return rootView;
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		init();
		
		//已购商品
		PurchaseFragment purfragerment = new PurchaseFragment();
		//积分兑换商品
		RedeemMerchandiseFragment rmfragment = new RedeemMerchandiseFragment();
		
		lists.add(purfragerment);
		lists.add(rmfragment);
		shoppingcar_viewpager.setOffscreenPageLimit(0);
		shoppingcar_viewpager.setAdapter(new GoodsListViewPagerAdapter(getChildFragmentManager(),lists));
		shoppingcar_viewpager
		.setOnPageChangeListener(new ShoppingCarOnPageChangeListener());
		shoppingcar_viewpager.setCurrentItem(0);
		shoppingcar_but1.setTextColor(this.getResources().getColor(
				R.color.blue));
//		shoppingcar_but1.setBackground(this.getResources().getDrawable(
//				R.drawable.selected_line));
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
	
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
    
    
	/****
	 * 初始化页面控件
	 */
	private void init() {
		shoppingcar_viewpager = (ViewPager) parentActivity.findViewById(R.id.shoppingcar_viewpager);
		shoppingcar_but1 = (Button)parentActivity.findViewById(R.id.shoppingcar_bt1);
		shoppingcar_but2 = (Button)parentActivity.findViewById(R.id.shoppingcar_bt2);
		shoppingCarAccount = (Button) parentActivity.findViewById(R.id.shopping_car_account);
		
		shoppingcar_but1.setOnClickListener(this);
		shoppingcar_but2.setOnClickListener(this);
		shoppingCarAccount.setOnClickListener(this);
	}
	
	/**
	 * 页面滑动监听
	 */
	class ShoppingCarOnPageChangeListener implements OnPageChangeListener{
		@Override
		public void onPageScrollStateChanged(int arg0) {

		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {

		}

		@Override
		public void onPageSelected(int index) {
			// TODO Auto-generated method stub
			switch (index) {
			case 0:
				reset();
				shoppingcar_but1.setTextColor(ShoppingCarFragment.this
						.getResources().getColor(R.color.blue));
//				shoppingcar_but1.setBackground(ShoppingCarFragment.this
//						.getResources().getDrawable(R.drawable.selected_line));
				break;
			case 1:
				reset();
				shoppingcar_but2.setTextColor(ShoppingCarFragment.this
						.getResources().getColor(R.color.blue));
//				shoppingcar_but2.setBackground(ShoppingCarFragment.this
//						.getResources().getDrawable(R.drawable.selected_line));
				break;

			default:
				break;
			}
		}
	}
	
	/**
	 * 重置头标状态
	 */
	public void reset(){
		shoppingcar_but1.setTextColor(this.getResources().getColor(
				R.color.black));
		shoppingcar_but2.setTextColor(this.getResources().getColor(
				R.color.black));
		
		shoppingcar_but1.setBackgroundColor(this.getResources().getColor(
				R.color.gray));
		shoppingcar_but2.setBackgroundColor(this.getResources().getColor(
				R.color.gray));
		
	}
	
	
	/*****
	 * 控件点击事情监听
	 * @param view
	 */
	public void onClick(View view){
		switch (view.getId()) {
		case R.id.shoppingcar_bt1:
			shoppingcar_viewpager.setCurrentItem(0);
			break;
		case R.id.shoppingcar_bt2:
			shoppingcar_viewpager.setCurrentItem(1);
			break;
		case R.id.shopping_car_account:
			Intent intent = new Intent();
			intent.setClass(parentActivity, FillInOrderActivity.class);
			startActivity(intent);

		default:
			break;
		}
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
	}

}
