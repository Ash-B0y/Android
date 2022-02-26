package com.example.ash.sub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText ed1,ed2;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1=(EditText)findViewById(R.id.editText);
        ed2=(EditText)findViewById(R.id.editText2);
    }

    public void subr(View view) {
        int n1=Integer.parseInt(ed1.getText().toString());
        int n2=Integer.parseInt(ed2.getText().toString());
        int t=Math.abs(n1-n2);
        t1=(TextView)findViewById(R.id.textView);
        t1.setText(""+t);

    }

}
