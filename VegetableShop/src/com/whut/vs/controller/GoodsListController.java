package com.whut.vs.controller;

import java.util.List;

import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import android.os.Handler;

import com.whut.vs.bean.GoodsBean;
import com.whut.vs.config.MsgType;

public class GoodsListController extends BaseController {

	private static GoodsListController instance;
	private GoodsListController() {
		super();
	}
	
	public static GoodsListController getInstance() {
		if (instance == null) {
			instance = new GoodsListController();
		}
		return instance;
	}
	
	public void getNewGoodsList(final Handler handler){
		AjaxParams params = new AjaxParams();
		mFinalHttp.post(URL,params, new AjaxCallBack<Object>() {
			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
			}
			
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
				sendMessage(handler, MsgType.GET_NEW_GOODS_LIST_FAILED, strMsg);
			}
		});
	}
	
	
	public void getHotSaleGoodsList(final Handler handler){
		AjaxParams params = new AjaxParams();
		mFinalHttp.post(URL,params, new AjaxCallBack<Object>() {
			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
			}
			
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
				sendMessage(handler, MsgType.GET_HOT_SALE_GOODS_LIST_FAILED, strMsg);
			}
		});
	}
	
	public void getByPriceGoodsList(final Handler handler){
		AjaxParams params = new AjaxParams();
		mFinalHttp.post(URL,params, new AjaxCallBack<Object>() {
			@Override
			public void onSuccess(Object t) {
				super.onSuccess(t);
			}
			
			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				super.onFailure(t, errorNo, strMsg);
				sendMessage(handler, MsgType.GET_HOT_SALE_GOODS_LIST_FAILED, strMsg);
			}
		});
	}
}
