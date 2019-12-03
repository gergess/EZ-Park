package com.ez.ez_park;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;

import com.ez.ez_park.ui.SignInActivity;
import com.ez.ez_park.ui.SplashActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity{

    public static final int SPLASH_DONE = 1;
    public static final int SIGN_IN_DONE = 2;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == SPLASH_DONE) {
//            if (resultCode == RESULT_OK) {
//                Intent signIn = new Intent(MainActivity.this, SignInActivity.class);
//                startActivityForResult(signIn, SIGN_IN_DONE);
//            }
//        } else if (requestCode == SIGN_IN_DONE) {
//            if (resultCode == RESULT_OK) {
//                Toast.makeText(this, "Worked!!", Toast.LENGTH_SHORT).show();
//            }
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//
//        Intent splashIntent = new Intent(MainActivity.this, SplashActivity.class);
//        startActivityForResult(splashIntent, SPLASH_DONE);

        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_profile, R.id.navigation_map, R.id.navigation_receipt_list)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);


        Log.d("hey2", "onCreate: hey2");

        Log.d("MainActivity", "tested braches");


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.help_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.app_manual:
                openWebPage();
                break;
            case R.id.user_support:
                openUserSupport();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void openWebPage() { //because i used free host for web page, sometimes(couple hours a day) it can be offline
        Uri webpage = Uri.parse("https://ez-parking1.000webhostapp.com/appmanual.html");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    private void openUserSupport() {
        Intent supportIntent = new Intent(MainActivity.this, UserSupportActivity.class);
        startActivity(supportIntent);
    }



}