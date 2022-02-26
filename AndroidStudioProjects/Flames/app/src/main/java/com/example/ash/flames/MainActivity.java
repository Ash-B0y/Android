package com.example.ash.flames;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     TextView t1,t2,t3;
    EditText e1,e2;
    Button b1;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        e1=(EditText)findViewById(R.id.editText);
        e2=(EditText)findViewById(R.id.editText2);
        b1=(Button) findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2;
                char a[]=new char[20],b[]=new char[20],c[]={'F','L','A','M','E','S'};
                char d[]=new char[20],e,f[]=new char[20];
                String words[] = {"Friends","Love","Affection","Marriage","Enemy","Sister"};
                Integer m,i,n,x=6,p=0,ct=0,cp=0,y=-1,u=0,z=0,s=0,t=0,cntidx=0;

                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                StringBuilder sb = new StringBuilder(s1);
                StringBuilder sb1 = new StringBuilder(s2);
                m = sb.length();
                n = sb1.length();
                for (int io = 0; io < m; io++) {
                    for (int j = 0; j < n; j++) {
                        if (sb.charAt(io) == sb1.charAt(j) && cp == 0) {
                            p = p + 2;
                            sb1.setCharAt(j, '*');
                        }
                    }
                }
                cp = (m + n) - p;
                while (x != 1) {
                    y = -1;
                    for (int k = 1; k <= cp; k++) {

                        if (y == x - 1)
                            y = 0;
                        else
                            y++;
                    }
                    if (y == x - 1)
                        e = c[0];
                    else
                        e = c[y + 1];
                    u = 0;
                    for (int vi = 0; vi < x; vi++) {
                        if (vi == y)
                            continue;
                        else {
                            d[u] = c[vi];
                            u++;
                        }
                    }
                    d[u] = '\0';
                    x--;
                    for (int g = 0; g < x; g++)
                        f[g] = d[g];
                    z = 0;
                    ct = 0;
                    t = 0;
                    while (ct != x) {
                        if (f[z] == e || (ct > 0)) {
                            c[t] = f[z];
                            ct++;
                            t++;
                        }
                        z++;
                        if (z == x)
                            z = 0;
                    }
                }
                for (i = 0; i < 6; i++) {
                    if (c[0] == words[i].charAt(0)) {
                        t3.setText("The relationship between you two is:" + " " + words[i]);
                        cntidx=i;
                        break;
                    }
                }
                switch(cntidx)
                {
                    case 0:

                        Intent friend = new Intent(getBaseContext(), fri.class);
                        startActivity(friend);
                        break;

                    case 1:
                            Intent lov  = new Intent(getBaseContext(), lo.class);
                            startActivity(lov);
                            break;

                    case 2:
                            Intent affec = new Intent(getBaseContext(), aff.class);
                            startActivity(affec);
                            break;

                    case 3:
                            Intent ma = new Intent(getBaseContext(), marr.class);
                            startActivity(ma);
                             break;
                    case 4:
                            Intent en = new Intent(getBaseContext(), ene.class);
                            startActivity(en);
                            break;
                    case 5:
                        Intent si = new Intent(getBaseContext(), sis.class);
                        startActivity(si);
                        break;
                        }

                }


        });
    }
}






