package kr.co.eyc.cafeseek;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import Fragment.FavoriteFragment;
import Fragment.HomeFragment;
import Fragment.SearchFragment;
import Fragment.UserFragment;
import Fragment.UsersFragment;

public class NavigationActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private HomeFragment homeFragment = new HomeFragment();
    private FavoriteFragment favoriteFragment = new FavoriteFragment();
    private SearchFragment searchFragment = new SearchFragment();
    private UsersFragment usersFragment = new UsersFragment();
    private UserFragment userFragment = new UserFragment();

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        BottomNavigationView = findViewById(R.id.bottom_navigation);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.frame, homeFragment).commitAllowingStateLoss();


        Navigation();
    }

    


    void Navigation() {
        BottomNavigationView.setOnNavigationItemSelectedListener(new com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.addToBackStack(null);
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home: {
                        transaction.replace(R.id.frame, homeFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_favorite: {
                        transaction.replace(R.id.frame, favoriteFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_search: {
                        transaction.replace(R.id.frame, searchFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_group: {
                        transaction.replace(R.id.frame, usersFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_person: {
                        transaction.replace(R.id.frame, userFragment).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });



    }

}
