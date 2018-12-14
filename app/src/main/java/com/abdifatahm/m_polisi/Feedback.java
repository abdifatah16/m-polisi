package com.abdifatahm.m_polisi;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Feedback extends AppCompatActivity {
    Button calling, mailing, messaging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        calling = findViewById(R.id.btnCall);
        messaging = findViewById(R.id.btnSms);
        mailing = findViewById(R.id.btnMail);

        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = "070000";
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.fromParts("tel", phone, null));
                if (ContextCompat.checkSelfPermission(Feedback.this,
                        Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(Feedback.this,
                            new String[]{Manifest.permission.CALL_PHONE},1);

                    // MY_PERMISSIONS_REQUEST_CALL_PHONE is an
                    // app-defined int constant. The callback method gets the
                    // result of the request.
                } else {
                    //You already have permission
                    try {
                        startActivity(intent);
                    } catch(SecurityException e) {
                        e.printStackTrace();
                    }
                }
                startActivity(intent);

            }
        });

        messaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri tumaSms = Uri.parse("tel:+254712345678");
                Intent sms= new Intent(Intent.ACTION_VIEW, tumaSms);
                sms.putExtra("sms_body","My feedback on m-polisi app: ");
                sms.setType("vnd.android-dir/mms-sms");
                startActivity(sms);
            }
        });

    mailing.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        Intent sendMail = new Intent(Intent.ACTION_SENDTO,Uri.fromParts("mailto","mpolisi@gmail.com",null));
        sendMail.putExtra(Intent.EXTRA_SUBJECT, "M-Polisi App");
        sendMail.putExtra(Intent.EXTRA_TEXT, "The m-polisi app is...");
        startActivity(Intent.createChooser(sendMail, "You are sending an email"));

        }
        });
    }

}
