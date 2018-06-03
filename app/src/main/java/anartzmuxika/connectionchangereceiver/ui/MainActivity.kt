package anartzmuxika.connectionchangereceiver.ui

import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import anartzmuxika.connectionchangereceiver.utils.NetworkUtil
import anartzmuxika.connectionchangereceiver.R
import kotlinx.android.synthetic.main.activity_main.*
import anartzmuxika.connectionchangereceiver.services.NetworkChangeReceiver

import anartzmuxika.connectionchangereceiver.data.Constants.CONNECTIVITY_ACTION

/***********************************************
 * Created by Anartz Mugika on 22/6/16.
 * Updated in Kotlin: 20/01/2018
 * Adapt to new API, remove 'service' in Android Manifest
 ***********************************************/

class MainActivity : AppCompatActivity() {

    internal var intentFilter: IntentFilter? = null
    internal var receiver: NetworkChangeReceiver? = null

    override fun onResume() {
        super.onResume()
        registerReceiver(receiver, intentFilter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        intentFilter = IntentFilter()
        intentFilter?.let {
            intentFilter!!.addAction(CONNECTIVITY_ACTION)
            receiver = NetworkChangeReceiver()
        }


        if (NetworkUtil.getConnectivityStatus(this@MainActivity) > 0)
            println("Connect")
        else
            println("No connection")
        addLogText(NetworkUtil.getConnectivityStatusString(this@MainActivity))
    }

    fun addLogText(log: String) {
        logText!!.text = String.format("%s\n%s", logText.text!!.toString(), log)
    }
}
