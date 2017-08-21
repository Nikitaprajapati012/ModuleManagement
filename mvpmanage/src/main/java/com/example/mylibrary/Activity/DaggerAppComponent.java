package com.example.mylibrary.Activity;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.mylibrary.dagger.AppComponent;
import com.example.mylibrary.dagger.AppModule;
import com.example.mylibrary.dagger.ShoppingCartModule;

import javax.annotation.Generated;
import javax.inject.Provider;

import dagger.MembersInjector;
import dagger.internal.MembersInjectors;
import dagger.internal.Preconditions;
import dagger.internal.ScopedProvider;

@Generated(
        value = "dagger.internal.codegen.ComponentProcessor",
        comments = "https://google.github.io/dagger"
)
public final class DaggerAppComponent implements AppComponent {
    private Provider<Context> provideContextProvider;

    private Provider<SharedPreferences> providesSharedPreferenceProvider;

    private Provider<ShoppingCart> providesShoppingCartProvider;

    private MembersInjector<ProductListener> productListenerMembersInjector;

    private DaggerAppComponent(Builder builder) {
        assert builder != null;
        initialize(builder);
    }

    public static Builder builder() {
        return new Builder();
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Builder builder) {

        this.provideContextProvider =
                ScopedProvider.create(AppModule_ProvideContextFactory.create(builder.appModule));

        this.providesSharedPreferenceProvider =
                ScopedProvider.create(
                        ShoppingCartModule_ProvidesSharedPreferenceFactory.create(
                                builder.shoppingCartModule, provideContextProvider));

        this.providesShoppingCartProvider =
                ScopedProvider.create(
                        ShoppingCartModule_ProvidesShoppingCartFactory.create(
                                builder.shoppingCartModule, providesSharedPreferenceProvider));

        this.productListenerMembersInjector =
                ProductListener_MembersInjector.create(providesShoppingCartProvider);
    }

    @Override
    public void inject(ProductListener presenter) {
        productListenerMembersInjector.injectMembers(presenter);
    }

    @Override
    public void inject(MvpMainActivity activity) {
        MembersInjectors.<MvpMainActivity>noOp().injectMembers(activity);
    }

    public static final class Builder {
        private AppModule appModule;

        private ShoppingCartModule shoppingCartModule;

        private Builder() {
        }

        public AppComponent build() {
            if (appModule == null) {
                throw new IllegalStateException(AppModule.class.getCanonicalName() + " must be set");
            }
            if (shoppingCartModule == null) {
                this.shoppingCartModule = new ShoppingCartModule();
            }
            return new DaggerAppComponent(this);
        }

        public Builder appModule(AppModule appModule) {
            this.appModule = Preconditions.checkNotNull(appModule);
            return this;
        }

        public Builder shoppingCartModule(ShoppingCartModule shoppingCartModule) {
            this.shoppingCartModule = Preconditions.checkNotNull(shoppingCartModule);
            return this;
        }
    }
}
