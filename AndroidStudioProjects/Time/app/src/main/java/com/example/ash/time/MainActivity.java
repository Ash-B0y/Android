package com.example.ash.time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText hh,mm,ap;
    TextView usa,gmt;
    Button convert;
    private int swap(int a){
        if(a==0)
            return 1;
        else
            return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hh = (EditText) findViewById(R.id.hour);
        mm = (EditText) findViewById(R.id.min);
        usa = (TextView) findViewById(R.id.usa);
        gmt = (TextView) findViewById(R.id.gmt);
        convert = (Button) findViewById(R.id.convert);
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int h=Integer.parseInt(hh.getText().toString()),m =Integer.parseInt(mm.getText().toString());
                if(h>23||h<0||m<0|m>59){
                    usa.setText("USA :");
                    gmt.setText("GMT :");
                    Toast.makeText(getApplicationContext(), "Invalid time", Toast.LENGTH_LONG).show();
                }else {
                    int usa_hr=h-9,usa_min=m-30;
                    if(usa_min<0){
                        usa_hr--;
                        usa_min+=60;
                    }
                    if(usa_hr<0){
                        usa_hr+=24;
                    }
                    if(usa_hr>11){
                        int hr=usa_hr%12;
                        String hr_str="",min_str="";
                        if(hr<10){
                            hr_str="0";
                        }
                        hr_str+=hr;
                        if(usa_min<10){
                            min_str="0";
                        }
                        min_str+=usa_min;
                        usa.setText("USA :"+hr_str+":"+min_str+":PM");
                    }else {
                        int hr=usa_hr;
                        String hr_str="",min_str="";
                        if(hr<10){
                            hr_str="0";
                        }
                        hr_str+=hr;
                        if(usa_min<10){
                            min_str="0";
                        }
                        min_str+=usa_min;
                        usa.setText("USA :" + hr_str + ":" + min_str+":AM");
                    }
                    int gmt_hr=usa_hr+4;
                    gmt_hr%=24;
                    if(gmt_hr>11) {
                        int hr=gmt_hr%12;
                        String hr_str="",min_str="";
                        if(hr<10){
                            hr_str="0";
                        }
                        hr_str+=hr;
                        if(usa_min<10){
                            min_str="0";
                        }
                        min_str+=usa_min;
                        gmt.setText("GMT :" + hr_str + ":" + min_str+":PM");
                    }else{
                        int hr=gmt_hr;
                        String hr_str="",min_str="";
                        if(hr<10){
                            hr_str="0";
                        }
                        hr_str+=hr;
                        if(usa_min<10){
                            min_str="0";
                        }
                        min_str+=usa_min;
                        gmt.setText("GMT :" + hr_str + ":" + min_str+":AM");
                    }
                }
            }
        });
    }
}
