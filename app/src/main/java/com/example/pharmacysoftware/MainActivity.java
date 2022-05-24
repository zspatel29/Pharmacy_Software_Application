package com.example.pharmacysoftware;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                if (mAuth.getCurrentUser() != null){
                    startActivity(new Intent(MainActivity.this, Main.class));
                }
                else{
                    startActivity(new Intent(MainActivity.this, Login_Activity.class));
                }
            }
        },5000);

    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        new Timer().schedule(new TimerTask() {
            public void run() {
                if (currentUser != null) {
                    currentUser.reload();
                    startActivity(new Intent(MainActivity.this, Main.class));
                } else {
                    startActivity(new Intent(MainActivity.this, Login_Activity.class));
                }
            }
        },5000);
    }
}