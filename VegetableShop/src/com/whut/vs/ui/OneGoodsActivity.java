package com.whut.vs.ui;
import java.util.ArrayList;
import java.util.List;
import com.whut.vegetableshop.R;
import com.whut.vs.application.SApplication;
import com.whut.vs.ui.fragments.OneGoodsDetailFragment;
import com.whut.vs.ui.fragments.OneGoodsInfoFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
/**
 * һ����ƷActivity ������<br/>
 * 1.��Ʒ���Fragment   <br/>
 * 2.��Ʒ����Fragment   <br/>
 * @author yubo
 */
public class OneGoodsActivity extends FinalActivity implements OnClickListener {

	private static final int ONE_GOODS_INFO_PAGE = 0;
	private static final int ONE_GOODS_DETAIL_PAGE= 1;
	
	private List<Fragment> mOneGoodsFragmentList;
	
	@ViewInject(id = R.id.vp_one_goods)
	private ViewPager mVpOneGoods;
	// ��Ʒ���ҳ
	@ViewInject(id = R.id.tv_one_goods_center_goods)
	private TextView tvOneGoodsInfo;
	// ��Ʒ����ҳ
	@ViewInject(id = R.id.tv_one_goods_center_detail)
	private TextView tvOneGoodsDetail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_one_goods);
		SApplication.getInstance().addActivity(this);
		init();
	}

	/**
	 * ��ʼ������ <br/> 
	 * 1.���fragmentList <br/> 
	 * 2.����tv�ĵ������   <br/> 
	 * 3.��ʼ��viewpager  <br/> 
	 */
	private void init() {
		mOneGoodsFragmentList = new ArrayList<Fragment>();
		mOneGoodsFragmentList.add(new OneGoodsInfoFragment());
		mOneGoodsFragmentList.add(new OneGoodsDetailFragment());
		
		tvOneGoodsInfo.setOnClickListener(this);
		tvOneGoodsDetail.setOnClickListener(this);
		//Ĭ����Ʒ���ҳ�汻ѡ��
		mVpOneGoods.setCurrentItem(ONE_GOODS_INFO_PAGE);
		mVpOneGoods.setAdapter(new OneGoodsInfoPagerAdapter(getSupportFragmentManager(),mOneGoodsFragmentList));
		mVpOneGoods.setOnPageChangeListener(new OneGoodsPagerChangeListener());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.tv_one_goods_center_goods:
			setCheckedPageState(ONE_GOODS_INFO_PAGE);
			mVpOneGoods.setCurrentItem(ONE_GOODS_INFO_PAGE);
			break;

		case R.id.tv_one_goods_center_detail:
			setCheckedPageState(ONE_GOODS_DETAIL_PAGE);
			mVpOneGoods.setCurrentItem(ONE_GOODS_DETAIL_PAGE);
			break;
		}
	}
	
	public class OneGoodsInfoPagerAdapter extends FragmentPagerAdapter{

		private List<Fragment> mOneGoodsFragmentList;
		
		public OneGoodsInfoPagerAdapter(FragmentManager fm,List<Fragment> OneGoodsFragmentList) {
			super(fm);
			this.mOneGoodsFragmentList = OneGoodsFragmentList;
		}
		@Override
		public Fragment getItem(int position) {
			return mOneGoodsFragmentList.get(position);
		}
		@Override
		public int getCount() {
			return mOneGoodsFragmentList.size();
		}
	}
	
	public class  OneGoodsPagerChangeListener implements OnPageChangeListener{
		@Override
		public void onPageScrollStateChanged(int arg0) {}
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {}
		@Override
		public void onPageSelected(int index) {
			if(index == ONE_GOODS_INFO_PAGE || index == ONE_GOODS_DETAIL_PAGE){
				setCheckedPageState(index);
			}
		}
	}
	
	
	/**
	 * ��tab��ǩ������ʽ: <br/>
	 * 0������Ʒ���ҳ��ѡ�� <br/>
	 * 1������Ʒ����ҳ��ѡ�� <br/>
	 * @param checkedIndex ҳ��index 
	 */
	public void setCheckedPageState(int checkedIndex){
		switch (checkedIndex) {
		case ONE_GOODS_INFO_PAGE:
			tvOneGoodsInfo.setTextColor(Color.WHITE);
			tvOneGoodsDetail.setTextColor(Color.parseColor("#FF8888"));
			break;
		case ONE_GOODS_DETAIL_PAGE:
			tvOneGoodsInfo.setTextColor(Color.parseColor("#FF8888"));
			tvOneGoodsDetail.setTextColor(Color.WHITE);
			break;
		}
	}
}