package com.example.ash.palindrome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText textView;
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (EditText)findViewById(R.id.textView);
        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textStr = textView.getText().toString();
                StringBuilder rev = new StringBuilder(textStr).reverse();
                if (rev.toString().contentEquals(textStr)){
                    Toast.makeText(getApplicationContext(),"Palindrome",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Not a Palindrome",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
