package com.example.ash.h3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.*;

public class hang extends AppCompatActivity {
 TextView t2,t3,t4,t5;
    EditText e1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hang);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        t5 = (TextView) findViewById(R.id.textView5);
        e1 = (EditText) findViewById(R.id.editText);
        h();
    }
    public void h()
    {
        String words[] = {"ADDIS ABABA", "MEMENTO", "CHRISTIAN BALE"};
        String clue[] = {"CAPITAL CITY", "AN ENGLISH MOVIE", "ACTOR"};
        String x = "";
        String a="";
        t2.setText("Try Guessing the Word!!!");
        Integer cnt = 6, ct = 0, incnt = 0, mx = 0, flag = 0, ascii = 0, z = 0, fl1 = 0;
        for (int va = 0; va < words.length; va++) {

            x = x + words[va];
            t3.setText("CLUE:" + " " + clue[va]);
            t4.setText("");
            StringBuilder sb = new StringBuilder(x);
            for (z = 0; z < sb.length(); z++) {
                if (sb.charAt(z) == ' ')
                    continue;
                sb.setCharAt(z, '-');
            }
            Integer fl[] = new Integer[x.length()];
            Integer freq[] = new Integer[26];
            Arrays.fill(fl, 0);
            Arrays.fill(freq, 0);
            while (cnt != 0) {
                flag = 0;
                a=e1.getText().toString();
                if (a.charAt(0) >= 'A' && a.charAt(0) <= 'Z') {
                    fl1 = 0;
                } else {
                    fl1 = 1;
                }
                if (fl1 == 1) {
                    Toast.makeText(getApplicationContext(), "Do Enter an UpperCase Alphabet!!!!!", Toast.LENGTH_SHORT).show();

                }
                if (fl1 == 1)
                    continue;

                ascii = a.charAt(0) - 65;
                if (freq[ascii] == 1) {
                    t4.setText("You've Already Guessed that character, Try something else...... ");
                    flag = 1;
                } else if (freq[ascii] == 0) {
                    freq[ascii]++;
                }
                if (flag == 1)
                    continue;
                for (int i = 0; i < x.length(); i++) {
                    if (a.charAt(0) == x.charAt(i) && fl[i] == 0) {
                        sb.setCharAt(i, a.charAt(0));
                        fl[i] = 1;
                        ct++;
                        continue;
                    } else if (x.charAt(i) == ' ' && fl[i] == 0) {
                        incnt++;
                        ct++;
                        fl[i] = 1;
                        continue;

                    } else if (a.charAt(0) != x.charAt(i) && fl[i] == 1) {
                        incnt++;
                        continue;
                    } else if (a.charAt(0) != x.charAt(i) && fl[i] == 0) {
                        incnt++;

                    }
                }
                t4.setText(sb);
                if (incnt == (x.length())) {
                    t5.setText("Sorry,Wrong Guess!!!!!" + " " + "Attempts Left:" + " " + cnt);
                    cnt--;

                }
                if (ct > mx) {
                    mx = ct;
                    t5.setText(" Good Guess!!!!");

                }
                incnt = 0;
                if (ct == x.length()) {
                    t5.setText("Great Playing!!!!");
                    break;
                }

                System.out.print("\n");
                if (cnt == 0) {
                    t5.setText("Better Luck next time!!!!!!!" + " " + "The Correct Answer is:" + " " + x);
                    break;

                }

            }
            x = "";
            cnt = 6;
            ct = 0;
            incnt = 0;
            mx = 0;


        }
    }
}




