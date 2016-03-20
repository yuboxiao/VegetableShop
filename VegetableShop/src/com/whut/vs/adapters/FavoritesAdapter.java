package com.whut.vs.adapters;

import java.util.List;

import net.tsz.afinal.FinalBitmap;
import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.CustomAdapter.CustomViewHolder;
import com.whut.vs.bean.FavoritesGoodsBean;
import com.whut.vs.bean.GoodsBean;
import com.whut.vs.utils.ScreenUtils;

public class FavoritesAdapter extends CustomAdapter<FavoritesGoodsBean> {

	private FinalBitmap mFinalBitmap;
	private int screenWidth;

	public FavoritesAdapter(Context context, List<FavoritesGoodsBean> list) {
		super(context, list);
		initFinalBitmap();
		screenWidth = ScreenUtils.getScreenWidth(context);
	}

	private void initFinalBitmap() {
		mFinalBitmap = FinalBitmap.create(mContext);
		// 加载失败显示的图片
		mFinalBitmap.configLoadfailImage(R.drawable.white);
		// 加载中显示的图片
		mFinalBitmap.configLoadingImage(R.drawable.white);
	}

	@Override
	public int obtainView() {
		return R.layout.layout_favorites_item;
	}

	@Override
	public void bindView(CustomViewHolder vh, FavoritesGoodsBean bean) {
		if (bean.getAddress() != null) {
			TextView tv = vh.getView(R.id.tv_new_favorites_address);
			tv.setText(bean.getAddress());
		}
		if (bean.getImageUrl() != null) {
			ImageView iv = vh.getView(R.id.iv_new_favorites_photo);
			mFinalBitmap.display(iv, bean.getImageUrl());
		}
		if (bean.getIntegration() != 0) {
			TextView tv = vh.getView(R.id.tv_new_favorites_integration);
			tv.setText(bean.getIntegration() + "");
		}
	}

}
