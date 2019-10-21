package com.example.food_for_mood.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

import com.example.food_for_mood.service.model.Category;
import com.example.food_for_mood.service.model.Recipe;
import com.example.food_for_mood.service.repository.CategoryRepository;
import com.example.food_for_mood.service.repository.RecipeRepository;

import java.util.List;

public class FoodForMoodViewModel extends AndroidViewModel {


    /*
    since we have relation between these two tables, we need both Repositories here
     */
    private RecipeRepository recipeRepository;
    private CategoryRepository categoryRepository;

    private LiveData<List<Recipe>> recipes;
    private LiveData<List<Category>> categories;

    private LiveData<Recipe> recipe;


    /*
     ViewModelProviders.of() will call empty constructor
     If we want to call another constructor, we need ViewModel Factory
     */


    public FoodForMoodViewModel(@NonNull Application application) {
        super(application);
        recipeRepository = new RecipeRepository(application);
        recipes = getRecipes();

        categoryRepository = new CategoryRepository(application);
        categories = categoryRepository.getAll();
    }

    public LiveData<Recipe> returnRecipe() { return recipe; }

    public void insertRecipe(Recipe recipe) {
        recipeRepository.insert(recipe);
    }

    public void updateRecipe(Recipe recipe) {
        recipeRepository.update(recipe);
    }

    public void deleteRecipe(Recipe recipe) {
        recipeRepository.delete(recipe);
    }

    public LiveData<List<Recipe>> getAll() {
        return recipes;
    }


    public LiveData<List<Recipe>> getNotYetCooked() { return recipeRepository.getNotYetCooked(); }

    public LiveData<List<Category>> getCategories() {
        return categories;
    }

    public LiveData<List<Recipe>> getRecipesByCategory(long category) {
        return recipeRepository.getRecipesByCategory(category);
    }

    public LiveData<List<Recipe>> getFavoriteRecipes() {
        return recipeRepository.getFavoriteRecipes();
    }


    /*
    we need to run async task to get category from category table for each recipe
    based on category_id in recipe table
     */
    public LiveData<List<Recipe>> getLastAddedRecipes() {
        LiveData<List<Recipe>> recipes = recipeRepository.getLastAddedRecipes();
        recipes = Transformations.map(recipes, new Function<List<Recipe>, List<Recipe>>() {

            @Override
            public List<Recipe> apply(final List<Recipe> input) {
                for (Recipe recipe : input) {
                    recipe.setCategory(categoryRepository.findCategoryById(recipe.getCategoryId()));
                }
                return input;
            }
        });
        return recipes;
    }


    /*
    since we have to get Category for Recipe from another table, we have to run this
    query in background task manually
    another way would be to get LiveData for both Categories and Recepies, but then
    we would have to wire them manually (we would have 2 separate lists)
    TODO find out why!!! Move this to ModelView, you don't have CategoryRepository here and you need that getRecipe() method, not CategoryDao getRecipe()
    */
    public LiveData<List<Recipe>> getRecipes() {
        LiveData<List<Recipe>> recipes = recipeRepository.getAllRecipes();
        recipes = Transformations.map(recipes, new Function<List<Recipe>, List<Recipe>>() {

            @Override
            public List<Recipe> apply(final List<Recipe> input) {
                for (Recipe recipe : input) {
                    recipe.setCategory(categoryRepository.findCategoryById(recipe.getCategoryId()));
                }
                return input;
            }
        });
        return recipes;
    }


    public LiveData<Recipe> findById(long recipe_id) {
        LiveData<Recipe> recipe = recipeRepository.findById(recipe_id);

        recipe = Transformations.map(recipe, new Function<Recipe, Recipe>() {

            @Override
            public Recipe apply(final Recipe input) {
               input.setCategory(categoryRepository.findCategoryById(input.getCategoryId()));
               return input;
            }
        });
        return recipe;
    }


}
