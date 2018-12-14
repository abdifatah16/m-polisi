package com.abdifatahm.m_polisi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText userName, userEmail, userPassword;
    private Button regButton;
    private FirebaseAuth firebaseAuth;
    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        setupUIViews();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Registering...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        firebaseAuth=FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    //upload to db
                    dialog.show();
                    String user_email= userEmail.getText().toString().trim();
                    String user_password = userPassword.getText().toString().trim();

                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if (task.isSuccessful()){
                                Toast.makeText(Register.this, "Registration was successful!", Toast.LENGTH_SHORT).show();
                                dialog.dismiss();

                                startActivity(new Intent(Register.this,Login.class));
                            }
                            else{
                                dialog.dismiss();
                                Toast.makeText(Register.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });


                }
            }
        });
    }

    private void setupUIViews(){
        userName= (EditText) findViewById(R.id.edtName);
        userPassword= (EditText) findViewById(R.id.edtPassword);
        userEmail = (EditText) findViewById(R.id.edtMail);
        regButton = (Button) findViewById(R.id.btnSignup);


    }

    private  Boolean validate(){
        Boolean result= false;

        String name= userName.getText().toString();
        String password= userPassword.getText().toString();
        String email= userEmail.getText().toString();

        if(name.isEmpty() || password.isEmpty() || email.isEmpty()){

            Toast.makeText(this, "Please fill in all the details", Toast.LENGTH_SHORT).show();
        }
        else {
            result= true;
        }
        return result;
    }
}
