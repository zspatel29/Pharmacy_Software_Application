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

public class Cart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.cart);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.cart:
                        return true;

                    case R.id.healthcare:
                        startActivity(new Intent(getApplicationContext(), Health_care.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.prescription:
                        startActivity(new Intent(getApplicationContext(),Prescription.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Main.class));
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

        RecyclerView cartRV;

        // Arraylist for storing data
        ArrayList<DoctorModel> doctorModelArrayList;

        cartRV = findViewById(R.id.idCartView);

        // here we have created new array list and added data to it.
        doctorModelArrayList = new ArrayList<>();
        doctorModelArrayList.add(new DoctorModel("Dettol Liquid Disinfectant", "Health-care",88, R.drawable.product1));
        doctorModelArrayList.add(new DoctorModel("Multivitamin Supreme", "Medicine",835, R.drawable.medicine1));
        doctorModelArrayList.add(new DoctorModel("Turmeric Curcumin 95% ", "Medicine",245, R.drawable.medicine2));
        doctorModelArrayList.add(new DoctorModel("Dabur Chyawanprakash ","Health-care" ,581, R.drawable.product2));
        doctorModelArrayList.add(new DoctorModel("Brain Formula with Vitamin B ", "Medicine",348, R.drawable.medicine3));
        doctorModelArrayList.add(new DoctorModel("Horlicks Health", "Health-care",118, R.drawable.product3));
        //doctorModelArrayList.add(new DoctorModel("HTML and CSS", "html, css",4, R.drawable.dummy));

        // we are initializing our adapter class and passing our arraylist to it.
        CartAdapter cartAdapter = new CartAdapter(this, doctorModelArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        cartRV.setLayoutManager(linearLayoutManager);
        cartRV.setAdapter(cartAdapter);
    }
}