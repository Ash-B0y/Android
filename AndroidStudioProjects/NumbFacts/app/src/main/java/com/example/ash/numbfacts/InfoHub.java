package com.example.ash.numbfacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InfoHub extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_hub);
        String num[]={"The Evolution of Numbers","Natural Numbers","Whole Numbers","Real Numbers","Transcendental Numbers","Integers","Rational Numbers","Irrational Numbers","Complex Numbers","Imaginary Numbers","HyperComplex Numbers","P-adic Numbers"};
        ListView listView;
        List<RowItem> rowItems;
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < num.length; i++) {
            RowItem item = new RowItem(num[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.listView);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                int pos=position;
                Log.d(getClass().getName(), String.format("value = %d", pos));
                switch(pos)
                {
                    case 0:

                        Intent His = new Intent(getBaseContext(), History.class);
                        startActivity(His);
                        break;

                    case 1:
                        Intent nat  = new Intent(getBaseContext(), Natural.class);
                        startActivity(nat);
                        break;

                    case 2:
                        Intent who = new Intent(getBaseContext(), whole.class);
                        startActivity(who);
                        break;

                    case 3:
                        Intent re = new Intent(getBaseContext(), Real.class);
                        startActivity(re);
                        break;

                    case 4:
                        Intent trans = new Intent(getBaseContext(), Transcendental .class);
                        startActivity(trans);
                        break;

                    case 5:
                        Intent i = new Intent(getBaseContext(), Int.class);
                        startActivity(i);
                        break;
                    case 6:
                        Intent rat = new Intent(getBaseContext(), Rational.class);
                        startActivity(rat);
                        break;
                    case 7:
                        Intent irat  = new Intent(getBaseContext(), Irrational.class);
                        startActivity(irat);
                        break;

                    case 8:
                        Intent com = new Intent(getBaseContext(), Complex.class);
                        startActivity(com);
                        break;

                    case 9:
                        Intent img = new Intent(getBaseContext(), Imaginary.class);
                        startActivity(img);
                        break;
                    case 10:
                        Intent hyp = new Intent(getBaseContext(), Hyper.class);
                        startActivity(hyp);
                        break;
                    case 11:
                        Intent pad = new Intent(getBaseContext(), Padic.class);
                        startActivity(pad);
                        break;
                }


            }


        });
    }
}
