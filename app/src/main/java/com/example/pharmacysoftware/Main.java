package com.example.pharmacysoftware;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.home:
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

                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(),Profile.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        int url1 = R.drawable.slider_5;
        int url2 = R.drawable.slider_2;
        int url3 = R.drawable.slider_3;
        int url4 = R.drawable.slider_4;
        int url5 = R.drawable.slider_6;

        // we are creating array list for storing our image urls.
        ArrayList<SliderDataNew> sliderDataArrayList = new ArrayList<>();

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        sliderDataArrayList.add(new SliderDataNew(url1));
        sliderDataArrayList.add(new SliderDataNew(url2));
        sliderDataArrayList.add(new SliderDataNew(url3));
        sliderDataArrayList.add(new SliderDataNew(url4));
        sliderDataArrayList.add(new SliderDataNew(url5));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();


            RecyclerView
                    ParentRecyclerViewItem
                    = findViewById(
                    R.id.parent_recyclerview);

            // Initialise the Linear layout manager
            LinearLayoutManager
                    layoutManager
                    = new LinearLayoutManager(
                    Main.this);

            // Pass the arguments
            // to the parentItemAdapter.
            // These arguments are passed
            // using a method ParentItemList()
            ParentItemAdapter
                    parentItemAdapter
                    = new ParentItemAdapter(
                    ParentItemList());

            // Set the layout manager
            // and adapter for items
            // of the parent recyclerview
            ParentRecyclerViewItem
                    .setAdapter(parentItemAdapter);
            ParentRecyclerViewItem
                    .setLayoutManager(layoutManager);
        }

        private List<ParentItem> ParentItemList()
        {
            List<ParentItem> itemList
                    = new ArrayList<>();

            ParentItem item
                    = new ParentItem(
                    "Medicine",
                    ChildItemList());
            itemList.add(item);
            ParentItem item1
                    = new ParentItem(
                    "Ayurveda",
                    ChildItemList());
            itemList.add(item1);
            ParentItem item2
                    = new ParentItem(
                    "Vitamins",
                    ChildItemList());
            itemList.add(item2);
            ParentItem item3
                    = new ParentItem(
                    "Pain Relief",
                    ChildItemList());
            itemList.add(item3);

            return itemList;
        }

        // Method to pass the arguments
        // for the elements
        // of child RecyclerView
        private List<ChildItem> ChildItemList()
        {
            List<ChildItem> ChildItemList
                    = new ArrayList<>();

            ChildItemList.add(new ChildItem("Multivitamin Supreme","835.8", R.drawable.medicine1));
            ChildItemList.add(new ChildItem("Turmeric Curcumin", "245", R.drawable.medicine2));
            ChildItemList.add(new ChildItem("Vitamin B Complex", "348", R.drawable.medicine3));
            ChildItemList.add(new ChildItem("Pain Relief Oil", "148", R.drawable.medicine4));

            return ChildItemList;
        }

}

