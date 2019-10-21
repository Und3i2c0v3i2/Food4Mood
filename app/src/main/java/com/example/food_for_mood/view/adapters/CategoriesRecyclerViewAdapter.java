package com.example.food_for_mood.view.adapters;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Category;

import java.util.List;

public class CategoriesRecyclerViewAdapter
        extends RecyclerView.Adapter<CategoriesRecyclerViewAdapter.CategoriesViewHolder> {


    private OnClickCategoryListener listener;
    private List<Category> categories;


    public CategoriesRecyclerViewAdapter(OnClickCategoryListener listener) {
        this.listener = listener;

    }

    @NonNull
    @Override
    public CategoriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_recycler_view_holder, parent, false);

        return new CategoriesViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final CategoriesViewHolder holder, final int position) {

        Category category = categories.get(position);

        holder.txtCategory.setText(category.getType());

        Resources res = holder.imgCategory.getResources();
        int identifier = res.getIdentifier(category.getImgFileName(), "drawable", holder.imgCategory.getContext().getPackageName());
        Drawable drawable = res.getDrawable(identifier);

        holder.imgCategory.setImageDrawable(drawable);

    }


    @Override
    public int getItemCount() {
        if (categories != null)
            return categories.size();

        return 0;
    }

    public Category getDishAt(int position) {
        return categories.get(position);
    }




    public class CategoriesViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgCategory;
        private TextView txtCategory;


        public CategoriesViewHolder(@NonNull View itemView) {
            super(itemView);


            imgCategory = itemView.findViewById(R.id.category_recycler_view_holder_img);
            txtCategory = itemView.findViewById(R.id.category_recycler_view_holder_txt);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClick(categories.get(position));
                    }
                }
            });

        }


    }

    /*
    set list of categories in onChanged() in anonymous Observer in CategoriesFragment
     */
    public void setCategoriesForAdapter(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }



}
