package com.example.ash.volley;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    Button b1;
    Button b2;
    ImageView img;
    String chk = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.Mob);
        e2 = (EditText) findViewById(R.id.Otp);
        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button2);
        b1.setEnabled(false);
        b2.setEnabled(false);
        img = (ImageView) findViewById(R.id.imageView);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        boolean net = haveNetworkConnection();
        if (net) {
            //img.setVisibility(View.VISIBLE);
            //img.setImageResource(R.drawable.sims);
        } else {
            Toast.makeText(getApplicationContext(), "Unable to Connect To sims Hospital,Kindly contact 044 2591 3333 ", Toast.LENGTH_LONG).show();
            //img.setVisibility(View.INVISIBLE);
        }
        e1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                e1.setHint("");
                return false;
            }
        });

        TextWatcher textWatcher = new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.length() == 10) {
                    b1.setEnabled(true);
                }

            }
        };
        e1.addTextChangedListener(textWatcher);
        e2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                e2.setHint("");
                return false;
            }
        });
        TextWatcher textWatch = new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.length() == 5) {
                    b2.setEnabled(true);
                }

            }
        };
        final RequestQueue MyRequestQueue = Volley.newRequestQueue(this);
        e2.addTextChangedListener(textWatch);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                e2.setHint("Enter OTP");
                String phoneNo = e1.getText().toString();
                if (isValid(phoneNo)) {
                    Toast.makeText(getApplicationContext(), "Valid Number", Toast.LENGTH_LONG).show();
                    Random rand = new Random();
                    int pickedNumber = rand.nextInt(99999) + 1;
                    String msg = Integer.toString(pickedNumber);
                    chk = chk + msg;
                    String otp = "Your One-Time-Password for booking an appointment using Volley library is ";
                    otp = otp + msg;
                    String user = "vignana";
                    final String text = otp;
                    String pass = "smsvignana";
                    String sender = "SAHOSP";
                    final String phone = e1.getText().toString();
                    String priority = "ndnd";
                    String stype = "normal";
                    String url = "http://bhashsms.com/api/sendmsg.php?user=vignana&pass=smsvignana&sender=SAHOSP&phone=" + phone + "&text=" + text + "&priority=ndnd&stype=normal";
                    StringRequest MyStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            //This code is executed if the server responds, whether or not the response contains data.

                        }
                    }, new Response.ErrorListener() { //Create an error listener to handle errors appropriately.
                        @Override
                        public void onErrorResponse(VolleyError error) {

                        }
                    }) {
                        protected Map<String, String> getParams() {
                            Map<String, String> MyData = new HashMap<String, String>();
                            MyData.put("phone", phone);
                            MyData.put("text",text);//Add the data you'd like to send to the server.
                            return MyData;
                        }

                    };
                    MyRequestQueue.add(MyStringRequest);
                } else
                    Toast.makeText(getApplicationContext(), "Invalid Number ", Toast.LENGTH_LONG).show();


            }
        });


    }

    public boolean isValid(String s) {

        Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m = p.matcher(s);
        return (m.find() && m.group().equals(s));
    }

    private boolean haveNetworkConnection() {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    }




