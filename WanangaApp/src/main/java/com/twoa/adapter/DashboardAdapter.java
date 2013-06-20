package com.twoa.adapter;


import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.twoa.R;
import com.twoa.WanangaApplication;

import static com.twoa.R.layout.adapter_dashboard;

/**
 * Created by Raukawa on 20/06/13.
 */
public class DashboardAdapter extends BaseAdapter {

    private LayoutInflater mLayoutInflater;
    private String[] mDashboardOptions;
    private Typeface mOpenSans;

    public DashboardAdapter(Context context) {
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDashboardOptions = context.getResources().getStringArray(R.array.dashboard_options);
        mOpenSans = ((WanangaApplication) context.getApplicationContext()).getOpenSansLight();
    }

    @Override
    public int getCount() {
        return mDashboardOptions.length;
    }

    @Override
    public Object getItem(int position) {
        return mDashboardOptions[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        if(view == null) {
            view = mLayoutInflater.inflate(adapter_dashboard, null);
        }

        ImageView imageView = (ImageView) view.findViewById(R.id.adapter_dashboard_image);
        TextView textView = (TextView) view.findViewById(R.id.adapter_dashboard_title);
        textView.setTypeface(mOpenSans);
        BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
        bitmapOptions.inSampleSize = 16;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        switch (position) {
            case 0:
                Bitmap bitmap = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap);
                textView.setText(view.getResources().getString(R.string.title_karakia));
                break;
            case 1:
                Bitmap bitmap1 = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap1);
                textView.setText(view.getResources().getString(R.string.title_waiata_himene));
                break;
            case 2:
                Bitmap bitmap2 = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap2);
                textView.setText(view.getResources().getString(R.string.title_powhiri));
                break;
            case 3:
                Bitmap bitmap3 = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap3);
                textView.setText(view.getResources().getString(R.string.title_haka_powhiri));
                break;
            case 4:
                Bitmap bitmap4 = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap4);
                textView.setText(view.getResources().getString(R.string.title_moteatea));
                break;
            case 5:
                Bitmap bitmap5 = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap5);
                textView.setText(view.getResources().getString(R.string.title_mihi));
                break;
            case 6:
                Bitmap bitmap6 = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap6);
                textView.setText(view.getResources().getString(R.string.title_hononga));
                break;
            case 7:
                Bitmap bitmap7 = BitmapFactory.decodeResource(view.getResources(), R.drawable.image_karakia, bitmapOptions);
                imageView.setImageBitmap(bitmap7);
                textView.setText(view.getResources().getString(R.string.title_whakatauki));
                break;
            default:
                break;
        }

        return view;
    }
}
