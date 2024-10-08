package com.example.e_commerce_app.ui.onboarding.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.e_commerce_app.R;
import com.example.e_commerce_app.data.models.OnBoardingData;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.MyViewHolder> {

    private List<OnBoardingData> onBoardingData;
    private Context context;

    public OnBoardingAdapter(List<OnBoardingData> onBoardingData, Context context) {
        this.onBoardingData = onBoardingData;
        this.context = context;
    }

    @NonNull
    @Override
    public OnBoardingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        MyViewHolder viewHolder= new MyViewHolder(inflater.inflate(R.layout.onboarding,parent,false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingAdapter.MyViewHolder holder, int position) {
        OnBoardingData boardingData = onBoardingData.get(position);
        holder.onBoardingIV.setImageResource(boardingData.getImage());
        holder.titleTV.setText(boardingData.getTitle());
        holder.contentTV.setText(boardingData.getContent());

    }

    @Override
    public int getItemCount() {
        return onBoardingData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV;
        TextView contentTV;
        ImageView onBoardingIV;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            contentTV = itemView.findViewById(R.id.contentTV);
            onBoardingIV = itemView.findViewById(R.id.onBoardingIV);
        }
    }
}
