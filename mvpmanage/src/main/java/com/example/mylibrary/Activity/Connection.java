package com.example.mylibrary.Activity;

import android.os.AsyncTask;

/*** Created by nikita on 21/8/17.
 */

public class Connection extends AsyncTask<String, Void, String> {

    MvpMainActivity mvpMainActivity;

    public Connection(MvpMainActivity activity) {
        mvpMainActivity = activity;
    }

    @Override
    protected String doInBackground(String... strings) {
        return mvpMainActivity.toString();
    }
}