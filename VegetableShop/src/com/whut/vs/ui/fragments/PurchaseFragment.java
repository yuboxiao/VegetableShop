package com.whut.vs.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.PurchaseAdapter;
import com.whut.vs.bean.PurchaseBean;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class PurchaseFragment extends Fragment implements OnItemClickListener {
	private ListView purchase_fragment_listview;
	
	private Activity parentActivity;
	private View rootView;
	
	private ListView purchaseFragmentListview;
	
	private PurchaseAdapter purchaseAdapter;
	
	private List<PurchaseBean> purchaseBeans = new ArrayList<PurchaseBean>();
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			 ViewGroup container,  Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.fragment_purchase, null);
			FinalActivity.initInjectedView(this, rootView);
		}
		

		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}
		
		return rootView;
	}

	@Override
	public void onActivityCreated( Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		initView();
		
		purchaseBeans.clear();
		
		PurchaseBean bean = new PurchaseBean();
		bean.setName("Ð¡°×²Ë");
		bean.setWeight("20kg");
		
		PurchaseBean bean2 = new PurchaseBean();
		bean2.setName("Ð¡°×²Ë");
		bean2.setWeight("20kg");
		
		PurchaseBean bean3 = new PurchaseBean();
		bean3.setName("Ð¡°×²Ë");
		bean3.setWeight("20kg");
		
		PurchaseBean bean4 = new PurchaseBean();
		bean4.setName("Ð¡°×²Ë");
		bean4.setWeight("20kg");
		
		purchaseBeans.add(bean);
		purchaseBeans.add(bean2);
		purchaseBeans.add(bean3);
		purchaseBeans.add(bean4);
		
		purchaseAdapter = new PurchaseAdapter(parentActivity,purchaseBeans);
		purchaseFragmentListview.setAdapter(purchaseAdapter);
		
	}
	
	

	private void initView() {

		purchaseFragmentListview = (ListView)PurchaseFragment.this.getView()
				.findViewById(R.id.fragment_purchase_listview);
		purchaseFragmentListview.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

		
	}
}
