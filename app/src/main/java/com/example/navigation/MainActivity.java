package com.example.navigation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.customview.widget.Openable;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.navigation.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((binding = ActivityMainBinding.inflate(getLayoutInflater())).getRoot());

        setSupportActionBar(binding.toolbar);

        AppBarConfiguration aBC = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.drawer1Fragment, R.id.drawer2Fragment
        )
                .setOpenableLayout((Openable) binding.mainLayout)
                .build();


        // Drawer1Fragment
        NavController nav1 = ((NavHostFragment) Objects.requireNonNull(getSupportFragmentManager()
                .findFragmentById(R.id.nav_draw))).getNavController();


        NavigationUI.setupWithNavController(binding.navView, nav1);
        NavigationUI.setupWithNavController(binding.toolbar, nav1, aBC);

        NavController nav2 = ((NavHostFragment) Objects.requireNonNull(getSupportFragmentManager()
                .findFragmentById(R.id.nav_bottom))).getNavController();

        NavigationUI.setupWithNavController(binding.navView, nav2);
        NavigationUI.setupWithNavController(binding.toolbar, nav2);

        NavController nav3 = ((NavHostFragment) Objects.requireNonNull(getSupportFragmentManager()
                .findFragmentById(R.id.nav_fragment))).getNavController();

        NavigationUI.setupWithNavController(binding.navView, nav3);
        NavigationUI.setupWithNavController(binding.toolbar, nav3, aBC);

        AppBarConfiguration aBC2 = new AppBarConfiguration.Builder(
                // Top-level destinations:
                R.id.options1Fragment, R.id.options2Fragment
        )
                .build();

        NavController nav4 = ((NavHostFragment) Objects.requireNonNull(getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_options))).getNavController();

        NavigationUI.setupWithNavController(binding.navView, nav4);
        NavigationUI.setupWithNavController(binding.toolbar, nav4, aBC2);
    }
}