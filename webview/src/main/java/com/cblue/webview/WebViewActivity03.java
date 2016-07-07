package com.cblue.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


/**
 * 我们使用WebView加载网页，并且在加载过程中有进度显示
 * WebViewClient 加载网页
 * WebChromeClient
 */

public class WebViewActivity03 extends AppCompatActivity {


    ProgressBar progressBar;
    WebView webView;
    String url ="http://10.8.169.32:8080/MyWeb/index.html";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view03);

        progressBar = (ProgressBar)findViewById(R.id.webview_activity03_pb);
        webView = (WebView)findViewById(R.id.webview_activity03_webview);

        //使用WebView加载网页
        webView.loadUrl(url);
        //让我们的WebView隐藏起来
        webView.setVisibility(View.INVISIBLE);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        //掌控网页的加载进度
        webView.setWebChromeClient(new WebChromeClient(){

            //可以获得网页进度信息
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                Log.i("aaa","newProgress="+newProgress);
                setTitle("loading.....");
                progressBar.setProgress(newProgress);
                if(newProgress==100){
                    setTitle("done.....");
                   webView.setVisibility(View.VISIBLE);
                }


            }

            //获得网页的标题信息
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.i("aaa",title);
            }
        });



    }
}
