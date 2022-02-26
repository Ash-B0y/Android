package com.example.ash.smstest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
        boolean net = haveNetworkConnection();
        if (net) {
            img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.sims);
        } else {
            Toast.makeText(getApplicationContext(), "Unable to Connect To sims Hospital,Kindly contact 044 2591 3333 ", Toast.LENGTH_LONG).show();
            img.setVisibility(View.INVISIBLE);
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
        e2.addTextChangedListener(textWatch);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e2.setHint("Enter OTP");
                String phoneNo = e1.getText().toString();
                if (isValid(phoneNo)) {
                    Toast.makeText(getApplicationContext(), "Valid Number", Toast.LENGTH_LONG).show();
                    sendssms send = new sendssms();
                    send.execute(phoneNo);
                } else
                    Toast.makeText(getApplicationContext(), "Invalid Number ", Toast.LENGTH_LONG).show();


            }
        });

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
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
    public class sendssms extends AsyncTask<String, String, String> {

        String a="";
        String server_response;
        @Override
        protected void onPreExecute() {
            Toast.makeText(MainActivity.this, "Sending SMS", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_SHORT).show();

        }

        @Override
        protected String doInBackground(String... params) {
            try {
                chk = "";
                Random rand = new Random();
                int pickedNumber = rand.nextInt(99999) + 1;
                String msg = Integer.toString(pickedNumber);
                chk = chk + msg;
                String otp = "Your One-Time-Password for booking an appointment is ";
                otp = otp + msg;
                String apiKey = "apikey=" + "Q/kLyn+k/cI-ChoulO2trrUNNG2a6Z6wcSmQi5WDMr";
                String message = "&message=" + otp;
                String sender = "&sender=" + "TXTLCL";
                String numbers = "&numbers=" + params[0];
                String data = apiKey + numbers + message + sender;
                // Send data
                HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.getOutputStream().write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                String line;
                while ((line = rd.readLine()) != null) {
                    server_response+=line;
                }
                rd.close();
                server_response+=conn;
            } catch (Exception e) {

                System.out.println("Error SMS " + e);
                Toast.makeText(getApplicationContext(), "the error message is" + e, Toast.LENGTH_LONG).show();

                e.printStackTrace();
            }
            a="SMS sent Successfully"+server_response;
            return a;

        }
    }
}
