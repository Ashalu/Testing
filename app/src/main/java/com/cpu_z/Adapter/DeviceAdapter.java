package com.cpu_z.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cpu_z.R;

import java.util.ArrayList;

public class DeviceAdapter extends BaseAdapter {
    String [] result;
    Context context;
    ArrayList<String> imageId;
    private static LayoutInflater inflater=null;
        public DeviceAdapter(Context Description, String[] tagname, ArrayList<String> tagresponse) {
            result=tagname;
            context=Description;
            imageId=tagresponse;
            inflater = (LayoutInflater)context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder
    {
        TextView tvHeading;
        TextView tvResponse;
    }
    private int lastPosition = -1;


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.descriptionitem, null);
        Animation animation = AnimationUtils.loadAnimation(context, (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        rowView.startAnimation(animation);
        lastPosition = position;

        holder.tvHeading=(TextView) rowView.findViewById(R.id.heading);
        holder.tvResponse=(TextView) rowView.findViewById(R.id.response);
        holder.tvHeading.setText(result[position] +"  :  ");
        holder.tvResponse.setText(imageId.get(position));
        return rowView;
    }
}