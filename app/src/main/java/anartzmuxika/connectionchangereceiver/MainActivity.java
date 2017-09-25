package anartzmuxika.connectionchangereceiver;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static anartzmuxika.connectionchangereceiver.Constants.CONNECTIVITY_ACTION;

public class MainActivity extends AppCompatActivity {

    IntentFilter intentFilter;
    NetworkChangeReceiver receiver;
    private static TextView log_network;
    private static String log_str;

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentFilter = new IntentFilter();
        intentFilter.addAction(CONNECTIVITY_ACTION);
        receiver = new NetworkChangeReceiver();

        if (NetworkUtil.getConnectivityStatus(MainActivity.this) > 0 ){ // Connect
            System.out.println("Connect");
        } else {
            System.out.println("No connection");
        }

        log_str = NetworkUtil.getConnectivityStatusString(MainActivity.this);
        log_network = (TextView) findViewById(R.id.log_network);
        log_network.setText(log_str);
    }

    public static void addLogText(String log)
    {
        log_str = log_str + "\n" + log;
        log_network.setText(log_str);
    }
}
