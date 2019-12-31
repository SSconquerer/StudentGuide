package android.example.android.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void tap(View view) {
        Intent i= new Intent(this,events.class);
        startActivity(i);
    }

    public void tapped(View view) {
        Intent ii=new Intent(this,events2.class);
        startActivity(ii);

    }
    public void mapOnClick(View view){
        Intent i = new Intent(this,maps.class);
        startActivity(i);
    }
    public void downloadsOnClick(View view) {
        Intent i = new Intent(this,downloadsActivity.class);
        startActivity(i);
    }


    public void deptOnCLick(View view) {
        Intent i = new Intent(this,DepartmentListActivity.class);
        startActivity(i);
    }
    public void notesOnClick(View view){
        Intent i = new Intent(this,notesActivity.class);
        startActivity(i);
    }
    public void uploadOnClick(View view){
        Intent i = new Intent(this,uploadActivity.class);
        startActivity(i);
    }
}