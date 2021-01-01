package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Wisata extends AppCompatActivity {
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        final DatabaseHandler db = new DatabaseHandler(this);

        // Reading all contacts
        Log.d("Reading: ", "Reading all contacts..");
        List<DBWisata> wisata = db.getAllWisata();

        gridView = (GridView) findViewById(R.id.wisataView);

        WisataAdapter adapter = new WisataAdapter(this, android.R.layout.simple_list_item_1, wisata);

        gridView.setAdapter(adapter);

        gridView.setSelected(true);
        gridView.setOnItemClickListener(new GridView.OnItemClickListener(){
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3){
                Intent i = new Intent(getApplicationContext(), DetailWisata.class);
                i.putExtra("id", arg2+1);
                startActivity(i);
            }
        });
    }
}
