package android.example.android.myapp;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.example.android.myapp.MainActivity;
import android.example.android.myapp.R;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class uploadActivity extends AppCompatActivity {
    Button logOut;
    Uri pdfuri;
    Button uploadFile;
    Button choosepdf,chooseaudio,choosevideo,chooseimage;
    TextView notification;
    FirebaseAuth mFirebaseAuth;
    FirebaseStorage Storage;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    private FirebaseAuth.AuthStateListener mAuthlistener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);
        logOut=(Button)findViewById(R.id.button6);
        choosepdf=(Button)findViewById(R.id.button2);
        chooseaudio=(Button)findViewById(R.id.button4);
        choosevideo=(Button)findViewById(R.id.button5);
        chooseimage=(Button)findViewById(R.id.button3);
        uploadFile=(Button)findViewById(R.id.button7);
        notification=(TextView)findViewById(R.id.textView5);
        Storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(uploadActivity.this, MainActivity.class));
            }
        });
        choosepdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(uploadActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectThePdf("application/pdf");
                }
                else{
                    ActivityCompat.requestPermissions(uploadActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},123);

                }

            }
        });
        chooseimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(uploadActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectThePdf("image/*");
                }
                else{
                    ActivityCompat.requestPermissions(uploadActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},124);

                }

            }
        });
        chooseaudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(uploadActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectThePdf("audio/*");
                }
                else{
                    ActivityCompat.requestPermissions(uploadActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},125);

                }

            }
        });
        choosevideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(uploadActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectThePdf("video/*");
                }
                else{
                    ActivityCompat.requestPermissions(uploadActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},126);

                }

            }
        });
        uploadFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pdfuri!=null) {
                    uploadFile(pdfuri);
                } else{
                    Toast.makeText(uploadActivity.this, "select file", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private void uploadFile(final Uri pdfuri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("uploading file....");
        progressDialog.show();
        final String Filename=System.currentTimeMillis()+"";
        //DatabaseReference databaseReference=database.getReference("uploads");
        final StorageReference storageReference=Storage.getReference();
        storageReference.child("upload").child(pdfuri.getPath()).putFile(pdfuri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {

            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                String url=taskSnapshot.getMetadata().getReference().getDownloadUrl().toString();


                DatabaseReference reference=database.getReference("upload");
                reference.child(Filename).setValue(pdfuri.getPath());
                progressDialog.dismiss();
                Toast.makeText(uploadActivity.this, "uploaded", Toast.LENGTH_SHORT).show();


            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(uploadActivity.this, "not uploaded", Toast.LENGTH_SHORT).show();

            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                int currentprogress=(int)(100.0*taskSnapshot.getBytesTransferred()/taskSnapshot.getTotalByteCount());
                progressDialog.setMessage("uploaded "+(int)currentprogress+"%");

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode==123 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectThePdf("application/pdf");

        }
        else if(requestCode==124 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectThePdf("image/*");

        }
        else if(requestCode==125 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            selectThePdf("audio/*");

        }
        else if(requestCode==126 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
            selectThePdf("video/*");

        }
        else{
            Toast.makeText(uploadActivity.this,"please provide permission",Toast.LENGTH_SHORT).show();
        }
    }

    private void selectThePdf(String s) {
        Intent intent=new Intent();
        intent.setType(s);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,96);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode==96 && resultCode==RESULT_OK && data!=null){
            pdfuri=data.getData();
            notification.setText(pdfuri.getPath());


        }
        else{
            Toast.makeText(uploadActivity.this,"select a file",Toast.LENGTH_SHORT).show();
        }
    }



}
