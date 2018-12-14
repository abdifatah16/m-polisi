package com.abdifatahm.m_polisi;

//CustomAdapter
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

import android.widget.ImageView;

public class CustomAdapter extends BaseAdapter {
    Context mContext;
    ArrayList<Item> data;//modify here

    public CustomAdapter(Context mContext, ArrayList<Item> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();// # of items in your array-list
    }
    @Override
    public Object getItem(int position) {
        return data.get(position);// get the actual item
    }
    @Override
    public long getItemId(int id) {
        return id;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_layout, parent,false);//modify here
            viewHolder = new ViewHolder();

            //modify this block of code
            viewHolder.tvnamesreport = (TextView) convertView.findViewById(R.id.etNamesReport);
            viewHolder.tvdate = (TextView) convertView.findViewById(R.id.etDate);
            viewHolder.tvevent = (TextView) convertView.findViewById(R.id.etEvents);
            viewHolder.tvlocation = (TextView) convertView.findViewById(R.id.etLocation);
            viewHolder.tvwitness = (TextView) convertView.findViewById(R.id.etWitness);
            //Up to here
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        //MODIFY THIS BLOCK OF CODE
        Item person = data.get(position);//modify here
        viewHolder.tvnamesreport.setText(person.getEtname());//modify here
        viewHolder.tvdate.setText(person.getEtdate());//modify here
        viewHolder.tvevent.setText(person.getEtevent());//modify here
        viewHolder.tvlocation.setText(person.getEtevent());//modify here
        viewHolder.tvwitness.setText(person.getEtevent());//modify here
//        viewHolder.imageView.setImageResource(person.getImage());
        return convertView;

    }
    static class ViewHolder {
        TextView tvnamesreport;
        TextView tvdate;
        TextView tvevent;
        TextView tvlocation;
        TextView tvwitness;


        //These don't have to be same names as the Id's
        //MODIFY THIS BLOCK OF CODE
        //TextView textViewTitle;
//        ImageView imageView;
    }

}