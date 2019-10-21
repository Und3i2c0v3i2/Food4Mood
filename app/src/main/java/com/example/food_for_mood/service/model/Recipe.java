package com.example.food_for_mood.service.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.food_for_mood.util.Converter;

import java.util.List;


@Entity(tableName = "recipe",
        indices = {@Index(value = {"recipe_name", "category_id"},
        unique = true)},
        foreignKeys = {
        @ForeignKey(entity = Category.class,
        parentColumns = "id",
        childColumns = "category_id")})
public class Recipe {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "recipe_id")
    private long id;
    @ColumnInfo(name = "recipe_name")
    private String name;
    @ColumnInfo(name = "recipe_description")
    private String description;
    @ColumnInfo(name = "category_id")
    private long categoryId;
    @TypeConverters(Converter.class)
    private List<String> ingredients;
    @ColumnInfo(name = "recipe_preparation")
    private String preparation;
    @ColumnInfo(name = "recipe_calories")
    private int kcal;
    @ColumnInfo(name = "recipe_img")
    private String imgFile;
    @ColumnInfo(name = "recipe_rating")
    private float rating;
    @ColumnInfo(name = "is_favorite")
    private boolean isFavorite;
    @ColumnInfo(name = "times_prepared")
    private int timesPrepared;

    @Ignore
    private Category category;



    public Recipe(String name, String description, long categoryId, List<String> ingredients, String preparation, int kcal, String imgFile, float rating, boolean isFavorite, int timesPrepared) {
        this.name = name;
        this.description = description;
        this.categoryId = categoryId;
        this.ingredients = ingredients;
        this.preparation = preparation;
        this.kcal = kcal;
        this.imgFile = imgFile;
        this.rating = rating;
        this.isFavorite = isFavorite;
        this.timesPrepared = timesPrepared;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getPreparation() {
        return preparation;
    }

    public int getKcal() {
        return kcal;
    }

    public String getImgFile() {
        return imgFile;
    }

    public float getRating() {
        return rating;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public int getTimesPrepared() {
        return timesPrepared;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    public void setTimesPrepared(int timesPrepared) {
        this.timesPrepared = timesPrepared;
    }
}
