package anartzmuxika.connectionchangereceiver.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import anartzmuxika.connectionchangereceiver.data.Constants;
import anartzmuxika.connectionchangereceiver.ui.MainActivity;
import anartzmuxika.connectionchangereceiver.utils.NetworkUtil;

/***********************************************
 * Created by anartzmugika on 22/6/16.
 */

public class NetworkChangeReceiver extends BroadcastReceiver {
    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        mContext = context;
        String status = NetworkUtil.getConnectivityStatusString(context);

        Log.e("Receiver ", "" + status);

        if (status.equals(Constants.NOT_CONNECT)) {
            Log.e("Receiver ", "not connection");// your code when internet lost


        } else {
            Log.e("Receiver ", "connected to internet");//your code when internet connection come back
        }
        MainActivity.addLogText(status);

    }
}
