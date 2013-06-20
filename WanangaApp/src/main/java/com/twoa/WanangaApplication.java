package com.twoa;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Application;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class WanangaApplication extends Application {

    public Typeface getRobotoRegular() {
        return Typeface.createFromAsset(getAssets(), "fonts/RobotoSlab-Regular.ttf");
    }

    public Typeface getComboRegular() {
        return Typeface.createFromAsset(getAssets(), "fonts/Combo-Regular.ttf");
    }

    public Typeface getOpenSansRegular() {
        return Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Regular.ttf");
    }

    public Typeface getOpenSansLight() {
        return Typeface.createFromAsset(getAssets(), "fonts/OpenSans-Light.ttf");
    }
}
