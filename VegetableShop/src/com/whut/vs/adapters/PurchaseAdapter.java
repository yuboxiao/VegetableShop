package com.whut.vs.adapters;

import java.util.List;

import android.content.Context;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.PurchaseBean;

public class PurchaseAdapter extends CustomAdapter<PurchaseBean> {
	
	public PurchaseAdapter(Context context,
			List<PurchaseBean> list) {
		super(context, list);
	}

	@Override
	public int obtainView() {
		return R.layout.adapter_purchase_item ;
	}

	@Override
	public void bindView(
			com.whut.vs.adapters.CustomAdapter.CustomViewHolder vh,
			PurchaseBean bean) {
		TextView name = vh.getView(R.id.purchase_name);
	}
}
