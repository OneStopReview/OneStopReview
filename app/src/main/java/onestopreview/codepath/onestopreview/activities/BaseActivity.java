package onestopreview.codepath.onestopreview.activities;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import onestopreview.codepath.onestopreview.R;

public class BaseActivity extends AppCompatActivity {
    private static final int WIFI_ENABLE_REQUEST = 0x1006;

    private static final String NETWORK_DISABLED = "Network Disabled";
    private static final String NO_INTERNET_MESSAGE = "No active internet connection found.";
    private static final String POSITIVE_BUTTON_TEXT = "Turn On";
    private static final String NEGATIVE_BUTTON_TEXT = "Cancel";

    private BroadcastReceiver networkDetectReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            checkInternetConnection();
        }
    };

    private AlertDialog internetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerReceiver(networkDetectReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(networkDetectReceiver);
        super.onDestroy();
    }


    private void checkInternetConnection() {
        if (!hasNetworkConnection()) {
            showNoInternetDialog();
        }
    }


    private boolean hasNetworkConnection() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = manager.getActiveNetworkInfo();
        return (ni != null && ni.isConnectedOrConnecting());
    }


    private void showNoInternetDialog() {

        if (internetDialog != null && internetDialog.isShowing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(NETWORK_DISABLED);
        builder.setIcon(R.drawable.ic_alert);
        builder.setMessage(NO_INTERNET_MESSAGE);
        builder.setPositiveButton(POSITIVE_BUTTON_TEXT, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent wifiIntent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
                        startActivityForResult(wifiIntent, WIFI_ENABLE_REQUEST);
                    }
                }).setNegativeButton(NEGATIVE_BUTTON_TEXT, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Do nothing
            }
        });
                internetDialog = builder.create();
        internetDialog.show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == WIFI_ENABLE_REQUEST) {
            //TODO:
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
