package com.recyclerviewonclick;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Date:2017/7/7
 * Function:适配器
 */

public class SuperAdapter extends RecyclerView.Adapter<SuperAdapter.Viewholder> implements View.OnClickListener {
    Context context;
    String[] strings;

    SuperOnclick superOnclick = null;

    public SuperAdapter(Context context, String[] strings) {
        this.context = context;
        this.strings = strings;
    }

    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        Viewholder viewholder = new Viewholder(view);
        view.setOnClickListener(this);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.textView.setText(strings[position]);

        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    @Override
    public void onClick(View v) {
        if (superOnclick != null) {
            superOnclick.RVOnclick(v, (int) v.getTag());
        }
    }

    public void setonclick(SuperOnclick superOnclick) {
        this.superOnclick = superOnclick;
    }

    class Viewholder extends RecyclerView.ViewHolder {
        TextView textView;

        public Viewholder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textview);
        }
    }
}
