package com.polytech.si3.mypolytech.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.polytech.si3.mypolytech.R;

/**
 * Created by justin on 20/04/16.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {
    Context context;
    String firstElement;
    String[] text;
    boolean isFirstTime;
    boolean open;

    public SpinnerAdapter(Context context,int textViewResourceId,String[] array) {
        super(context,textViewResourceId,array);
        this.context = context;
        this.firstElement = array[0];
        this.text = array;
        this.isFirstTime = true;

    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if(isFirstTime) {
            isFirstTime = false;
        }
        return getCustomView(position, convertView, parent);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        notifyDataSetChanged();
        return getCustomView(position, convertView, parent);
    }

    public View getCustomView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.spinner_row, parent, false);
        TextView label;
        if(position==0){
            label = (TextView) row.findViewById(R.id.title_text);
        }
        else{
            label = (TextView) row.findViewById(R.id.spinner_text);
        }
        label.setText(text[position]);

        return row;
    }


}
