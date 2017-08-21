package com.example.mylibrary.Model;


import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

/*** Created by nikita on 16/08/2017.
 */

public class Product extends SugarRecord {
    @SerializedName("id")
    private long id;
    @SerializedName("productName")
    private String productName;
    @SerializedName("description")
    private String description;
    @SerializedName("salePrice")
    private double salePrice;

    public Product(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.salePrice = product.getSalePrice();
    }

    public Long getId() {
        return id;
    }

    public Product() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }
}
