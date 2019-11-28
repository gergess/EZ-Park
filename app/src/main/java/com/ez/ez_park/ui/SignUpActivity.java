package com.ez.ez_park.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ez.ez_park.R;
import com.ez.ez_park.model.Card;
import com.ez.ez_park.model.User;
import com.ez.ez_park.viewmodel.DBViewModel;


public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtName;
    EditText edtEmail;
    EditText edtPassword;
    EditText edtConfirmPassword;
    EditText edtPhone;
    EditText edtCarPlate;
    EditText edtCardNumber;
    EditText edtExpiryDate;
    EditText edtCardName;
    EditText edtCVV;

    String fullName;
    String email;
    String password;
    String phone;
    String carPlate;
    String cardNumber;
    String expiryDate;
    String cardName;
    String CVV;

    Button btnSubmit;

    DBViewModel vm;

    final static int RESULT_FALSE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        vm = new DBViewModel(getApplication());

        edtName = findViewById(R.id.edt_name_su);
        edtEmail = findViewById(R.id.edt_email_su);
        edtPassword = findViewById(R.id.edt_password_su);
        edtConfirmPassword = findViewById(R.id.edt_confirmpassword_su);
        edtPhone = findViewById(R.id.edt_phone_su);
        edtCarPlate = findViewById(R.id.edt_carplate_su);
        edtCardNumber = findViewById(R.id.edt_cardnumber_su);
        edtExpiryDate = findViewById(R.id.edt_expirydate_su);
        edtCardName = findViewById(R.id.edt_cardname_su);
        edtCVV = findViewById(R.id.edt_cvv_su);

        btnSubmit = findViewById(R.id.btn_submit_su);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_submit_su:
                if (this.validateData()){

                    User user = new User();

                    Card card = new Card();

                    user.setName(fullName);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setPhoneNum(phone);
                    user.setPlateNum(carPlate);

                    card.setCardName(cardName);
                    card.setCardNum(Integer.parseInt(cardNumber));
                    card.setCVV(Integer.parseInt(CVV));
                    card.setExpiryDate(expiryDate);

                    user.setCard(card);

                    Intent backIntent = new Intent();

                    if(vm.insertUser(user)){
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }else {
                        setResult(RESULT_FALSE, backIntent);
                        finish();
                    }
                }
                //temporary segway

        }

    }

    private boolean validateData() {
        boolean allValidations = true;

        if (edtName.getText().toString().isEmpty()){
            edtName.setError("You must enter full name");
            allValidations= false;
        }else{
            fullName = edtName.getText().toString();
        }
        if (edtEmail.getText().toString().isEmpty()){
            edtEmail.setError("You must enter email");
            allValidations = false;
        }else{
            email = edtEmail.getText().toString();
        }
        if (edtPassword.getText().toString().isEmpty()){
            edtPassword.setError("You must enter a password");
            allValidations = false;
        }
        if (edtConfirmPassword.getText().toString().isEmpty()){
            edtConfirmPassword.setError("You must confirm a password");
            allValidations = false;
        }else if (!edtPassword.getText().toString().equals(edtConfirmPassword.getText().toString())){
            edtConfirmPassword.setError("Both passwords must be same");
            allValidations = false;
        }else {
            password = edtConfirmPassword.getText().toString();
        }
        if (edtPhone.getText().toString().isEmpty()){
            edtPhone.setError("You must enter phone number");
            allValidations = false;
        }else {
            phone = edtPhone.getText().toString();
        }
        if (edtCarPlate.getText().toString().isEmpty()){
            edtCarPlate.setError("You must enter a car plate number");
            allValidations = false;
        }else{
            carPlate = edtCarPlate.getText().toString();
        }
        if (edtCardNumber.getText().toString().isEmpty()){
            edtCardNumber.setError("You must enter a card number");
            allValidations = false;
        }else {
            cardNumber = edtCardNumber.getText().toString();
        }
        if (edtExpiryDate.getText().toString().isEmpty()){
            edtExpiryDate.setError("You must enter an expiry date");
            allValidations = false;
        }else{
            expiryDate = edtExpiryDate.getText().toString();
        }
        if (edtCardName.getText().toString().isEmpty()){
            edtCardName.setError("You must enter a card holder name");
            allValidations = false;
        }else{
            cardName = edtCardName.getText().toString();
        }
        if (edtCVV.getText().toString().isEmpty()){
            edtCVV.setError("You must enter CVV number");
            allValidations = false;
        }else{
            CVV = edtCVV.getText().toString();
        }

        return allValidations;
    }
}
