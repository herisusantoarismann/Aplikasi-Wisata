package com.example.tugasakhir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends ArrayAdapter {
    List<DBHotel> hotel;

    public HotelAdapter(Context context, int textViewResourceId, List<DBHotel> list) {
        super(context, textViewResourceId, list);
        hotel = list;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_hotel, null);
        TextView textView = (TextView) v.findViewById(R.id.text_hotel);
        ImageView imageView = (ImageView) v.findViewById(R.id.img_hotel);
        textView.setText(hotel.get(position).getName());
        imageView.setImageResource(hotel.get(position).get_image());
        return v;
    }
}
