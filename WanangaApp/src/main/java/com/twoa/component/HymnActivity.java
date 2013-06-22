package com.twoa.component;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.twoa.MainActivity;
import com.twoa.R;
import com.twoa.adapter.ContentPagerAdapter;
import com.twoa.adapter.DrawerAdapter;
import com.twoa.adapter.transformer.ZoomOutPageTransformer;
import com.twoa.fragment.hymn.ContentFragment;
import com.twoa.fragment.hymn.FifthFragment;
import com.twoa.fragment.hymn.FirstFragment;
import com.twoa.fragment.hymn.FourthFragment;
import com.twoa.fragment.hymn.SecondFragment;
import com.twoa.fragment.hymn.ThirdFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raukawa on 20/06/13.
 */
public class HymnActivity extends FragmentActivity {

    private ActionBar mActionBar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;
    private ViewPager mViewPager;
    private int mCurrentIndex;

    private Fragment mContentFragment;
    private Fragment mFirstFragment;
    private Fragment mSecondFragment;
    private Fragment mThirdFragment;
    private Fragment mFourthFragment;
    private Fragment mFifthFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);

        setupActionBar();
        setupNavigationDrawer();
        instantiateFragments();
        setupPager();
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home: {
                toggleDrawer();
                return true;
            }
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        transitionToMainActivity();
    }

    private void setupActionBar() {
        mActionBar = getActionBar();
        mActionBar.setTitle(getResources().getString(R.string.title_waiata_himene));
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_grey));
        mActionBar.setIcon(getResources().getDrawable(R.drawable.logo_main));
        ImageView view = (ImageView)findViewById(android.R.id.home);
        view.setPadding(20, 0, 20, 0);
    }

    private void setupNavigationDrawer() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_prayer);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                R.drawable.icon_drawer,
                R.string.drawer_open,
                R.string.drawer_closed) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                setCurrentTitle(mCurrentIndex);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                mActionBar.setTitle(getResources().getString(R.string.title_menu));
            }
        };

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerList = (ListView) findViewById(R.id.drawer_left_prayer);
        mDrawerList.setAdapter( new DrawerAdapter(this, getResources().getStringArray(R.array.drawer_hymn)));
        mDrawerList.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mDrawerLayout.closeDrawer(mDrawerList);
                switch(position) {
                    case 0:
                        mCurrentIndex = 0;
                        break;
                    case 1:
                        mCurrentIndex = 1;
                        break;
                    case 2:
                        mCurrentIndex = 2;
                        break;
                    case 3:
                        mCurrentIndex = 3;
                        break;
                    case 4:
                        mCurrentIndex = 4;
                        break;
                    case 5:
                        mCurrentIndex = 5;
                        break;
                    default:
                        break;
                }

                mViewPager.setCurrentItem(mCurrentIndex);
            }
        });
    }

    private void instantiateFragments() {
        mContentFragment = new ContentFragment();
        mFirstFragment = new FirstFragment();
        mSecondFragment = new SecondFragment();
        mThirdFragment = new ThirdFragment();
        mFourthFragment = new FourthFragment();
        mFifthFragment = new FifthFragment();
    }

    private void setupPager() {
        mViewPager = (ViewPager) findViewById(R.id.activity_pager_prayer);
        mViewPager.setAdapter(new ContentPagerAdapter(getSupportFragmentManager(), getFragments()));
        mViewPager.setPageTransformer(false, new ZoomOutPageTransformer());

        mViewPager.setOnPageChangeListener( new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int i, float v, int i2) {}

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mCurrentIndex = position;
                        break;
                    case 1:
                        mCurrentIndex = position;
                        break;
                    case 2:
                        mCurrentIndex = position;
                        break;
                    case 3:
                        mCurrentIndex = position;
                        break;
                    case 4:
                        mCurrentIndex = position;
                        break;
                    case 5:
                        mCurrentIndex = position;
                        break;
                    default:
                        break;
                }
                setCurrentTitle(mCurrentIndex);
            }

            @Override
            public void onPageScrollStateChanged(int i) {}
        });
    }

    private List<Fragment> getFragments() {
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(Fragment.instantiate(this, mContentFragment.getClass().getName()));
        fragments.add(Fragment.instantiate(this, mFirstFragment.getClass().getName()));
        fragments.add(Fragment.instantiate(this, mSecondFragment.getClass().getName()));
        fragments.add(Fragment.instantiate(this, mThirdFragment.getClass().getName()));
        fragments.add(Fragment.instantiate(this, mFourthFragment.getClass().getName()));
        fragments.add(Fragment.instantiate(this, mFifthFragment.getClass().getName()));

        return fragments;
    }

    private void toggleDrawer() {
        if(mDrawerLayout.isDrawerOpen(mDrawerList)) {
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            mDrawerLayout.openDrawer(mDrawerList);
        }
    }

    private void setCurrentTitle(int currentIndex) {
        switch (currentIndex) {
            case 0:
                mActionBar.setTitle(getResources().getString(R.string.title_waiata_himene));
                break;
            case 1:
                mActionBar.setTitle(getResources().getString(R.string.title_hymn_first));
                break;
            case 2:
                mActionBar.setTitle(getResources().getString(R.string.title_hymn_second));
                break;
            case 3:
                mActionBar.setTitle(getResources().getString(R.string.title_hymn_third));
                break;
            case 4:
                mActionBar.setTitle(getResources().getString(R.string.title_hymn_fourth));
                break;
            case 5:
                mActionBar.setTitle(getResources().getString(R.string.title_hymn_fifth));
                break;
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void transitionToMainActivity() {
        Intent invoiceIntent = new Intent(this, MainActivity.class);
        Bundle animationBundle = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in_and_scale_600, R.anim.slide_out_bottom_300).toBundle();
        startActivity(invoiceIntent, animationBundle);
    }
}
