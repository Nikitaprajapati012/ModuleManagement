package com.example.mylibrary.Activity;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class ProductListener_MembersInjector implements MembersInjector<ProductListener> {
    private final Provider<ShoppingCart> mCartProvider;

    public ProductListener_MembersInjector(Provider<ShoppingCart> mCartProvider) {
        assert mCartProvider != null;
        this.mCartProvider = mCartProvider;
    }

    public static MembersInjector<ProductListener> create(Provider<ShoppingCart> mCartProvider) {
        return new ProductListener_MembersInjector(mCartProvider);
    }

    @Override
    public void injectMembers(ProductListener instance) {
        if (instance == null) {
            throw new NullPointerException("Cannot inject members into a null reference");
        }
        instance.mCart = mCartProvider.get();
    }

    public static void injectMCart(ProductListener instance, Provider<ShoppingCart> mCartProvider) {
        instance.mCart = mCartProvider.get();
    }
}
