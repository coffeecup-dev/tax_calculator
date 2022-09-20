package com.example.taxcalculator;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<TaxModel> arrayList;

    public CustomAdapter(Context context, ArrayList<TaxModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tax_cart_layout, parent, false);
        }

        ImageView imageView =
                convertView.findViewById(R.id.taximg);
        TextView textView =
                convertView.findViewById(R.id.taxtxt);
        imageView.setImageResource(arrayList.get(position).image);
        textView.setText(arrayList.get(position).title);

        return convertView;
    }
}
