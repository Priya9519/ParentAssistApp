package com.example.priya.parentassistapp.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.priya.parentassistapp.R;
import com.example.priya.parentassistapp.adapter.CustomAdapter;
import com.example.priya.parentassistapp.pojo.DataModel;

import java.util.ArrayList;

public class StrengthActivity extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter adapter;
    private  ArrayList<DataModel> dataModels;
    private String title[],description[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strength);
        initView();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent intent=new Intent(StrengthActivity.this,RelationshipActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
    //initalise view
    private void initView() {
        listView=(ListView)findViewById(R.id.list_view);
        dataModels=new ArrayList<DataModel>();
        title=getResources().getStringArray(R.array.title);
        description=getResources().getStringArray(R.array.description);
        for(int i=0;i<title.length;i++)
        dataModels.add(new DataModel(title[i],description[i]));
        adapter=new CustomAdapter(dataModels,this);
        listView.setAdapter(adapter);

    }
}
