package edu.shu.com.shufinance.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import edu.shu.com.shufinance.R;

public class SHUPoliciesActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policies);
        getSupportActionBar().setTitle("SHU POLICIES");
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("http://www.sacredheart.edu/admissions/financialassistance/satisfactoryacademicprogresspolicy/");

    }
}
