package com.whut.vs.ui.fragments;

import java.util.Arrays;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.ui.CreditMallActivity;
import com.whut.vs.ui.GoodsListActivity;
import com.whut.vs.ui.RechargeChoiceActivity;
import com.whut.vs.widgets.LoopSlidingView;

/**
 * @description 主页面的首页Fragment
 * @author xiongbin
 */
public class MainPageFragment extends Fragment {
	@ViewInject(id = R.id.loopSlidingView)
	private LoopSlidingView lsv;// banner滑动

	@ViewInject(id = R.id.tv_main_page_instant_buying, click = "onClick")
	private TextView tv_main_page_instant_buying;// 即时抢购

	@ViewInject(id = R.id.tv_main_page_fresh_fruits, click = "onClick")
	private TextView tv_main_page_fresh_fruits;// 新鲜水果

	@ViewInject(id = R.id.tv_main_page_recharge, click = "onClick")
	private TextView tv_main_page_recharge;// 充值

	@ViewInject(id = R.id.tv_main_page_credit_mall, click = "onClick")
	private TextView tv_main_page_credit_mall;// 积分商城

	private View rootView;
	private Activity parentActivity;

	private String[] imageUrls = {
			"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
			"http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
			"http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
			"http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
			"http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg" };

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.layout_main_page, null);
			FinalActivity.initInjectedView(this, rootView);
		}

		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}

		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();

		lsv.setImage(Arrays.asList(imageUrls));
	}

	@Override
	public void onPause() {
		super.onPause();
	}

	public void onClick(View view) {
		Intent intent;
		switch (view.getId()) {

		// 即时抢购
		case R.id.tv_main_page_instant_buying:
			break;

		// 新鲜水果
		case R.id.tv_main_page_fresh_fruits:
			intent = new Intent(parentActivity, GoodsListActivity.class);
			startActivity(intent);
			break;

		// 充值
		case R.id.tv_main_page_recharge:
			intent = new Intent(parentActivity, RechargeChoiceActivity.class);
			startActivity(intent);
			break;

		// 积分商城
		case R.id.tv_main_page_credit_mall:
			intent = new Intent(parentActivity, CreditMallActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
