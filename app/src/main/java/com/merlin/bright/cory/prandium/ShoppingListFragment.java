package com.merlin.bright.cory.prandium;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by cory on 7/20/17.
 */

public class ShoppingListFragment extends Fragment{
    public interface OnShoppingSelectedInterface {
        void onShoppingListSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        ShoppingListFragment.OnShoppingSelectedInterface listener = (OnShoppingSelectedInterface) getActivity();
        View view = inflater.inflate(R.layout.fragment_shopping_list, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ShoppingListRecyclerView);
        ShoppingListAdapter shoppingListAdapter = new ShoppingListAdapter(listener);


        recyclerView.setAdapter(shoppingListAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
