package com.example.ash.otp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.*;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    Button b1;
    Button b2;
    TextView t1, t2, t3;
    ImageView img;
    ProgressDialog progressdialog;
    String chk = "";
    ConnectionClass connectionClass;
    static String mob = "";
    static String gen = "";
    static String age = "";
    static String name = "";
    static String reg = "";
    static String braid = "";
    String bra = "";
    String doct = "";
    String dep = "";
    String slo="";
    static List<String> ag = new ArrayList<String>();
    static List<String> ge = new ArrayList<String>();
    static List<String> na = new ArrayList<String>();
    static List<String> re = new ArrayList<String>();
    static List<String> br = new ArrayList<String>();
    static List<String> doc = new ArrayList<String>();
    static int flag = 0;
    static int cnt = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("Home Page");
        connectionClass = new ConnectionClass();
        e1 = (EditText) findViewById(R.id.Mob);
        e2 = (EditText) findViewById(R.id.Otp);
        b1 = (Button) findViewById(R.id.button3);
        b2 = (Button) findViewById(R.id.button2);
        b1.setEnabled(false);
        b2.setEnabled(false);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        img = (ImageView) findViewById(R.id.imageView);
        boolean net = haveNetworkConnection();
        if (net) {
            t1.setText("Vignana");
            t2.setText("Vignana, Chennai, Tamil Nadu 600081");
            t3.setText("04448522738");
            img.setVisibility(View.VISIBLE);
            img.setImageResource(R.drawable.logo);
        } else {
            Toast.makeText(getApplicationContext(), "Unable to Connect To Vignana Hospital,Kindly contact 04448522738", Toast.LENGTH_LONG).show();
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
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = e2.getText().toString();
                if (otp.equals(chk)) {
                    mob = e1.getText().toString();
                    DoLogin doLogin = new DoLogin();
                    doLogin.execute("");

                } else {
                    if (cnt >= 3) {
                        e2.setText("");
                        Toast.makeText(getApplicationContext(), "OTP-Expired,Try a new One!!", Toast.LENGTH_LONG).show();
                        b2.setEnabled(false);
                        cnt = 0;
                    }
                    cnt++;
                    Toast.makeText(getApplicationContext(), "Incorrect-OTP", Toast.LENGTH_LONG).show();
                }


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

    public class DoLogin extends AsyncTask<String, String, String> {
        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            progressdialog=new ProgressDialog(MainActivity.this);
            progressdialog.setMessage("Checking Connectivity and Re-Directing...");
            progressdialog.show();
        }

        @Override
        protected void onPostExecute(String r) {
            progressdialog.dismiss();
            Toast.makeText(MainActivity.this, r, Toast.LENGTH_SHORT).show();

            if (isSuccess) {
                Intent booking = new Intent(getBaseContext(), book.class);
                startActivity(booking);

            }

        }

        @Override
        protected String doInBackground(String... params) {

            try {
                Connection con = connectionClass.CONN();
                if (con == null) {
                    z = "Error in connection with SQL server";
                } else {
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("select *from M_Person where CELLNO ='" + mob + "' or secondmobileno='" + mob + "'");
                    age = "";
                    name = "";
                    gen = "";
                    reg = "";
                    braid = "";
                    ag.clear();
                    na.clear();
                    ge.clear();
                    re.clear();
                    while (rs.next()) {
                        age = rs.getString("AGE");
                        ag.add(age);
                        name = rs.getString("PERSONNM");
                        na.add(name);
                        gen = rs.getString("GENDERID");
                        if (gen.equals("1"))
                            gen = "Male";
                        else
                            gen = "Female";
                        ge.add(gen);
                        reg = rs.getString("PERSONID");
                        re.add(reg);
                        braid = rs.getString("BRANCHID");
                    }
                    rs = stmt.executeQuery("SELECT DISTINCT M_Person.PERSONNM,M_SubDepartment.subdeptnm FROM M_Person INNER JOIN M_Doctor ON M_Person.PERSONID=M_Doctor.PERSONID INNER JOIN DrSkill ON M_Doctor.DRID=DrSkill.DRID INNER JOIN M_SubDepartment ON DrSkill.SUBDEPTID=M_SubDepartment.subdeptid INNER JOIN DrBranchFee ON DrBranchFee.branchid='" + braid + "'");
                    doc.clear();
                    while (rs.next()) {
                        String te = "";
                        doct = rs.getString("PERSONNM");
                        dep = rs.getString("subdeptnm");
                        te = "Dr. " + doct + "-" + dep;
                        doc.add(te);
                    }
                    if (age != "") {

                        z = "Fetching Data";
                        isSuccess = true;
                        flag = 1;
                    } else {
                        z = "Mobile No not Present in our Records";
                        isSuccess = false;
                        Intent regi = new Intent(getBaseContext(), reg.class);
                        startActivity(regi);
                    }
                    rs = stmt.executeQuery("select listnm from M_Branch");
                    br.clear();
                    while (rs.next()) {
                        bra = rs.getString("listnm");
                        br.add(bra);
                    }

                }


            } catch (Exception ex) {
                isSuccess = false;
                z = "Exceptions";
                ex.printStackTrace();
            }

            return z;

        }
    }

    public class sendssms extends AsyncTask<String, String, String> {

    String a="";
    String line;
    String sresp="";
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
                String user = "vignana";
                String text = otp;
                String pass = "smsvignana";
                String sender = "SAHOSP";
                String phone = params[0];
                String priority = "ndnd";
                String stype = "normal";

                HttpURLConnection conn = (HttpURLConnection) new URL("http://bhashsms.com/api/sendmsg.php?user=vignana&pass=smsvignana&sender=SAHOSP&phone="+phone+"&text="+text+"&priority=ndnd&stype=normal").openConnection();
                String data = user+pass+sender+phone+text+priority+stype;
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                conn.getOutputStream().write(data.getBytes("UTF-8"));
                final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                final StringBuffer stringBuffer = new StringBuffer();
                while ((line = rd.readLine()) != null) {
                    sresp+=line;
                }

                rd.close();

            } catch (Exception e) {

                System.out.println("Error SMS " + e);
                Toast.makeText(getApplicationContext(), "the error message is" + e, Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
            a="SMS sent Successfully";
            return a;

        }
    }

}



