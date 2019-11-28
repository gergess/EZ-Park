package com.ez.ez_park.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ez.ez_park.model.Card;
import com.ez.ez_park.model.Receipt;
import com.ez.ez_park.model.User;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DBViewModel extends AndroidViewModel {

    private final static String COLLECTION_USER = "Users";
    private final static String COLLECTION_RECEIPT = "Receipts";

    private final static String TAG = "DBViewModel";

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

        try {

            Log.e(TAG, "findUserID: 1");
            User u = db.collection(COLLECTION_USER).document("yyFU4NBl5DIl4NvPKw1I").get().getResult().toObject(User.class);
            Log.e(TAG, "findUserID: 2" );
            Log.e(TAG, u.getName() );
            return u.getName();
//            if(query.isSuccessful()){
//
//                List<DocumentSnapshot> documents = query.getResult().getDocuments();
//
//                for (DocumentSnapshot document: documents){
//                    if(document.getString("email").equals(email)){
//                        if(document.getString("password").equals(pass)){
//                            return document.getId();
//                        }
//                    }
//                }
//
//            }else{
//                Log.e(TAG, "not successful" );
//            }

        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() + " Sign IN" );
        }
        return "";
    }

    public boolean insertUser(User user){
        boolean success = false;

        try {
            boolean exist = db.collection(COLLECTION_USER).whereEqualTo(user.getName(), true).get().isSuccessful();


            if (!exist){


                success = db.collection(COLLECTION_USER).document().set(user).isSuccessful();
            }
        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }

        return success;
    }
    public boolean insertReceipt(Receipt receipt){

        try {
            return db.collection(COLLECTION_RECEIPT).document().set(receipt).isSuccessful();
        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }
        return false;
    }
    public boolean updateUser(String documentID, String field, String value){

        try {
            return db.collection(COLLECTION_USER).document(documentID).update(field, value).isSuccessful();
        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }

        return false;

    }

    public ArrayList getReceiptsByUserID(String userID){

        ArrayList<Receipt> receipts = new ArrayList<>();

        try {
            QuerySnapshot documents = db.collection(COLLECTION_RECEIPT)
                    .whereEqualTo("userID", userID)
                    .get().getResult();

            if (documents.size() > 0){

                for (QueryDocumentSnapshot document: documents){

                    receipts.add(document.toObject(Receipt.class));

                }

            }
        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }

        return receipts;
    }
    public Receipt getReceiptByID(String documentID){

        try {
            DocumentSnapshot document =  db.collection(COLLECTION_RECEIPT).document(documentID).get().getResult();

            return document.toObject(Receipt.class);
        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }

        return null;

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
