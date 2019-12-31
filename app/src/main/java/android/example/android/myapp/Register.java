package android.example.android.myapp;


import android.content.Intent;
import android.os.PersistableBundle;
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
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class Register extends AppCompatActivity {
    private EditText email, password;
    private Button sign_up;
    TextView signin;
    private FirebaseAuth mfirebase;
    private DatabaseReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText email = (EditText) findViewById(R.id.editText_username);
        final EditText password = (EditText) findViewById(R.id.editText_password);
        TextView signin = (TextView) findViewById(R.id.textView_login);
        Button sign_up = (Button) findViewById(R.id.button_register);
        mfirebase = FirebaseAuth.getInstance();
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Pass = password.getText().toString();
                if (Email.isEmpty()) {
                    email.setError("Please enter email");
                } else if (Pass.isEmpty()) {
                    password.setError("Please enter password");
                } else if (Email.isEmpty() && Pass.isEmpty()) {
                    Toast.makeText(Register.this, "Fields are empty", Toast.LENGTH_SHORT).show();
                } else if (!(Email.isEmpty() && Pass.isEmpty())) {
                    mfirebase.createUserWithEmailAndPassword(Email, Pass).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Register.this, "sign up unsuccessful", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(Register.this, "SignUp Successful", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
                } else {
                    Toast.makeText(Register.this, "Error Occured", Toast.LENGTH_SHORT).show();
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });

    }


}