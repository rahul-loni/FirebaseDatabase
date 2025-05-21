package com.example.firebase_database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity {

    EditText txt_email,txt_password;
    Button btn_login;
    TextView txt_signup,txt_fp;


    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);

        mAuth=FirebaseAuth.getInstance();

        txt_email=findViewById(R.id.txt1);
        txt_password=findViewById(R.id.txt2);
        btn_login=findViewById(R.id.btnLogin);
        txt_signup=findViewById(R.id.signup_txt);
        txt_fp=findViewById(R.id.forgot_txt);

        //Login Button Click Function
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email=txt_email.getText().toString().trim();
                String Password=txt_password.getText().toString().trim();

                if (Email.isEmpty()){
                    Toast.makeText(LoginPage.this,
                            "Please Enter Email First", Toast.LENGTH_SHORT).show();
                }
                if (Password.isEmpty()){
                    Toast.makeText(LoginPage.this,
                            "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                mAuth.signInWithEmailAndPassword(Email,Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(LoginPage.this, "Login Failed ", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });

            }
        });

    }
}