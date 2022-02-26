package com.example.ash.otp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import static com.example.ash.otp.MainActivity.mob;

public class reg extends AppCompatActivity  {
    String[] gender = {"Male", "Female"};
    static String gen="";
    static String age="";
    static String name="";
    static String reg="";
    static String branch="";
    String dc="";
    String dp="";
    List<String> names1 = MainActivity.na;
    List<String> age1 = MainActivity.ag;
    List<String> gen1 = MainActivity.ge;
    List<String> reg1 = MainActivity.re;
    List<String> br1 = MainActivity.br;
    static List<String> dcdep = new ArrayList<String>();
    static int flag1=0;
    EditText e1,e2,e3;
    Spinner spin,spin1;
    Button b1;
    ConnectionClass connectionClass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg2);
        this.setTitle("Registration");
        e1 = (EditText) findViewById(R.id.editText3);
        e2 = (EditText) findViewById(R.id.editText);
        e3 = (EditText) findViewById(R.id.editText2);
        spin = (Spinner) findViewById(R.id.spinner3);
        spin1 = (Spinner) findViewById(R.id.spinner4);
        String Mo= mob;
        connectionClass = new ConnectionClass();
        e2.setText(Mo);
        b1 = (Button) findViewById(R.id.button3);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, gender);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, br1);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin1.setAdapter(aa1);
        TextWatcher tw = new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String age=s.toString();
                boolean set=false;
                if (age.length()!=0) {
                    int num = Integer.parseInt(age);
                    if ((num>150)||(num<1)) {
                        set=true;
                    }
                    if(set) {
                        Toast.makeText(getApplicationContext(), "Key in a valid age span", Toast.LENGTH_LONG).show();
                        e1.setText("");
                    }
                }

            }
            @Override
            public void afterTextChanged(Editable editable) {

            }

        };
        e1.addTextChangedListener(tw);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = e1.getText().toString();
                name= e3.getText().toString();
               if(!age.trim().equals("")) {
                   Integer i1 = Integer.parseInt(age);
               }
                if(age.trim().equals("")||name.trim().equals(""))
                    Toast.makeText(getApplicationContext(), "Fill in all the fields!!!!" , Toast.LENGTH_LONG).show();
                    else {
                    reg.DoLogin doLogin = new reg.DoLogin();
                    doLogin.execute("");
                }


            }
        });
    }

    public class DoLogin extends AsyncTask<String, String, String> {
        String z = "";
        Boolean isSuccess = false;
        String Mo= mob;
        BigInteger bi = new BigInteger(Mo);
        Integer i1=Integer.parseInt(age);
        @Override
        protected void onPreExecute() {
            Toast.makeText(reg.this, "Checking Connectivity", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onPostExecute(String r) {
            Toast.makeText(reg.this, r, Toast.LENGTH_SHORT).show();

            if (isSuccess) {
                Toast.makeText(reg.this, "Re-Directing" , Toast.LENGTH_SHORT).show();
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
                    int titleid;
                    int gid;
                    int brid;
                    gen=spin.getSelectedItem().toString();
                    if(gen=="Male")
                    {
                        titleid=1;
                        gid=1;

                    }
                    else
                    {
                        gid=2;
                        titleid=2;
                    }

                    branch=spin1.getSelectedItem().toString();
                    if(branch.equals("Nanganallur"))
                        brid=1;
                    else if(branch.equals("MADURAI"))
                        brid=2;
                    else
                        brid=3;
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Calendar now = Calendar.getInstance();
                    String pst=sdf.format(now.getTime());
                    now.set(Calendar.HOUR, 0);
                    now.set(Calendar.MINUTE, 0);
                    now.set(Calendar.SECOND, 0);
                    now.set(Calendar.HOUR_OF_DAY, 0);
                    String pre=sdf.format(now.getTime());
                    int year = Calendar.getInstance().get(Calendar.YEAR);
                    year=year-i1;
                    now.set(Calendar.YEAR,year);
                    String dob=sdf.format(now.getTime());
                    Statement stmt = con.createStatement();
                     int fl = stmt.executeUpdate("insert into M_Person(PERSONNM,HOSPITALREF,REGNDT,DOB,AGE,CELLNO,EMAILID,BRANCHID,UID,POSTDT,TITLEID,BGID,RELIGIONID,GENDERID,STATUSID,VSTACTIVE,MARITALID,ACTVISITID,DUEAMOUNT,SPOUSENM,OCCUPATION,ANNUALINCOME,REFACTUALID,PERSONREM,coaid,aadharno,duetpa,igstcustomer,secondmobileno,patientpwd) values( '" + name + "','','" + pre + "','" + dob + "','" + age + "','" + Mo + "','','" + brid + "','1','" + pst + "','" + titleid + "','0','0','" + gid + "','1','N','0','','0.00','','','','1','','-1','','0.00','N','','')");
                    if (fl>0) {
                        z = "Insertion Successful";
                        isSuccess = true;
                        flag1=1;
                        age1.add(age);
                        names1.add(name);
                        gen1.add(gen);
                        reg1.add(reg);
                    } else {
                        z = "Error";
                        isSuccess = false;
                    }
                   ResultSet rs = stmt.executeQuery("select PERSONID from M_Person where CELLNO ='" + Mo + "'");
                    reg="";
                    reg1.clear();
                    while (rs.next()) {
                        reg=rs.getString("PERSONID");
                        reg1.add(reg);
                    }
                    rs = stmt.executeQuery("SELECT DISTINCT M_Person.PERSONNM,M_SubDepartment.subdeptnm FROM M_Person INNER JOIN M_Doctor ON M_Person.PERSONID=M_Doctor.PERSONID INNER JOIN DrSkill ON M_Doctor.DRID=DrSkill.DRID INNER JOIN M_SubDepartment ON DrSkill.SUBDEPTID=M_SubDepartment.subdeptid INNER JOIN DrBranchFee ON DrBranchFee.branchid='"+brid+"'");
                    dcdep.clear();
                    while (rs.next()) {
                        String te="";
                        dc=rs.getString("PERSONNM");
                        dp=rs.getString("subdeptnm");
                        te="Dr. "+dc+"-"+dp;
                        dcdep.add(te);
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


}

