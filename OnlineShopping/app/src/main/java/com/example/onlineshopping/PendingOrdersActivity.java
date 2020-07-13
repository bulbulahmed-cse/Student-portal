package com.example.onlineshopping;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PendingOrdersActivity extends AppCompatActivity {

    private ArrayList<String> ordorNo = new ArrayList<>();
    private ArrayList<String> order_productId = new ArrayList<>();
    private ArrayList<String> order_productName = new ArrayList<>();
    private ArrayList<String> order_productPrice = new ArrayList<>();
    private ArrayList<String> order_productQuantity = new ArrayList<>();
    private ArrayList<String> order_sellerId = new ArrayList<>();
    private ArrayList<String> order_buyerId = new ArrayList<>();

    private JSONObject jsonObject;
    private JSONArray jsonArray;

    static String  sellerId, productJsonString;

    BackgroundWorker backgroundWorker = new BackgroundWorker(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_orders);

        sellerId = backgroundWorker.sellerId;

        showProductFromDb();
        getValueFromBw();
    }

    private void getValueFromBw() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                progressDialog.show();
            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();

                productJsonString = backgroundWorker.productJsonString;

                /*AlertDialog alertDialog = new AlertDialog.Builder(PendingOrdersActivity.this).create();
                alertDialog.setTitle("Buyer Order");
                alertDialog.setMessage("id: "+sellerId+"json"+productJsonString);
                alertDialog.show();*/

                convertJsonToArray();

                initRecyclerView();

            }
        }.start();


    }



    private void convertJsonToArray() {

        ordorNo.clear();
        order_productId.clear();
        order_productName.clear();
        order_productPrice.clear();
        order_sellerId.clear();
        order_buyerId.clear();
        order_productQuantity.clear();

        try {
            jsonObject = new JSONObject(productJsonString);
            jsonArray = jsonObject.getJSONArray("server_response");

            int count = 0;
            String o_id, o_pId, o_pn, o_pp, o_pq, o_sId, o_bId;

            while (count < jsonArray.length()){
                JSONObject jo = jsonArray.getJSONObject(count);
                o_id = jo.getString("orderNo");
                o_pId = jo.getString("productId");
                o_pn = jo.getString("productName");
                o_pp = jo.getString("productPrice");
                o_pq = jo.getString("productQuantity");
                o_sId = jo.getString("sellerId");
                o_bId = jo.getString("buyerId");




                ordorNo.add(o_id);
                order_productId.add(o_pId);
                order_productName.add(o_pn);
                order_productPrice.add(o_pp);
                order_productQuantity.add(o_pq);
                order_sellerId.add(o_sId);
                order_buyerId.add(o_bId);

                count++;
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void showProductFromDb() {
        String type = "pending_order_list";

        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, sellerId);
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.pendingOrderListRv);
        PendingOrderListReclyerAdapter adapter = new PendingOrderListReclyerAdapter(this, sellerId, ordorNo, order_productId, order_productName, order_productPrice, order_productQuantity, order_sellerId, order_buyerId);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
