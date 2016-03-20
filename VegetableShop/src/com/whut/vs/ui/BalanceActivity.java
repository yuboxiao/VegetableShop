package com.whut.vs.ui;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.whut.vegetableshop.R;

/**
 * ������
 * @author cw
 *
 */
public class BalanceActivity extends FinalActivity {

	// �����ҵĲ˳�
	@ViewInject(id = R.id.iv_return_mymarket, click = "onClick")
	private ImageView iv_return_mymarket;
	// ������ҳ
	@ViewInject(id = R.id.iv_to_home, click = "onClick")
	private ImageView iv_return_home;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_balance);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_return_mymarket:
			this.finish();
			break;

		case R.id.iv_to_home:
			Intent intent = new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
		default:
			break;
		}
	}

}
