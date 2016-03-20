package com.whut.vs.ui.fragments;

import net.tsz.afinal.FinalActivity;

import com.whut.vegetableshop.R;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * һ����Ʒ������Fragment
 * @author yubo
 */
public class OneGoodsDetailFragment extends Fragment {

	private View mRootView;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if (mRootView == null) {
			mRootView = inflater.inflate(R.layout.fragment_goods_detail, null);
			FinalActivity.initInjectedView(this,mRootView);
		}
		ViewGroup parent = (ViewGroup) mRootView.getParent();
		if (parent != null) {
			parent.removeView(mRootView);
		}
		return mRootView;
	}

}
