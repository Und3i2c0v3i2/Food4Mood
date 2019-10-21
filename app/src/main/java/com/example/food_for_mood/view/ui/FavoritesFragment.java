package com.example.food_for_mood.view.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Recipe;
import com.example.food_for_mood.view.adapters.OnClickRecipeListener;
import com.example.food_for_mood.view.adapters.SlideshowPagerAdapter;
import com.example.food_for_mood.view.adapters.StaggeredGridRecyclerViewAdapter;
import com.example.food_for_mood.viewmodel.FoodForMoodViewModel;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoritesFragment extends Fragment {


    private RecyclerView favDishRecyclerView;
    private StaggeredGridRecyclerViewAdapter adapter;
    private ViewPager slideshow;
    private SlideshowPagerAdapter slideshowAdapter;
    private Timer timer;
    private int currentPosition;

    private LinearLayout dotsLayout;
    private int dot_position;

    private FoodForMoodViewModel dishViewModel;


    public FavoritesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_favorites, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        favDishRecyclerView = view.findViewById(R.id.favorites_fragment_recycler_view);
        dotsLayout = view.findViewById(R.id.favorites_fragment_dots_container);
        slideshow = view.findViewById(R.id.favorites_fragment_slideshow_view_pager);


        setupAdapter();
        setupRecyclerView();


        dishViewModel = ViewModelProviders.of(this)
                .get(FoodForMoodViewModel.class);

        dishViewModel.getFavoriteRecipes().observe(getViewLifecycleOwner(), new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> dishes) {
                adapter.setRecipesByCategory(dishes);

            }
        });

        dishViewModel.getNotYetCooked().observe(getViewLifecycleOwner(), new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                slideshowAdapter.setRecipes(recipes);
            }
        });

    }


    private void setupAdapter() {
        adapter = new StaggeredGridRecyclerViewAdapter(listener);
        slideshowAdapter = new SlideshowPagerAdapter(listener);
    }

    private void setupRecyclerView() {
        favDishRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        favDishRecyclerView.setHasFixedSize(true);
        favDishRecyclerView.setAdapter(adapter);
        slideshow.setAdapter(slideshowAdapter);
    }


    @Override
    public void onStop() {
        super.onStop();
        timer.cancel();
    }

    @Override
    public void onResume() {
        super.onResume();

        prepareDots(dot_position);
        createSlideShow();


        slideshow.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

//                if(dot_position >= slideshowAdapter.getCount()) {
//                    dot_position = 0;
//                }

                prepareDots(position++);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void createSlideShow() {

        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPosition == slideshowAdapter.getCount()) {
                    currentPosition = 0;
                }

                prepareDots(currentPosition);
                slideshow.setCurrentItem(currentPosition++, true);

            }
        };

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(runnable);
            }
        }, 250, 2500);
    }


    private void prepareDots(int currentSlidePosition) {

        if (dotsLayout.getChildCount() > 0) {
            dotsLayout.removeAllViews();
        }

        ImageView[] dots = new ImageView[slideshowAdapter.getCount()];
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new ImageView(getContext());
            dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.inactive_dot));
            if (i == currentSlidePosition) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.active_dot));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4, 0, 4, 0);
            dotsLayout.addView(dots[i], params);


        }

    }

    private final OnClickRecipeListener listener = new OnClickRecipeListener() {
        @Override
        public void onClick(Recipe recipe) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((HomePageActivity) getActivity()).goToSelectedRecipe(recipe);
            }
        }
    };


}
