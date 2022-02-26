package com.example.ash.string;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        e1=(EditText)findViewById(R.id.editText);
        t1=(TextView)findViewById(R.id.textView2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int t=0;
                String s1="";
                String textStr = e1.getText().toString();
                StringBuilder sb = new StringBuilder(textStr);
                for(int i=0;i<sb.length();i=i+2)
                {
                 t=sb.charAt(i)-'0';
                  for(int j=0;j<t;j++)
                  {
                      s1+=sb.charAt(i+1);
                  }
                }
                t1.setText(s1);
                     }
        });


    }
}
