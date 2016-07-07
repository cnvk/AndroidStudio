package com.cblue.webview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * javascript调用Android的方法
 */
public class WebViewActivity05 extends AppCompatActivity {


    WebView webView;
    String url ="http://10.8.169.32:8080/MyWeb/index.html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view05);

        webView = (WebView)findViewById(R.id.webview_activity05_webview);
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //webview支持javascript
        WebSettings webSetting = webView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        //webView添加javascript接口
        webView.addJavascriptInterface(new MyObject(this),"myobj");

    }
}
class MyObject {
    private Context context;
    public MyObject(Context context){
        this.context = context;
    }

    @JavascriptInterface
    public void showInfo(String s1,String s2){
        Log.i("aaa","s1="+s1+";s2="+s2);
    }

}
