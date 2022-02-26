package com.example.ash.flames;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ene extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ene);
        Thread thread=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    finish();

                }
            }
        });
        thread.start();



    }
    }

