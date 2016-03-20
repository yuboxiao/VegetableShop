package com.whut.vs.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.RedeemMerchandiseAdapter;
import com.whut.vs.bean.RedeemMerchandiseBean;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class RedeemMerchandiseFragment extends Fragment {

	private View rootView;
	private Activity parentActivity;
	
	@ViewInject(id = R.id.listview_fragment_redeem_merchandise)
	private ListView listview_fragment_redeem_merchandise;
	
	private RedeemMerchandiseAdapter rmAdapter;
	
	private List<RedeemMerchandiseBean> rmbeans= new ArrayList<RedeemMerchandiseBean>(); 
	
	@Override    
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.fragment_redeem_merchandise, null);
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
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		RedeemMerchandiseBean bean1 = new RedeemMerchandiseBean();
		bean1.setName("hha");
		
		RedeemMerchandiseBean bean2 = new RedeemMerchandiseBean();
		bean2.setName("hhei");
		
		rmbeans.add(bean1);
		rmbeans.add(bean2);
		
		rmAdapter = new RedeemMerchandiseAdapter(parentActivity, rmbeans);
		listview_fragment_redeem_merchandise.setAdapter(rmAdapter);
	}
}
