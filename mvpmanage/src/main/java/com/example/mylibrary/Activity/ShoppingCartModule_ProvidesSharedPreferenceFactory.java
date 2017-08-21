package com.example.mylibrary.Activity;

import android.content.Context;
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
public final class ShoppingCartModule_ProvidesSharedPreferenceFactory
        implements Factory<SharedPreferences> {
    private final ShoppingCartModule module;

    private final Provider<Context> contextProvider;

    public ShoppingCartModule_ProvidesSharedPreferenceFactory(
            ShoppingCartModule module, Provider<Context> contextProvider) {
        assert module != null;
        this.module = module;
        assert contextProvider != null;
        this.contextProvider = contextProvider;
    }

    @Override
    public SharedPreferences get() {
        return Preconditions.checkNotNull(
                module.providesSharedPreference(contextProvider.get()),
                "Cannot return null from a non-@Nullable @Provides method");
    }

    public static Factory<SharedPreferences> create(
            ShoppingCartModule module, Provider<Context> contextProvider) {
        return new ShoppingCartModule_ProvidesSharedPreferenceFactory(module, contextProvider);
    }
}
