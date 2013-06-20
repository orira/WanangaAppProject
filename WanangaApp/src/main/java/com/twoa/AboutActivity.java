package com.twoa;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class AboutActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        setupActionBar();
        setupView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home: {
                transitionToMainActivity();
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
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(getResources().getDrawable(R.drawable.gradient_grey));
        actionBar.setIcon(getResources().getDrawable(R.drawable.logo_main));
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setupView() {
        Typeface openSans = ((WanangaApplication) getApplication()).getOpenSansLight();
        Typeface roboto = ((WanangaApplication) getApplication()).getRobotoRegular();

        TextView paragraph1 = (TextView) findViewById(R.id.activity_about_paragraph_1);
        paragraph1.setTypeface(openSans);

        TextView paragraph2 = (TextView) findViewById(R.id.activity_about_paragraph_2);
        paragraph2.setTypeface(openSans);

        TextView developers = (TextView) findViewById(R.id.activity_about_developers);
        developers.setTypeface(roboto);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void transitionToMainActivity() {
        Intent invoiceIntent = new Intent(this, MainActivity.class);
        Bundle animationBundle = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in_and_scale_600, R.anim.slide_out_bottom_300).toBundle();
        startActivity(invoiceIntent, animationBundle);
    }
}
