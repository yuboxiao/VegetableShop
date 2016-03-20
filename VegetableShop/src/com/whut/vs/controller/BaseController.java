package com.whut.vs.controller;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalHttp;
import android.os.Handler;
import android.os.Message;

import com.whut.vs.application.SApplication;

public class BaseController {

	public static final String URL = "http://192.168.1.102/pwcus/"; 
	protected FinalHttp mFinalHttp;
	protected FinalDb mFinalDb;
	
	public BaseController() {
		mFinalHttp = FinalHttp.create();
		mFinalDb = FinalDb.create(SApplication.getInstance().getApplicationContext());
	}
	
	protected void sendMessage(Handler handler,int type) {
		Message msg = handler.obtainMessage();
		msg.what = type;
		msg.sendToTarget();
	}
	
	protected void sendMessage(Handler handler,int type,Object object) {
		Message msg = handler.obtainMessage();
		msg.what = type;
		msg.obj = object;
		msg.sendToTarget();
	}
}
