package com.example.mylibrary.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mylibrary.Adapter.ProductAdapter;
import com.example.mylibrary.Model.Product;
import com.example.mylibrary.R;
import com.example.mylibrary.Utils.Utils;

import java.util.ArrayList;

public class MvpMainActivity extends AppCompatActivity implements View.OnClickListener {
    RecyclerView recyclerViewProduct;
    ProductListener listener;
    ImageView imgBack;
    ArrayList<Product> productArrayList;
    Utils utils;
    Toolbar toolbar;
    public static TextView txtGrandTotal;
    public Connection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvpmain);
        Log.d("MVP","@@ENTER");
        findById();
        init();
        setDataInList();
    }

    public void findById() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        recyclerViewProduct = (RecyclerView) findViewById(R.id.activity_main_listProduct);
        imgBack = (ImageView) findViewById(R.id.activity_main_imgback);
        imgBack.setVisibility(View.GONE);
        txtGrandTotal = (TextView) findViewById(R.id.activity_main_txtgrandtotal);
    }

    public void init() {
        utils = new Utils(MvpMainActivity.this);
    }

    public void setDataInList() {
        productArrayList = new ArrayList<>();
        int[] productId = {1, 2, 3, 4, 5};
        String[] productName = {"Mobile", "TV", "PC", "Fan", "Tubelight"};
        double[] productPrice = {15999, 99999, 39999, 2999, 199};
        String[] productDesc = {"This Mobile have very nice features.",
                "This TV have very nice features.",
                "This PC have very nice features.",
                "This Fan is too fast.",
                "This Tubelight is spread more light."};

        for (int h = 0; h < productId.length; h++) {
            Product productDetails = new Product();
            productDetails.setId(productId[h]);
            productDetails.setProductName(productName[h]);
            productDetails.setSalePrice(productPrice[h]);
            productDetails.setDescription(productDesc[h]);
            productDetails.save();
            productArrayList.add(productDetails);
        }
        ProductAdapter adapter = new ProductAdapter(this, productArrayList);
        utils.replaceFragment(recyclerViewProduct, adapter);
    }

    public MvpMainActivity() {
        //Here is where the actual injection takes place
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cart) {
            Intent intent = new Intent(MvpMainActivity.this, CartActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }
}
