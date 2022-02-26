package com.example.ash.magic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Ph1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ph1);
        Toast.makeText(getApplicationContext(), "Choose any card from the given six.......", Toast.LENGTH_SHORT).show();

        Thread thread=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intermed=new Intent(getApplicationContext(),Inter.class);
                    startActivity(intermed);
                    finish();
                }
            }
        });
        thread.start();
    }
}
