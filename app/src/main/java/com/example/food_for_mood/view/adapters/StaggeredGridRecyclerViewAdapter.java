package com.example.food_for_mood.view.adapters;


import android.content.res.AssetManager;
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
import com.example.food_for_mood.service.model.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StaggeredGridRecyclerViewAdapter
        extends RecyclerView.Adapter<StaggeredGridRecyclerViewAdapter.GridViewHolder> {


    private OnClickRecipeListener listener;
    private List<Recipe> recipesByCategory;

    private Recipe recipe;

    public StaggeredGridRecyclerViewAdapter(OnClickRecipeListener listener) {
        this.listener = listener;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.staggered_grid_holder, parent, false);

        return new GridViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {

        //TODO how to get context from no-lifecycle class???
//        InputStream inputStream = null;
//        AssetManager asset = holder.img.getContext();

        Resources res = holder.img.getResources();
        String name = recipesByCategory.get(position).getImgFile();
        int identifier = res.getIdentifier(name.substring(0, name.length()-4), "drawable", holder.img.getContext().getPackageName());
        Drawable drawable = res.getDrawable(identifier);
//        try {
////            inputStream = asset.open(recipesByCategory.get(position).getImgFile());
////            Drawable drawable = Drawable.createFromStream(inputStream, recipesByCategory.get(position).getImgFile());
//            Drawable drawable =
//            holder.img.setImageDrawable(drawable);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        holder.img.setImageDrawable(drawable);
        holder.txtName.setText(recipesByCategory.get(position).getName());
        List<String> ingredientsArray = recipesByCategory.get(position).getIngredients();
        StringBuilder ingredients = new StringBuilder();
        for(String s : ingredientsArray) {
            if(!s.startsWith("\n"))
                ingredients.append("* ");

            ingredients.append(s + "\n");
        }
        holder.txtDescription.setText(ingredients.toString());

    }

    @Override
    public int getItemCount() {
        if(recipesByCategory != null) {
            return recipesByCategory.size();
        }

        return 0;
    }

    public void setRecipesByCategory(List<Recipe> recipes) {
        this.recipesByCategory = recipes;
        notifyDataSetChanged();
    }



    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
        notifyDataSetChanged();
    }



    public class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView txtName;
        private TextView txtDescription;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.staggered_grid_holder_img);
            txtName = itemView.findViewById(R.id.staggered_grid_holder_txt_title);
            txtDescription = itemView.findViewById(R.id.staggered_grid_holder_txt_description);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClick(recipesByCategory.get(position));
                    }
                }
            });

        }
    }
}
