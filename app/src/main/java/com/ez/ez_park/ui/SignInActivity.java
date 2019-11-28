package com.ez.ez_park.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ez.ez_park.MainActivity;
import com.ez.ez_park.R;
import com.ez.ez_park.model.User;
import com.ez.ez_park.viewmodel.DBViewModel;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtEmail;
    EditText edtPassword;
    Button btnSignIn;
    CheckBox chkRemember;
    TextView txtSignUp;
    TextView txtForgetPass;

    String email_enter = "";
    String password_enter = "";

    DBViewModel vm;

    public static final int SIGN_UP_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtEmail = findViewById(R.id.edt_email_si);
        edtPassword = findViewById(R.id.edt_password_si);

        btnSignIn = findViewById(R.id.btn_sign_in);
        btnSignIn.setOnClickListener(this);

        chkRemember = findViewById(R.id.chk_remember_si);

        txtSignUp = findViewById(R.id.txt_sighup_si);
        txtSignUp.setOnClickListener(this);

        txtForgetPass = findViewById(R.id.txt_forgetpassword_si);
        txtForgetPass.setOnClickListener(this);

        vm = new DBViewModel(getApplication());

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_sign_in:
                //signin operation
                this.signIn();
                break;
            case R.id.txt_sighup_si:
                //signup operation
                this.signUp();
                break;
            case R.id.txt_forgetpassword_si:
                //forget password operation
                this.resetPassword();
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == SIGN_UP_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        }
    }

    private void signIn() {
        email_enter = edtEmail.getText().toString();
        password_enter = edtPassword.getText().toString();

        String id = vm.findUserID(email_enter, password_enter);

        if(!id.isEmpty()){
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);
            finish();
        }else{
            //login unsuccesful
            Toast.makeText(this, "Incorrect Username/Password! Try again.", Toast.LENGTH_LONG).show();
        }

    }

    private void openMainActivity() {
         Intent mainIntent = new Intent(SignInActivity.this, MainActivity.class);
         startActivity(mainIntent);
    }

    private void resetPassword() {
    }

    private void signUp() {
        Intent signUpIntent = new Intent(SignInActivity.this, SignUpActivity.class);
        startActivityForResult(signUpIntent, SIGN_UP_REQUEST_CODE);
    }


}
