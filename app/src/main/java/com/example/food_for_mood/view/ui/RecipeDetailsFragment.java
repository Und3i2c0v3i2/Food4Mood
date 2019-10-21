package com.example.food_for_mood.view.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;


import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Recipe;
import com.example.food_for_mood.viewmodel.FoodForMoodViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.IOException;
import java.io.InputStream;


public class RecipeDetailsFragment extends Fragment {


    private Toolbar menu;
    private ImageView recipeImg;
    private RatingBar ratingBar;
    private TextView recipeName,
            recipeDescription,
            recipePreparation,
            recipeKcal,
            recipeCategory,
            ingredientsList;

    private FloatingActionButton btnFav;

    private FoodForMoodViewModel recipeViewModel;

    public static final String RECIPE_ID = "com.example.termin14zadaci.recipe_id";


    long recipeId;
    Recipe recipe;

    public RecipeDetailsFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recipe_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fieldsInitialization(view);


        recipeViewModel = ViewModelProviders.of(this)
                .get(FoodForMoodViewModel.class);


        recipeViewModel.findById(recipeId).observe(this, new Observer<Recipe>() {
            @Override
            public void onChanged(Recipe recipe) {
                if (recipe != null) {
                    RecipeDetailsFragment.this.recipe = recipe;
                    displayRecipeInfo();
                }
            }
        });

    }


//    private void setRecipe(Recipe recipe) {
//        this.recipe = recipe;
//
//    }


    private void fieldsInitialization(View view) {

        recipeImg = view.findViewById(R.id.recipe_img);
        ratingBar = view.findViewById(R.id.rating_bar);
        recipeName = view.findViewById(R.id.recipe_name);
        recipeDescription = view.findViewById(R.id.recipe_description);
        recipePreparation = view.findViewById(R.id.recipe_preparation);
        recipeKcal = view.findViewById(R.id.recipe_kcal);
        recipeCategory = view.findViewById(R.id.recipe_category);
        ingredientsList = view.findViewById(R.id.ingredients_list);
        btnFav = view.findViewById(R.id.btn_fav);
    }


    private void displayRecipeInfo() {

        ratingBar.setRating(recipe.getRating());
        recipeName.setText(recipe.getName());
        recipeKcal.setText(getResources().getString(R.string.calories, recipe.getKcal()));
        recipeCategory.setText(getResources().getString(R.string.category, recipe.getCategory().getType()));
        recipeDescription.setText(recipe.getDescription());
        recipePreparation.setText(recipe.getPreparation());

        Drawable drawable = null;
        if(recipe.isFavorite()) {
            drawable = getResources().getDrawable(R.drawable.ic_favorite_pink_24dp);
        } else {
            drawable = getResources().getDrawable(R.drawable.ic_favorite_grey_24dp);
        }

        btnFav.setImageDrawable(drawable);


        InputStream inputStream = null;
        try {
            inputStream = getContext().getAssets().open(recipe.getImgFile());
            drawable = Drawable.createFromStream(inputStream, null);
            recipeImg.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }


        StringBuilder ingredients = new StringBuilder();
        for (String ingredient : recipe.getIngredients()) {
            ingredients.append(ingredient)
                    .append("\n");
        }

        ingredientsList.setText(ingredients.toString());

        final Recipe r = recipe;
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar rb, float rating, boolean fromUser) {
                ratingBar.setRating(rb.getRating());
                r.setRating(rating);
                recipeViewModel.updateRecipe(r);
            }
        });

        btnFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r.setFavorite(!r.isFavorite());
                recipeViewModel.updateRecipe(r);
            }
        });

    }


    //TODO get recipe id
    public void setRecipeId(long recipeId) {
        this.recipeId = recipeId;
    }


}
