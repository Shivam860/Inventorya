package com.inventorya.network;

import android.os.AsyncTask;

import com.inventorya.callback.NetworkCallback;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Connectivity {

        private static final int TIME_OUT = 1000;
        private static NetworkCallback callback;
        public static void isNetworkAvailable(NetworkCallback networkCallback) {
            callback = networkCallback;
            ConnectionExecutor executor = new ConnectionExecutor();
            executor.execute();
        }



        static class ConnectionExecutor extends AsyncTask<Void,Void,Boolean> {

            protected Boolean doInBackground(Void... voids) {
                try {
                    Socket socket = new Socket();
                    SocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53);
                    socket.connect(socketAddress,TIME_OUT);
                    socket.close();
                    return true;
                } catch (IOException e) {
                    return false;
                }
            }

            @Override
            protected void onPostExecute(Boolean aBoolean) {
                super.onPostExecute(aBoolean);
                if(aBoolean){
                    callback.connectionEstablished();
                }else {
                    callback.noConnectionAvailable();
                }

            }
        }

    }

