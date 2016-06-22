package anartzmuxika.connectionchangereceiver;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static TextView log_network;
    private static String log_str;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
