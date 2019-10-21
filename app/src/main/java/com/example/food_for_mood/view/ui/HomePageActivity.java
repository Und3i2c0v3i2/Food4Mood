package com.example.food_for_mood.view.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Category;
import com.example.food_for_mood.service.model.Recipe;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class HomePageActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_activity_fragments_container, new HomeFragment())
                                .addToBackStack(null)
                                .commit();


    }


    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {

                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;

                        case R.id.nav_category:
                            selectedFragment = new CategoriesFragment();
                            break;

                        case R.id.nav_favorites:
                            selectedFragment = new FavoritesFragment();
                            break;
                    }

                    if(selectedFragment != null) {
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.home_activity_fragments_container, selectedFragment)
                                .addToBackStack(null)
                                .commit();

                        return true;
                    } else {
                        return false;
                    }
                }
            };



    public void goToRecipesFromSelectedCategory(Category category) {
        //TODO replace hard-coded strings in code
        SortByCategoryFragment fragment = new SortByCategoryFragment();
        fragment.getCategoryId(category.getId());

        getSupportFragmentManager().beginTransaction()
                                    .replace(R.id.home_activity_fragments_container, fragment)
                                    .addToBackStack(null)
                                    .commit();
    }


    public void goToSelectedRecipe(Recipe recipe) {

        RecipeDetailsFragment fragment = new RecipeDetailsFragment();
        fragment.setRecipeId(recipe.getId());

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.home_activity_fragments_container, fragment)
                .addToBackStack(null)
                .commit();


    }


}
