package com.example.ash.intern;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Window;

import android.widget.AdapterView.OnItemClickListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
     SearchView s1;
     ListView l1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.logo);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        s1 = (SearchView) findViewById(R.id.searchView);
        l1 = (ListView) findViewById(R.id.listView);
        b1 = (Button) findViewById(R.id.button);
        String name[]=new String[5],area[]=new String[5];
        Integer[] img ={R.drawable.apollo,
                R.drawable.kauveri,R.drawable.vijaya,R.drawable.rajiv,R.drawable.sims};

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("Hosp.txt")));
            String x = bufferedReader.readLine();
            int i=0,j=0;
              while(x!=null) {
                 String y[]=x.split(",");
                      name[j]=y[i];
                     i++;
                     area[j]="  "+y[i];
                 x = bufferedReader.readLine();
                 i=0;
                 j++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        ListView listView;
        List<RowItem> rowItems;
        rowItems = new ArrayList<RowItem>();
        for (int i = 0; i < img.length; i++) {
            RowItem item = new RowItem(img[i],name[i],area[i]);
            rowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.listView);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, rowItems);
        listView.setAdapter(adapter);

}
    };

