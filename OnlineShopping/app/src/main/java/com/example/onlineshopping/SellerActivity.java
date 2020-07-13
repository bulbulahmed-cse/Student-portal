package com.example.onlineshopping;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SellerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

    }

    public void addProduct(View view) {
        Intent intent = new Intent(this, AddProductActivity.class);
        startActivity(intent);
    }

    public void perndingOrders(View view) {
        Intent intent = new Intent(this, PendingOrdersActivity.class);
        startActivity(intent);
    }
}