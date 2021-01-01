package com.example.tugasakhir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class OlehAdapter extends ArrayAdapter {
    List<DBOleh> oleh;

    public OlehAdapter(Context context, int textViewResourceId, List<DBOleh> list) {
        super(context, textViewResourceId, list);
        oleh = list;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.list_oleh, null);
        TextView textView = (TextView) v.findViewById(R.id.text_oleh);
        ImageView imageView = (ImageView) v.findViewById(R.id.img_oleh);
        textView.setText(oleh.get(position).getName());
        imageView.setImageResource(oleh.get(position).get_image());
        return v;
    }
}
