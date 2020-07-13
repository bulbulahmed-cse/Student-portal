package com.example.onlineshopping;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class bProductFragment extends Fragment {


    private Spinner catagorySpinner;

    private ArrayList<String> productId = new ArrayList<>();
    private ArrayList<String> productName = new ArrayList<>();
    private ArrayList<String> productCategory = new ArrayList<>();
    private ArrayList<String> productPrice = new ArrayList<>();
    private ArrayList<String> productDetails = new ArrayList<>();
    private ArrayList<String> productSellerId = new ArrayList<>();

    String catagory;
    static String  buyerId, productJsonString;

    JSONObject jsonObject;
    JSONArray jsonArray;
    private View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        v = inflater.inflate(R.layout.fragment_b_product, container, false);

        catagorySpinner = v.findViewById(R.id.categorySpinner);

        //for category spinner
        ArrayList<String> arrayList1 = new ArrayList<>();
        arrayList1.add("All Category");
        arrayList1.add("Accessories");
        arrayList1.add("Clothes");
        arrayList1.add("Devices");
        arrayList1.add("Groceries");
        arrayList1.add("Stationeries");
        arrayList1.add("Others");

        ArrayAdapter deviceAdapter1 = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,arrayList1);
        catagorySpinner.setAdapter(deviceAdapter1);

        catagorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                catagory = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(),catagory,Toast.LENGTH_SHORT).show();
                showProductFromDb();
                getValueFromBw();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Toast.makeText(getActivity(),"Fragment",Toast.LENGTH_SHORT).show();

        /*showProductFromDb();
        getValueFromBw();*/


        return v;

    }

    private void getValueFromBw() {
        final ProgressDialog progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("Loading...");
        CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressDialog.show();
            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
                BackgroundWorker backgroundWorker = new BackgroundWorker(getActivity());
                buyerId = backgroundWorker.buyerId;
                productJsonString = backgroundWorker.productJsonString;

                /*AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                alertDialog.setTitle("Login status");
                alertDialog.setMessage("id: "+buyerId+"json"+productJsonString);
                alertDialog.show();*/

                convertJsonToArray();

                initRecyclerView();

            }
        }.start();


    }



    private void convertJsonToArray() {
        productId.clear();
        productName.clear();
        productCategory.clear();
        productPrice.clear();
        productDetails.clear();
        productSellerId.clear();
        try {
            jsonObject = new JSONObject(productJsonString);
            jsonArray = jsonObject.getJSONArray("server_response");

            int count = 0;
            String p_id, p_name, p_category, p_price, p_details, p_seller_id;

            while (count < jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);
                p_id = jo.getString("productId");
                p_name = jo.getString("productName");
                p_category = jo.getString("productCategory");
                p_price = jo.getString("productPrice");
                p_details = jo.getString("productDetails");
                p_seller_id = jo.getString("sellerId");


                productId.add(p_id);
                productName.add(p_name);
                productCategory.add(p_category);
                productPrice.add(p_price);
                productDetails.add(p_details);
                productSellerId.add(p_seller_id);

                Log.d("pname ", p_name);
                Log.d("pprice ", p_price);

                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showProductFromDb() {
        String type = "product_list";

        BackgroundWorker backgroundWorker = new BackgroundWorker(getActivity());
        backgroundWorker.execute(type, catagory);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = v.findViewById(R.id.productRv);
        ProductReclyerAdapter adapter = new ProductReclyerAdapter(getActivity(),buyerId, productId, productName, productCategory, productPrice, productDetails, productSellerId);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

}
