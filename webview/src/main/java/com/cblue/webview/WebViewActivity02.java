package com.cblue.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * 使用WebView实现一个类似游览器的效果，学习WebView的方法
 */
public class WebViewActivity02 extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button goBtn;
    Button btn1,btn2,btn3,btn4;
    WebView webView;
    String url = null;
    WebViewClient webViewClient;

    float smallScale = 0;
    float bigScale = 1.0f;

    //缩放  0--1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view02);

        editText = (EditText)findViewById(R.id.webview_activity02_et);
        goBtn =(Button)findViewById(R.id.webview_activity02_btn);

        btn1 = (Button)findViewById(R.id.webview_activity02_control_btn01);
        btn2 = (Button)findViewById(R.id.webview_activity02_control_btn02);
        btn3 = (Button)findViewById(R.id.webview_activity02_control_btn03);
        btn4 = (Button)findViewById(R.id.webview_activity02_control_btn04);

        webView = (WebView)findViewById(R.id.webview_activity02_webview);


        goBtn.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        webViewClient = new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        };

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.webview_activity02_btn:
                //访问网页
                url =  editText.getText().toString();
                if(url!=null){
                    webView.loadUrl(url);
                    webView.setWebViewClient(webViewClient);
                }


                break;

            case R.id.webview_activity02_control_btn01:
               //前进
                if(webView.canGoForward()){
                    webView.goForward();
                }
            break;

            case R.id.webview_activity02_control_btn02:
                //后退
                if(webView.canGoBack()){
                    webView.goBack();
                }
                break;

            case R.id.webview_activity02_control_btn03:
               //放大   void onScaleChanged
                Log.i("aaa","smallScale="+smallScale);
                webViewClient.onScaleChanged(webView,smallScale,smallScale+=0.4);
               // webView.zoomIn();
                break;
            case R.id.webview_activity02_control_btn04:
               //缩小
                webViewClient.onScaleChanged(webView,bigScale,bigScale-=0.1);
                //webView.zoomOut();
                break;


        }
    }
}
