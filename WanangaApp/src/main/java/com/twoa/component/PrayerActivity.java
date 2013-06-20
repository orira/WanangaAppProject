package com.twoa.component;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.twoa.MainActivity;
import com.twoa.R;

/**
 * Created by Raukawa on 20/06/13.
 */
public class PrayerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer);

        setupActionBar();
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
        actionBar.setTitle("");
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void transitionToMainActivity() {
        Intent invoiceIntent = new Intent(this, MainActivity.class);
        Bundle animationBundle = ActivityOptions.makeCustomAnimation(this, R.anim.fade_in_and_scale_600, R.anim.slide_out_bottom_300).toBundle();
        startActivity(invoiceIntent, animationBundle);
    }
}
