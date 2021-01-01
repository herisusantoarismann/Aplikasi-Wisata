package com.example.tugasakhir;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.List;

public class DetailWisata extends FragmentActivity {

    DBWisata hasil;
    CarouselView carouselView;
    TextView title, description, address, ticket, distance;
    Button maps;

    String location;
    int[] sampleImages = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_wisata);

        DatabaseHandler db = new DatabaseHandler(this);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        title = (TextView) findViewById(R.id.name);
        description = (TextView) findViewById(R.id.description_content);
        address = (TextView) findViewById(R.id.address_content);
        ticket = (TextView) findViewById(R.id.ticket_price);
        distance = (TextView) findViewById(R.id.distance);
        maps = (Button) findViewById(R.id.maps);

        List<DBDetailWisata> detailWisataImage = db.getDetailWisataImage(getIntent().getIntExtra("id", 0));
        for (int i = 0; i < db.getDetailWisataCount(getIntent().getIntExtra("id", 0)); i++) {
            sampleImages[i] = detailWisataImage.get(i).get_image();
        }

        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);

        hasil = db.getWisata(getIntent().getIntExtra("id", 0));
        title.setText(hasil.getName());
        description.setText(hasil.getDesc());
        address.setText(hasil.getAddress());
        ticket.setText(hasil.getTicket());
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

//        double disctance = CalculationByDistance(-7.8330648347232055, 110.38307828255695, -7.809844078693606, 110.35939372488583);
//        distance.setText(Double.toString(disctance));
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

//    public double CalculationByDistance(double lat1, double lon1, double lat2, double lon2) {
//        int Radius = 6371;// radius of earth in Km
//        double dLat = Math.toRadians(lat2 - lat1);
//        double dLon = Math.toRadians(lon2 - lon1);
//        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
//                + Math.cos(Math.toRadians(lat1))
//                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
//                * Math.sin(dLon / 2);
//        double c = 2 * Math.asin(Math.sqrt(a));
//        double valueResult = Radius * c;
//        double km = valueResult / 1;
//        DecimalFormat newFormat = new DecimalFormat("####");
//        int kmInDec = Integer.valueOf(newFormat.format(km));
//        double meter = valueResult % 1000;
//        int meterInDec = Integer.valueOf(newFormat.format(meter));
//        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
//                + " Meter   " + meterInDec);
//
//        return Radius * c;
//    }
}