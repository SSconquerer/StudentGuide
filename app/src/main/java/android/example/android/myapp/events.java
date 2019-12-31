package android.example.android.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;

import android.view.View;

public class events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        getSupportActionBar().setTitle("CLUBS AND COMMITTEES");

    }

    public void tapp1(View view) {


        Intent i1= new Intent(this,ecell.class);
        startActivity(i1);
    }

    public void tapp2(View view) {
        Intent i2=new Intent(this,cc.class);
        startActivity(i2);
    }

    public void tap3(View view) {
        Intent i3=new Intent(this,tech.class);
        startActivity(i3);
    }

    public void tap4(View view) {
        Intent i4=new Intent(this,sahyog.class);
        startActivity(i4);
    }

    public void tap5(View view) {
        Intent i5=new Intent(this,nrityam.class);
        startActivity(i5);
    }

    public void tap6(View view) {
        Intent i6=new Intent(this,raga.class);
        startActivity(i6);
    }

    public void tap7(View view) {
        Intent i7=new Intent(this,shaurya.class);
        startActivity(i7);
    }

    public void tap8(View view) {
        Intent i8=new Intent(this,gogreen.class);
        startActivity(i8);
    }
}
