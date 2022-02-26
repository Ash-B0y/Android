package com.example.ash.files;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Fs extends AppCompatActivity {
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fs);
        button=(Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text="";

                try {
                    InputStream is= getAssets().open("asf.txt");
                    int size=is.available();
                    byte []buffer=new byte[size];
                    is.read(buffer);
                    is.close();
                    text=new String(buffer);
                    char a[]=text.toCharArray();
                    int i=0,j=0;
                    while(i<text.length()){
                        if(a[i]==' ')
                        {
                            System.out.println(text.substring(j,i));
                            j=i+1;

                        }
                        i++;

                    }
                    System.out.println(text.substring(j,i));

                } catch (IOException e) {
                    e.printStackTrace();
                }textView.setText(text);
                Log.e("error",text);

            }
        });
    }
}
