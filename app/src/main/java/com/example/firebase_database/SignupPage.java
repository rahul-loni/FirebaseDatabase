package com.example.firebase_database;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupPage extends AppCompatActivity {
    EditText txt_email,txt_password,txt_cPassword;
    Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup_page);

        txt_email=findViewById(R.id.txt1);
        txt_password=findViewById(R.id.txt2);
        txt_cPassword=findViewById(R.id.txt3);
        btn_signup=findViewById(R.id.btnSignup);

       btn_signup.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String email=txt_email.getText().toString().trim();
               String password=txt_password.getText().toString().trim();
               String ConfirmPassword=txt_cPassword.getText().toString().trim();
           }
       });

    }
}