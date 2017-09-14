package com.example.priya.parentassistapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.priya.parentassistapp.pojo.DataModel;
import com.example.priya.parentassistapp.R;

import java.util.ArrayList;

/**
 * Created by priya on 13/9/17.
 */

public class CustomAdapter  extends ArrayAdapter<DataModel>{

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.list_item, data);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        DataModel dataModel = getItem(position);
        if (convertView == null) {
            holder=new ViewHolder();

            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent,false);
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holder. tvDes = (TextView) convertView.findViewById(R.id.tv_desc);
            convertView.setTag(holder);
        }
        else{
            holder=(ViewHolder)convertView.getTag();
        }
        holder.tvTitle.setText(dataModel.getTitle());
        holder.tvDes.setText(dataModel.getDescription());
        return convertView;


    }
    private static class ViewHolder {
        TextView tvTitle;
        TextView tvDes;
    }
}
