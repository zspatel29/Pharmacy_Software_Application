package com.example.pharmacysoftware;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {
    RelativeLayout logout;
    TextView home;

    //    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        logout = (RelativeLayout) findViewById(R.id.btn_logout);
        logout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(Profile.this, Login_Activity.class));
        });

        home = (TextView) findViewById(R.id.back_home);
        home.setOnClickListener(view ->{
            startActivity(new Intent(Profile.this,Main.class));
        });

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("User");
        String userID = user.getUid();

        final TextView NameTextView = (TextView) findViewById(R.id.user_name);
        final TextView emailTextView = (TextView) findViewById(R.id.user_email);
        final TextView phoneTextView = (TextView) findViewById(R.id.user_phone);
        final TextView MNameTextView = (TextView) findViewById(R.id.user_main_name);
        final TextView MemailTextView = (TextView) findViewById(R.id.user_main_email);

        reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);

                if (userProfile != null){
                    String Name = userProfile.fullName;
                    String email = userProfile.email;
                    String phone = userProfile.number;
//                    String MName = userProfile.fullName;
//                    String Memail = userProfile.email;

                    NameTextView.setText(Name);
                    emailTextView.setText(email);
                    phoneTextView.setText(phone);
                    MNameTextView.setText(Name);
                    MemailTextView.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Profile.this, "Something wrong happend !",Toast.LENGTH_LONG);
            }
        });

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.profile);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.profile:
                        return true;

                    case R.id.healthcare:
                        startActivity(new Intent(getApplicationContext(), Health_care.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.prescription:
                        startActivity(new Intent(getApplicationContext(),Prescription.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(),Cart.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Main.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

//    private void setSupportActionBar(Toolbar toolbar) {
//    }


}