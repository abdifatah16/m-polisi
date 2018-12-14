package com.abdifatahm.m_polisi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Report extends AppCompatActivity {

    EditText etname,etdate,etevent,etlocation,etwitness;
    Button submit,upload;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        etname= findViewById(R.id.etNamesReport);
        etdate= findViewById(R.id.etDate);
        etevent= findViewById(R.id.etEvents);
        etlocation= findViewById(R.id.etLocation);
        etwitness= findViewById(R.id.etWitness);
        upload=findViewById(R.id.btnUpload);
        submit= findViewById(R.id.btnReport);
        dialog= new ProgressDialog(this);
        dialog.setMessage("Saving...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String jina = etname.getText().toString();
                String tarehe = etdate.getText().toString();
                String tukio = etevent.getText().toString();
                String pahali = etlocation.getText().toString();
                String shahidi = etwitness.getText().toString();

                if(jina.isEmpty()||tarehe.isEmpty()||tukio.isEmpty()||pahali.isEmpty()||shahidi.isEmpty()){
                    Toast.makeText(Report.this, "Fill all the inputs please", Toast.LENGTH_SHORT).show();

                }
                else{


                }

            }
        });


    }
}
