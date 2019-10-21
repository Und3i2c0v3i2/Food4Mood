package com.example.food_for_mood.service.repository;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;


import com.example.food_for_mood.service.dao.CategoryDao;
import com.example.food_for_mood.service.dao.RecipeDao;
import com.example.food_for_mood.service.database.FoodForMoodDatabase;
import com.example.food_for_mood.service.model.Recipe;

import java.util.List;


public class RecipeRepository {

    private RecipeDao recipeDao;
    private CategoryDao categoryDao;
    private LiveData<List<Recipe>> recipes;



    public RecipeRepository(Application application) {
        FoodForMoodDatabase foodForMoodDatabase = FoodForMoodDatabase.getInstance(application);
        recipeDao = foodForMoodDatabase.getRecipeDao();
        recipes = recipeDao.getAllRecipes();

        /*
        since we have only id field for Category in Recipe table, we need categoryDao here
         */
        categoryDao = foodForMoodDatabase.getCategoryDao();
    }

    /*
    AsyncTask needed for insert, update, delete and findById
    because we don't have LiveData result
     */
    public void insert(Recipe... recipe) {
        new InsertRecipeAsyncTask(recipeDao).execute(recipe);
    }

    public void update(Recipe recipe) {
        new UpdateRecipeAsyncTask(recipeDao).execute(recipe);
    }

    public void delete(Recipe recipe) {
        new DeleteRecipeAsyncTask(recipeDao).execute(recipe);
    }

    /*
    all of these will run automatically in the background thread
    because of LiveData wrapper
     */
    public LiveData<List<Recipe>> getAllRecipes() {
        return recipes;
    }

    public LiveData<List<Recipe>> getLastAddedRecipes() {
        return recipeDao.getLastAddedRecipes();
    }

    public LiveData<List<Recipe>> getFavoriteRecipes(){
        return recipeDao.getFavoriteRecipes();
    }

    public LiveData<List<Recipe>> getNotYetCooked() {
        return recipeDao.getNotYetCooked();
    }

    public LiveData<List<Recipe>> getRecipesByCategory(long categoryId) {
        return recipeDao.getRecipesByCategory(categoryId);
    }

    public LiveData<Recipe> findById(long id) {
        return recipeDao.findById(id);
    }

//    public Recipe findById(long id) {
//
//        Recipe recipe = null;
//        try {
//            recipe = new FindRecipeByIdAsyncTask(recipeDao).execute(id).get();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        return recipe;
//    }


    private static class InsertRecipeAsyncTask extends AsyncTask<Recipe, Void, Void> {

        private RecipeDao recipeDao;

        private InsertRecipeAsyncTask(RecipeDao recipeDao) {
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.insert(recipes[0]);
            return null;
        }
    }


    private static class UpdateRecipeAsyncTask extends AsyncTask<Recipe, Void, Void> {

        private RecipeDao recipeDao;

        private UpdateRecipeAsyncTask(RecipeDao recipeDao) {
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.update(recipes[0]);
            return null;
        }
    }

    private static class DeleteRecipeAsyncTask extends AsyncTask<Recipe, Void, Void> {

        private RecipeDao recipeDao;

        private DeleteRecipeAsyncTask(RecipeDao recipeDao) {
            this.recipeDao = recipeDao;
        }

        @Override
        protected Void doInBackground(Recipe... recipes) {
            recipeDao.delete(recipes[0]);
            return null;
        }
    }

//    private static class FindRecipeByIdAsyncTask extends AsyncTask<Long, Void, Recipe> {
//
//        private RecipeDao recipeDao;
//
//        private FindRecipeByIdAsyncTask(RecipeDao recipeDao) {
//            this.recipeDao = recipeDao;
//        }
//
//        @Override
//        protected Recipe doInBackground(Long... longs) {
//            return recipeDao.findById(longs[0]);
//
//        }
//
//    }


}
