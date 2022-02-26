package com.example.domestic;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class registration extends AppCompatActivity {
databaseHelper women;
 EditText mail;
 EditText phoneno;
EditText last_name;
EditText first_name;
 Button but;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        women= new databaseHelper(this);
        mail = (EditText)findViewById(R.id.email);
        phoneno = (EditText)findViewById(R.id.phone);
        first_name = (EditText)findViewById(R.id.fname);
        last_name = (EditText)findViewById(R.id.lname);
        but= (Button) findViewById(R.id.buttonsub);
        add();

    }
    public void add()
    {
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String fname= first_name.getText().toString();
                String lname= last_name.getText().toString();
                String email= mail.getText().toString();
                String phone= phoneno.getText().toString();
                boolean insertdata = women.addData(fname,lname,email,phone);
                if (insertdata == true)
                {
                    Toast.makeText(registration.this,"Success!!!!",Toast.LENGTH_LONG).show();

                }
                else
                {
                    Toast.makeText(registration.this,"srsly??",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}



