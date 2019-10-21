package com.example.food_for_mood.view.adapters;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class SlideshowPagerAdapter extends PagerAdapter {

    private List<Recipe> recipes;
    private OnClickRecipeListener listener;

    private int customPosition = 0;


    public SlideshowPagerAdapter(OnClickRecipeListener listener) {
        this.listener = listener;
    }


    @Override
    public int getCount() {

        if (recipes != null) {
            return recipes.size();
        }
        return 0;
    }


    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {

        if(customPosition >= recipes.size()) {
            customPosition = 0;
        }

        LayoutInflater layoutInflater = (LayoutInflater) container.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slideshow_view_holder, container, false);

        ImageView imgView = view.findViewById(R.id.category_recycler_view_holder_img);
//        TextView txtView = view.findViewById(R.id.category_recycler_view_holder_txt);

        InputStream inputStream = null;
        AssetManager asset = container.getContext().getAssets();
        try {
            inputStream = asset.open(recipes.get(position).getImgFile());
            Drawable drawable = Drawable.createFromStream(inputStream, recipes.get(position).getImgFile());
            imgView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        txtView.setText(recipes.get(position).getName());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(recipes.get(position));
            }
        });

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ConstraintLayout)object);
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
        notifyDataSetChanged();
    }

}
