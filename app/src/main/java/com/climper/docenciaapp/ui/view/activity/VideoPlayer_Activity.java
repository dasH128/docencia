package com.climper.docenciaapp.ui.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.climper.docenciaapp.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoPlayer_Activity extends YouTubeBaseActivity {
    private final String API = "AIzaSyBzyApTiGtDwTnoQck4HScoGPKqwxpBjmA";
    String codVideo = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        Bundle parametros = this.getIntent().getExtras();
        codVideo =parametros.getString("cod");
        Log.i("cod-> ",""+codVideo);

        YouTubePlayerView youtube = (YouTubePlayerView) findViewById(R.id.videoPlayer);
        youtube.initialize(API, new YouTubePlayer.OnInitializedListener(){
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if (!b) {
                    youTubePlayer.cueVideo(codVideo);
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
    }
}
