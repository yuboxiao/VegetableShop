package com.whut.vs.ui;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.ClearingGoodsAdapter;
import com.whut.vs.bean.ClearingGoodsBean;
import com.whut.vs.widgets.WrapContentListView;

/****
 * ÃÓ–¥∂©µ•“≥√Ê
 * @author think
 *
 */
public class FillInOrderActivity extends FinalActivity {
	
	@ViewInject(id = R.id.rl_address_order,click = "onClick")
	private RelativeLayout rl_address_order;
	
	@ViewInject(id = R.id.rl_delivery_time,click = "onClick")
	private RelativeLayout rl_delivery_time;
	
	@ViewInject(id = R.id.listview_clearing_goods)
	private WrapContentListView listview_clearing_goods;
	
	@ViewInject(id = R.id.activity_fill_in_order_place_order, click = "onClick")
	private Button activity_fill_in_order_place_order;
	
	private ClearingGoodsAdapter cgAdapter;
	
	private List<ClearingGoodsBean> cgbeans = new ArrayList<ClearingGoodsBean>();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_fill_in_order);
		
		ClearingGoodsBean bean1 = new ClearingGoodsBean();
		ClearingGoodsBean bean2 = new ClearingGoodsBean();
		cgbeans.add(bean1);
		cgbeans.add(bean2);
		
		cgAdapter = new ClearingGoodsAdapter(this, cgbeans);
		listview_clearing_goods.setAdapter(cgAdapter);
		
	}
	
	private void onClick(View v){
		switch(v.getId()){
		case R.id.activity_fill_in_order_place_order:
			Intent intent = new Intent();
			intent.setClass(this, CashierDeskActivity.class);
			startActivity(intent);
			break;
		case R.id.rl_address_order:
			Intent intent1 = new Intent();
			intent1.setClass(this, ShippingAddressActivity.class);
			startActivity(intent1);
			break;
		case R.id.rl_delivery_time:
			Intent intent2 = new Intent();
			intent2.setClass(this, DeliveryTimeActivity.class);
			startActivity(intent2);
			break;
		}
	}
}
