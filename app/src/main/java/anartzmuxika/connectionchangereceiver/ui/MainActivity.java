package anartzmuxika.connectionchangereceiver.ui;

import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import anartzmuxika.connectionchangereceiver.utils.NetworkUtil;
import anartzmuxika.connectionchangereceiver.R;
import anartzmuxika.connectionchangereceiver.services.NetworkChangeReceiver;

import static anartzmuxika.connectionchangereceiver.data.Constants.CONNECTIVITY_ACTION;

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

        if (NetworkUtil.getConnectivityStatus(MainActivity.this) > 0 ) System.out.println("Connect");
        else System.out.println("No connection");

        log_network = findViewById(R.id.log_network);
        addLogText(NetworkUtil.getConnectivityStatusString(MainActivity.this));
    }

    public static void addLogText(String log)
    {
        log_network.setText(String.format("%s\n%s", log_network.getText().toString(), log));
    }
}
