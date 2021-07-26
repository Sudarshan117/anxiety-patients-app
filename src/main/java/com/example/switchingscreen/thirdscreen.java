package com.example.switchingscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class thirdscreen extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_thirdscreen);
    }

    public void play(View view) {
        if(player==null)
        {
            player = MediaPlayer.create(this,R.raw.anxietyvid_real);
        }
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopping();
            }
        });
        player.start();
    }

    public void pause(View view) {
        player.pause();
    }

    public void stop(View view) {
        stopping();
    }

    private void stopping()
    {
        if (player != null) {

            player.release();
            player=null;
            Toast.makeText(this," Stopping...",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopping();
    }

    public void play_r(View view) {
        if(player==null)
        {
            player = MediaPlayer.create(this,R.raw.rain);
        }
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopping();
            }
        });
        player.start();
    }

    public void pause_r(View view) {
        player.pause();
    }

    public void stop_r(View view) {
        stopping();
    }

}