package com.example.food_for_mood.view.ui;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.food_for_mood.R;
import com.example.food_for_mood.service.model.Category;
import com.example.food_for_mood.view.adapters.CategoriesRecyclerViewAdapter;
import com.example.food_for_mood.view.adapters.OnClickCategoryListener;
import com.example.food_for_mood.viewmodel.FoodForMoodViewModel;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoriesFragment extends Fragment {


    private RecyclerView categoriesRecyclerView;
    private CategoriesRecyclerViewAdapter categoriesAdapter;
    private FoodForMoodViewModel foodForMoodViewModel;


    public CategoriesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_categories, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        foodForMoodViewModel = ViewModelProviders.of(this)
                .get(FoodForMoodViewModel.class);

        categoriesRecyclerView = view.findViewById(R.id.categories_fragment_recycler_view);
        adapterSetup();
        recyclerViewSetup();

        foodForMoodViewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                categoriesAdapter.setCategoriesForAdapter(categories);
            }
        });

    }


    private void adapterSetup() {
        categoriesAdapter = new CategoriesRecyclerViewAdapter(listener);
    }

    private void recyclerViewSetup() {
        categoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        categoriesRecyclerView.setHasFixedSize(true);
        categoriesRecyclerView.setAdapter(categoriesAdapter);
    }



    private final OnClickCategoryListener listener = new OnClickCategoryListener() {
        @Override
        public void onClick(Category category) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                ((HomePageActivity) getActivity()).goToRecipesFromSelectedCategory(category);
            }
        }
    };

}