package com.example.onlineshopping;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private EditText userEmail, userPass;
    private Button loginBtn;
    private TextView registerTv;

    private RadioButton buyerBtn, sellerBtn;

    private String email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEmail = findViewById(R.id.loginUserEmailEt);
        userPass = findViewById(R.id.loginUserPassEt);
        loginBtn = findViewById(R.id.loginBtn);
        registerTv = findViewById(R.id.loginRegisterTv);

        sellerBtn = findViewById(R.id.loginAsSellerRd);
        buyerBtn = findViewById(R.id.loginAsBuyerRd);

        buyerBtn.setChecked(true);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (sellerBtn.isChecked()){
                    email = userEmail.getText().toString();
                    pass = userPass.getText().toString();

                    String type = "seller_login";

                    BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
                    backgroundWorker.execute(type, email, pass);
                }
                else if (buyerBtn.isChecked()){
                    email = userEmail.getText().toString();
                    pass = userPass.getText().toString();

                    String type = "buyer_login";

                    BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
                    backgroundWorker.execute(type, email, pass);
                }


            }
        });

        registerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    public void viewAll(View view) {
        String type = "seller_list";

        BackgroundWorker backgroundWorker = new BackgroundWorker(MainActivity.this);
        backgroundWorker.execute(type);
    }
}
