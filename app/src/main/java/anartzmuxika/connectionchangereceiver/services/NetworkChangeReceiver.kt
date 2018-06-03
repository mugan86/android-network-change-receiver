package anartzmuxika.connectionchangereceiver.services

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

import anartzmuxika.connectionchangereceiver.data.Constants
import anartzmuxika.connectionchangereceiver.ui.MainActivity
import anartzmuxika.connectionchangereceiver.utils.NetworkUtil

/***********************************************
 * Created by Anartz Mugika on 22/6/16.
 * Updated in Kotlin: 20/01/2018
 ***********************************************/

class NetworkChangeReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val status = NetworkUtil.getConnectivityStatusString(context)

        Log.e("Receiver ", "" + status)

        if (status == Constants.NOT_CONNECT) {
            Log.e("Receiver ", "not connection")// your code when internet lost


        } else {
            Log.e("Receiver ", "connected to internet")//your code when internet connection come back
        }

        (context as MainActivity).addLogText(status)
    }
}
