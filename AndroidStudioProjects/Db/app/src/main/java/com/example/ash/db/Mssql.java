package com.example.ash.db;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;



public class Mssql extends AppCompatActivity {

    ConnectionClass connectionClass;
    EditText edtuserid,edtpass;
    Button btninsert;
    ProgressBar pbbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mssql);
        connectionClass = new ConnectionClass();
        edtuserid = (EditText) findViewById(R.id.edtuserid);
        edtpass = (EditText) findViewById(R.id.edtpass);
        btninsert = (Button) findViewById(R.id.btnlogin);
        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                DoLogin doLogin = new DoLogin();
                doLogin.execute("");

            }
        });

    }

    public class DoLogin extends AsyncTask<String,String,String>
    {
        String z = "";
        String pass="";
        Boolean isSuccess = false;


        String userid = edtuserid.getText().toString();


        @Override
        protected void onPreExecute() {
            pbbar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String r) {
            pbbar.setVisibility(View.GONE);
            Toast.makeText(Mssql.this,r,Toast.LENGTH_SHORT).show();

            if(isSuccess) {
                Toast.makeText(Mssql.this,"Password:"+pass,Toast.LENGTH_SHORT).show();

                finish();
            }

        }

        @Override
        protected String doInBackground(String... params) {
            if(userid.trim().equals(""))
                z = "Please enter User Id";
            else
            {
                try {
                    Connection con = connectionClass.CONN();
                    if (con == null) {
                        z = "Error in connection with SQL server";
                    } else {
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery("select Password from admin where UserName='" + userid + "'");
                            while (rs.next()) {
                                pass= rs.getString("Password");
                        }
                        if (pass!="") {

                            z = "Fetching Data";
                            isSuccess=true;
                        } else {
                            z = "Invalid id";
                            isSuccess = false;
                        }
                    }
                }
                catch (Exception ex)
                {
                    isSuccess = false;
                    z = "Exceptions";
                    ex.printStackTrace();
                }
            }
            return z;
        }
    }
}

