package com.ejia.abplayer.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ejia.abplayer.fragment.BangumiFragment;
import com.ejia.abplayer.fragment.DonghuaFragment;
import com.ejia.abplayer.fragment.GamesCenterFragment;
import com.ejia.abplayer.fragment.HomePageFragment2;
import com.ejia.abplayer.fragment.PromotionFragment;
import com.ejia.abplayer.fragment.SubareaFragment;

/**
 * FragmentPager适配器
 * 
 * @author wwj_748
 * @2014/8/9
 */
public class MainTabAdapter extends FragmentPagerAdapter {
	// 内容标题
	public static final String[] DONG_HUA_TITLE = new String[] { "首页",
			"分区导航","精品应用"};
	public HomePageFragment2 homepage = new HomePageFragment2();
	public SubareaFragment subarea = new SubareaFragment();
	
	public MainTabAdapter(FragmentManager fm) {
		super(fm);
		// TODO Auto-generated constructor stub
	}


	// 获取项
	@Override
	public Fragment getItem(int position) {
		System.out.println("Fragment position:" + position);
		
		switch (position) {
		case 0:
			return homepage;
		case 1:
			return subarea;
		case 2:
			return new PromotionFragment();
		default:
			return new DonghuaFragment(33);
		}
		
		// MainFragment fragment = new MainFragment(position);
		// return fragment;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// 返回页面标题
		return DONG_HUA_TITLE[position % DONG_HUA_TITLE.length].toUpperCase();
	}

	@Override
	public int getCount() {
		// 页面个数
		return DONG_HUA_TITLE.length;
	}

}
