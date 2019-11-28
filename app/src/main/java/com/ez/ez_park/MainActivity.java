package com.ez.ez_park;

import android.content.Intent;
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

    TextView name, email, password, phone, carPlate, cardNumber, expiryDate, cardName, cvv;

    public static final int SPLASH_DONE = 1;
    public static final int SIGN_IN_DONE = 2;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SPLASH_DONE) {
            if (resultCode == RESULT_OK) {
                Intent signIn = new Intent(MainActivity.this, SignInActivity.class);
                startActivityForResult(signIn, SIGN_IN_DONE);
            }
        } else if (requestCode == SIGN_IN_DONE) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Worked!!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        referWidgets();
    }

    private void referWidgets() {
        name = findViewById(R.id.txtNameUP);
        //name.setOnClickListener(this);
        email = findViewById(R.id.txtEmailUP);
        //email.setOnClickListener(this);
        password = findViewById(R.id.txtPasswordUP);
        //password.setOnClickListener(this);
        phone = findViewById(R.id.txtPhoneUP);
        //phone.setOnClickListener(this);
        carPlate = findViewById(R.id.txtCarPlateUP);
        //carPlate.setOnClickListener(this);
        cardNumber = findViewById(R.id.txtCardNumberUP);
        //cardNumber.setOnClickListener(this);
        cardName = findViewById(R.id.txtCardNameUP);
        //cardName.setOnClickListener(this);
        expiryDate = findViewById(R.id.txtExpiryDateUP);
        //expiryDate.setOnClickListener(this);
        cvv = findViewById(R.id.txtCvvUP);
        //cvv.setOnClickListener(this);
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
                openAppManual();
                break;
            case R.id.user_support:
                openUserSupport();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openAppManual() {

    }
    private void openUserSupport() {
        Intent supportIntent = new Intent(MainActivity.this, UserSupportActivity.class);
        startActivity(supportIntent);
    }



}