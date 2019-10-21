package com.example.food_for_mood.view.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Recipe;
import com.example.food_for_mood.view.adapters.OnClickRecipeListener;
import com.example.food_for_mood.view.adapters.StaggeredGridRecyclerViewAdapter;
import com.example.food_for_mood.viewmodel.FoodForMoodViewModel;

import java.util.List;


public class SortByCategoryFragment extends Fragment {

    private RecyclerView recyclerView;
    private StaggeredGridRecyclerViewAdapter gridAdapter;
    private long categoryId;

    private FoodForMoodViewModel recipeViewModel;


    public SortByCategoryFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sort_by_category, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recipeViewModel = ViewModelProviders.of(this)
                .get(FoodForMoodViewModel.class);

        recyclerView = view.findViewById(R.id.dishes_by_category_fragment_recycler_view);
        setupAdapter();

        recipeViewModel.getRecipesByCategory(categoryId).observe(this, new Observer<List<Recipe>>() {
            @Override
            public void onChanged(List<Recipe> recipes) {
                gridAdapter.setRecipesByCategory(recipes);
            }
        });
    }


    private void setupAdapter() {
        gridAdapter = new StaggeredGridRecyclerViewAdapter(listener);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(gridAdapter);
    }

    private final OnClickRecipeListener listener = new OnClickRecipeListener() {
        @Override
        public void onClick(Recipe recipe) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((HomePageActivity) getActivity()).goToSelectedRecipe(recipe);
            }

        }

    };


    public void getCategoryId(long id) {
        categoryId = id;
    }
}
