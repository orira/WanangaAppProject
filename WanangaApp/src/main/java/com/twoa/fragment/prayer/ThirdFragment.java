package com.twoa.fragment.prayer;

import android.content.res.AssetFileDescriptor;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.twoa.R;
import com.twoa.WanangaApplication;

import java.io.IOException;

public class ThirdFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mPlayer;
    private Boolean mPlaying = false;
    private Button mButton;

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)	{
		return inflater.inflate(R.layout.fragment_prayer_third, container, false);
	}

	@Override
	public void onStart() {
		super.onStart();

        setupView();
	}
	
    @Override
    public void onClick(View view) {
        if(mPlaying) {
            mPlayer.stop();
            mButton.setText(getResources().getString(R.string.button_start));
            mPlaying = false;
        } else {
            setupAudio();
            mPlayer.start();
            mButton.setText(getResources().getString(R.string.button_stop));
            mPlaying = true;
        }
    }

    private void setupView() {
        Typeface openSans = ((WanangaApplication) (getActivity().getApplication())).getOpenSansLight();
        TextView line1 = (TextView) getActivity().findViewById(R.id.line_1_prayer_fragment_third);
        TextView line2 = (TextView) getActivity().findViewById(R.id.line_2_prayer_fragment_third);
        TextView line3 = (TextView) getActivity().findViewById(R.id.line_3_prayer_fragment_third);
        TextView line4 = (TextView) getActivity().findViewById(R.id.line_4_prayer_fragment_third);
        TextView line5 = (TextView) getActivity().findViewById(R.id.line_5_prayer_fragment_third);
        TextView line6 = (TextView) getActivity().findViewById(R.id.line_6_prayer_fragment_third);
        TextView line7 = (TextView) getActivity().findViewById(R.id.line_7_prayer_fragment_third);
        TextView line8 = (TextView) getActivity().findViewById(R.id.line_8_prayer_fragment_third);
        TextView line9 = (TextView) getActivity().findViewById(R.id.line_9_prayer_fragment_third);
        TextView line10 = (TextView) getActivity().findViewById(R.id.line_10_prayer_fragment_third);
        TextView line11 = (TextView) getActivity().findViewById(R.id.line_11_prayer_fragment_third);
        TextView line12 = (TextView) getActivity().findViewById(R.id.line_12_prayer_fragment_third);
        TextView line13 = (TextView) getActivity().findViewById(R.id.line_13_prayer_fragment_third);
        TextView line14 = (TextView) getActivity().findViewById(R.id.line_14_prayer_fragment_third);
        TextView line15 = (TextView) getActivity().findViewById(R.id.line_15_prayer_fragment_third);
        TextView line16 = (TextView) getActivity().findViewById(R.id.line_16_prayer_fragment_third);
        TextView line17 = (TextView) getActivity().findViewById(R.id.line_17_prayer_fragment_third);
        line1.setTypeface(openSans);
        line2.setTypeface(openSans);
        line3.setTypeface(openSans);
        line4.setTypeface(openSans);
        line5.setTypeface(openSans);
        line6.setTypeface(openSans);
        line7.setTypeface(openSans);
        line8.setTypeface(openSans);
        line9.setTypeface(openSans);
        line10.setTypeface(openSans);
        line11.setTypeface(openSans);
        line12.setTypeface(openSans);
        line13.setTypeface(openSans);
        line14.setTypeface(openSans);
        line15.setTypeface(openSans);
        line16.setTypeface(openSans);
        line17.setTypeface(openSans);

        mButton = (Button) getActivity().findViewById(R.id.button_karakia_third);
        mButton.setOnClickListener(this);

        setupAudio();
    }

    private void setupAudio() {
        AssetFileDescriptor afd = null;
        mPlayer = new MediaPlayer();
        try {
            afd = getActivity().getAssets().openFd("audio/karakia3.mp3");
            mPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}