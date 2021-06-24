package com.example.onlinegroceries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.onlinegroceries.adapter.CategoryAdapter;
import com.example.onlinegroceries.adapter.DiscountedProductAdapter;
import com.example.onlinegroceries.adapter.RecentlyViewedAdapter;
import com.example.onlinegroceries.model.Category;
import com.example.onlinegroceries.model.DiscountedProducts;
import com.example.onlinegroceries.adapter.DiscountedProductAdapter;
import com.example.onlinegroceries.model.DiscountedProducts;
import com.example.onlinegroceries.model.RecentlyViewed;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView discountRecyclerView, categoryRecyclerView, recentlyViewedRecycler;
    DiscountedProductAdapter discountedProductAdapter;
    List<DiscountedProducts> discountedProductsList;

    CategoryAdapter categoryAdapter;
    List<Category> categoryList;

    RecentlyViewedAdapter recentlyViewedAdapter;
    List<RecentlyViewed> recentlyViewedList;

    ImageView allCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        discountRecyclerView = findViewById(R.id.discountedRecycler);
        categoryRecyclerView = findViewById(R.id.categoryRecycler);
        allCategory = findViewById(R.id.allCategoryImage);
        recentlyViewedRecycler = findViewById(R.id.recently_item);

        allCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,AllCategory.class);
                startActivity(i);

            }
        });


        discountedProductsList = new ArrayList<>();
        discountedProductsList.add(new DiscountedProducts(1, R.drawable.bournvita));
        discountedProductsList.add(new DiscountedProducts(2, R.drawable.coupon));
        discountedProductsList.add(new DiscountedProducts(3, R.drawable.off));

        categoryList = new ArrayList<>();
        categoryList.add(new Category( 1, R.drawable.ic_dairy));
        categoryList.add(new Category( 2, R.drawable.ic_eggs));
        categoryList.add(new Category( 3, R.drawable.ic_fruits));
        categoryList.add(new Category( 4, R.drawable.ic_juice));
        categoryList.add(new Category( 5, R.drawable.ic_cupcake));
        categoryList.add(new Category( 6, R.drawable.ic_cookies));
        categoryList.add(new Category( 7, R.drawable.ic_meat));
        categoryList.add(new Category( 8, R.drawable.ic_salad));
        categoryList.add(new Category( 9, R.drawable.ic_vegetables));

        // adding data to model
        recentlyViewedList = new ArrayList<>();
        recentlyViewedList.add(new RecentlyViewed("Strawberry","Watermelon has high water content and also provide some fiber","₹ 80", "2","KG", R.drawable.strawberry , R.drawable.s1));
        recentlyViewedList.add(new RecentlyViewed("Papaya","Watermelon has high water content and also provide some fiber","₹ 80", "2","KG", R.drawable.papaya , R.drawable.p1));
        recentlyViewedList.add(new RecentlyViewed("Mango","Watermelon has high water content and also provide some fiber","₹ 80", "2","KG", R.drawable.mango , R.drawable.m1));
        recentlyViewedList.add(new RecentlyViewed("Watermelon","Watermelon has high water content and also provide some fiber","₹ 80", "2","KG", R.drawable.watermelon1, R.drawable.w1));


        setDiscountedRecycler(discountedProductsList);
        setCategoryRecycler(categoryList);
        setRecentlyViewedRecycler(recentlyViewedList);
    }

    private void setDiscountedRecycler(List<DiscountedProducts> dataList){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL , false);
        discountRecyclerView.setLayoutManager(layoutManager);
        discountedProductAdapter = new DiscountedProductAdapter(this, dataList);
        discountRecyclerView.setAdapter(discountedProductAdapter);

    }
    private void setCategoryRecycler(List<Category> categoryDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL , false);
        categoryRecyclerView.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this, categoryDataList);
        categoryRecyclerView.setAdapter(categoryAdapter);
    }
    private void setRecentlyViewedRecycler(List<RecentlyViewed> recentlyViewedDataList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL , false);
        recentlyViewedRecycler.setLayoutManager(layoutManager);
        recentlyViewedAdapter = new RecentlyViewedAdapter(this, recentlyViewedDataList);
        recentlyViewedRecycler.setAdapter(recentlyViewedAdapter);
    }
}