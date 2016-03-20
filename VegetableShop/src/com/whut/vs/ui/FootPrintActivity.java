package com.whut.vs.ui;

import java.util.ArrayList;
import java.util.List;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.whut.vegetableshop.R;
import com.whut.vs.adapters.FavoritesAdapter;
import com.whut.vs.bean.FavoritesGoodsBean;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

/**
 * 足迹页面
 * 
 * @author cw 用的FavoritesAdapter适配器和FavoritesGoodsBean
 */
public class FootPrintActivity extends FinalActivity implements OnClickListener {

	@ViewInject(id = R.id.pull_refresh_gridview_footprint)
	private PullToRefreshGridView mPullToRefreshGridView;
	private GridView mGridView;
	// 返回菜场图标
	@ViewInject(id = R.id.iv_footprint_to_mymarket, click = "onClick")
	private ImageView iv_footprint_to_mymarket;
	// 清空
	@ViewInject(id = R.id.tv_footprint_clear, click = "onClick")
	private TextView tv_footprint_clear;

	private FavoritesAdapter mFavoritesAdapter;
	private List<FavoritesGoodsBean> list = new ArrayList<FavoritesGoodsBean>();

	private String[] imageUrls = {
			"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1456908117&di=c3fea2d2f3ea4da72a42722aab2521ea&src=http://img4.duitang.com/uploads/item/201312/05/20131205172421_QKF4K.thumb.600_0.jpeg",
			"http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
			"http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
			"http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
			"http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_footprint);
		initDate();
		mFavoritesAdapter = new FavoritesAdapter(this, list);
		mGridView = mPullToRefreshGridView.getRefreshableView();
		mGridView.setNumColumns(2);
		mGridView.setHorizontalSpacing(5);
		mGridView.setVerticalSpacing(10);
		mGridView.setAdapter(mFavoritesAdapter);

		mPullToRefreshGridView.setMode(Mode.PULL_FROM_START);
		mPullToRefreshGridView
				.setOnRefreshListener(new OnRefreshListener<GridView>() {

					@Override
					public void onRefresh(
							PullToRefreshBase<GridView> refreshView) {
						// new GetDataTask().execute();
					}
				});

	}

	/*
	 * 初识话数据，假数据
	 */
	private void initDate() {
		for (int i = 0; i < 10; i++) {
			FavoritesGoodsBean bean = new FavoritesGoodsBean();
			bean.setAddress("江西");
			bean.setImageUrl(imageUrls[0]);
			bean.setIntegration(i + 3.48f);
			list.add(bean);
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.iv_footprint_to_mymarket:
			this.finish();
			break;

		default:
			break;
		}
	}
}
