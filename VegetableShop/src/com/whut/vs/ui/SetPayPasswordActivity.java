package com.whut.vs.ui;

import com.whut.vegetableshop.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/****
 * @description 设置支付密码页面
 * @author think
 *
 */
public class SetPayPasswordActivity extends Activity implements OnClickListener {
	private ImageView setpaypasswordtohome_iv, setpaypasswordtomymarket_iv;
	private Button confirmpaypassword_btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_setpaypassword);
		initViews();
	}

	private void initViews() {
		setpaypasswordtohome_iv = (ImageView) findViewById(R.id.iv_set_paypassword_tohome);
		setpaypasswordtomymarket_iv = (ImageView) findViewById(R.id.iv_favorites_to_mymarket);
		confirmpaypassword_btn = (Button) findViewById(R.id.btn_confirm_paypassword);
		// 设置监听
		setpaypasswordtohome_iv.setOnClickListener(this);
		setpaypasswordtomymarket_iv.setOnClickListener(this);
		confirmpaypassword_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_set_paypassword_tohome:
			Intent intent1 = new Intent();
			intent1.setClass(this, MainActivity.class);
			startActivity(intent1);
			break;

		case R.id.iv_favorites_to_mymarket:
			this.finish();
			break;
		case R.id.btn_confirm_paypassword:
			Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
}
