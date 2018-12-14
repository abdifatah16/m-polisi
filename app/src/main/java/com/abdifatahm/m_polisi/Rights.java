package com.abdifatahm.m_polisi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Rights extends AppCompatActivity {
    WebView myWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rights);
        myWebView= (WebView) findViewById(R.id.wbView);
        myWebView.loadUrl("http://www.kenyalaw.org/lex/actview.xql?actid=Const2010");
    }
}
