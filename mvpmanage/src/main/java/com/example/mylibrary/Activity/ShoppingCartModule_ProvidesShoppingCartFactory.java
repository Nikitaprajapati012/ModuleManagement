package com.example.mylibrary.Activity;

import android.content.SharedPreferences;

import com.example.mylibrary.dagger.ShoppingCartModule;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.internal.Factory;
import dagger.internal.Preconditions;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class ShoppingCartModule_ProvidesShoppingCartFactory implements Factory<ShoppingCart> {
    private final ShoppingCartModule module;

    private final Provider<SharedPreferences> preferencesProvider;

    public ShoppingCartModule_ProvidesShoppingCartFactory(
            ShoppingCartModule module, Provider<SharedPreferences> preferencesProvider) {
        assert module != null;
        this.module = module;
        assert preferencesProvider != null;
        this.preferencesProvider = preferencesProvider;
    }

    @Override
    public ShoppingCart get() {
        return Preconditions.checkNotNull(
                module.providesShoppingCart(preferencesProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<ShoppingCart> create(
            ShoppingCartModule module, Provider<SharedPreferences> preferencesProvider) {
        return new ShoppingCartModule_ProvidesShoppingCartFactory(module, preferencesProvider);
    }
}
