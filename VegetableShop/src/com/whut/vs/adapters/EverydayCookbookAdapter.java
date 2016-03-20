package com.whut.vs.adapters;

import java.util.List;

import net.tsz.afinal.FinalBitmap;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.EverydayCookbookBean;

/*** 
 * @author xiongbin
 * @date 2016-3-18
 * @description ÿ�ղ���ҳ��GridView������
 */
public class EverydayCookbookAdapter extends CustomAdapter<EverydayCookbookBean> {

	private FinalBitmap mFinalBitmap;
	
	public EverydayCookbookAdapter(Context context,
			List<EverydayCookbookBean> list) {
		super(context, list);
		initFinalBitmap();
	}
	
	private void initFinalBitmap() {
		mFinalBitmap = FinalBitmap.create(mContext);
		// ����ʧ����ʾ��ͼƬ
		mFinalBitmap.configLoadfailImage(R.drawable.white);
		// ��������ʾ��ͼƬ
		mFinalBitmap.configLoadingImage(R.drawable.white);
	}

	@Override
	public int obtainView() {
		return R.layout.adapter_everyday_cookbook;
	}

	@Override
	public void bindView(CustomViewHolder vh, EverydayCookbookBean bean) {
		if (bean.getCookbookImageUrl() != null) {
			ImageView iv = vh.getView(R.id.iv_everyday_cookbook_photo);
			mFinalBitmap.display(iv, bean.getCookbookImageUrl());
		}
		if (bean.getCookbookName() != null) {
			TextView tv = vh.getView(R.id.tv_everyday_cookbook_name);
			tv.setText(bean.getCookbookName());
		}
		if (bean.getCookbookWeight() != null) {
			TextView tv = vh.getView(R.id.tv_everyday_cookbook_weight);
			tv.setText(bean.getCookbookWeight());
		}
		if (bean.getCookbookPrice() != null) {
			TextView tv = vh.getView(R.id.tv_everyday_cookbook_price);
			tv.setText(bean.getCookbookPrice());
		}
	}

}
