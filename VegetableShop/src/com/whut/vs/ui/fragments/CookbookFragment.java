package com.whut.vs.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.handmark.pulltorefresh.library.ILoadingLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;
import com.handmark.pulltorefresh.library.PullToRefreshGridView;
import com.whut.vegetableshop.R;
import com.whut.vs.bean.CategoryBean;
import com.whut.vs.ui.EverydayCookbookActivity;
import com.whut.vs.widgets.ClassifyView;
import com.whut.vs.widgets.ClassifyView.RightGridviewAdapter;


/**
 * @description 主页面的菜谱Fragment
 * @author xiongbin
 */
public class CookbookFragment extends Fragment implements OnItemClickListener{
		
	private View rootView;
	private Activity parentActivity;
	
	//菜谱列表
	@ViewInject(id = R.id.prGirdView_cookbook)
	private PullToRefreshGridView prGirdViewCookbook;
	private GridView mGridView;
	
	/***
	 * 菜谱列表的适配器
	 * {@link ClassifyView.RightGridviewAdapter }
	 * 使用自定义控件ClassifyView类中的一适配器
	 */
	private ClassifyView.RightGridviewAdapter mCookbookAdapter;
	
	
	private List<CategoryBean> categoryBeans = new ArrayList<CategoryBean>();
	
	
    private String[] imageUrls = {"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1456908117&di=c3fea2d2f3ea4da72a42722aab2521ea&src=http://img4.duitang.com/uploads/item/201312/05/20131205172421_QKF4K.thumb.600_0.jpeg",  
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",  
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",  
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",  
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"};

	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
            Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.layout_cookbook, null);
			FinalActivity.initInjectedView(this, rootView);
		}


		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}
		
		return rootView;
    } 
    
    @Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;
		
		CategoryBean bean1 = new CategoryBean();
		bean1.setCategory("糖醋鲤鱼");
		bean1.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean1);
		
		CategoryBean bean2 = new CategoryBean();
		bean2.setCategory("九转大肠");
		bean2.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean2);
		
		CategoryBean bean3 = new CategoryBean();
		bean3.setCategory("汤爆双脆");
		bean3.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean3);
		
		CategoryBean bean4 = new CategoryBean();
		bean4.setCategory("奶汤蒲菜");
		bean4.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean4);
		
		CategoryBean bean5 = new CategoryBean();
		bean5.setCategory("南肠");
		bean5.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean5);
		
		CategoryBean bean6 = new CategoryBean();
		bean6.setCategory("玉记扒鸡");
		bean6.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean6);
		
		CategoryBean bean7 = new CategoryBean();
		bean7.setCategory("姜汁鸡蛋白");
		bean7.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean7);
		
		CategoryBean bean8 = new CategoryBean();
		bean8.setCategory("济南烤鸭");
		bean8.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean8);
		
		CategoryBean bean9 = new CategoryBean();
		bean9.setCategory("玉记扒鸡");
		bean9.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean9);
		
		CategoryBean bean10 = new CategoryBean();
		bean10.setCategory("姜汁鸡蛋白");
		bean10.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean10);
		
		CategoryBean bean11 = new CategoryBean();
		bean11.setCategory("济南烤鸭");
		bean11.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean11);
		
		CategoryBean bean12 = new CategoryBean();
		bean12.setCategory("玉记扒鸡");
		bean12.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean12);
	}

	
    
    @Override
	public void onResume() {
		super.onResume();
		mCookbookAdapter = new RightGridviewAdapter(parentActivity, categoryBeans);
        mGridView = prGirdViewCookbook.getRefreshableView();
        mGridView.setNumColumns(3);
        mGridView.setHorizontalSpacing(10);
        mGridView.setVerticalSpacing(10);
        mGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        mGridView.setAdapter(mCookbookAdapter);
		prGirdViewCookbook.setAdapter(mCookbookAdapter);
		prGirdViewCookbook.setOnItemClickListener(this);
		
		prGirdViewCookbook.setMode(Mode.BOTH);
		ILoadingLayout mHeader = prGirdViewCookbook.getLoadingLayoutProxy(true,false);
		mHeader.setPullLabel("下拉刷新");
		mHeader.setReleaseLabel("释放刷新");
		mHeader.setRefreshingLabel("正在刷新...");
		
		ILoadingLayout mFooter = prGirdViewCookbook.getLoadingLayoutProxy(false,true);
		mFooter.setPullLabel("下拉刷新");
		mFooter.setReleaseLabel("释放刷新");
		mFooter.setRefreshingLabel("正在刷新...");

	}
	
	@Override
	public void onPause() {
		super.onPause();
		
	}

	public void onclick(View view) {
		int id = view.getId();
		switch (id) {
	
		default:
			
			break;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		Intent intent = new Intent(parentActivity,EverydayCookbookActivity.class);
		startActivity(intent);
	}
	
	

	
}

