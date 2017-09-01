package com.merlin.bright.cory.prandium;

/**
 * Created by cory on 7/10/17.
 */

public class RecipeListAdapter extends RecyclerAdapter {
    private RecipesFragment.OnRecipeSelectedInterface mRecipeListener;

    public RecipeListAdapter(RecipesFragment.OnRecipeSelectedInterface listener) {
        mRecipeListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mRecipeListener.onListRecipeSelected(index);

    }

}
