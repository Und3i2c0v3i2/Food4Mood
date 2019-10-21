package com.example.food_for_mood.service.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.food_for_mood.service.model.Recipe;

import java.util.List;

@Dao
public interface RecipeDao {


    @Insert
    void insertAll(Recipe... recipes);

    @Insert
    void insert(Recipe recipes);
    @Delete
    void delete(Recipe recipe);
    @Update
    void update(Recipe recipe);


    @Query("select * from recipe order by recipe_name asc;")
    LiveData<List<Recipe>> getAllRecipes();

    @Query("select * from recipe where recipe_id=:id;")
    LiveData<Recipe> findById(long id);

    @Query("select * from recipe order by recipe_id desc limit 3;")
    LiveData<List<Recipe>> getLastAddedRecipes();

    @Query("select * from recipe where is_favorite = 1;")
    LiveData<List<Recipe>> getFavoriteRecipes();

    @Query("select * from recipe where times_prepared = 0 order by random() limit 3;")
    LiveData<List<Recipe>> getNotYetCooked();

    @Query("select * from recipe where category_id = :categoryId;")
    LiveData<List<Recipe>> getRecipesByCategory(long categoryId);



}
