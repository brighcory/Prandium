package com.merlin.bright.cory.prandium.ui;

import com.merlin.bright.cory.prandium.Recipes;

/**
 * Created by cory on 8/29/17.
 */

public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
