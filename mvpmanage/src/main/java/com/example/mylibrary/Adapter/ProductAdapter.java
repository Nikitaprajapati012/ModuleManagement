package com.example.mylibrary.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylibrary.Activity.ProductListener;
import com.example.mylibrary.Model.CartItems;
import com.example.mylibrary.Model.Product;
import com.example.mylibrary.R;
import com.example.mylibrary.Utils.Utils;
import com.orm.util.NamingHelper;
import java.util.ArrayList;
import java.util.List;

import static com.example.mylibrary.Activity.MvpMainActivity.txtGrandTotal;

/*** Created by nikita on 17/8/17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Product> productList;
    private Utils utils;
    private ProductListener listener;

    public ProductAdapter(Context context, ArrayList<Product> productArrayList) {
        this.mContext = context;
        this.productList = productArrayList;
        this.utils = new Utils(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final Product productDetails = productList.get(position);
        holder.txtProductName.setText(productDetails.getProductName());
        holder.txtProductPrice.setText(String.valueOf(productDetails.getSalePrice()));
        holder.txtProductDescription.setText(productDetails.getDescription());
        txtGrandTotal.setVisibility(View.GONE);
        holder.txtSubTotal.setVisibility(View.INVISIBLE);
        holder.imgCancel.setVisibility(View.GONE);
        holder.layoutQuantity.setVisibility(View.GONE);
        holder.imgAdd.setVisibility(View.VISIBLE);

        // TODO: 18/8/17 add the items in cartt 
        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener = new ProductListener();
                listener.onAddToCartButtonClicked(productDetails);
                Toast.makeText(mContext, "Add to cart", Toast.LENGTH_SHORT).show();

                List<Product> productListData = Product.find(Product.class, NamingHelper.toSQLNameDefault("id")
                        + " = ? ", String.valueOf(productDetails.getId()));

                for (Product product : productListData) {
                    CartItems cart = new CartItems();
                    cart.setId(product.getId());
                    cart.setDescription(product.getDescription());
                    cart.setSalePrice(product.getSalePrice());
                    cart.setProductName(product.getProductName());
                    cart.save();
                }
//                productList.remove(position);
//                notifyDataSetChanged();
//                notifyItemRemoved(position);
//                notifyItemRangeChanged(position, productList.size());
            }
        });
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtProductName, txtProductPrice, txtProductDescription, txtSubTotal;
        ImageView imgCancel, imgAdd;
        LinearLayout layoutQuantity;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtSubTotal = (TextView) itemView.findViewById(R.id.fragment_product_list_txtsubtotal);
            layoutQuantity = (LinearLayout) itemView.findViewById(R.id.fragment_product_list_layoutquantity);
            imgCancel = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgcancel);
            imgAdd = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgadd);
            txtProductName = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductname);
            txtProductPrice = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductprice);
            txtProductDescription = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductdesc);

        }
    }
}
