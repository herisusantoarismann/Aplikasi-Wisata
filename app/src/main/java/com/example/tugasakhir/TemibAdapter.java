package com.example.tugasakhir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TemibAdapter extends ArrayAdapter {
    List<DBTemib> temib;

    public TemibAdapter(Context context, int textViewResourceId, List<DBTemib> list) {
        super(context, textViewResourceId, list);
        temib = list;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_temib, null);
        TextView textView = (TextView) v.findViewById(R.id.text_temib);
        ImageView imageView = (ImageView) v.findViewById(R.id.img_temib);
        textView.setText(temib.get(position).getName());
        imageView.setImageResource(temib.get(position).get_image());
        return v;
    }
}
