package com.example.pharmacysoftware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.icu.text.UCharacterIterator;
import android.os.Build;
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
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class Signup_Activity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        TextView textView;
        ProgressBar progressBar;
        EditText editTextFullName, editTextEmail, editTextNumber, editTextPassword, editTextConformPassword;
        Button button;

        mAuth = FirebaseAuth.getInstance();

        textView=(TextView)findViewById(R.id.register_login_link);
        textView.setOnClickListener(this);
        editTextFullName = (EditText) findViewById(R.id.register_full_name);
        editTextEmail = (EditText) findViewById(R.id.register_Email_Address);
        editTextNumber = (EditText) findViewById(R.id.register_phone_number);
        editTextPassword = (EditText) findViewById(R.id.register_password);
        editTextConformPassword = (EditText) findViewById(R.id.register_conform_password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar_register);
        button = (Button) findViewById(R.id.register_button);
        button.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_login_link:
                startActivity(new Intent(this, Login_Activity.class));
                break;
            case R.id.register_button:
                registerUser();
                //startActivity(new Intent(this , Home.class ));
                break;
        }

    }

    private void registerUser() {

        TextView editTextFullName = (EditText) findViewById(R.id.register_full_name);;
        String fullName=editTextFullName.getText().toString().trim();
        TextView editTextEmail = (EditText) findViewById(R.id.register_Email_Address);
        String email=editTextEmail.getText().toString().trim();
        TextView editTextNumber = (EditText) findViewById(R.id.register_phone_number);
        String number=editTextNumber.getText().toString().trim();
        TextView editTextPassword = (EditText) findViewById(R.id.register_password);
        String password=editTextPassword.getText().toString().trim();
        TextView editTextConformPassword = (EditText) findViewById(R.id.register_conform_password);
        String conformPassword=editTextConformPassword.getText().toString().trim();

        if(fullName.isEmpty()){
            editTextFullName.setError("Full Name is required!");
            editTextFullName.requestFocus();
            return;
        }

        if (email.isEmpty()) {
            editTextEmail.setError("Email Address is required!");
            editTextEmail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editTextEmail.setError("please provide Email!");
            editTextEmail.requestFocus();
            return;
        }

        if(password.isEmpty()) {
            editTextPassword.setError("password is required!");
            editTextPassword.requestFocus();
            return;
        }

        if (password.length() < 6) {
            editTextPassword.setError("Min password length would be 6 character!");
            editTextPassword.requestFocus();
            return;
        }

        if (conformPassword.isEmpty()) {
            editTextConformPassword.setError("Conform password is required!");
            editTextConformPassword.requestFocus();
            return;
        }
        boolean check_password=conformPassword.equals(password);
        if(!check_password){
            editTextConformPassword.setError("Conform password should be same as password!");
            editTextConformPassword.requestFocus();
            return;
        }

        if(number.isEmpty()) {
            editTextNumber.setError("Phone Number is required!");
            editTextNumber.requestFocus();
            return;
        }

        if(number.length()<10 | number.length()>10) {
            editTextNumber.setError("Enter only 10 digit number!");
            editTextNumber.requestFocus();
            return;
        }

        View progressBar = (ProgressBar) findViewById(R.id.progressBar_register);
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if(task.isSuccessful()){
                    User user = new User(fullName, email, number, password, conformPassword);

                    FirebaseDatabase.getInstance().getReference("User").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {

                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()) {
                                Toast.makeText(Signup_Activity.this, "Registerd successfully", Toast.LENGTH_LONG).show();;
                                progressBar.setVisibility(View.GONE);
                                startActivity(new Intent(Signup_Activity.this, Login_Activity.class));
                            }
                            else{
                                Toast.makeText(Signup_Activity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();
                                progressBar.setVisibility(View.GONE);
                            }
                        }
                    });

                }else{
                    Toast.makeText(Signup_Activity.this, "Failed to register! Try again!", Toast.LENGTH_LONG).show();;
                    progressBar.setVisibility(View.GONE);
                }
            }
        });

    }
}
