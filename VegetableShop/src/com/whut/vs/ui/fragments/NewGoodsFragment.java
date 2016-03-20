package com.whut.vs.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener2;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.whut.vegetableshop.R;
import com.whut.vs.adapters.GoodsListAdapter;
import com.whut.vs.bean.GoodsBean;
import com.whut.vs.config.MsgType;
import com.whut.vs.controller.GoodsListController;

/**
 * @description 商品列表中的新品Fragment
 * @author xiongbin
 */
public class NewGoodsFragment extends Fragment {

	private Activity parentActivity;
	private View rootView;
	
	@ViewInject(id = R.id.prGridView_goods_list)
    private PullToRefreshGridView mPullToRefreshGridView;
    private GridView mGridView;
    
    private GoodsListAdapter mGoodsListAdapter;
    private List<GoodsBean> list = new ArrayList<GoodsBean>();
	
    private String[] imageUrls = {"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1456908117&di=c3fea2d2f3ea4da72a42722aab2521ea&src=http://img4.duitang.com/uploads/item/201312/05/20131205172421_QKF4K.thumb.600_0.jpeg",  
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",  
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",  
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",  
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};
    
    private GoodsListController mGoodsListController;
    
    private Handler mHandler = new Handler(new Handler.Callback() {
		
		@Override
		public boolean handleMessage(Message msg) {
			switch (msg.what) {
			case MsgType.GET_NEW_GOODS_LIST_FAILED:
				mPullToRefreshGridView.onRefreshComplete();
				break;

			default:
				break;
			}
			return false;
		}
	});
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;
		
		mGoodsListController = GoodsListController.getInstance();
		
		for(int i = 0;i < 10;i++){
			GoodsBean bean = new GoodsBean();
			bean.setAddress("江西");
			bean.setImageUrl(imageUrls[0]);
			bean.setIntegration(i + 3.48f);
			list.add(bean);
		}
		
		mGoodsListAdapter = new GoodsListAdapter(parentActivity, list);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.layout_goods_list_new_goods, null);
			FinalActivity.initInjectedView(this, rootView);
		}

		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}

        mGridView = mPullToRefreshGridView.getRefreshableView();
        mGridView.setNumColumns(2);
        mGridView.setHorizontalSpacing(10);
        mGridView.setVerticalSpacing(10);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mGridView.setAdapter(mGoodsListAdapter);
		
		mPullToRefreshGridView.setMode(Mode.BOTH);
		ILoadingLayout mHeader = mPullToRefreshGridView.getLoadingLayoutProxy(true,false);
		mHeader.setPullLabel("下拉刷新");
		mHeader.setReleaseLabel("释放刷新");
		mHeader.setRefreshingLabel("正在刷新...");
		
		ILoadingLayout mFooter = mPullToRefreshGridView.getLoadingLayoutProxy(false,true);
		mFooter.setPullLabel("下拉刷新");
		mFooter.setReleaseLabel("释放刷新");
		mFooter.setRefreshingLabel("正在刷新...");

        mPullToRefreshGridView.setOnRefreshListener(new OnRefreshListener2<GridView>() {

			@Override
			public void onPullDownToRefresh(
					PullToRefreshBase<GridView> refreshView) {
				mGoodsListController.getNewGoodsList(mHandler);
			}

			@Override
			public void onPullUpToRefresh(
					PullToRefreshBase<GridView> refreshView) {
				mGoodsListController.getNewGoodsList(mHandler);
			}
		});


		return rootView;
	}
}
