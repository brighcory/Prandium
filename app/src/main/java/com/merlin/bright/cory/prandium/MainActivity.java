package com.merlin.bright.cory.prandium;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements RecipesFragment.OnRecipeSelectedInterface {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_calender:
                    mTextMessage.setText("Calender");
                    CalenderFragment fragment = new CalenderFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.placeHolder, fragment);
                    return true;
                case R.id.navigation_Recipes:
                    mTextMessage.setText("Recipes");
                    RecipesFragment recipesFragment = new RecipesFragment();
                    fragmentManager = getFragmentManager();
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.add(R.id.placeHolder, recipesFragment);
                    fragmentTransaction.commit();
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


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListRecipeSelected(int index) {
        Toast.makeText(this, Recipes.names[index], Toast.LENGTH_SHORT).show();
    }
}
