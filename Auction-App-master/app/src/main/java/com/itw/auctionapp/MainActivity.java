package com.itw.auctionapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.itw.auctionapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    TextView username;
    TextView emailNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        setSupportActionBar(activityMainBinding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);


        navigationViewDrawer();
        bottomNavigation();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ListingFragment()).commit();


    }

    private void bottomNavigation() {
        activityMainBinding.bottomNavigation.setOnNavigationItemSelectedListener(bottomNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavigationItemSelectedListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.bottom_navigation_home:
                            selectedFragment = new ListingFragment();
                            activityMainBinding.toolbar.setTitle(MainActivity.this.getText(R.string.listing));
                            break;

                        case R.id.bottom_navigation_bids:
                            selectedFragment = new BiddingFragment();
                            activityMainBinding.toolbar.setTitle(MainActivity.this.getText(R.string.bids));
                            break;


                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    return false;
                }
            };


    private void navigationViewDrawer() {

        activityMainBinding.navigationView.setNavigationItemSelectedListener(drawerNavigationItemSelectedListener);

        View view = activityMainBinding.navigationView.inflateHeaderView(R.layout.navigation_drawer);
        username = view.findViewById(R.id.navigation_drawer_username);
        emailNav = view.findViewById(R.id.navigation_drawer_email);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, activityMainBinding.drawerLayout, activityMainBinding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        activityMainBinding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        activityMainBinding.navigationView.setCheckedItem(R.id.homeDrawer);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.user_image);
        // should be after adding toggle listener

    }

    private NavigationView.OnNavigationItemSelectedListener drawerNavigationItemSelectedListener =
            new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.exitApp:
                            MainActivity.this.finish();
                            break;
                    }
                    return true;
                }
            };
}