package com.inventorya.framework;

import android.content.Intent;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


import com.inventorya.callback.NetworkCallback;
import com.inventorya.network.Connectivity;

public abstract class BaseActivity extends AppCompatActivity implements NetworkCallback {

    private Handler handler;
    private Runnable runnable;
    private boolean isNetworkDemonActive = false;
   public void callBaseMethod(int id){
        setContentView(id);
        setupUi();
        initialize();
        runNetworkCall();
        response();

    }

    public void runNetworkCall(){
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                isNetworkDemonActive = true;
                handler.postDelayed(runnable,3000);
                Connectivity.isNetworkAvailable(BaseActivity.this);
            }
        };runnable.run();
    }
    protected abstract void setupUi();
    protected abstract void initialize();
    protected   abstract void response();

    public <T> void  navigateTo(Class<T> className){
        finish();
        startActivity(new Intent(this, className));
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(isNetworkDemonActive){
            handler.removeCallbacks(runnable);
            isNetworkDemonActive = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(!isNetworkDemonActive){
            runNetworkCall();
            isNetworkDemonActive = true;
        }
    }
}
