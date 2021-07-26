package com.example.switchingscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class secondscreen extends AppCompatActivity {

    MediaPlayer player;
    Vibrator vibrator;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();



        setContentView(R.layout.activity_secondscreen);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
    }

    public void play(View view) {
        if(player==null)
        {
            player = MediaPlayer.create(this,R.raw.song2_1);
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
    public void play2(View view) {

        if(player==null)
        {
            player = MediaPlayer.create(this,R.raw.panic);
        }
        else {stopping(); player = MediaPlayer.create(this,R.raw.panic);}

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopping();
            }
        });
        player.start();
    }

    public void play3(View view) {
        if(player==null)
        {
            player = MediaPlayer.create(this,R.raw.panicvid_real);
        }
        else
        {stopping(); player = MediaPlayer.create(this,R.raw.panicvid_real);}

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopping();
            }
        });
        player.start();

        if(Build.VERSION.SDK_INT>=26) {
            vibrator.vibrate(VibrationEffect.createOneShot(8000, VibrationEffect.DEFAULT_AMPLITUDE));
        }
        else
        {
            vibrator.vibrate(VibrationEffect.createOneShot(8000, VibrationEffect.DEFAULT_AMPLITUDE));

        }


    }

    public void pause3(View view) {
        player.pause();
    }

    public void stop3(View view) {
        stopping();
    }

}