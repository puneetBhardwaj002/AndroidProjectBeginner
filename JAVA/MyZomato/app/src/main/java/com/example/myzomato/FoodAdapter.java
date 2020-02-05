package com.example.myzomato;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {

    final ArrayList<Food> foodList;
    LayoutInflater inflater;
    Context context;

    public FoodAdapter(Context context, ArrayList<Food> foodList) {
        inflater = LayoutInflater.from(context);
        this.foodList = foodList;
        this.context = context;
    }


    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.menu_single_item, parent, false);
        return new FoodViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(FoodAdapter.FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.nameText.setText(food.getName());
        holder.priceText.setText(food.getPrice());
        holder.categoryText.setText(food.getCategory());

        Picasso.with(context).load(foodList.get(position).getImageResource()).resize(100,100).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        public final ImageView imageView;
        public final TextView nameText;
        public final TextView priceText;
        public final TextView categoryText;
        final FoodAdapter mAdapter;

        public FoodViewHolder(View itemView, FoodAdapter adapter) {
            super(itemView);
            imageView = itemView.findViewById(R.id.food_image);
            nameText = itemView.findViewById(R.id.food_name);
            priceText = itemView.findViewById(R.id.food_price);
            categoryText = itemView.findViewById(R.id.food_category);
            this.mAdapter = adapter;
        }
    }


}
