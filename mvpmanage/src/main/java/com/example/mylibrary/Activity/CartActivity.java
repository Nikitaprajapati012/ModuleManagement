package com.example.mylibrary.Activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylibrary.Adapter.CartAdapter;
import com.example.mylibrary.Model.CartItems;
import com.example.mylibrary.Model.Product;
import com.example.mylibrary.R;
import com.example.mylibrary.Utils.Utils;

import java.util.List;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerViewProduct;
    ProductListener listener;
    Product productDetails;
    List<CartItems> productArrayList;
    Utils utils;
    Toolbar toolbar;
    ImageView imgBack;
    public static TextView txtGrandTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpmain);
        findById();
        init();
        setDataInList();
        click();
    }

    private void findById() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerViewProduct = (RecyclerView) findViewById(R.id.activity_main_listProduct);
        imgBack = (ImageView) findViewById(R.id.activity_main_imgback);
        txtGrandTotal = (TextView) findViewById(R.id.activity_main_txtgrandtotal);
        imgBack.setVisibility(View.VISIBLE);
    }

    private void init() {
        utils = new Utils(CartActivity.this);
    }

    private void setDataInList() {
        productArrayList = CartItems.listAll(CartItems.class);
        CartAdapter adapter = new CartAdapter(this, productArrayList);
        utils.replaceFragment(recyclerViewProduct, adapter);
    }

    private void click() {
        imgBack.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.activity_main_imgback) {
            onBackPressed();
        }
    }
}
