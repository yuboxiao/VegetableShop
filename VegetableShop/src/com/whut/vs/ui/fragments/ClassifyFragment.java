package com.whut.vs.ui.fragments;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.whut.vegetableshop.R;
import com.whut.vs.bean.CategoryBean;
import com.whut.vs.ui.GoodsListActivity;
import com.whut.vs.widgets.ClassifyView;
import com.whut.vs.widgets.ClassifyView.ILeftListviewItemListener;
import com.whut.vs.widgets.ClassifyView.IRightGridviewItemListener;

/**
 * @description ��ҳ��ķ���Fragment
 * @author xiongbin
 */
public class ClassifyFragment extends Fragment {

	@ViewInject(id = R.id.classifyPageView)
	private ClassifyView cfv;
	
	private View rootView;

	private List<String> list = new ArrayList<String>();
	private List<CategoryBean> categoryBeans = new ArrayList<CategoryBean>();

	private Activity parentActivity;
	
    private String[] imageUrls = {"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1456908117&di=c3fea2d2f3ea4da72a42722aab2521ea&src=http://img4.duitang.com/uploads/item/201312/05/20131205172421_QKF4K.thumb.600_0.jpeg",  
            "http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",  
            "http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",  
            "http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",  
            "http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg"}; 

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		parentActivity = activity;

		list.add("�߲�ˮ��");
		list.add("����ˮ��");
		list.add("���͸ɻ�");
		list.add("��������");
		list.add("��ˮ����");
		list.add("�Ҿ���Ʒ");
		list.add("��ʳ����");
		
		CategoryBean bean1 = new CategoryBean();
		bean1.setCategory("ˮ��");
		bean1.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean1);
		
		CategoryBean bean2 = new CategoryBean();
		bean2.setCategory("Ҷ�˻���");
		bean2.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean2);
		
		CategoryBean bean3 = new CategoryBean();
		bean3.setCategory("����");
		bean3.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean3);
		
		CategoryBean bean4 = new CategoryBean();
		bean4.setCategory("�Ϲ�ʵ");
		bean4.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean4);
		
		CategoryBean bean5 = new CategoryBean();
		bean5.setCategory("����");
		bean5.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean5);
		
		CategoryBean bean6 = new CategoryBean();
		bean6.setCategory("���");
		bean6.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean6);
		
		CategoryBean bean7 = new CategoryBean();
		bean7.setCategory("�Ϲ�ʵ");
		bean7.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean7);
		
		CategoryBean bean8 = new CategoryBean();
		bean8.setCategory("����");
		bean8.setImageUrl(imageUrls[0]);
		categoryBeans.add(bean8);
		
		CategoryBean bean9 = new CategoryBean();
		bean9.setCategory("ȫ��");
		bean9.setImageUrl("");
		categoryBeans.add(bean9);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (rootView == null) {
			rootView = inflater.inflate(R.layout.layout_classify, null);
			FinalActivity.initInjectedView(this, rootView);
		}

		ViewGroup parent = (ViewGroup) rootView.getParent();
		if (parent != null) {
			parent.removeView(rootView);
		}

		return rootView;
	}

	@Override
	public void onResume() {
		super.onResume();
		cfv.setListViewData(list);
		cfv.recoveryListViewSelection();
		
		cfv.setGridViewData(categoryBeans);
		
		cfv.setmILeftListviewItemListener(new MyILeftListviewItemListener());
		cfv.setmIRightGridviewItemListener(new MyIRightGridviewItemListener());
	}
	
	/*****
	 * �������Listview�ļ�����
	 * @author xiongbin
	 */
	private class MyILeftListviewItemListener implements ILeftListviewItemListener{

		@Override
		public void OnItemClick(View view, int position) {

		}
		
	}
	
	/*****
	 * �����ұ�Gridview�ļ�����
	 * @author xiongbin
	 */
	private class MyIRightGridviewItemListener implements IRightGridviewItemListener{

		@Override
		public void OnItemClick(View view, int position) {
			Intent intent = new Intent(parentActivity,GoodsListActivity.class);
			startActivity(intent);
		}
		
	}
	
	
	/****
	 * ҳ��ؼ�����
	 */
	public void onClick(View view){
		Intent intent;
		switch (view.getId()) {
			
		default:
			break;
		}
	}
}
