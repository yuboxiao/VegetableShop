package com.whut.vs.ui;

import java.util.ArrayList;
import java.util.List;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.whut.vegetableshop.R;
import com.whut.vs.adapters.EverydayCookbookAdapter;
import com.whut.vs.bean.EverydayCookbookBean;
import com.whut.vs.widgets.WrapContentGridView;

/*** 
 * @author xiongbin
 * @date 2016-3-18
 * @description 每日菜谱页面
 */
public class EverydayCookbookActivity extends FinalActivity {

	@ViewInject(id = R.id.wcGridView_everyday_cookbook)
	private WrapContentGridView wcGridView_everyday_cookbook;
	
	private EverydayCookbookAdapter mEverydayCookbookAdapter;
	
	private List<EverydayCookbookBean> everydayCookbookBeans = new ArrayList<EverydayCookbookBean>();
	
	private String[] imageUrls = {
			"https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?image&quality=100&size=b4000_4000&sec=1456908117&di=c3fea2d2f3ea4da72a42722aab2521ea&src=http://img4.duitang.com/uploads/item/201312/05/20131205172421_QKF4K.thumb.600_0.jpeg",
			"http://pic30.nipic.com/20130626/8174275_085522448172_2.jpg",
			"http://pic18.nipic.com/20111215/577405_080531548148_2.jpg",
			"http://pic15.nipic.com/20110722/2912365_092519919000_2.jpg",
			"http://pic.58pic.com/58pic/12/64/27/55U58PICrdX.jpg" };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_everyday_cookbook);

		for(int i = 0;i < 10;i++){
			EverydayCookbookBean bean = new EverydayCookbookBean();
			bean.setCookbookImageUrl(imageUrls[0]);
			bean.setCookbookName("鲫鱼");
			bean.setCookbookWeight("500g");
			bean.setCookbookPrice("￥.13.48");
			everydayCookbookBeans.add(bean);
		}
		
		mEverydayCookbookAdapter = new EverydayCookbookAdapter(this, everydayCookbookBeans);
		wcGridView_everyday_cookbook.setNumColumns(2);
		wcGridView_everyday_cookbook.setHorizontalSpacing(10);
		wcGridView_everyday_cookbook.setVerticalSpacing(10);
		wcGridView_everyday_cookbook.setSelector(new ColorDrawable(Color.TRANSPARENT));
		wcGridView_everyday_cookbook.setFocusable(false);//解决ScrollView不在顶部的问题
		wcGridView_everyday_cookbook.setAdapter(mEverydayCookbookAdapter);
		
	}
}
