package com.example.food_for_mood.service.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.food_for_mood.service.model.Category;

import java.util.List;

@Dao
public interface CategoryDao {

    @Insert
    void insertAll(Category... categories);

    @Query("select * from category where id = :id")
    Category findCategoryById(long id);

    @Query("select * from category")
    LiveData<List<Category>> getAll();


}
