package com.whut.vs.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.MonthBillAdapter;
import com.whut.vs.adapters.MonthBillAdapter;
import com.whut.vs.bean.MonthBillItem;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;

/***
 * @description 每月账单页面
 * @author think
 *
 */
public class MonthBillActivity extends FinalActivity implements OnClickListener {

	// 返回和首页图标
	@ViewInject(id=R.id.iv_month_bill_return_mymarket,click="onClick")
	private ImageView monthbillreturnmymarket_iv;
	@ViewInject(id=R.id.iv_month_bill_to_home,click="onClick")
	private ImageView monthbilltohome_iv;
	
	@ViewInject(id=R.id.lv_month_bill)
	private ListView monthbill_lv;
	
	private List<MonthBillItem> list=new ArrayList<MonthBillItem>();
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_monthbill);
		monthbill_lv.setAdapter(new MonthBillAdapter(this,getData()));

	}

	@SuppressLint("InlinedApi")
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_month_bill_return_mymarket:
			this.finish();
			break;
		case R.id.iv_month_bill_to_home:
			Intent intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}

	/**
	 * 假数据
	 */
	private String[] payItem = { "转账", "转账-余额宝支出", "在线支付", "在线支付", "充值" };
	private String[] yueMoney = { "4.50", "2004.50", "15.00", "0.50", "1.00" };
	private String[] payTime = { "2016-01-02", "2016-01-02", "2016-01-02",
			"2016-01-02", "2016-01-02" };
	private String[] billMoney = { "+2000.00", "-1600.00", "+2000.00",
			"+2000.00", "+2000.00" };

	private List<MonthBillItem> getData() {
		for (int i = 0; i < payItem.length; i++) {
			MonthBillItem bean=new MonthBillItem();
			bean.setBillMoney(billMoney[i]);
			bean.setPayItem(payItem[i]);
			bean.setPayTime(payTime[i]);
			bean.setYueMoney(yueMoney[i]);
			list.add(bean);
		}
		return list;
	}

}
