package com.whut.vs.adapters;

import java.util.List;

import android.content.Context;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.ClearingGoodsBean;

public class ClearingGoodsAdapter extends CustomAdapter<ClearingGoodsBean> {

	public ClearingGoodsAdapter(Context context,
			List<ClearingGoodsBean> list) {
		super(context, list);
		
	}

	@Override
	public int obtainView() {
		return R.layout.adapter_clearing_goods;
	}

	@Override
	public void bindView(
			com.whut.vs.adapters.CustomAdapter.CustomViewHolder vh,
			ClearingGoodsBean bean) {
		
	}
}
