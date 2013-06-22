package com.twoa.fragment.hymn;

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
		return inflater.inflate(R.layout.fragment_hymn_content, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();

        mOpenSans = ((WanangaApplication) getActivity().getApplication()).getOpenSansRegular();
		setupView();
	}
	
	private void setupView() {
        Typeface openSans = ((WanangaApplication) (getActivity().getApplication())).getOpenSansLight();
        TextView paragraph1 = (TextView) getActivity().findViewById(R.id.paragraph_1_hymn_content);
        paragraph1.setTypeface(openSans);
	}
}