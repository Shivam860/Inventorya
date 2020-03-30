package com.inventorya.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.inventorya.R;
import com.inventorya.framework.BaseActivity;
import com.inventorya.network.Connectivity;

public class SplashActivity extends BaseActivity  {

    private TextView descriptionTv;
    private String TAG = "SplashActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callBaseMethod(R.layout.splash_activity);
    }

    @Override
    protected void setupUi() {
        descriptionTv = findViewById(R.id.sa_tv_id);
    }

    @Override
    protected void initialize() {
        Log.d(TAG, "connectionEstablished: "+descriptionTv.getText());
    }

    @Override
    protected void response() {

    }

    @Override
    public void connectionEstablished() {
        descriptionTv.setText(getResources().getString(R.string.successfully_sync));
        Log.d(TAG, "connectionEstablished: "+descriptionTv.getText());

        navigateTo(Dashboard.class);
    }

    @Override
    public void noConnectionAvailable() {
        descriptionTv.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.colorRed));
        descriptionTv.setText(getResources().getString(R.string.error_while_sync));

    }
}
