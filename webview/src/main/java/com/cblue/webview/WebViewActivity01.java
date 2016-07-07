package com.cblue.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * 使用WebView实现网页加载
 */
public class WebViewActivity01 extends AppCompatActivity {

    WebView webView;
    String urlStr ="http://www.baidu.com";
    WebSettings webSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view01);

        webView = (WebView)findViewById(R.id.webview_activity01);

        webSettings = webView.getSettings();

        webSettings.setBuiltInZoomControls(true);

        webView.loadUrl(urlStr);

        webView.setWebViewClient(new WebViewClient(){
            //覆盖url的加载
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}
