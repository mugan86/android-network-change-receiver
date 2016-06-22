package anartzmuxika.connectionchangereceiver;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by anartzmugika on 22/6/16.
 */

public class NetworkUtil {

    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;

    public static int getConnectivityStatus(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (null != activeNetwork) {

            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {

        int conn = NetworkUtil.getConnectivityStatus(context);

        String status = null;
        if (conn == NetworkUtil.TYPE_WIFI) {
            //status = "Wifi enabled";
            status = Constants.CONNECT_TO_WIFI;
        } else if (conn == NetworkUtil.TYPE_MOBILE) {
            //status = "Mobile data enabled";
            status = Constants.CONNECT_TO_MOBILE;
        } else if (conn == NetworkUtil.TYPE_NOT_CONNECTED) {
            status = Constants.NOT_CONNECT;
        }
        return status;
    }
}
