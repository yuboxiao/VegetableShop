package com.whut.vs.ui;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import com.whut.vegetableshop.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;

/****
 * @description 设置收货地址页面
 * @author think
 *
 */
public class SetAddressActivity extends FinalActivity implements
		OnClickListener {

	@ViewInject(id = R.id.iv_address_return_mymarket, click = "onClick")
	private ImageView iv_address_return_mymarket;
	@ViewInject(id = R.id.iv_address_to_home, click = "onClick")
	private ImageView iv_address_to_home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setaddress);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.iv_address_to_home:
			Intent intent1 = new Intent();
			intent1.setClass(this, MainActivity.class);
			startActivity(intent1);
			break;
		case R.id.iv_address_return_mymarket:
			this.finish();
			break;
		default:
			break;
		}
	}
}
