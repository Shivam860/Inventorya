package com.inventorya.activity;
import android.os.Bundle;
import android.util.Log;

import com.inventorya.R;
import com.inventorya.framework.BaseActivity;

public class Dashboard extends BaseActivity {

    public static final String TAG = "Dashboard"; 
                
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callBaseMethod(R.layout.activity_dashboard);
    }

    @Override
    protected void setupUi() {
        Log.d(TAG, "setupUi: ");
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void response() {

    }

    @Override
    public void connectionEstablished() {
        System.out.println("is connected...");
    }

    @Override
    public void noConnectionAvailable() {
        System.out.println("is not connected...");
    }
}
