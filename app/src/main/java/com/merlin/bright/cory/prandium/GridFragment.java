package com.merlin.bright.cory.prandium;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cory on 8/30/17.
 */

public class GridFragment extends Fragment {

    public interface OnRecipeSelectedInterface {
        void onGridRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_recipes, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.RecipeRecyclerView);
        GridAdapter gridAdapter = new GridAdapter(listener);


        recyclerView.setAdapter(gridAdapter);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels/displayMetrics.density;
        int numColumns = (int) (dpWidth/200);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),numColumns);
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}