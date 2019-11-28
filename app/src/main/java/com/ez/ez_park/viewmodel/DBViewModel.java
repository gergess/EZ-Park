package com.ez.ez_park.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ez.ez_park.model.Card;
import com.ez.ez_park.model.Receipt;
import com.ez.ez_park.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    private FirebaseFirestore db;

    public DBViewModel(@NonNull Application application) {
        super(application);
        db = FirebaseFirestore.getInstance();
    }

    public User getUserByID(String documentID){
        DocumentSnapshot document =  db.collection(COLLECTION_USER).document(documentID).get().getResult();

        return document.toObject(User.class);
    }

    public String findUserID(String email, String pass){

        QuerySnapshot documents = db.collection(COLLECTION_USER)
                .whereEqualTo("email", email)
                .whereEqualTo("password", pass)
                .get().getResult();

        if (documents.size() == 1){

            for (QueryDocumentSnapshot document: documents){
                return document.getId();

            }

        }
        return null;
    }

    public boolean insertUser(User user, Card card){

        boolean exist = db.collection(COLLECTION_USER).whereEqualTo(user.getName(), true).get().isSuccessful();

        boolean success = false;

        if (!exist){

            HashMap<String, Object> data = new HashMap<>();

            success = db.collection(COLLECTION_USER).document().set(data).isSuccessful();
        }

        return success;
    }
    public boolean insertReceipt(Receipt receipt){

        return db.collection(COLLECTION_RECEIPT).document().set(receipt).isSuccessful();

    }
    public boolean updateUser(String documentID, String field, String value){

        return db.collection(COLLECTION_USER).document(documentID).update(field, value).isSuccessful();

    }

    public ArrayList getReceiptsByUserID(String userID){

        ArrayList<Receipt> receipts = new ArrayList<>();

        QuerySnapshot documents = db.collection(COLLECTION_RECEIPT)
                .whereEqualTo("userID", userID)
                .get().getResult();

        if (documents.size() > 0){

            for (QueryDocumentSnapshot document: documents){

                receipts.add(document.toObject(Receipt.class));

            }

        }

        return receipts;
    }
    public Receipt getReceiptByID(String documentID){
        DocumentSnapshot document =  db.collection(COLLECTION_RECEIPT).document(documentID).get().getResult();

        return document.toObject(Receipt.class);
    }
//
//    private String addCard(Card card){
//
//        boolean exist = db.collection(COLLECTION_CARDS).whereEqualTo(String.valueOf(card.getCardNum()), true).get().isSuccessful();
//
//        String cardID = null;
//
//        if (!exist){
//
//            cardID = db.collection(COLLECTION_CARDS).document().getId();
//            db.collection(COLLECTION_CARDS).document(cardID).set(card);
//
//        }
//
//
//        return cardID;
//    }
}
