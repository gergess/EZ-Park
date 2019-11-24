package com.ez.ez_park.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ez.ez_park.model.Receipt;
import com.ez.ez_park.model.User;
import com.google.firebase.firestore.FirebaseFirestore;

public class DBViewModel extends AndroidViewModel {
    final static String KEY_NAME = "Name";
    final static String KEY_EMAIL = "Email";
    final static String KEY_CONTACT = "Phone Number";
    final static String KEY_CARPLATE = "Plate Number";

    private FirebaseFirestore db;

    public DBViewModel(@NonNull Application application) {
        super(application);
        db = FirebaseFirestore.getInstance();
    }

    public void insertUser(User user){

    }
    public void insertReceipt(Receipt receipt){

    }
    public void updateUser(String field, String value){

    }
}
