package com.example.googlemap;

import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
private static final String MAP_URL = "file:///android_asset/map_v3.html";
private WebView webView;


 @Override
 /** Called when the activity is first created. */
 public void onCreate(Bundle savedInstanceState) {
   super.onCreate(savedInstanceState);
   setContentView(R.layout.activity_main);
   setupWebView();
 }
 /** Sets up the WebView object and loads the URL of the page **/
 private void setupWebView(){
   webView = (WebView) findViewById(R.id.webview01);
   webView.getSettings().setJavaScriptEnabled(true);//啟用Webview的JavaScript功能
   webView.setWebViewClient(new WebViewClient());
   webView.loadUrl(MAP_URL);
 }
}
