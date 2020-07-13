package com.example.onlineshopping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ProductReclyerAdapter extends RecyclerView.Adapter<ProductReclyerAdapter.ViewHolder>{

    private ArrayList<String> productId = new ArrayList<>();
    private ArrayList<String> productName = new ArrayList<>();
    private ArrayList<String> productCategory = new ArrayList<>();
    private ArrayList<String> productPrice = new ArrayList<>();
    private ArrayList<String> productDetails = new ArrayList<>();
    private ArrayList<String> productSellerId = new ArrayList<>();

    private String buyerId;
    private Context mContext;

    public ProductReclyerAdapter(Context mContext, String buyerId, ArrayList<String> productId, ArrayList<String> productName, ArrayList<String> productCategory, ArrayList<String> productPrice, ArrayList<String> productDetails, ArrayList<String> productSellerId) {
        this.buyerId = buyerId;
        this.productId = productId;
        this.productName = productName;
        this.productCategory = productCategory;
        this.productPrice = productPrice;
        this.productDetails = productDetails;
        this.productSellerId = productSellerId;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductReclyerAdapter.ViewHolder holder, final int i) {
        holder.productNameTv.setText(productName.get(i));
        holder.productPriceTv.setText("Price: ("+productPrice.get(i)+" BDT)");
        holder.productDetailsTv.setText("Details: \n"+productDetails.get(i));

        holder.orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = "set_order";

                BackgroundWorker backgroundWorker = new BackgroundWorker(mContext);
                backgroundWorker.execute(type, productId.get(i), productName.get(i), productPrice.get(i), "1", buyerId, productSellerId.get(i));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView productNameTv;
        TextView productPriceTv;
        TextView productDetailsTv;
        Button orderBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            productNameTv = itemView.findViewById(R.id.productNameTv);
            productPriceTv = itemView.findViewById(R.id.productPriceTv);
            productDetailsTv = itemView.findViewById(R.id.productDetailsTv);
            orderBtn = itemView.findViewById(R.id.productOrderBtn);
        }
    }
}
