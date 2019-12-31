package android.example.android.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class notesActivity extends AppCompatActivity {
    WebView notesSection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        notesSection = (WebView)findViewById(R.id.button6);
        WebSettings webSettings = notesSection.getSettings();
        webSettings.setJavaScriptEnabled(true);
        notesSection.loadUrl("https://drive.google.com/folderview?id=10r_krPwLld09Dji460s0RG6UAJ6CdapK ");
    }

    public void notesOnClick(View view) {
        Intent i = new Intent(this,Welcome.class);
        startActivity(i);
    }
}
