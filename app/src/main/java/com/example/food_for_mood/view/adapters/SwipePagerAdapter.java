package com.example.food_for_mood.view.adapters;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Recipe;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


public class SwipePagerAdapter extends PagerAdapter {


    private List<Recipe> lastAddedRecipes;
    private OnClickRecipeListener listener;


    public SwipePagerAdapter(OnClickRecipeListener listener) {
        this.listener = listener;
    }


    @Override
    public int getCount() {
        if (lastAddedRecipes != null) {
            return lastAddedRecipes.size();
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

//        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(container.getContext())
                .inflate(R.layout.swipe_pager_holder, container, false);

        /* ******************************************************************** */
        ImageView imgView = view.findViewById(R.id.swipe_pager_holder_img);
        TextView txtView = view.findViewById(R.id.swipe_pager_holder_description);
        RatingBar ratingBar = view.findViewById(R.id.swipe_pager_holder_rating_bar_indicator);
        TextView category = view.findViewById(R.id.swipe_pager_holder_txt_category);

        InputStream inputStream = null;
        try {
            inputStream = imgView.getContext().getAssets().open(lastAddedRecipes.get(position).getImgFile());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imgView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        txtView.setText(lastAddedRecipes.get(position).getName());
        ratingBar.setRating(lastAddedRecipes.get(position).getRating());
        category.setText(lastAddedRecipes.get(position).getCategory().getType());
        /* ******************************************************************** */


        /*
        setting onClick option for each item in ViewPager and passing it as parameter
        to our OnClickRecipeListener
        For this adapter it is a listener created in HomeFragment (passed as parameter to adapter's constructor),
        and inside that listener we will implement desired behaviour in onClick() method
         */
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null && position >= 0 && position < lastAddedRecipes.size()) {
                    listener.onClick(lastAddedRecipes.get(position));
                }
            }
        });

        container.addView(view);

        return view;
    }


    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


    /*
    set list of last added recipes in onChanged() in anonymous Observer in HomeFragment
     */
    public void setLastAddedRecipesForViewPager(List<Recipe> recipes) {
        this.lastAddedRecipes = recipes;
        notifyDataSetChanged();
    }


}
