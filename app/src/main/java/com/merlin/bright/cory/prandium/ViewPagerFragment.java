package com.merlin.bright.cory.prandium;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by cory on 8/23/17.
 */

public class ViewPagerFragment extends Fragment {
    public static final String KEY_RECIPE_INDEX = "recipe_index";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_veiwpager, container, false);
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        Toast.makeText(getActivity(), Recipes.names[index], Toast.LENGTH_SHORT).show();

        return view;
    }
}
