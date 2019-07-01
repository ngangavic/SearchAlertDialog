package com.ngangavictor.alertdialogsearch.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ngangavictor.alertdialogsearch.R;

import java.util.ArrayList;

public class AlertAdapter  extends BaseAdapter {

    Context context=null;
    ArrayList<String> listArray= new ArrayList<String>();
    private LayoutInflater mInflater=null;

    public AlertAdapter(Activity activity, ArrayList<String> listArray) {
        this.context = activity;
        this.listArray = listArray;
        mInflater = activity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return listArray.size();
    }

    @Override
    public Object getItem(int position) {
        return listArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null ) {
            holder = new ViewHolder();
           // LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.alert_list_row, null);
            holder.tvAnimal =convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }
       // ListItems listItems = listArray.get(position);
        holder.tvAnimal.setText(listArray.get(position));

        return convertView;
    }

    private static class ViewHolder {
        TextView tvAnimal;
    }
}
