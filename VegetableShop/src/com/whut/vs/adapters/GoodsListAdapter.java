package com.whut.vs.adapters;

import java.util.List;

import net.tsz.afinal.FinalBitmap;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.GoodsBean;
import com.whut.vs.utils.ScreenUtils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

/*** 
 * @author xiongbin
 * @date 2016-3-18
 * @description ��Ʒҳ�������Ʒ���������۸��������
 */
public class GoodsListAdapter extends CustomAdapter<GoodsBean> {

	private FinalBitmap mFinalBitmap;
	private int screenWidth;
	
	public GoodsListAdapter(Context context, List<GoodsBean> list) {
		super(context, list);
		initFinalBitmap();
		screenWidth = ScreenUtils.getScreenWidth(context);
	}
	
	private void initFinalBitmap(){
		mFinalBitmap = FinalBitmap.create(mContext);
		//����ʧ����ʾ��ͼƬ
		mFinalBitmap.configLoadfailImage(R.drawable.white);
		//��������ʾ��ͼƬ
		mFinalBitmap.configLoadingImage(R.drawable.white);
	}

	@Override
	public int obtainView() {
		return R.layout.layout_goods_list_item;
	}

	@Override
	public void bindView(CustomViewHolder vh, GoodsBean bean) {
		if (bean.getAddress() != null) {
			TextView tv = vh.getView(R.id.tv_new_goods_address);
			tv.setText(bean.getAddress());
		}
		if (bean.getImageUrl() != null) {
			ImageView iv = vh.getView(R.id.iv_new_goods_photo);
			mFinalBitmap.display(iv, bean.getImageUrl());
		}
		if (bean.getIntegration() != 0) {
			TextView tv = vh.getView(R.id.tv_new_goods_integration);
			tv.setText(bean.getIntegration()+"");
		}
	}

}
