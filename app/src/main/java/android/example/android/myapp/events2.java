package android.example.android.myapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class events2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events2);
    }

    public void tapp1(View view) {
        Intent browse=new Intent(events2.this,ecellevents.class);
        startActivity(browse);
    }

    public void tapp2(View view) {
        Intent browse1=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nitrr.ac.in/downloads/stu%20welfare/Cultural%20Committees.pdf"));
        startActivity(browse1);
    }


    public void tap3(View view) {
        Intent browse3=new Intent(Intent.ACTION_VIEW, Uri.parse("http://technocracy.nitrr.ac.in/"));
        startActivity(browse3);
    }

    public void tap4(View view) {
        Intent browse4=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nitrr.ac.in/downloads/stu%20welfare/Sahyog-%20The%20Mentorship%20Club.pdf"));
        startActivity(browse4);

    }

    public void tap5(View view) {
        Intent browse5=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nitrr.ac.in/downloads/stu%20welfare/Nrityam%20NITRR%20website%20content.pdf"));
        startActivity(browse5);

    }



    public void tap6(View view) {
        Intent browse6=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nitrr.ac.in/downloads/stu%20welfare/Raaga-%20The%20Music%20Club.pdf"));
        startActivity(browse6);
    }

    public void tap7(View view) {
        Intent browse7=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nitrr.ac.in/downloads/stu%20welfare/SPORTS_ACTIVITY.pdf"));
        startActivity(browse7);
    }

    public void tap8(View view) {
        Intent browse8=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.nitrr.ac.in/downloads/stu%20welfare/Go%20green_03062019.pdf"));
        startActivity(browse8);
    }
}