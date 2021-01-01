package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Kuliner extends AppCompatActivity {
    private GridView gridView;
    public static ArrayList<String> ArrayofName = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        DatabaseHandler db = new DatabaseHandler(this);

        /**
         * CRUD Operations
         * */

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<DBKuliner> kuliners = db.getAllKuliner();

        gridView = (GridView) findViewById(R.id.kulinerView);

        KulinerAdapter adapter = new KulinerAdapter(this, android.R.layout.simple_list_item_1, kuliners);

        gridView.setAdapter(adapter);

        gridView.setSelected(true);
        gridView.setOnItemClickListener(new GridView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3){
                Intent i = new Intent(getApplicationContext(), DetailKuliner.class);
                i.putExtra("id", arg2+1);
                startActivity(i);
            }
        });
    }
}
