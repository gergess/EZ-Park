package com.ez.ez_park;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserSupportActivity extends AppCompatActivity implements View.OnClickListener{

    Button phone;
    Button email;

    String email_compose = "4braus@gmail.com";
    String phone_call = "6478031384";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_support);

        phone = findViewById(R.id.btn_phoneContact);
        phone.setOnClickListener(this);

        email = findViewById(R.id.btn_emailContact);
        email.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_phoneContact:
                dialPhoneNumber();
                break;
            case R.id.btn_emailContact:
                composeEmail();
                break;
        }
    }

    public void dialPhoneNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phone_call));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void composeEmail() {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + email_compose));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
