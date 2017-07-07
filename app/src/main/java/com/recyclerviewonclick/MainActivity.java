package com.recyclerviewonclick;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    Context context = MainActivity.this;
    String[] strings = {"1", "2", "3", "4", "5"};

    SuperAdapter superAdapter;

    @Bind(R.id.recyclerview)
    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        superAdapter=new SuperAdapter(MainActivity.this,strings);
        recyclerview.setAdapter(superAdapter);
        
        superAdapter.setonclick(new SuperOnclick() {
            @Override
            public void RVOnclick(View view, int postsion) {
                Toast.makeText(context, "点击是=" + postsion, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
