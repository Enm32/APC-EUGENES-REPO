package com.example.progresscheckerforcbc;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
public class NetworkUtil {

    public static String getConnectivityStatusString(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        activeNetwork.getState();
        if (activeNetwork == null) {
            return "no internet";
        }else
            return  "network available";
    }
}
