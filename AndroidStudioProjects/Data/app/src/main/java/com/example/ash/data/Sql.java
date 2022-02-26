package com.example.ash.data;
import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import java.sql.ResultSet;
import java.sql.Statement;
import android.os.AsyncTask;
import android.util.Log;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class Sql extends AppCompatActivity {
    EditText edtuserid,edtpass;
    Button btnlogin;
    ProgressBar pbbar;
    Connection con;
    String un="ash";
    String pass="12345";
    String db="coll";
    String ip="192.168.1.11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);
        edtuserid = (EditText) findViewById(R.id.edtuserid);
        edtpass = (EditText) findViewById(R.id.edtpass);
        btnlogin = (Button) findViewById(R.id.btnlogin);
        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                CheckLogin checkLogin = new CheckLogin();
                checkLogin.execute("");
            }
        });
    }

                public class CheckLogin extends AsyncTask<String,String,String> {
                    String z = "";
                    Boolean isSuccess = false;
                    String userid = edtuserid.getText().toString();
                    String password = edtpass.getText().toString();

                    @Override
                    protected void onPreExecute() {
                        pbbar.setVisibility(View.VISIBLE);
                    }

                    @Override
                    protected String doInBackground(String... params) {

                        if (userid.trim().equals("") || password.trim().equals(""))
                            z = "Please enter User Id and Password";
                        else {
                            try {
                                con = connectionClass(un,pass,db,ip);
                                if (con == null) {
                                    z = "Error in connection with SQL server";
                                } else {
                                    String query = "select *from login where name='" + userid.toString() + "' and password='" + password.toString() + "'";
                                     Statement stmt = con.createStatement();
                                    ResultSet rs = stmt.executeQuery(query);

                                    if (rs.next()) {

                                        z = "Login successfull";
                                         isSuccess = true;
                                    } else {
                                        z = "Invalid Credentials";
                                        isSuccess = false;
                                    }

                                }
                            } catch (Exception ex) {
                                isSuccess = false;
                                z="Exceptions";

                            }
                        }
                        return z;
                    }

                    @Override
                    protected void onPostExecute(String r) {
                        Toast.makeText(Sql.this, r, Toast.LENGTH_SHORT).show();
                        pbbar.setVisibility(View.GONE);

                        if (isSuccess) {
                            Toast.makeText(Sql.this, "SUCCESS", Toast.LENGTH_SHORT).show();

                            finish();
                        }

                    }
         }




              @SuppressLint("NewApi")
              public Connection connectionClass(String user, String pas,String database,String server)
              {
                  StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                          .permitAll().build();
                  StrictMode.setThreadPolicy(policy);
                  Connection connection = null;
                  String ConnectionURL = null;
                  try {

                      Class.forName("net.sourceforge.jtds.jdbc.Driver");
                      ConnectionURL = "jdbc:jtds:sqlserver://" + server + ";" + "databaseName=" + database + ";user=" + user + ";password=" + pas + ";";
                      connection = DriverManager.getConnection(ConnectionURL);
                  } catch (SQLException se) {
                      Log.e("ERROR 1", se.getMessage());
                  } catch (ClassNotFoundException e) {
                      Log.e("ERROR 2"+e.getMessage(), e.getMessage());

                  } catch (Exception e) {
                      Log.e("ERROR 3", e.getMessage());
                  }
                  return connection;
              }
}



