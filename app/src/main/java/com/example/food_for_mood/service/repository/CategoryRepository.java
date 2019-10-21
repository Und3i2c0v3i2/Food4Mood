package com.example.food_for_mood.service.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.food_for_mood.service.dao.CategoryDao;
import com.example.food_for_mood.service.database.FoodForMoodDatabase;
import com.example.food_for_mood.service.model.Category;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class CategoryRepository {

    private CategoryDao categoryDao;
    private LiveData<List<Category>> categories;


    public CategoryRepository(Application application) {
        FoodForMoodDatabase foodForMoodDatabase = FoodForMoodDatabase.getInstance(application);
        categoryDao = foodForMoodDatabase.getCategoryDao();
        categories = categoryDao.getAll();
    }


    /*
    LiveData will get categories in the background thread
    We will get categories in constructor, so here we can just return that list
     */
    public LiveData<List<Category>> getAll() {
        return categories;
    }


    /*
    this data is not wrapped in LiveData, so we have to run query in the background thread
     */
    public Category findCategoryById(long id) {
        try {
            return new FindCategoryByIdAsyncTask(categoryDao).execute(id).get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }


    /*
    this will run query in the background thread
     */
    private static class FindCategoryByIdAsyncTask extends AsyncTask<Long, Void, Category> {

        private CategoryDao categoryDao;

        private FindCategoryByIdAsyncTask(CategoryDao categoryDao) {
            this.categoryDao = categoryDao;
        }

        @Override
        protected Category doInBackground(Long... longs) {
            return categoryDao.findCategoryById(longs[0]);

        }

    }
}
