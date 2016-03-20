package com.whut.vs.ui.fragments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.whut.vegetableshop.R;
import com.whut.vs.adapters.OneGoodsEvaluateAdapter;
import com.whut.vs.bean.OneGoodsEvaluateBean;
import com.whut.vs.widgets.LoopSlidingView;
import com.whut.vs.widgets.WrapContentListView;

/**
 * 一个商品的简介Fragment
 * @author yubo
 */
public class OneGoodsInfoFragment extends Fragment {

	@ViewInject(id = R.id.loopSlidingView_one_goods)
	private LoopSlidingView lsv;
	
	@ViewInject(id = R.id.wclv_one_goods_evaluate)
	private WrapContentListView lv_one_goods_evaluate;

	private OneGoodsEvaluateAdapter mOneGoodsEvaluateAdapter;
	private List<OneGoodsEvaluateBean> oneGoodsEvaluateBeans = new ArrayList<OneGoodsEvaluateBean>();

	private Activity parentActivity;
	private String[] imageUrls = {
			"http://img.taodiantong.cn/v55183/infoimg/2013-07/130720115322ky.jpg",
			"http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
			"http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
			"http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
			"http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg" };
	private View mRootView;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (mRootView == null) {
			mRootView = inflater.inflate(R.layout.fragment_goods_info, null);
			FinalActivity.initInjectedView(this,mRootView);
		}
		ViewGroup parent = (ViewGroup) mRootView.getParent();
		if (parent != null) {
			parent.removeView(mRootView);
		}
		return mRootView;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		lsv.setImage(Arrays.asList(imageUrls));
		for (int i = 0; i < 10; i++) {
			OneGoodsEvaluateBean bean = new OneGoodsEvaluateBean();
			bean.setPhone("13012345678");
			bean.setEvaluateContent("蜜桔很甜，感觉很划算");
			bean.setTime("20150311");
			bean.setEvaluateScore(4.2f);
			oneGoodsEvaluateBeans.add(bean);
		}
		mOneGoodsEvaluateAdapter = new OneGoodsEvaluateAdapter(parentActivity,
				oneGoodsEvaluateBeans);
		lv_one_goods_evaluate.setAdapter(mOneGoodsEvaluateAdapter);
	}
}
