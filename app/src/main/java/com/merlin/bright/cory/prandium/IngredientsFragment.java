package com.merlin.bright.cory.prandium;

/**
 * Created by cory on 8/29/17.
 */

public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
