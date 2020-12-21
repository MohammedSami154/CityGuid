package com.example.cityguide.HelperClasses;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cityguide.R;

import java.util.List;

public class OnBoardingAdapter extends RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>{

    List<OnBoardingItems> onBoardingItemsList;

    public OnBoardingAdapter(List<OnBoardingItems> onBoardingItems) {
        this.onBoardingItemsList = onBoardingItems;
    }

    @NonNull
    @Override
    public OnBoardingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OnBoardingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.slides_layout , parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull OnBoardingViewHolder holder, int position) {
        holder.onBoardingItem(onBoardingItemsList.get(position));

    }

    @Override
    public int getItemCount() {
        return onBoardingItemsList.size();
    }

    class OnBoardingViewHolder extends RecyclerView.ViewHolder{
        private TextView textTitle;
        private TextView textDesc;
        private ImageView imageSlider;

         public OnBoardingViewHolder(@NonNull View itemView) {
             super(itemView);
             textTitle = itemView.findViewById(R.id.slider_title);
             textDesc = itemView.findViewById(R.id.slider_docs);
             imageSlider = itemView.findViewById(R.id.slider_img);
         }

         void onBoardingItem(OnBoardingItems onBoardingItems){
             textTitle.setText(onBoardingItems.title);
             textDesc.setText(onBoardingItems.docs);
             imageSlider.setImageResource(onBoardingItems.images);
         }
     }

}
