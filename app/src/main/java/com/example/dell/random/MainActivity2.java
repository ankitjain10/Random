package com.example.dell.random;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;


public class MainActivity2 extends ActionBarActivity {

    MediaPlayer playSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        playSong = MediaPlayer.create(MainActivity2.this, R.drawable.banno);
        playSong.start();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(1000);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                } finally {
                    Intent intent = new Intent("com.example.dell.random.Menu");
                    startActivity(intent);
                }
            }

        };
        thread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
        playSong.release();
    }
}
