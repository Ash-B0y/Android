package com.example.ash.hangman;

import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.*;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    TextView t1, t2, t3, t4;
    Button but1, but2, but3, but4, but5, but6, but7, but8, but9, but10, but11, but12, but13, but14, but15, but16, but17, but18, but19, but20, but21, but22, but23, but24, but25, but26,but27,but28;
    Integer freq[] = new Integer[26];
    Integer cnt = 6, ct = 0, it = 0, mx = 0, z =0, f1 = 0, bgf = 0,ascii = 0,flag = 0,e=0,fl2=0,cou=0,c1=0,c2=0,c3=0,c4=0,c5=0;
    String words[] = {"ADDIS ABABA", "MEMENTO", "CHRISTIAN BALE","DAVIS MOTOMIYA","DARTS"};
    String clue[] = {"CAPITAL CITY", "AN ENGLISH MOVIE", "ACTOR","AN ANIME CHARACTER","SPORT/GAME"};
    Integer co[]=new Integer[20];
    String x = "";
    String bT = "";
    String ex="EXIT";
    String nex="NEXT";
    StringBuilder sb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        but1 = (Button) findViewById(R.id.button2);
        but1.setOnClickListener(this);
        but2 = (Button) findViewById(R.id.button3);
        but2.setOnClickListener(this);
        but3 = (Button) findViewById(R.id.button4);
        but3.setOnClickListener(this);
        but4 = (Button) findViewById(R.id.button5);
        but4.setOnClickListener(this);
        but5 = (Button) findViewById(R.id.button6);
        but5.setOnClickListener(this);
        but6 = (Button) findViewById(R.id.button7);
        but6.setOnClickListener(this);
        but7 = (Button) findViewById(R.id.button8);
        but7.setOnClickListener(this);
        but8 = (Button) findViewById(R.id.button9);
        but8.setOnClickListener(this);
        but9 = (Button) findViewById(R.id.button10);
        but9.setOnClickListener(this);
        but10 = (Button) findViewById(R.id.button11);
        but10.setOnClickListener(this);
        but11 = (Button) findViewById(R.id.button12);
        but11.setOnClickListener(this);
        but12 = (Button) findViewById(R.id.button13);
        but12.setOnClickListener(this);
        but13 = (Button) findViewById(R.id.button14);
        but13.setOnClickListener(this);
        but14 = (Button) findViewById(R.id.button15);
        but14.setOnClickListener(this);
        but15 = (Button) findViewById(R.id.button16);
        but15.setOnClickListener(this);
        but16 = (Button) findViewById(R.id.button17);
        but16.setOnClickListener(this);
        but17 = (Button) findViewById(R.id.button18);
        but17.setOnClickListener(this);
        but18 = (Button) findViewById(R.id.button19);
        but18.setOnClickListener(this);
        but19 = (Button) findViewById(R.id.button20);
        but19.setOnClickListener(this);
        but20 = (Button) findViewById(R.id.button21);
        but20.setOnClickListener(this);
        but21 = (Button) findViewById(R.id.button22);
        but21.setOnClickListener(this);
        but22 = (Button) findViewById(R.id.button23);
        but22.setOnClickListener(this);
        but23 = (Button) findViewById(R.id.button24);
        but23.setOnClickListener(this);
        but24 = (Button) findViewById(R.id.button25);
        but24.setOnClickListener(this);
        but25 = (Button) findViewById(R.id.button26);
        but25.setOnClickListener(this);
        but26 = (Button) findViewById(R.id.button27);
        but26.setOnClickListener(this);
        but27 = (Button) findViewById(R.id.button);
        but27.setOnClickListener(this);
        but28 = (Button) findViewById(R.id.button28);
        but28.setOnClickListener(this);

        t1 = (TextView) findViewById(R.id.textView);
        t2 = (TextView) findViewById(R.id.textView2);
        t3 = (TextView) findViewById(R.id.textView3);
        t4 = (TextView) findViewById(R.id.textView4);
        if (f1 == 0) {
            if(bT.equals(ex))
                finish();

            if(z==words.length)
            {
                Toast.makeText(getApplicationContext(), "That's It for the Day!!! Press Exit....", Toast.LENGTH_SHORT).show();
                fl2=1;
                return;
            }
            if(fl2==1)
                return;
            x=x+words[z];
            f1 = 1;
            Arrays.fill(co, 0);
            Arrays.fill(freq, 0);
            sb = new StringBuilder(x);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' ')
                    continue;
                sb.setCharAt(i, '-');
            }
            t1.setText("Try Guessing the Word!!!");
            t2.setText("CLUE:" + " " + clue[z]);
            t3.setText(sb);
            z++;
            Integer co[] = new Integer[x.length()];

        }

    }


    public void onClick(View v) {
        bT = ((Button) v).getText().toString();
        if ((f1 == 0)||(bT.equals(nex))) {
            if (bT.equals(ex))
                finish();

            if (z == words.length) {
                Toast.makeText(getApplicationContext(), "That's It for the Day!!! Press Exit....", Toast.LENGTH_SHORT).show();
                fl2 = 1;
                return;
            }
            if (fl2 == 1)
                return;
            f1 = 0;
            x = "";
            cnt = 6;
            ct = 0;
            cou = 0;
            it = 0;
            mx = 0;
            c1=0;
            c2=0;
            c3=0;
            c4=0;
            c5=0;
            x = x + words[z];
            f1 = 1;
            Arrays.fill(co, 0);
            Arrays.fill(freq, 0);
            sb = new StringBuilder(x);
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == ' ')
                    continue;
                sb.setCharAt(i, '-');
            }

                 t1.setText("Try Guessing the Word!!!");
                 t2.setText("CLUE:" + " " + clue[z]);
                 t3.setText(sb);
                 t4.setText("");
            z++;
            Integer co[] = new Integer[x.length()];
        }
        if (bT.equals(ex))
            finish();
        if (bT.equals(nex))
            return;

        flag = 0;
        ascii = bT.charAt(bgf)-65;
        if (freq[ascii] == 1) {
            t4.setText("You've Already Guessed that character, Try something else...... ");
            flag = 1;
        } else if (freq[ascii] == 0) {
            freq[ascii]++;
        }
        if (flag == 1)
            return;
        for (e = 0; e < sb.length(); e++) {

            if ((bT.charAt(bgf) == x.charAt(e)) && (co[e] == 0)) {
                sb.setCharAt(e, bT.charAt(bgf));
                co[e] = 1;
                ct++;
                continue;
            }
            if ((x.charAt(e) == ' ') && (co[e] == 0)) {
                it++;
                cou = 1;
                co[e] = 1;
                continue;
            } else if ((bT.charAt(bgf) != x.charAt(e)) && (co[e] == 0)) {
                it++;
                continue;
            } else if ((bT.charAt(bgf) != x.charAt(e)) && (co[e] == 1)) {
                it++;
                continue;
            }

        }

        t3.setText(sb);
        if (it == (x.length())) {
            cnt--;
            t4.setText("Sorry,Wrong Guess!!!!!" + " " + "Attempts Left:" + " " + cnt);

        }
        if ((ct > mx)) {
            mx = ct;
            t4.setText(" Good Guess!!!!");
        }
        it = 0;
        if (ct == x.length() || ((cou == 1) && (ct == x.length() - 1))) {
            t4.setText("Great Playing!!!!");
            f1 = 0;
            x = "";
            cnt = 6;
            ct = 0;
            cou = 0;
            it = 0;
            mx = 0;
            c1=0;
            c2=0;
            c3=0;
            c4=0;
            c5=0;
            Toast.makeText(getApplicationContext(), "Press any Button Other than Exit to Guess the next word!!!!", Toast.LENGTH_SHORT).show();

        }

        if (cnt == 0) {
            t4.setText("Better Luck next time!!!!!!!" + " " + "The Correct Answer is:" + " " + x);
            f1 = 0;
            x = "";
            cnt = 6;
            ct = 0;
            cou = 0;
            it = 0;
            mx = 0;
            c1=0;
            c2=0;
            c3=0;
            c4=0;
            c5=0;
            Intent imag6=new Intent(getBaseContext(),img6.class);
            startActivity(imag6);
            Toast.makeText(getApplicationContext(), "Press any Button Other than Exit to Guess the next word!!!!", Toast.LENGTH_SHORT).show();

        }
        switch (cnt)
        {

            case 1:
                if(c1==0) {
                    Intent imag5 = new Intent(getBaseContext(), img5.class);
                    startActivity(imag5);
                }
                c1++;
                break;

            case 2:
                if(c2==0) {
                    Intent imag4 = new Intent(getBaseContext(), img4.class);
                    startActivity(imag4);
                }
                c2++;
                break;

            case 3:
                 if(c3==0) {
                     Intent imag3 = new Intent(getBaseContext(), img3.class);
                     startActivity(imag3);
                 }
                c3++;
                break;

            case 4:
                if(c4==0) {
                    Intent imag2 = new Intent(getBaseContext(), img2.class);
                    startActivity(imag2);
                }
                c4++;
                break;
            case 5:
                if(c5==0) {
                    Intent imag1 = new Intent(getBaseContext(), img1.class);
                    startActivity(imag1);
                }

                c5++;
                break;
        }
    }
    @Override
    protected void onDestroy()
    {
        Process.killProcess(Process.myPid());
        super.onDestroy();

    }

}



