package com.example.onlineshopping;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PendingOrderListReclyerAdapter extends RecyclerView.Adapter<PendingOrderListReclyerAdapter.ViewHolder>{


    private Context mContext;
    private String sellerId;

    private ArrayList<String> ordorNo = new ArrayList<>();
    private ArrayList<String> order_productId = new ArrayList<>();
    private ArrayList<String> order_productName = new ArrayList<>();
    private ArrayList<String> order_productPrice = new ArrayList<>();
    private ArrayList<String> order_productQuantity = new ArrayList<>();
    private ArrayList<String> order_sellerId = new ArrayList<>();
    private ArrayList<String> order_buyerId = new ArrayList<>();

    public PendingOrderListReclyerAdapter(Context mContext, String sellerId, ArrayList<String> ordorNo, ArrayList<String> order_productId, ArrayList<String> order_productName, ArrayList<String> order_productPrice, ArrayList<String> order_productQuantity, ArrayList<String> order_sellerId, ArrayList<String> order_buyerId) {
        this.mContext = mContext;
        this.sellerId = sellerId;
        this.ordorNo = ordorNo;
        this.order_productId = order_productId;
        this.order_productName = order_productName;
        this.order_productPrice = order_productPrice;
        this.order_productQuantity = order_productQuantity;
        this.order_sellerId = order_sellerId;
        this.order_buyerId = order_buyerId;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pending_list_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull PendingOrderListReclyerAdapter.ViewHolder holder, int i) {
        holder.productNameTv.setText(order_productName.get(i));
        holder.productPriceTv.setText("Price: ("+order_productPrice.get(i)+" BDT)");
    }

    @Override
    public int getItemCount() {
        return order_productName.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView productNameTv;
        TextView productPriceTv;

        public ViewHolder(View itemView) {
            super(itemView);
            productNameTv = itemView.findViewById(R.id.pendingNameTv);
            productPriceTv = itemView.findViewById(R.id.pendingPriceTv);
        }
    }
}
