package com.whut.vs.adapters;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


/*** 
 * @author xiongbin
 * @date 2016-3-18
 * @description Í¨ÓÃViewPagerÊÊÅäÆ÷
 */
public class GoodsListViewPagerAdapter extends FragmentPagerAdapter {
	private List<Fragment> fragments;

	public GoodsListViewPagerAdapter(FragmentManager fm,List<Fragment> fragments) {
		super(fm);
		this.fragments = fragments;
	}

	@Override
	public Fragment getItem(int index) {
		return fragments.get(index);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}
}