package com.merlin.bright.cory.prandium.recipe;

import com.merlin.bright.cory.prandium.R;
import com.merlin.bright.cory.prandium.RecyclerAdapter;

/**
 * Created by cory on 8/30/17.
 */

class GridAdapter extends RecyclerAdapter {
    private final GridFragment.OnRecipeSelectedInterface mListener;

    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }
}
