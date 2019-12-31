package android.example.android.myapp;


import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText email,password;
    private Button login;
    TextView register;
    private FirebaseAuth mfirebase;
    private FirebaseAuth.AuthStateListener mauthlistener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText email = (EditText) findViewById(R.id.editText_username1);
        final EditText password = (EditText) findViewById(R.id.editText_password1);
        TextView register = (TextView) findViewById(R.id.textView_register);
        Button login = (Button) findViewById(R.id.button_Login);
        mfirebase = FirebaseAuth.getInstance();
        mauthlistener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mfirebaseuser = mfirebase.getCurrentUser();
                if (mfirebaseuser != null) {
                    //Toast.makeText(loginActivity.this, "successfully sign up", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "sign up", Toast.LENGTH_SHORT).show();
                }

            }
        };
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Pass = password.getText().toString();
                if (Email.isEmpty()) {
                    email.setError("Please enter email");
                } else if (Pass.isEmpty()) {
                    password.setError("Please enter password");
                } else if (Email.isEmpty() && Pass.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(Email.isEmpty() && Pass.isEmpty())) {
                    mfirebase.signInWithEmailAndPassword(Email, Pass).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(MainActivity.this, "Error Occured", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(MainActivity.this,Welcome.class));
                                Toast.makeText(MainActivity.this, "Successfully Logged In", Toast.LENGTH_SHORT).show();

                            }

                        }
                    });
                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }

    @Override
    protected  void onStart(){
        super.onStart();
        mfirebase.addAuthStateListener(mauthlistener);
    }
}

