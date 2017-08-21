package com.example.mylibrary.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by nikita on 17/8/17.
 */

public class Utils {
    Context mContext;
    SharedPreferences preference;

    public Utils(Context mContext) {
        this.mContext = mContext;
        preference = mContext.getSharedPreferences(Constants.Prefrence, Context.MODE_PRIVATE);
    }

    public void replaceFragment(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(mContext);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public static void WriteSharePrefrence(Context context, String key, String value) {
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String ReadSharePrefrence(Context context, String key) {
        String data;
        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = preferences.edit();
        data = preferences.getString(key, "");
        editor.apply();
        return data;
    }

    public static void ClearSharePref(Context context, String value) {

        final SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        final SharedPreferences.Editor editor = preferences.edit().remove(value);
        editor.apply();
    }


}
