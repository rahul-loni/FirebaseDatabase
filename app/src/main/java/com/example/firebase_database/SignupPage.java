package com.example.firebase_database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupPage extends AppCompatActivity {
    EditText txt_email,txt_password,txt_cPassword;
    Button btn_signup;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);

        firebaseAuth=FirebaseAuth.getInstance();

        txt_email=findViewById(R.id.txt1);
        txt_password=findViewById(R.id.txt2);
        txt_cPassword=findViewById(R.id.txt3);
        btn_signup=findViewById(R.id.btnSignup);

       btn_signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //get text from layout
               String email=txt_email.getText().toString().trim();
               String password=txt_password.getText().toString().trim();
               String ConfirmPassword=txt_cPassword.getText().toString().trim();

               //form validation

               if (email.isEmpty()){
                   Toast.makeText(SignupPage.this, "Enter Email first ", Toast.LENGTH_SHORT).show();
               }
               if (password.isEmpty()){
                   Toast.makeText(SignupPage.this, "Enter Password first ", Toast.LENGTH_SHORT).show();
               }
               if(password.length()<6){
                   Toast.makeText(SignupPage.this, "password too short", Toast.LENGTH_SHORT).show();
               }
               if (password.equals(ConfirmPassword)){
                   firebaseAuth.createUserWithEmailAndPassword(email,password)
                           .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful()){
                                       Toast.makeText(SignupPage.this, "Signup Is Compplete", Toast.LENGTH_SHORT).show();
                                       Intent intent=new Intent(getApplicationContext(),
                                               MainActivity.class);
                                       startActivity(intent);

                                   }else {
                                       Toast.makeText(SignupPage.this, "Not Complete", Toast.LENGTH_SHORT).show();
                                   }
                               }
                           });
               }

           }
       });

    }
}