package com.cblue.webview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Android加载html5页面中javascript
 */
public class WebViewActivity04 extends AppCompatActivity {

    WebView webView;
    String url ="http://10.8.169.32:8080/MyWeb/index.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view04);

        webView =(WebView)findViewById(R.id.webview_activity04_webview);

        webView.loadUrl(url);

        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        //设置WebView支持javascript
       WebSettings webSettings =  webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public boolean onJsAlert(WebView view, String url, String message,final JsResult result) {
                Log.i("aaa","message="+message);
                AlertDialog.Builder builder = new AlertDialog.Builder(WebViewActivity04.this);
                builder.setTitle("提示");
                builder.setMessage(message);
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                });
                builder.create().show();
                return true;
            }
        });





    }
}
