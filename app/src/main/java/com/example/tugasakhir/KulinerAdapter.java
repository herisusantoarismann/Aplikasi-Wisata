package com.example.tugasakhir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class KulinerAdapter extends ArrayAdapter {
    List<DBKuliner> kuliner;

    public KulinerAdapter(Context context, int textViewResourceId, List<DBKuliner> list) {
        super(context, textViewResourceId, list);
        kuliner = list;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_kuliner, null);
        TextView textView = (TextView) v.findViewById(R.id.text_kuliner);
        ImageView imageView = (ImageView) v.findViewById(R.id.img_kuliner);
        textView.setText(kuliner.get(position).getName());
        imageView.setImageResource(kuliner.get(position).get_image());
        return v;
    }
}
