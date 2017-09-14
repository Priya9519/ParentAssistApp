package com.example.priya.parentassistapp.frontend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.example.priya.parentassistapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivAbout,ivStrength,ivHassles,ivSkill,ivStuff,ivContact;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    //initialise view
    private void initView() {
        ivAbout=(ImageView)findViewById(R.id.iv_about);
        ivStrength=(ImageView)findViewById(R.id.iv_strength);
        ivHassles=(ImageView)findViewById(R.id.iv_hassles);
        ivSkill=(ImageView)findViewById(R.id.iv_skill);
        ivStuff=(ImageView)findViewById(R.id.iv_stuff);
        ivContact=(ImageView)findViewById(R.id.iv_contact);

        ivAbout.setOnClickListener(this);
        ivStrength.setOnClickListener(this);
        ivHassles.setOnClickListener(this);
        ivSkill.setOnClickListener(this);
        ivStuff.setOnClickListener(this);
        ivContact.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_about:
                intent=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_strength:
                intent=new Intent(MainActivity.this,StrengthActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_contact:
                intent=new Intent(MainActivity.this,ContactActivity.class);
                startActivity(intent);
                break;
        }

    }
}
