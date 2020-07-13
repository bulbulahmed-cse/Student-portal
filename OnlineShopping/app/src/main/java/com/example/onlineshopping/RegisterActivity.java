package com.example.onlineshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class RegisterActivity extends AppCompatActivity{


    private EditText regNameEt, regEmailEt, regPasswordEt;
    private Button buttonRegister;
    private TextView textViewLogin;

    private String name, email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        regNameEt = (EditText) findViewById(R.id.regNameEt);
        regEmailEt = (EditText) findViewById(R.id.regEmailEt);
        regPasswordEt = (EditText) findViewById(R.id.regPasswordEt);
        buttonRegister = (Button) findViewById(R.id.regRegisterBtn);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser() {

        name = regNameEt.getText().toString();
        email = regEmailEt.getText().toString();
        pass = regPasswordEt.getText().toString();

        String type = "seller_register";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, name, email, pass);

    }
}
