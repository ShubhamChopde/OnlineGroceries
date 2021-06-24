package com.example.onlinegroceries.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.onlinegroceries.R;
import com.example.onlinegroceries.model.DiscountedProducts;

import java.util.List;

public class DiscountedProductAdapter extends RecyclerView.Adapter<DiscountedProductAdapter.DiscountedProductHolder>{

    Context context;
    List<DiscountedProducts> discountedProductsList;

    public DiscountedProductAdapter(Context context , List<DiscountedProducts> discountedProductsList){
        this.context = context;
        this.discountedProductsList = discountedProductsList;
    }

    @NonNull
    @Override
    public DiscountedProductHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.discounted_row_items,parent,false);
        return new DiscountedProductHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  DiscountedProductAdapter.DiscountedProductHolder holder, int position) {
        holder.discountImageView.setImageResource(discountedProductsList.get(position).getImageurl());

    }

    @Override
    public int getItemCount() { return discountedProductsList.size(); }




    public static class DiscountedProductHolder extends RecyclerView.ViewHolder{
        ImageView discountImageView;

        public DiscountedProductHolder(@NonNull View itemView) {
            super(itemView);

            discountImageView = itemView.findViewById(R.id.categoryImage);
        }
    }
}
