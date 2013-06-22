package com.twoa.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class ContentPagerAdapter extends FragmentStatePagerAdapter
{
	private List<Fragment> fragments;
	
	public ContentPagerAdapter(android.support.v4.app.FragmentManager fragmentManager, List<Fragment> fragments)
	{
		super( fragmentManager );
		this.fragments = fragments;
	}
	
	@Override
	public Fragment getItem( int position ) {
		return fragments.get( position );
	}

	@Override
	public int getCount() {
		return fragments.size();
	}
}
