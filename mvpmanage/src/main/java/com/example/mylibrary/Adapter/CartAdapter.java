package com.example.mylibrary.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylibrary.Model.CartItems;
import com.example.mylibrary.R;

import java.text.DecimalFormat;
import java.util.List;

import static com.example.mylibrary.Activity.CartActivity.txtGrandTotal;


/*** Created by nikita on 17/8/17.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private Context mContext;
    private List<CartItems> productList;

    public CartAdapter(Context context, List<CartItems> productArrayList) {
        this.mContext = context;
        this.productList = productArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_product_list, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final CartItems productDetails = productList.get(position);
        holder.txtProductName.setText(productDetails.getProductName());
        holder.txtProductPrice.setText(String.valueOf(productDetails.getSalePrice()));
        holder.txtProductDescription.setText(productDetails.getDescription());
        txtGrandTotal.setVisibility(View.INVISIBLE);
        holder.txtSubTotal.setVisibility(View.VISIBLE);
        holder.imgCancel.setVisibility(View.VISIBLE);
        holder.layoutQuantity.setVisibility(View.VISIBLE);
        holder.imgAdd.setVisibility(View.GONE);
        holder.imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                productList.remove(position);
                productDetails.delete();
                notifyDataSetChanged();
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, productList.size());
            }
        });
        holder.imgQuantityUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int temp = position;
                int quantity = Integer.parseInt(holder.edQuantity.getText().toString().trim());
                holder.edQuantity.setText(String.valueOf(quantity + 1));
                quantity = quantity + 1;
                Float priceTotal = (float) productList.get(temp).getSalePrice();
                holder.txtSubTotal.setText(String.valueOf(priceTotal));
                Double productTotal = Double.parseDouble(holder.txtSubTotal.getText().toString().trim());
                Double subTotal = null;
                subTotal = Double.parseDouble(String.valueOf(priceTotal)) * quantity;
                String subtotalProduct = "" + String.valueOf
                        (new DecimalFormat("##.##").format(subTotal));
                holder.txtSubTotal.setText(subtotalProduct);
                grandTotal(productList, holder, position, subtotalProduct);
            }
        });
        holder.imgQuantityDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.edQuantity.getText().toString().equalsIgnoreCase("1")) {
                    Toast.makeText(mContext, "select atlest 1", Toast.LENGTH_LONG).show();
                } else {
                    final int temp = position;
                    int quantity = Integer.parseInt(holder.edQuantity.getText().toString().trim());
                    holder.edQuantity.setText(String.valueOf(quantity - 1));
                    quantity = quantity - 1;
                    Float priceTotal = (float) productList.get(temp).getSalePrice();
                    holder.txtSubTotal.setText(String.valueOf(priceTotal));
                    Double productTotal = Double.parseDouble(holder.txtSubTotal.getText().toString().trim());
                    Double subTotal = null;
                    subTotal = Double.parseDouble(String.valueOf(priceTotal)) * quantity;
                    String subtotalProduct = "" + String.valueOf
                            (new DecimalFormat("##.##").format(subTotal));
                    holder.txtSubTotal.setText(subtotalProduct);
                    grandTotal(productList, holder, position, subtotalProduct);
                }
            }
        });

    }

    private void grandTotal(List<CartItems> productList, MyViewHolder holder,
                            int position, String subTotal) {
        Double aDouble = Double.valueOf(subTotal);
        for (int i = 0; i < productList.size(); i++) {
            aDouble += Double.parseDouble(subTotal);
            String grandTotal = "$" + String.valueOf(new DecimalFormat("##.##").format(aDouble));
            Log.d("grandTotal", "@@" + grandTotal);
            txtGrandTotal.setText(grandTotal);
        }
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
        ImageView imgCancel, imgAdd, imgQuantityUp, imgQuantityDown;
        LinearLayout layoutQuantity;
        EditText edQuantity;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtSubTotal = (TextView) itemView.findViewById(R.id.fragment_product_list_txtsubtotal);
            edQuantity = (EditText) itemView.findViewById(R.id.fragment_product_list_edquantity);
            layoutQuantity = (LinearLayout) itemView.findViewById(R.id.fragment_product_list_layoutquantity);
            imgQuantityUp = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgquantity_up);
            imgQuantityDown = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgquantity_down);
            imgCancel = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgcancel);
            imgAdd = (ImageView) itemView.findViewById(R.id.fragment_product_list_imgadd);
            txtProductName = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductname);
            txtProductPrice = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductprice);
            txtProductDescription = (TextView) itemView.findViewById(R.id.fragment_product_list_txtproductdesc);

        }
    }
}
