package android.example.android.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class ecellevents extends AppCompatActivity {
  WebView ecellactivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecellevents);

        ecellactivity = (WebView)findViewById(R.id.ecelle);
        WebSettings webSettings = ecellactivity.getSettings();
        webSettings.setJavaScriptEnabled(true);
        ecellactivity.loadUrl("https://ecell.nitrr.ac.in/events");

    }
}
