package com.example.threadbasic2;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.WorkerThread;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Thread wr;
    boolean running = true;
    final String TAG = "THREAD2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        running = true;
        wr = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                for(i = 0; i< 20 && running; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                    Log.v("TAG", "Runnable time" + i);
                }
            }
        });
        wr.start();
        Log.v(TAG, "Now I am in onStart");
    }
    @Override
    public void onStop() {
        super.onStop();
        running = false;
        Log.v(TAG, "Now I am in onStop" );
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v(TAG, "Now I am in onPause" );
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v(TAG, "Now I am in onResume" );
    }
}