package com.ez.ez_park.viewmodel;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.ez.ez_park.model.Receipt;
import com.ez.ez_park.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class DBViewModel extends AndroidViewModel {

    private final static String COLLECTION_USER = "Users";
    private final static String COLLECTION_RECEIPT = "Receipts";

    private final static String TAG = "DBViewModel";

    public String id = "";

    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    public QuerySnapshot usersQS, receiptsQS;

    public DBViewModel(@NonNull Application application) {
        super(application);

        refreshDB();

    }

    public void refreshDB(){
        db.collection(COLLECTION_USER).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                usersQS = task.getResult();
            }
        });
        db.collection(COLLECTION_RECEIPT).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                receiptsQS = task.getResult();
            }
        });
    }


    public User getUserByID(String documentID) {

        try {

            for (QueryDocumentSnapshot document: usersQS){
                if (document.getId().equals(documentID)){
                    return document.toObject(User.class);
                }
            }

        } catch (Exception e) {
            Log.e(TAG, "getUserByID: " + e.getLocalizedMessage());
        }

        return null;
    }

    public String findUserID(final String email, final String pass){

        Log.e(TAG, "findUserID: 1 hey");

        if(usersQS != null){
            for (QueryDocumentSnapshot document: usersQS){
                User u = document.toObject(User.class);
                if(u.getEmail().equals(email)){
                    if (u.getPassword().equals(pass)){
                        id = document.getId();
                    }
                }
            }
        }

        return id;
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

        long receiptNum = Math.round(Math.random()*5000+1000);

        receipt.setReceiptNum(receiptNum);

        try {
            return db.collection(COLLECTION_RECEIPT).document().set(receipt).isSuccessful();
        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }
        return false;
    }
    public boolean updateUser(String documentID, String field, String value){

        try {
            boolean success = db.collection(COLLECTION_USER).document(documentID).update(field, value).isSuccessful();

            refreshDB();
            return success;

        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }

        return false;

    }

    public ArrayList getReceiptsByUserID(String userID){

        ArrayList<Receipt> receipts = new ArrayList<>();

        try {
            for (QueryDocumentSnapshot document: receiptsQS){

                if(document.getString("userID").equals(userID)){
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

            for(QueryDocumentSnapshot document: receiptsQS){

                if (document.getId().equals( documentID)){
                    return document.toObject(Receipt.class);
                }

            }

        }catch (Exception e){
            Log.e(TAG, e.getLocalizedMessage() );
        }

        return null;

    }
}
