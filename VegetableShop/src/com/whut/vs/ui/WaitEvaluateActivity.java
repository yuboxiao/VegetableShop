package com.whut.vs.ui;

import com.whut.vegetableshop.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
/**
 * ������ҳ��
 * @author cw
 *
 */
public class WaitEvaluateActivity extends FinalActivity {

	//����ͼ��
	@ViewInject(id=R.id.iv_wait_evaluate_to_home,click="onclick")
	private ImageView iv_wait_evaluate_to_home;
	@ViewInject(id=R.id.iv_wait_evaluate_return_mymarket,click="onclick")
	private ImageView iv_wait_evaluate_return_mymarket;
	
	//���ͼƬ
	@ViewInject(id=R.id.iv_evaluate_add_pictrue,click="onclick")
	private ImageView iv_evaluate_add_pictrue;
	
	//��������
	@ViewInject(id=R.id.btn_published_evaluation,click="onclick")
	private Button btn_published_evaluation;
	
	
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_wait_evaluate);
	}
	
	private void onclick(View v){
		Intent intent;
		switch (v.getId()) {
		case R.id.iv_wait_evaluate_return_mymarket:
			this.finish();
			break;
		case R.id.iv_wait_evaluate_to_home:
			intent=new Intent();
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			break;
		case R.id.btn_published_evaluation:
			toast("���۳ɹ�");
			break;
		default:
			break;
		}
	}
}
