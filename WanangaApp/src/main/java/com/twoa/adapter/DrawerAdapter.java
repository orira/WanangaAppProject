package com.twoa.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.twoa.R;
import com.twoa.WanangaApplication;

public class DrawerAdapter extends BaseAdapter{
	
	private String[] mItems;
	private LayoutInflater mLayoutInflator;
	private Typeface mOpenSansLight;
	
	public DrawerAdapter(Context context, String[] items) {
		mLayoutInflator = ( LayoutInflater ) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
		mItems = items;
		mOpenSansLight = ((WanangaApplication) context.getApplicationContext()).getOpenSansLight();
	}

	@Override
	public int getCount() {
		return mItems.length;
	}

	@Override
	public String getItem(int position) {
		return mItems[position];
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		
		if (view == null){
             view = mLayoutInflator.inflate(R.layout.drawer_list_item, null);
        }
		
		((TextView) view).setText(mItems[position]);
		((TextView) view).setTypeface(mOpenSansLight);		
		
		return view;
	}		
}
