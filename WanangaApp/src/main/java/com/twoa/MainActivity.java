package com.twoa;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Typeface;

import com.twoa.adapter.DashboardAdapter;
import com.twoa.component.PrayerActivity;

public class MainActivity extends Activity {

    private GridView mGridView;
    private Bundle mAnimationBundle;
    private Typeface mRoboto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRoboto = ((WanangaApplication) getApplicationContext()).getOpenSansLight();

        setupActionBar();
        setupView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:
                transitionToAboutView();
        }
        return super.onOptionsItemSelected(item);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void transitionToAboutView() {
        Intent invoiceIntent = new Intent(this, AboutActivity.class);
        startActivity(invoiceIntent, mAnimationBundle);
    }

    private void setupActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_grey));
        actionBar.setIcon(getResources().getDrawable(R.drawable.logo_main));

        ImageView view = (ImageView)findViewById(android.R.id.home);
        view.setPadding(0, 0, 20, 0);

        SpannableString title = new SpannableString("Rarangi matua");
        title.setSpan(mRoboto, 0, title.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        actionBar.setTitle(title);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setupView() {
        mAnimationBundle = ActivityOptions.makeCustomAnimation(this, R.anim.slide_in_bottom_500, R.anim.fade_out_and_scale_500).toBundle();
        mGridView = (GridView) findViewById(R.id.gridview_main);
        mGridView.setAdapter(new DashboardAdapter(this));
        mGridView.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                TextView textView = (TextView) view.findViewById(R.id.adapter_dashboard_title);

                switch(position) {
                    case 0:
                        textView.setText("Prayer");
                        transitionToView("Prayer");
                        break;
                    case 1:
                        textView.setText("Hymns");
                        break;
                    case 2:
                        textView.setText("Welcome Ceremony");
                        break;
                    case 3:
                        textView.setText("Welcoming Haka");
                        break;
                    case 4:
                        textView.setText("Dirge");
                        break;
                    case 5:
                        textView.setText("Salutations");
                        break;
                    case 6:
                        textView.setText("Useful Links");
                        break;
                    case 7:
                        textView.setText("Proverbs");
                        break;
                }
            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void transitionToView(String view) {
        if(view.equals("Prayer")) {
            Intent intent = new Intent(this, PrayerActivity.class);
            startActivity(intent, mAnimationBundle);
        }
    }
}
