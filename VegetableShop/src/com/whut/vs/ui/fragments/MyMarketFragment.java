package com.whut.vs.ui.fragments;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.ui.BalanceActivity;
import com.whut.vs.ui.FavoritesActivity;
import com.whut.vs.ui.FootPrintActivity;
import com.whut.vs.ui.LookOrderActivity;
import com.whut.vs.ui.MonthBillActivity;
import com.whut.vs.ui.OrderDetailsActivity;
import com.whut.vs.ui.SetAddressActivity;
import com.whut.vs.ui.SetPayPasswordActivity;
import com.whut.vs.ui.WaitEvaluateActivity;
import com.whut.vs.widgets.TitleBar;

/**
 * @description 主页面的我的菜场Fragment
 * @author cw
 */
public class MyMarketFragment extends Fragment {

	private View rootView;
	private Activity parentActivity;

	@ViewInject(id = R.id.iv_my_market_favorites, click = "onClick")
	private ImageView iv_my_market_favorites;// 收藏图标

	@ViewInject(id = R.id.tv_my_markets_vp_name)
	private TextView tv_my_markets_vp_name;// 会员名

	@ViewInject(id = R.id.tv_my_markets_vp_level)
	private TextView tv_my_markets_vp_level;// 会员等级

	@ViewInject(id = R.id.ll_my_market_integral_clicked)
	private LinearLayout ll__my_market_integral_clicked;// 可点击进入积分页面

	@ViewInject(id = R.id.tv_my_market_integral)
	private TextView tv_my_market_integral;// 积分

	@ViewInject(id = R.id.ll_my_market_balance_clicked, click = "onClick")
	private LinearLayout ll_my_market_balance_clicked;// 可点击进入余额页面

	@ViewInject(id = R.id.tv_my_market_balance)
	private TextView tv_my_market_balance;// 余额

	@ViewInject(id = R.id.ll_my_market_coupon_clicked, click = "onClick")
	private LinearLayout ll__my_market_coupon_clicked;// 可点击进入优惠券页面

	@ViewInject(id = R.id.tv_my_market_coupon)
	private TextView ll__my_market_coupon;// 优惠券

	@ViewInject(id = R.id.rl_my_market_seek_all_order, click = "onClick")
	private RelativeLayout rl_my_market_seek_all_order;// 查看全部订单

	@ViewInject(id = R.id.tv_my_market_wait_payment)
	private TextView tv_my_market_wait_payment;// 待付款

	@ViewInject(id = R.id.tv_my_market_wait_evaluate)
	private TextView tv_wait_evaluate;// 待评价

	@ViewInject(id = R.id.tv_my_market_wait_receiving)
	private TextView tv_wait_receiving;// 待收货

	@ViewInject(id = R.id.tv_my_market_return_goods)
	private TextView tv_my_market_return_goods;// 退货

	@ViewInject(id = R.id.rl_my_market_every_month_check, click = "onClick")
	private RelativeLayout rl_my_market_every_month_check;// 每月账单

	@ViewInject(id = R.id.rl_my_market_footer_print, click = "onClick")
	private RelativeLayout rl_my_market_footer_print;// 足迹

	@ViewInject(id = R.id.rl_my_market_pwd_setting, click = "onClick")
	private RelativeLayout rl_my_market_pwd_setting;// 设置支付密码

	@ViewInject(id = R.id.rl_my_market_receiving_address_setting, click = "onClick")
	private RelativeLayout rl_my_market_receiving_address_setting;// 设置收货地址

	@ViewInject(id = R.id.rl_my_market_phone)
	private RelativeLayout rl_my_market_phone;// 联系电话

	@ViewInject(id = R.id.btn_my_market_logout)
	private Button btn_my_market_logout;// 退出登录

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		if (rootView == null) {
			rootView = inflater.inflate(R.layout.fragment_my_market, null);
			FinalActivity.initInjectedView(this, rootView);
		}

		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}

		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onPause() {
		super.onPause();

	}

	private TitleBar.OnClickTitleBarListener titleBarListener = new TitleBar.OnClickTitleBarListener() {

		@Override
		public void onClickRightButton() {

		}

		@Override
		public void onClickLeftButton() {
		}
	};

	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {

		// 收藏夹
		case R.id.iv_my_market_favorites:
			intent = new Intent();
			intent.setClass(parentActivity, FavoritesActivity.class);
			startActivity(intent);
			break;

		// 积分
		case R.id.ll_my_market_integral_clicked:
			intent = new Intent(parentActivity, BalanceActivity.class);
			startActivity(intent);
			break;

		// 余额
		case R.id.ll_my_market_balance_clicked:
			intent = new Intent(parentActivity, BalanceActivity.class);
			startActivity(intent);
			break;

		// 优惠券
		case R.id.ll_my_market_coupon_clicked:
			intent = new Intent(parentActivity, BalanceActivity.class);
			startActivity(intent);
			break;

		// 查看全部订单
		case R.id.rl_my_market_seek_all_order:
			intent = new Intent(parentActivity, LookOrderActivity.class);
			startActivity(intent);
			break;

		// 待付款
		case R.id.tv_my_market_wait_payment:
			intent = new Intent();
			intent.setClass(parentActivity, WaitEvaluateActivity.class);
			startActivity(intent);
			break;

		// 待评价
		case R.id.tv_my_market_wait_evaluate:
			intent = new Intent();
			intent.setClass(parentActivity, WaitEvaluateActivity.class);
			startActivity(intent);
			break;

		// 待收货
		case R.id.tv_my_market_wait_receiving:
			intent = new Intent();
			intent.setClass(parentActivity, OrderDetailsActivity.class);
			startActivity(intent);
			break;

		// 退货
		case R.id.tv_my_market_return_goods:
			intent = new Intent();
			intent.setClass(parentActivity, OrderDetailsActivity.class);
			startActivity(intent);
			break;

		// 每月账单
		case R.id.rl_my_market_every_month_check:
			intent = new Intent();
			intent.setClass(parentActivity, MonthBillActivity.class);
			startActivity(intent);
			break;

		// 足迹
		case R.id.rl_my_market_footer_print:
			intent = new Intent();
			intent.setClass(parentActivity, FootPrintActivity.class);
			startActivity(intent);
			break;
		
		// 支付密码设置
		case R.id.rl_my_market_pwd_setting:
			intent = new Intent();
			intent.setClass(parentActivity, SetPayPasswordActivity.class);
			startActivity(intent);
			break;
		
		// 收货地址设置
		case R.id.rl_my_market_receiving_address_setting:
			intent = new Intent(parentActivity, SetAddressActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}

	}

}
