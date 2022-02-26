package com.example.ash.hangman;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button play;
@Override
 protected void onCreate(Bundle inst)
    {
        super.onCreate(inst);
        setContentView(R.layout.activity_main);
        play = (Button)findViewById(R.id.button);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intgam=new Intent(getBaseContext(),GameActivity.class);
                startActivity(intgam);

            }
        });
    }
}


