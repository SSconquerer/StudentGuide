package android.example.android.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class downloadsActivity extends AppCompatActivity {

    WebView downloadsSection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_downloads);

downloadsSection = (WebView)findViewById(R.id.downloadsSection);
        WebSettings webSettings = downloadsSection.getSettings();
        webSettings.setJavaScriptEnabled(true);
        downloadsSection.loadUrl("http://www.nitrr.ac.in/gen_downloads.php");

    }

    public void downloadsOnClick(View view) {
        Intent i = new Intent(this,Welcome.class);
        startActivity(i);
    }

}
