package com.example.tugasakhir;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnwisata, btnkuliner, btngojek, btnhotel, btntemib, btnoleh;
    TextView time;
    Calendar calendar;
    SimpleDateFormat dateFormat;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnwisata = (Button)findViewById(R.id.btnwisata);
        btnkuliner = (Button)findViewById(R.id.btnkuliner);
        btngojek = (Button)findViewById(R.id.btngojek);
        btnhotel = (Button)findViewById(R.id.btnhotel);
        btntemib = (Button)findViewById(R.id.btntemib);
        btnoleh = (Button)findViewById(R.id.btnoleh);
        time = (TextView)findViewById(R.id.time);
        calendar = Calendar.getInstance();

        dateFormat = new SimpleDateFormat("dd MMMM yyyy", Locale.getDefault());
        date = dateFormat.format(calendar.getTime());
        time.setText(date + ", ");

        btnwisata.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent wisata = new Intent(MainActivity.this, Wisata.class);
                startActivity(wisata);
            }
        });

        btnhotel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent hotel = new Intent(MainActivity.this, Hotel.class);
                startActivity(hotel);
            }
        });

        btnkuliner.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent kuliner = new Intent(MainActivity.this, Kuliner.class);
                startActivity(kuliner);
            }
        });

        btntemib.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent hotel = new Intent(MainActivity.this, Temib.class);
                startActivity(hotel);
            }
        });

        btnoleh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent hotel = new Intent(MainActivity.this, Oleh.class);
                startActivity(hotel);
            }
        });

        btngojek.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.gojek.app");
                if (launchIntent != null) {
                    startActivity(launchIntent);//null pointer check in case package name was not found
                }
            }
        });
    }
}