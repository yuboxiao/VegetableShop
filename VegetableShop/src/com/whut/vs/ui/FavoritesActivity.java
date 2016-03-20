package com.whut.vs.ui;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.whut.vegetableshop.R;
import com.whut.vs.adapters.FavoritesAdapter;
import com.whut.vs.adapters.GoodsListAdapter;
import com.whut.vs.bean.FavoritesGoodsBean;
import com.whut.vs.bean.GoodsBean;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

/**
 * 收藏夹页面
 * 
 * @author cw
 * 
 */

public class FavoritesActivity extends FinalActivity {

	@ViewInject(id = R.id.pull_refresh_gridview_favorites)
	private PullToRefreshGridView mPullToRefreshGridView;
	private GridView mGridView;

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
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_favorites);
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
}
