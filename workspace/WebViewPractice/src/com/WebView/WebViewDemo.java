package com.WebView;

import com.WebView.R;
import android.os.Bundle;
import android.app.Activity;
import android.webkit.WebView;

public class WebViewDemo extends Activity {
	WebView browser;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);
		browser = (WebView) findViewById(R.id.webkit);
		browser.loadUrl("http://www.sinyi.com.tw");
		browser.getSettings().setJavaScriptEnabled(true);
	}
}
