package com.example.tugasakhir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WisataAdapter extends ArrayAdapter {
    List<DBWisata> wisata;

    public WisataAdapter(Context context, int textViewResourceId, List<DBWisata> list) {
        super(context, textViewResourceId, list);
        wisata = list;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_wisata, null);
        TextView textView = (TextView) v.findViewById(R.id.text_wisata);
        ImageView imageView = (ImageView) v.findViewById(R.id.img_wisata);
        textView.setText(wisata.get(position).getName());
        imageView.setImageResource(wisata.get(position).get_image());
        return v;
    }
}
