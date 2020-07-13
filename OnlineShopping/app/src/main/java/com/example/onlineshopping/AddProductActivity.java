package com.example.onlineshopping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class AddProductActivity extends AppCompatActivity {

    private EditText pName, pPrice, pDetails;
    private Spinner pCatagorySpinner;

    String name, catagory, price, details, sellerId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        pName = findViewById(R.id.addProductName);
        pPrice = findViewById(R.id.addProductPrice);
        pDetails = findViewById(R.id.addProductDetails);
        pCatagorySpinner = findViewById(R.id.addProductCategory);


        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("Select Category");
        arrayList1.add("Accessories");
        arrayList1.add("Clothes");
        arrayList1.add("Devices");
        arrayList1.add("Groceries");
        arrayList1.add("Stationeries");
        arrayList1.add("Others");

        ArrayAdapter deviceAdapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList1);
        pCatagorySpinner.setAdapter(deviceAdapter1);

        pCatagorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                catagory = parent.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void addProduct(View view) {

        if (catagory.equals("Select Category")){
            Toast.makeText(this,"Select Category",Toast.LENGTH_SHORT).show();
        }
        else {
            name = pName.getText().toString().trim();
            price = pPrice.getText().toString().trim();
            details = pDetails.getText().toString().trim();

            String type = "add_product";

            BackgroundWorker backgroundWorker = new BackgroundWorker(this);
            sellerId = backgroundWorker.sellerId;
            backgroundWorker.execute(type, name, catagory, price, details, sellerId);
        }

    }
}
