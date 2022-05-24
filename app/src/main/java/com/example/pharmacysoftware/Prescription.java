package com.example.pharmacysoftware;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Prescription extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prescription);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.prescription);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.prescription:
                        return true;

                    case R.id.healthcare:
                        startActivity(new Intent(getApplicationContext(), Health_care.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Main.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.cart:
                        startActivity(new Intent(getApplicationContext(),Cart.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        RecyclerView doctorRV;

        // Arraylist for storing data
        ArrayList<DoctorModel> doctorModelArrayList;

            doctorRV = findViewById(R.id.idRVCourse);

            // here we have created new array list and added data to it.
            doctorModelArrayList = new ArrayList<>();
            doctorModelArrayList.add(new DoctorModel("Kim Lee", "MBBS,  General Medicine ",5, R.drawable.doctor1));
            doctorModelArrayList.add(new DoctorModel("Peter Griffin", "General Physician,Medicine",5, R.drawable.doctor2));
            doctorModelArrayList.add(new DoctorModel("Stewie K.", "medicime,Gastroenterology",4, R.drawable.doctor3));
            doctorModelArrayList.add(new DoctorModel("Ben Williams","ENT Specialist,H&N Surgeon" ,4, R.drawable.doctor4));
            doctorModelArrayList.add(new DoctorModel("Kevin Thomas", "BHMS, MD",3, R.drawable.doctor5));
            doctorModelArrayList.add(new DoctorModel("John Deo", "Neurology, BDS",3, R.drawable.doctor6));


            // we are initializing our adapter class and passing our arraylist to it.
            DoctorAdapter doctorAdapter = new DoctorAdapter(this, doctorModelArrayList);

            // below line is for setting a layout manager for our recycler view.
            // here we are creating vertical list so we will provide orientation as vertical
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

            // in below two lines we are setting layoutmanager and adapter to our recycler view.
            doctorRV.setLayoutManager(linearLayoutManager);
            doctorRV.setAdapter(doctorAdapter);
    }
}
