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

public class Health_care extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthcare);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.healthcare);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.healthcare:
                        return true;

                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),Main.class));
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
                    Health_care.this);

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
                    "Nutritional",
                    ChildItemList());
            itemList.add(item);
            ParentItem item1
                    = new ParentItem(
                    "Water and Sanitation",
                    ChildItemList());
            itemList.add(item1);
            ParentItem item2
                    = new ParentItem(
                    "Preventative",
                    ChildItemList());
            itemList.add(item2);
            ParentItem item3
                    = new ParentItem(
                    "Laboratory and diagnostic",
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

            ChildItemList.add(new ChildItem("Dettol Liquid","99", R.drawable.product1));
            ChildItemList.add(new ChildItem("Dabur Chyawanprakash ", "581.25", R.drawable.product2));
            ChildItemList.add(new ChildItem("Horlicks Health", "118", R.drawable.product3));
            ChildItemList.add(new ChildItem("Indulekha", "215.28", R.drawable.product4));

            return ChildItemList;
        }
}