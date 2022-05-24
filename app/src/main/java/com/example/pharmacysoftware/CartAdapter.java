package com.example.pharmacysoftware;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

class CartAdapter extends RecyclerView.Adapter<CartAdapter.Viewholder> {

    private Context context;
    private ArrayList<DoctorModel> doctorModelArrayList;

    // Constructor
    public CartAdapter(Context context, ArrayList<DoctorModel> doctorModelArrayList) {
        this.context = context;
        this.doctorModelArrayList = doctorModelArrayList;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_layout, parent, false);
        return new Viewholder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull CartAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        DoctorModel model = doctorModelArrayList.get(position);
        holder.MedicineName.setText(model.getDoctor_name());
        holder.Medicinetype.setText(model.getDoctor_dest());
        holder.MedicinePrice.setText("₹ " + model.getDoctor_rating());
        holder.MedicineImage.setImageResource(model.getDoctor_image());
    }

    @Override
    public int getItemCount() {
        // this method is used for showing number
        // of card items in recycler view.
        return doctorModelArrayList.size();
    }

    // View holder class for initializing of
    // your views such as TextView and Imageview.
    public class Viewholder extends RecyclerView.ViewHolder {
        private ImageView MedicineImage;
        private TextView MedicineName, MedicinePrice, Medicinetype;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            MedicineImage = itemView.findViewById(R.id.idMedicineImage);
            MedicineName = itemView.findViewById(R.id.idMedicineName);
            Medicinetype = itemView.findViewById(R.id.idItemType);
            MedicinePrice = itemView.findViewById(R.id.idMedicinePrice);
        }
    }
}

