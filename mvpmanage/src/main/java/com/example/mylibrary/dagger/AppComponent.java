package com.example.mylibrary.dagger;

import com.example.mylibrary.Activity.MvpMainActivity;
import com.example.mylibrary.Activity.ProductListener;

import javax.inject.Singleton;

import dagger.Component;

/*** Created by nikita on 16/08/2017.
 */
@Singleton
@Component(
        modules = {
                AppModule.class,
                ShoppingCartModule.class
        }
)

public interface AppComponent {
    void inject(ProductListener presenter);

    void inject(MvpMainActivity activity);
}
