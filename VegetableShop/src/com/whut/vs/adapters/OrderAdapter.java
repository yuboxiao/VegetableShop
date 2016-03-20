package com.whut.vs.adapters;

import java.util.List;

import android.content.Context;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vegetableshop.R.id;
import com.whut.vs.bean.OrderBean;
import com.whut.vs.utils.ScreenUtils;

public class OrderAdapter extends CustomAdapter<OrderBean> {

	private int screenWidth;

	public OrderAdapter(Context context, List<OrderBean> list) {
		super(context, list);
		screenWidth = ScreenUtils.getScreenWidth(context);
	}

	@Override
	public int obtainView() {
		return R.layout.layout_look_order_item;
	}

	@Override
	public void bindView(
			com.whut.vs.adapters.CustomAdapter.CustomViewHolder vh,
			OrderBean bean) {
		if (bean.getOdermoney() != null) {
			TextView tv = vh.getView(R.id.tv_order_money);
			tv.setText(bean.getOdermoney());
		}
		if (bean.getOdernum() != null) {
			TextView tv = vh.getView(R.id.tv_order_num);
			tv.setText(bean.getOdernum());
		}
		if (bean.getOdertime() != null) {
			TextView tv = vh.getView(R.id.tv_order_time);
			tv.setText(bean.getOdertime());
		}
		if (bean.getOrderstatus() != null) {
			TextView tv = vh.getView(R.id.tv_order_status);
			tv.setText(bean.getOrderstatus());
		}
	}

}
