package com.whut.vs.adapters;

import java.util.List;

import android.content.Context;
import android.widget.RatingBar;
import android.widget.TextView;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.OneGoodsEvaluateBean;

public class OneGoodsEvaluateAdapter extends CustomAdapter<OneGoodsEvaluateBean> {

	public OneGoodsEvaluateAdapter(Context context,
			List<OneGoodsEvaluateBean> list) {
		super(context, list);
	}

	@Override
	public int obtainView() {
		return R.layout.adapter_one_goods_evaluate;
	}

	@Override
	public void bindView(CustomViewHolder vh,OneGoodsEvaluateBean bean) {
		if (bean.getPhone() != null) {
			TextView tv = vh.getView(R.id.tv_one_goods_evaluate_phone);
			tv.setText(bean.getPhone());
		}
		if (bean.getEvaluateContent() != null) {
			TextView tv = vh.getView(R.id.tv_one_goods_evaluate_content);
			tv.setText(bean.getEvaluateContent());
		}
		if (bean.getTime() != null) {
			TextView tv = vh.getView(R.id.tv_one_goods_evaluate_time);
			tv.setText(bean.getPhone());
		}
		if (bean.getEvaluateScore() != 0) {
			RatingBar rb = vh.getView(R.id.ratingBar_one_goods_evaluate_score_show);
			rb.setRating(bean.getEvaluateScore());
		}
	}

}
