package com.example.pharmacysoftware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class Forgot_Password<view> extends AppCompatActivity {

    private EditText emailEditText;
    private Button resetpasswordbtn;
    private ProgressBar forgotProgressbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot__password);

        emailEditText=(EditText) findViewById(R.id.Forgot_Email);
        resetpasswordbtn=(Button) findViewById(R.id.Forgot_button);
        forgotProgressbar=(ProgressBar) findViewById(R.id.progressBar_Forgot);

        mAuth = FirebaseAuth.getInstance();

        resetpasswordbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetPassword();
            }
        });
    }

    private void resetPassword() {
        String email=emailEditText.getText().toString().trim();

        if (email.isEmpty()) {
            emailEditText.setError("Email Address is required!");
            emailEditText.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEditText.setError("please provide valid Email!");
            emailEditText.requestFocus();
            return;
        }

        View fforgotProgressbar = (ProgressBar) findViewById(R.id.progressBar_Login);
        forgotProgressbar.setVisibility(View.VISIBLE);

        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Forgot_Password.this, "Check your email to reset your password", Toast.LENGTH_SHORT).show();
                    forgotProgressbar.setVisibility(View.GONE);
                    startActivity(new Intent(Forgot_Password.this, Login_Activity.class));
                }
                else {
                    Toast.makeText(Forgot_Password.this, "Try again! something went wrong happend!", Toast.LENGTH_SHORT).show();
                    forgotProgressbar.setVisibility(View.GONE);
                }
            }
        });
    }
}