package com.whut.vs.ui;

import java.util.ArrayList;
import java.util.List;

import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.whut.vegetableshop.R;
import com.whut.vs.adapters.OrderAdapter;
import com.whut.vs.bean.OrderBean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/****
 * 查看所有订单页面
 * @author think
 *
 */
public class LookOrderActivity extends FinalActivity {

	// 返回和首页图标
	@ViewInject(id = R.id.iv_look_order_to_home, click = "onClick")
	private ImageView iv_look_order_to_home;
	
	@ViewInject(id = R.id.iv_look_order_return_mymarket, click = "onClick")
	private ImageView iv_look_order_return_mymarket;
	
	@ViewInject(id = R.id.lv_look_order)
	private PullToRefreshListView lv_look_order;

	private List<OrderBean> list = new ArrayList<OrderBean>();

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.acitivity_look_order);
		lv_look_order.setMode(Mode.DISABLED);
		ListView lv = lv_look_order.getRefreshableView();
		//设置item间隔
		lv.setDividerHeight(20);
		lv_look_order.setAdapter(new OrderAdapter(this, getData()));
	}

	/**
	 * 假数据
	 * 
	 * @param v
	 */
	private String[] odernum = { "88888888888", "8888888888888", "999999999999999" };
	private String[] odermoney = { "¥52.00", "¥34.00", "¥55.00" };
	private String[] odertime = { "2016-03-05 15:00:00", "2016-03-05 15:00:00", "2016-03-05 15:00:00" };
	private String[] orderStatus = { "待付款", "待付款", "待付款" };

	private List<OrderBean> getData() {
		for (int i = 0; i < 3; i++) {
			OrderBean bean = new OrderBean();
			bean.setOdermoney(odermoney[i]);
			bean.setOdernum(odernum[i]);
			bean.setOdertime(odertime[i]);
			bean.setOrderstatus(orderStatus[i]);
			list.add(bean);
		}

		return list;

	}

	public void onClick(View v) {
		Intent intent;
		switch (v.getId()) {
		case R.id.iv_look_order_to_home:
			intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			break;
			
		case R.id.iv_look_order_return_mymarket:
			this.finish();
			break;
			
		default:
			break;
		}
	}

}
