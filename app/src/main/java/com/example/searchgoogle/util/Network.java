package com.example.searchgoogle.util;

import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.searchgoogle.R;

/**
 * Created by serj on 2/28/17.
 */

public class Network {

    public static boolean isOnline(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        boolean isAvailable = false;
        if (networkInfo != null && networkInfo.isConnected()) {
            isAvailable = true;
        }
        return isAvailable;
    }

    public static void showErrorConnectDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(context.getString(R.string.network_is_absent))
                .setMessage(context.getString(R.string.check_connection))
                .setPositiveButton(context.getString(R.string.retry), (dialog, which) -> dialog.dismiss())
                .setCancelable(false).create().show();

    }
}
