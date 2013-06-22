package com.twoa.fragment.prayer;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twoa.R;
import com.twoa.WanangaApplication;

public class ContentFragment extends Fragment {

    private Typeface mOpenSans;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)	{
		return inflater.inflate(R.layout.fragment_prayer_content, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();

        mOpenSans = ((WanangaApplication) getActivity().getApplication()).getOpenSansRegular();
		setupView();
	}
	
	private void setupView() {
        Typeface openSans = ((WanangaApplication) (getActivity().getApplication())).getOpenSansLight();
        TextView paragraph1 = (TextView) getActivity().findViewById(R.id.paragraph_1_prayer_content);
        TextView paragraph2 = (TextView) getActivity().findViewById(R.id.paragraph_2_prayer_content);
        TextView paragraph3 = (TextView) getActivity().findViewById(R.id.paragraph_3_prayer_content);
        TextView paragraph4 = (TextView) getActivity().findViewById(R.id.paragraph_4_prayer_content);
        paragraph1.setTypeface(openSans);
        paragraph2.setTypeface(openSans);
        paragraph3.setTypeface(openSans);
        paragraph4.setTypeface(openSans);
	}
}