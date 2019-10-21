package com.example.food_for_mood.view.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.SearchView;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Recipe;
import com.example.food_for_mood.view.adapters.OnClickRecipeListener;
import com.example.food_for_mood.view.adapters.SwipePagerAdapter;
import com.example.food_for_mood.viewmodel.FoodForMoodViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private AppCompatImageButton btnViewPagerPrev;
    private AppCompatImageButton btnViewPagerNext;
    private ViewPager swipeViewPager;
    private SwipePagerAdapter swipePagerAdapter;
    private SearchView searchView;

    private FoodForMoodViewModel recipesViewModel;


    public HomeFragment() { /* Required empty public constructor*/ }

    /*
    OBSERVE DATA, DON'T WRITE LOGIC HERE, JUST UPDATE/SET THE VIEW
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setupViews(view);
        setupAdapters();
        setupViewModel();
//        setupSearchFilter();

        btnViewPagerPrev.setOnClickListener(this);
        btnViewPagerNext.setOnClickListener(this);
        btnViewPagerPrev.setVisibility(View.INVISIBLE);

    }

    private void setupViews(View view) {
        btnViewPagerPrev = view.findViewById(R.id.home_fragment_left_nav);
        btnViewPagerNext = view.findViewById(R.id.home_fragment_right_nav);
        swipeViewPager = view.findViewById(R.id.home_fragment_view_pager);
        searchView = view.findViewById(R.id.home_fragment_search_view);
    }


    private void setupAdapters() {
        swipePagerAdapter = new SwipePagerAdapter(listener);
        swipeViewPager.setAdapter(swipePagerAdapter);
    }


    private void setupViewModel() {
        recipesViewModel = ViewModelProviders.of(this).get(FoodForMoodViewModel.class);

        recipesViewModel.getLastAddedRecipes().observe(getActivity(), new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                swipePagerAdapter.setLastAddedRecipesForViewPager(recipes);
            }
        });
    }

//    private void setupSearchFilter() {
//        /*
//        not sure how to display it yet
//         */
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//    }


    @Override
    public void onClick(View v) {

        int nextItemPosition = 0;

        switch (v.getId()) {
            case R.id.home_fragment_left_nav:
                nextItemPosition = -1;
                break;

            case R.id.home_fragment_right_nav:
                nextItemPosition = 1;
                break;
        }

        int item = swipeViewPager.getCurrentItem();
        swipeViewPager.setCurrentItem(item + nextItemPosition, true);
        handleViewPagerNavigation(item + nextItemPosition);
    }

    private void handleViewPagerNavigation(int item) {

                if(item == 0) {
                    btnViewPagerPrev.setVisibility(View.INVISIBLE);
                    btnViewPagerNext.setVisibility(View.VISIBLE);

                } else if(item == 1) {
                    btnViewPagerPrev.setVisibility(View.VISIBLE);
                    btnViewPagerNext.setVisibility(View.VISIBLE);
                } else {
                     btnViewPagerPrev.setVisibility(View.VISIBLE);
                    btnViewPagerNext.setVisibility(View.INVISIBLE);
                }
    }



    private final OnClickRecipeListener listener = new OnClickRecipeListener() {

        @Override
        public void onClick(Recipe recipe) {
            ((HomePageActivity) getActivity()).goToSelectedRecipe(recipe);
        }
    };

}
