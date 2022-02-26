package com.example.ash.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import java.util.*;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    TextView t1;
    Button b1;
    String a="";
    String s="";
    StringBuilder sb=new StringBuilder(s);
    int b,j=2;
    char d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        t1=(TextView)findViewById(R.id.textView2);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          a = e1.getText().toString();
                                          for (int i = 0; i < a.length()-1; i+=2) {
                                              b=Integer.parseInt(a.substring(i,j));
                                              j+=2;
                                              d=(char)b;
                                              sb.append(d);

                                          }

                                          t1.setText(sb);
                                      }
                                  }
        );

    }
}
