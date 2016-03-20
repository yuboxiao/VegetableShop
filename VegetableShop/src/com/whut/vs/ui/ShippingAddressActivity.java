package com.whut.vs.ui;

import com.whut.vegetableshop.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/***
 * @description 收货地址页面
 * @author think
 *
 */
public class ShippingAddressActivity extends FinalActivity {

	@ViewInject(id = R.id.bt_new_address,click = "onClick")
	private Button bt_new_address;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_shipping_address);
	}
	
	private void onClick(View v){
		switch (v.getId()) {
		case R.id.bt_new_address:
			Intent intent = new Intent();
			intent.setClass(this, NewShippingAddressActivity.class);
			startActivity(intent);
			break;

		default:
			break;
		}
	}
}
