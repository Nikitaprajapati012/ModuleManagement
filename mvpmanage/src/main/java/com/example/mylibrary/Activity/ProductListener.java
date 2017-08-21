package com.example.mylibrary.Activity;

import com.example.mylibrary.Model.CartItems;
import com.example.mylibrary.Model.Product;

import javax.inject.Inject;

/*** Created by Valentine on 4/20/2016.
 */

public class ProductListener {

    // TODO: 17/8/17 Now that we have everything wired up, we can actually use Dagger 2 like this.
    //We are creating a class member variable for the
    //Shopping cart that we will be injecting to this class

    @Inject
    ShoppingCart mCart;

    public ProductListener(){
        //Here is where the actual injection takes place
        ProntoShopApplication.getInstance().getAppComponent().inject(this);
    }

    //Here is an example of how we are using the injected shopping cart
    public void onItemQuantityChanged(CartItems item, int qty) {
        mCart.updateItemQty(item, qty);
    }

    //Another example of using the shopping cart
    public void onAddToCartButtonClicked(Product product) {
        //perform add to checkout button here
        CartItems item = new CartItems(product, 1);
        mCart.addItemToCart(item);
    }

    public void onClearButtonClicked() {
        mCart.clearShoppingCart();
    }

    public void onDeleteItemButtonClicked(CartItems item) {
        mCart.removeItemFromCart(item);
    }
}
