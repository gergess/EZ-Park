package com.ez.ez_park.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ez.ez_park.model.Card;
import com.ez.ez_park.model.Receipt;
import com.ez.ez_park.model.User;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class DBViewModel extends AndroidViewModel {

    final static String KEY_NAME = "Name";
    final static String KEY_EMAIL = "Email";
    final static String KEY_CONTACT = "Phone Number";
    final static String KEY_CARPLATE = "Plate Number";
    final static String KEY_PASS = "Password";
    final static String KEY_CARD = "Card ID";

    private final static String COLLECTION_USER = "Users";
    private final static String COLLECTION_RECEIPT = "Receipts";
    private final static String COLLECTION_CARDS = "Cards";

    private FirebaseFirestore db;

    public DBViewModel(@NonNull Application application) {
        super(application);
        db = FirebaseFirestore.getInstance();
    }

    private boolean insertUser(User user, Card card){

        boolean exist = db.collection(COLLECTION_USER).whereEqualTo(user.getName(), true).get().isSuccessful();

        boolean success = false;

        if (!exist){

            HashMap<String, Object> data = new HashMap<>();

            String cardID = addCard(card);

            user.setCardID(cardID);


            success = db.collection(COLLECTION_USER).document().set(data).isSuccessful();
        }

        return success;
    }
    private boolean insertReceipt(Receipt receipt){

        return db.collection(COLLECTION_RECEIPT).document().set(receipt).isSuccessful();

    }
    private void updateUser(String field, String value){

    }

    private String addCard(Card card){

        boolean exist = db.collection(COLLECTION_CARDS).whereEqualTo(String.valueOf(card.getCardNum()), true).get().isSuccessful();

        String cardID = null;

        if (!exist){

            cardID = db.collection(COLLECTION_CARDS).document().getId();
            db.collection(COLLECTION_CARDS).document(cardID).set(card);

        }


        return cardID;
    }
}
