package com.example.tugasakhir;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class DetailHotel extends AppCompatActivity {

    DBHotel hasil;
    CarouselView carouselView;
    TextView title, address, price, amenities;
    Button maps;

    String location;
    int[] sampleImages = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);

        DatabaseHandler db = new DatabaseHandler(this);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        title = (TextView) findViewById(R.id.name);
        address = (TextView) findViewById(R.id.address_content);
        price = (TextView) findViewById(R.id.prices);
        amenities = (TextView) findViewById(R.id.amenities_list);
        maps = (Button) findViewById(R.id.maps);

        List<DBDetailHotel> detailHotelImage = db.getDetailHotelImage(getIntent().getIntExtra("id", 0));
        for (int i = 0; i < db.getDetailHotelCount(getIntent().getIntExtra("id", 0)); i++) {
            sampleImages[i] = detailHotelImage.get(i).get_image();
        }

        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        hasil = db.getHotel(getIntent().getIntExtra("id", 0));
        title.setText(hasil.getName());
        address.setText(hasil.getAddress());
        price.setText(hasil.getPrice());
        amenities.setText(hasil.getAmenities());
        location = hasil.getName().replaceAll(" ", "+");

        maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri map = Uri.parse("google.navigation:q=" + location);
                Intent maps = new Intent(Intent.ACTION_VIEW, map);

                maps.setPackage("com.google.android.apps.maps");

                try {
                    startActivity(maps);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("google.navigation:q=" + location)));
                }
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };
}