package com.merlin.bright.cory.prandium;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

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
                    if (getSupportFragmentManager().findFragmentByTag(CALENDER_INDEX) == null) {
                        CalenderFragment calenderFragment = new CalenderFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.placeholder, calenderFragment, CALENDER_INDEX);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
                    return true;
                case R.id.navigation_Recipes:
                    boolean isTablet = getResources().getBoolean(R.bool.is_tablet);

                    if (!isTablet) {

                        if (getSupportFragmentManager().findFragmentByTag(RECIPE_INDEX) == null) {
                            RecipesFragment recipesFragment = new RecipesFragment();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.placeholder, recipesFragment, RECIPE_INDEX);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    } else {

                        if (getSupportFragmentManager().findFragmentByTag(RECIPE_INDEX) == null) {
                            GridFragment recipesFragment = new GridFragment();
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.placeholder, recipesFragment, RECIPE_INDEX);
                            fragmentTransaction.addToBackStack(null);
                            fragmentTransaction.commit();
                        }
                    }
                    return true;
                case R.id.navigation_shopping_list:
                    if (getSupportFragmentManager().findFragmentByTag(SHOPPINGLIST_INDEX) == null) {
                        ShoppingListFragment shoppingFragment = new ShoppingListFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.placeholder, shoppingFragment, SHOPPINGLIST_INDEX);
                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
                    }
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
