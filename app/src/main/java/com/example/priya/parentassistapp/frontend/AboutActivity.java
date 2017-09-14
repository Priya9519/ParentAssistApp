package com.example.priya.parentassistapp.frontend;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.priya.parentassistapp.R;

public class AboutActivity extends AppCompatActivity {
   private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        init();
    }
    //initialise view
    private void init() {
        webView=(WebView)findViewById(R.id.webView);
        webView.getSettings().setAllowFileAccess(true);
        webView.setBackgroundColor(Color.TRANSPARENT);
        webView.getSettings().setJavaScriptEnabled(true);
        loadWebView();
    }
    //load html page from asset folder to webview
    private void loadWebView() {
        webView.setWebViewClient(new WebViewClient() {
            ProgressDialog prDialog;
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                prDialog = ProgressDialog.show(AboutActivity.this, null, "Loading, please wait...");
                super.onPageStarted(view, url, favicon);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                prDialog.dismiss();
                super.onPageFinished(view, url);
            }
        });
        webView.loadUrl("file:///android_asset/about.html");
    }

}
