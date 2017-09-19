package com.merlin.bright.cory.prandium.ui;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.merlin.bright.cory.prandium.R;
import com.merlin.bright.cory.prandium.ViewPagerFragment;
import com.merlin.bright.cory.prandium.calender.CalenderFragment;
import com.merlin.bright.cory.prandium.recipe.DualPaneFragment;
import com.merlin.bright.cory.prandium.recipe.GridFragment;
import com.merlin.bright.cory.prandium.recipe.RecipesFragment;
import com.merlin.bright.cory.prandium.shoppinglist.ShoppingListFragment;

public class MainActivity extends AppCompatActivity
        implements RecipesFragment.OnRecipeSelectedInterface, GridFragment.OnRecipeSelectedInterface {

    public static final String CALENDER_INDEX = "calender_fragment",
            RECIPE_INDEX = "recipe_fragment",
            SHOPPINGLIST_INDEX = "shoppinglist_fragment",
            VIEWPAGER_INDEX = "viewpagers_fragement";


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_calender:
                    CalenderFragment calenderFragment = new CalenderFragment();
                    FragmentManager calenderFragmentManager = getSupportFragmentManager();
                    FragmentTransaction calenderFragmentTransaction = calenderFragmentManager.beginTransaction();
                    calenderFragmentTransaction.replace(R.id.placeholder, calenderFragment, CALENDER_INDEX);
                    calenderFragmentTransaction.addToBackStack(null);
                    calenderFragmentTransaction.commit();
                    return true;
                case R.id.navigation_Recipes:
                    boolean isTablet = getResources().getBoolean(R.bool.is_tablet);

                    if (!isTablet) {

                        RecipesFragment recipesFragment = new RecipesFragment();
                        FragmentManager recipeFragmentManager = getSupportFragmentManager();
                        FragmentTransaction recipeFragmentTransaction = recipeFragmentManager.beginTransaction();
                        recipeFragmentTransaction.replace(R.id.placeholder, recipesFragment, RECIPE_INDEX);
                        recipeFragmentTransaction.addToBackStack(null);
                        recipeFragmentTransaction.commit();
                    } else {

                        GridFragment recipesFragment = new GridFragment();
                        FragmentManager gridFragmentManager = getSupportFragmentManager();
                        FragmentTransaction gridFragmentTransaction = gridFragmentManager.beginTransaction();
                        gridFragmentTransaction.replace(R.id.placeholder, recipesFragment, RECIPE_INDEX);
                        gridFragmentTransaction.addToBackStack(null);
                        gridFragmentTransaction.commit();
                    }
                    return true;
                case R.id.navigation_shopping_list:
                    ShoppingListFragment shoppingFragment = new ShoppingListFragment();
                    FragmentManager shoppingListFragmentManager = getSupportFragmentManager();
                    FragmentTransaction shoppingListFragmentTransaction = shoppingListFragmentManager.beginTransaction();
                    shoppingListFragmentTransaction.replace(R.id.placeholder, shoppingFragment, SHOPPINGLIST_INDEX);
                    shoppingListFragmentTransaction.addToBackStack(null);
                    shoppingListFragmentTransaction.commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (getSupportFragmentManager().findFragmentByTag(CALENDER_INDEX) == null) {
            CalenderFragment calenderFragment = new CalenderFragment();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeholder, calenderFragment, RECIPE_INDEX);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment viewPagerFragment = new ViewPagerFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        viewPagerFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, viewPagerFragment, VIEWPAGER_INDEX);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onGridRecipeSelected(int index) {
        DualPaneFragment dualPaneFragment = new DualPaneFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        dualPaneFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.placeholder, dualPaneFragment, VIEWPAGER_INDEX);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
