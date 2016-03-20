package com.whut.vs.adapters;

import java.util.List;

import android.content.Context;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.MonthBillItem;
import com.whut.vs.utils.ScreenUtils;

public class MonthBillAdapter extends CustomAdapter<MonthBillItem> {

	private int screenWidth;

	public MonthBillAdapter(Context context, List<MonthBillItem> list) {
		super(context, list);
		screenWidth = ScreenUtils.getScreenWidth(context);
	}

	@Override
	public int obtainView() {
		// TODO Auto-generated method stub
		return R.layout.adapter_monthbill_item;
	}

	@Override
	public void bindView(
			com.whut.vs.adapters.CustomAdapter.CustomViewHolder vh,
			MonthBillItem bean) {
        if (bean.getBillMoney()!=null) {
			TextView tv=vh.getView(R.id.tv_bill_money);
			tv.setText(bean.getBillMoney());
		}    
        if (bean.getPayItem()!=null) {
			TextView tv=vh.getView(R.id.tv_pay_item);
			tv.setText(bean.getPayItem());
		}
        if (bean.getPayTime()!=null) {
			TextView tv=vh.getView(R.id.tv_pay_time);
			tv.setText(bean.getPayTime());
		}
        if (bean.getYueMoney()!=null) {
			TextView tv=vh.getView(R.id.tv_yue_money);
			tv.setText(bean.getYueMoney());
		}
	}

}
