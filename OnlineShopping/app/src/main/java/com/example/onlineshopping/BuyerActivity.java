package com.example.onlineshopping;


import android.app.AlertDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class BuyerActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buyer);

        mDrawerLayout = findViewById(R.id.buyerParentLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        bProductFragment bProductFragment = new bProductFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.buyerContainer, bProductFragment).commit();

        navigationView = findViewById(R.id.buyer_drawer_navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment selectedFragment = null;

                switch (item.getItemId()) {
                    case R.id.nav_buyer_profile:
                        selectedFragment = new bProductFragment();
                        break;
                    case R.id.nav_buyer_product:
                        selectedFragment = new bProductFragment();
                        break;
                    case R.id.nav_buyer_orders:
                        selectedFragment = new bOrderFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.buyerContainer, selectedFragment).commit();
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
