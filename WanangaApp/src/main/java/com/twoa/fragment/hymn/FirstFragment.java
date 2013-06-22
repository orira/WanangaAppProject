package com.twoa.fragment.hymn;

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

public class FirstFragment extends Fragment implements View.OnClickListener {

    private MediaPlayer mPlayer;
    private Boolean mPlaying = false;
    private Button mButton;

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)	{
		return inflater.inflate(R.layout.fragment_hymn_first, container, false);
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
        TextView line1 = (TextView) getActivity().findViewById(R.id.line_1_hymn_fragment_first);
        TextView line2 = (TextView) getActivity().findViewById(R.id.line_2_hymn_fragment_first);
        TextView line3 = (TextView) getActivity().findViewById(R.id.line_3_hymn_fragment_first);
        TextView line4 = (TextView) getActivity().findViewById(R.id.line_4_hymn_fragment_first);
        TextView line5 = (TextView) getActivity().findViewById(R.id.line_5_hymn_fragment_first);
        TextView line6 = (TextView) getActivity().findViewById(R.id.line_6_hymn_fragment_first);
        TextView line7 = (TextView) getActivity().findViewById(R.id.line_7_hymn_fragment_first);
        TextView line8 = (TextView) getActivity().findViewById(R.id.line_8_hymn_fragment_first);
        TextView line9 = (TextView) getActivity().findViewById(R.id.line_9_hymn_fragment_first);
        line1.setTypeface(openSans);
        line2.setTypeface(openSans);
        line3.setTypeface(openSans);
        line4.setTypeface(openSans);
        line5.setTypeface(openSans);
        line6.setTypeface(openSans);
        line7.setTypeface(openSans);
        line8.setTypeface(openSans);
        line9.setTypeface(openSans);

        mButton = (Button) getActivity().findViewById(R.id.button_himene_first);
        mButton.setOnClickListener(this);

        setupAudio();
    }

    private void setupAudio() {
        AssetFileDescriptor afd = null;
        mPlayer = new MediaPlayer();
        try {
            afd = getActivity().getAssets().openFd("audio/himene1.mp3");
            mPlayer.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
            mPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}