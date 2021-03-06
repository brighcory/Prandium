package com.merlin.bright.cory.prandium.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.merlin.bright.cory.prandium.R;
import com.merlin.bright.cory.prandium.adapters.RecipeListAdapter;

/**
 * Created by cory on 6/9/17.
 */

public class RecipesFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecipeRecyclerView);
        RecipeListAdapter recipeListAdapter = new RecipeListAdapter(listener);


        recyclerView.setAdapter(recipeListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }

    public interface OnRecipeSelectedInterface {
        void onListRecipeSelected(int index);
    }
}
