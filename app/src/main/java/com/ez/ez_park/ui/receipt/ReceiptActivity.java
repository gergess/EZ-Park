package com.ez.ez_park.ui.receipt;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ez.ez_park.R;
import com.ez.ez_park.model.Receipt;
import com.ez.ez_park.model.User;
import com.ez.ez_park.viewmodel.DBViewModel;

public class ReceiptActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_profile);

        DBViewModel vm = new DBViewModel(getApplication());

        Receipt receipt = vm.getReceiptByID(getIntent().getStringExtra("RECEIPT_ID"));

        User user = vm.getUserByID(receipt.getUserID());


    }
}