package com.example.ywq9682.eyepetizer.discover.vr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ywq9682.eyepetizer.R;
import com.squareup.picasso.Picasso;

/**
 * Created by dllo on 16/7/30.
 */
public class VrTimeAdapter extends BaseAdapter {
    private VrBean vrBean;
    private Context context;
    private String time;

    public VrTimeAdapter(Context context) {
        this.context = context;
    }

    public void setVrBean(VrBean vrBean) {
        this.vrBean = vrBean;
    }

    @Override
    public int getCount() {
        return vrBean == null ? 0 : vrBean.getItemList().size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_time_data, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(vrBean.getItemList().get(i).getData().getCover().getFeed()).into(viewHolder.imageView);
        viewHolder.textViewRecord.setText(vrBean.getItemList().get(i).getData().getCategory());

        int duration = vrBean.getItemList().get(i).getData().getDuration();
        time = duration / 60 + " ' " + duration % 60 + " '' ";
        viewHolder.textViewTime.setText(time);
        //viewHolder.textViewTitle.setText(weekBean.getItemList().get(i).getData().getName());
        viewHolder.textviewContent.setText(vrBean.getItemList().get(i).getData().getTitle());
        return view;
    }


    class ViewHolder {
        ImageView imageView;
        TextView textviewContent;
        TextView textViewTime;
        TextView textViewRecord;


        public ViewHolder(View view) {
            textviewContent = (TextView) view.findViewById(R.id.author_time_tv);
            imageView = (ImageView) view.findViewById(R.id.author_time_image);
            textViewTime = (TextView) view.findViewById(R.id.author_time_time);
            textViewRecord = (TextView) view.findViewById(R.id.author_time_record);


        }

    }
}
