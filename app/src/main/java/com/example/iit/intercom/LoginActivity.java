package com.example.iit.intercom;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import butterknife.Bind;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";


    @Bind(R.id.input_ref)
    EditText _refText;
    @Bind(R.id.input_pass)
    EditText _passText;
    @Bind(R.id.btn_login)
    Button _loginButton;
    ProgressDialog progressDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        _loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });


    }


    public void onLoginSuccess(String login, String pwd) throws com.parse.ParseException {

        _loginButton.setEnabled(true);
        ParseUser.logInInBackground(login, pwd, new LogInCallback() {
            @Override
            public void done(ParseUser user, com.parse.ParseException e) {


                if (e == null && user != null) {


                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                    progressDialog.dismiss();
                    startActivity(intent);
                    finish();

                } else if (user == null) {
                    Toast.makeText(LoginActivity.this, "Referance or Password invalide", Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }


            }

        });


    }

    public void login() {
        Log.d(TAG, "Login");

        if (!validate()) {
            onLoginFailed();
            return;
        }

        _loginButton.setEnabled(false);

        progressDialog = new ProgressDialog(LoginActivity.this);
        progressDialog.setIndeterminate(true);

        progressDialog.setMessage("Execute...");
        progressDialog.show();

        String ref = _refText.getText().toString();
        String pass = _passText.getText().toString();

        try {
            onLoginSuccess(ref, pass);
        } catch (com.parse.ParseException e) {
            e.printStackTrace();
        }


    }


    public void onLoginFailed() {
        Toast.makeText(getBaseContext(), "Invalide Authentification", Toast.LENGTH_LONG).show();

        _loginButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String ref = _refText.getText().toString();
        String pass = _passText.getText().toString();

        if (ref.isEmpty()) {
            _refText.setError("Invalid Referance");
            valid = false;
        } else {
            _refText.setError(null);
        }

        if (pass.isEmpty()) {
            _passText.setError("Invalide Password");
            valid = false;
        } else {
            _passText.setError(null);
        }

        return valid;
    }
}
