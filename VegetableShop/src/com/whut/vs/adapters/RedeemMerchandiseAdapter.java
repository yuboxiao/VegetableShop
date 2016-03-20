package com.whut.vs.adapters;

import java.util.List;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.RedeemMerchandiseBean;

import android.content.Context;

public class RedeemMerchandiseAdapter extends CustomAdapter<RedeemMerchandiseBean> {

	public RedeemMerchandiseAdapter(Context context,
			List<RedeemMerchandiseBean> list) {
		super(context, list);
	}

	@Override
	public int obtainView() {
		return R.layout.adapter_redeem_merchandise_item;
	}

	@Override
	public void bindView(
			com.whut.vs.adapters.CustomAdapter.CustomViewHolder vh,
			RedeemMerchandiseBean bean) {
		
	}
}
