package com.example.ash.sum;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    TextView t1,t2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.editText);
        e2 = (EditText) findViewById(R.id.editText2);
        t1 = (TextView) findViewById(R.id.textView4);
        t2 = (TextView) findViewById(R.id.textView5);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {

                                          convert();
                                      }
                                  }
        );
    }
    public void convert()
    {
        double a,b,c,d;
        a =Double.parseDouble(e1.getText().toString());
        b = Double.parseDouble(e2.getText().toString());
        c=(a*(3.14))/180.0;
        d=(b*(180.0))/3.14;
        t1.setText("The Corresponding value in Radian is:"+c);
        t2.setText("The Corresponding value in Degree is:"+d);


    }
}


