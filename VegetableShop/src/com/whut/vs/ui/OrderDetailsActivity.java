package com.whut.vs.ui;

import com.whut.vegetableshop.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/**
 * 待收货页面
 * 
 * @author cw
 * 
 */
   public class OrderDetailsActivity extends FinalActivity {
	   
	//订单跟踪btn
	@ViewInject(id=R.id.btn_wait_receipt_order_tracking,click="onClick")
	private Button btn_wait_receipt_order_tracking;    
	   
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		
		setContentView(R.layout.activity_order_details);
		
	}

	public void onClick(View v) {
		
		Intent intent;
		
		switch (v.getId()) {
		
		case R.id.btn_wait_receipt_order_tracking:
			intent = new Intent();
		    intent.setClass(this, OrderTrackingActivity.class);
		    startActivity(intent);
			break;

		default:
			break;
		}
	}
}
