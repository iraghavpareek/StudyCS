package com.example.studycs;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class cvideo extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsvideo);

        YouTubePlayerView youTubeView = (YouTubePlayerView)findViewById(R.id.jsv1);
        youTubeView.initialize(DeveloperKey.DEVELOPER_KEY, this);

    }
    public class DeveloperKey {
        public static final String DEVELOPER_KEY = "AIzaSyC5WbpTvRyly3H0dAUAMsGT55_9ZBfcmTA";
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) player.cueVideo("8PopR3x-VMY");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }


}

