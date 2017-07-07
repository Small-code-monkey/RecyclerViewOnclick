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

    //在onCreateViewHolder()中为每个item添加点击事件
    @Override
    public Viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        Viewholder viewholder = new Viewholder(view);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(Viewholder holder, int position) {
        holder.textView.setText(strings[position]);
        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return strings.length;
    }

    @Override
    public void onClick(View v) {
        if (superOnclick != null) {
            //注意这里使用getTag方法获取position
            superOnclick.RVOnclick(v, (int) v.getTag());
        }
    }

    //最后暴露给外面的调用者，定义一个设置Listener的方法
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
