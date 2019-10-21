package com.example.food_for_mood.service.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.food_for_mood.service.dao.CategoryDao;
import com.example.food_for_mood.service.dao.RecipeDao;
import com.example.food_for_mood.service.model.Category;
import com.example.food_for_mood.service.model.Recipe;


@Database(entities = {Category.class, Recipe.class}, version = 1)
public abstract class FoodForMoodDatabase extends RoomDatabase {


    private static FoodForMoodDatabase instance;

    public abstract RecipeDao getRecipeDao();
    public abstract CategoryDao getCategoryDao();


    public static synchronized FoodForMoodDatabase getInstance(Context context) {

        if (instance == null) {
            instance = buildDatabase(context);
        }

        return instance;
    }

    private static FoodForMoodDatabase buildDatabase(final Context context) {

        return Room.databaseBuilder(context,
                FoodForMoodDatabase.class,
                "food_for_mood_db")
                .fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build();

    }


    private static Callback roomCallback = new Callback() {

        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            new PopulateDbAsyncTask(instance).execute();
        }
    };



    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private RecipeDao recipeDao;
        private CategoryDao categoryDao;

        private PopulateDbAsyncTask(FoodForMoodDatabase recipeDatabase) {
            this.recipeDao = recipeDatabase.getRecipeDao();
            this.categoryDao = recipeDatabase.getCategoryDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            categoryDao.insertAll(MockData.initializeCategories());
            recipeDao.insertAll(MockData.initializeRecipes());
            return null;
        }
    }


}
