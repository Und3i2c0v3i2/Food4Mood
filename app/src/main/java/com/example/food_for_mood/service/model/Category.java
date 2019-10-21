package com.example.food_for_mood.service.model;

import androidx.annotation.StringDef;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;


@Entity(tableName = "category")
public class Category {


    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "type")
    private String type;
    @ColumnInfo(name = "img_file_name")
    private String imgFileName;

    public Category(String type, String imgFileName) {
        this.type = type;
        this.imgFileName = imgFileName;
    }


    @StringDef({
            Type.MEAT,
            Type.FISH,
            Type.SALAD,
            Type.PASTRY,
            Type.PASTA,
            Type.SOUP,
            Type.VEGETABLE_SIDES,
            Type.PIZZA,
            Type.SANDWICHES_WRAPS,
            Type.SAUCES_CONDIMENTS,
            Type.CAKE,
            Type.DESSERTS,
            Type.BEVERAGES})


    public @interface Type {
        String MEAT = "Meat";
        String FISH = "Fish";
        String SALAD = "Salad";
        String PASTRY = "Pies & Pastries";
        String PASTA = "Pasta";
        String SOUP = "Soup";
        String VEGETABLE_SIDES = "Vegetable Sides";
        String PIZZA = "Pizza";
        String SANDWICHES_WRAPS = "Sandwiches & wraps";
        String SAUCES_CONDIMENTS = "Sauces & condiments";
        String CAKE = "Cake";
        String DESSERTS = "Desserts";
        String BEVERAGES = "Beverages";

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgFileName() {
        return imgFileName;
    }

    public void setImgFileName(String imgFileName) {
        this.imgFileName = imgFileName;
    }
}
