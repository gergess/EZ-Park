package com.ez.ez_park;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.view.MenuInflater;

import com.ez.ez_park.ui.SignInActivity;
import com.ez.ez_park.ui.SplashActivity;
import com.ez.ez_park.viewmodel.DBViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    public static final int SPLASH_DONE = 1;
    public static final int SIGN_IN_DONE = 2;
    public String ID = "";

    DBViewModel vm = new DBViewModel(getApplication());

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

    public void openWebPage() {
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

    public void showReceiptDetail(long receiptNum){
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.receipt_detail, null);

        TextView tvReceiptNum = dialogView.findViewById(R.id.tvReceiptNum);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Receipt Detail")
                .setView(dialogView)
                .setPositiveButton("Done", null)
                .create();

        alertDialog.show();
    }

    public String getUserID(){
        return getIntent().getStringExtra("USER_ID");
    }

}