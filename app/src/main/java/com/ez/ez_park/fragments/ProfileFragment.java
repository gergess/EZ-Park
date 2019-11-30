package com.ez.ez_park.fragments;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.ez.ez_park.R;

public class ProfileFragment extends Fragment implements View.OnClickListener
{

    TextView name, email, password, phone, carPlate, cardNumber, expiryDate, cardName, cvv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        referWidgets(root);


        return root;

    }
    private void referWidgets(View root) {
        name = root.findViewById(R.id.txtNameUP);
        name.setOnClickListener(this);
        email = root.findViewById(R.id.txtEmailUP);
        email.setOnClickListener(this);
        password = root.findViewById(R.id.txtPasswordUP);
        password.setOnClickListener(this);
        phone = root.findViewById(R.id.txtPhoneUP);
        phone.setOnClickListener(this);
        carPlate = root.findViewById(R.id.txtCarPlateUP);
        carPlate.setOnClickListener(this);
        cardNumber = root.findViewById(R.id.txtCardNumberUP);
        cardNumber.setOnClickListener(this);
        cardName = root.findViewById(R.id.txtCardNameUP);
        cardName.setOnClickListener(this);
        expiryDate = root.findViewById(R.id.txtExpiryDateUP);
        expiryDate.setOnClickListener(this);
        cvv = root.findViewById(R.id.txtCvvUP);
        cvv.setOnClickListener(this);
        }

    @Override
    public void onClick(View view) {
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.update_profile, null);

        switch (view.getId()){
            case R.id.txtNameUP:
                AlertDialog alertNameDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new name:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                name.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertNameDialog.show();
                return;
            case R.id.txtEmailUP:
                AlertDialog alertEmailDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new email:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                email.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertEmailDialog.show();
                return;
            case R.id.txtPasswordUP:
                AlertDialog alertPasswordDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new password:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                password.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertPasswordDialog.show();
                return;
            case R.id.txtPhoneUP:
                AlertDialog alertPhoneDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new contact number:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                phone.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertPhoneDialog.show();
                return;
            case R.id.txtCarPlateUP:
                AlertDialog alertCarPlateDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new car plate number:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                carPlate.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertCarPlateDialog.show();
                return;
            case R.id.txtCardNumberUP:
                AlertDialog alertCardNumberDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new credit card number:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                cardNumber.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertCardNumberDialog.show();
                return;
            case R.id.txtCardNameUP:
                AlertDialog alertCardNameDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new credit card holder name:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                cardName.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertCardNameDialog.show();
                return;
            case R.id.txtExpiryDateUP:
                AlertDialog alertExpiryDateDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new credit card expiry date:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                expiryDate.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertExpiryDateDialog.show();
                return;
            case R.id.txtCvvUP:
                AlertDialog alertCvvDialog = new AlertDialog.Builder(view.getContext())
                        .setTitle("Update Profile Info")
                        .setMessage("Enter a new cvv:")
                        .setView(dialogView)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText update = dialogView.findViewById(R.id.updateInfo);
                                cvv.setText(update.getText().toString());
                            }
                        })
                        .setNegativeButton("Cancel", null)
                        .create();
                alertCvvDialog.show();
                return;









        }

    }
}
