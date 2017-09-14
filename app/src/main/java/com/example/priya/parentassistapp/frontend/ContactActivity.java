package com.example.priya.parentassistapp.frontend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.priya.parentassistapp.R;

public class ContactActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etName,etEmail,etMessage;
    private Button btnSubmit;
    private String name,email,message;
    private boolean isValidated=false;
    private static String app_name="Parent Assist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initView();
    }
   //initalise views of xml
    private void initView() {
        etName=(EditText)findViewById(R.id.et_name);
        etEmail=(EditText)findViewById(R.id.et_email);
        etMessage=(EditText)findViewById(R.id.et_message);
        btnSubmit=(Button)findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        validateDetail();
        if(isValidated){
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto",email, null));
            intent.putExtra(Intent.EXTRA_SUBJECT,app_name);
            intent.putExtra(Intent.EXTRA_TEXT,message);
            startActivity(Intent.createChooser(intent, "Send Email"));
        }

    }
    //validate data Entered by user
    private void validateDetail() {
       isValidated=false;
            name=etName.getText().toString();
            email=etEmail.getText().toString();
            message=etMessage.getText().toString();
            if (TextUtils.isEmpty(name)){
                etName.setError("Please Enter Your Name");
            }
            else if (name.matches("\\d+")){
                etName.setError("Name cannot be Numeric");
            }
            else if (TextUtils.isEmpty(email)) {
                etEmail.setError("Plz Enter you Email");
            } else if (!email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")){ //match email with valid email regex
                etEmail.setError("Invalid Email");}
                else if (TextUtils.isEmpty(message)){
                    etMessage.setError("Please Enter Message");
                }
            else isValidated=true;
        }


}
