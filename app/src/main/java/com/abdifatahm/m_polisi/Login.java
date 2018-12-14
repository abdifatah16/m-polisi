package com.abdifatahm.m_polisi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {

    private EditText userName,userPassword;
    private Button userLogin;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userName = (EditText) findViewById(R.id.etMail);
        userPassword= (EditText) findViewById(R.id.etPassword);
        userLogin= (Button) findViewById(R.id.btnLogin);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

//        FirebaseUser user = firebaseAuth.getCurrentUser();

//        if(user != null){
//            finish();
//        }

        progressDialog= new ProgressDialog(this);
        progressDialog.setMessage("Logging in...");
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        userLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(userName.getText().toString(),userPassword.getText().toString());
                }
            });
        }


    private void validate(String userName, String userPassword){

        progressDialog.show();
        firebaseAuth.signInWithEmailAndPassword(userName,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  progressDialog.dismiss();
                  Toast.makeText(Login.this, "Login Was Successful!", Toast.LENGTH_SHORT).show();
                  startActivity(new Intent(Login.this,LandingPage.class));
                  finish();
              }
              else{

                  Toast.makeText(Login.this, "Login Was Unsuccessful!", Toast.LENGTH_SHORT).show();
                  progressDialog.dismiss();
              }
            }
        });


    }
    }
