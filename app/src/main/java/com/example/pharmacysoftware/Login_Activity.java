package com.example.pharmacysoftware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login_Activity extends AppCompatActivity implements View.OnClickListener {
    TextView textView_forgot_password, textView_sign_up;
    Button log_in;
    ProgressBar progressBar_login;
    EditText TextEmail, TextPassword;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textView_forgot_password = (TextView) findViewById(R.id.login_forgot_password);
        textView_forgot_password.setOnClickListener(this);

        textView_sign_up = (TextView) findViewById(R.id.login_sign_up);
        textView_sign_up.setOnClickListener(this);

        log_in= (Button) findViewById(R.id.Forgot_button);
        log_in.setOnClickListener(this);

        progressBar_login=(ProgressBar) findViewById(R.id.progressBar_Login);
        TextEmail=(EditText) findViewById(R.id.Forgot_Email);
        TextPassword=(EditText) findViewById(R.id.login_password);

        mAuth = FirebaseAuth.getInstance();

    }
        @SuppressLint("NonConstantResourceId")
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case  R.id.login_forgot_password:
                    startActivity(new Intent(this, Forgot_Password.class));
                    break;
                case R.id.login_sign_up:
                    startActivity(new Intent( this, Signup_Activity.class));
                    break;
                case R.id.Forgot_button:
                    loginUser();
                    break;
            }
        }

    private void loginUser() {
        String email=TextEmail.getText().toString().trim();
        String password=TextPassword.getText().toString().trim();

        if (email.isEmpty()) {
            TextEmail.setError("Email Address is required!");
            TextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            TextEmail.setError("please provide Email!");
            TextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            TextPassword.setError("password is required!");
            TextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            TextPassword.setError("Min password length would be 6 character!");
            TextPassword.requestFocus();
            return;
        }


            View progressBar = (ProgressBar) findViewById(R.id.progressBar_Login);
            progressBar.setVisibility(View.VISIBLE);

            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                   if(task.isSuccessful()) {
                       Toast.makeText(Login_Activity.this, "Login Successfully!", Toast.LENGTH_SHORT).show();
                       progressBar.setVisibility(View.GONE);
                       startActivity(new Intent(Login_Activity.this, Main.class ));
                   }
                   else {
                       Toast.makeText(Login_Activity.this, "Login Failure!", Toast.LENGTH_SHORT).show();
                       progressBar.setVisibility(View.GONE);
                   }
                }
            });

    }
}
