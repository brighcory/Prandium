package com.merlin.bright.cory.prandium;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RecipesFragment.OnRecipeSelectedInterface {

    private TextView mTextMessage;
    boolean savedFragmentNull;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_calender:
                    if (savedFragmentNull) {
                        CalenderFragment fragment = new CalenderFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.placeHolder, fragment);
                        fragmentTransaction.commit();
                    }
                    return true;
                case R.id.navigation_Recipes:
                    if (savedFragmentNull) {
                        RecipesFragment recipesFragment = new RecipesFragment();
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.placeHolder, recipesFragment);
                        fragmentTransaction.commit();
                    }
                    return true;
                case R.id.navigation_shopping_list:
                    mTextMessage.setText(R.string.title_Shopping_List);
                    ShoppingListFragment shoppingFragment = new ShoppingListFragment();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecipesFragment savedFragment = (RecipesFragment) getSupportFragmentManager().findFragmentById(R.id.placeHolder);
//        savedFragmentNull = (savedFragment == null);

        RecipesFragment recipesFragment = new RecipesFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.placeHolder, recipesFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

        mTextMessage = (TextView) findViewById(R.id.message);
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
        fragmentTransaction.replace(R.id.placeHolder, viewPagerFragment);
        fragmentTransaction.commit();
    }

}
