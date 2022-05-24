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

class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.Viewholder> {

    private Context context;
    private ArrayList<DoctorModel> doctorModelArrayList;

    // Constructor
    public DoctorAdapter(Context context, ArrayList<DoctorModel> doctorModelArrayList) {
        this.context = context;
        this.doctorModelArrayList = doctorModelArrayList;
    }

    @NonNull
    @Override
    public DoctorAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // to inflate the layout for each item of recycler view.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DoctorAdapter.Viewholder holder, int position) {
        // to set data to textview and imageview of each card layout
        DoctorModel model = doctorModelArrayList.get(position);
        holder.doctorNameTV.setText(model.getDoctor_name());
        holder.doctorDestTV.setText(model.getDoctor_dest());
        holder.doctorRatingTV.setText("⭐ " + model.getDoctor_rating());
        holder.doctorIV.setImageResource(model.getDoctor_image());
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
        private ImageView doctorIV;
        private TextView doctorNameTV, doctorRatingTV, doctorDestTV;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            doctorIV = itemView.findViewById(R.id.idDoctorImage);
            doctorNameTV = itemView.findViewById(R.id.idDoctorName);
            doctorDestTV = itemView.findViewById(R.id.idDoctorDest);
            doctorRatingTV = itemView.findViewById(R.id.idMedicinePrice);
        }
    }
}
