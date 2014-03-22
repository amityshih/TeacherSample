package com.WebPractice;

import com.WebPractice.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebPractice extends Activity {
		WebView browser ;
		EditText weburl;
	public static final int Sinyi_ID 		= Menu.FIRST + 1;
	public static final int Google_ID 		= Menu.FIRST + 2;
	public static final int Hinet_ID 		= Menu.FIRST + 3;
	public static final int Yahoo_ID 		= Menu.FIRST + 4;
	public static final int Pchome_ID 		= Menu.FIRST + 5;
	public static final int Facebook_ID 	= Menu.FIRST + 6;
	public static final int Wretch_ID 		= Menu.FIRST + 7;

	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
	    weburl = (EditText) findViewById(R.id.weburl);  
	    
        browser = (WebView) findViewById(R.id.webkit);
		browser.loadUrl("http://www.sinyi.com/");
		browser.getSettings().setJavaScriptEnabled(true);

		browser.setWebViewClient(new WebViewClient());
				
		browser.getSettings().setSupportZoom(true);
		browser.getSettings().setBuiltInZoomControls(true);
		


		Button btnGo = (Button) findViewById(R.id.btnGo);
		btnGo.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

		  		browser.loadUrl(weburl.getText().toString());
			}
		});
		
		Button prevPageBtn = (Button) findViewById(R.id.prevPageBtn);
		prevPageBtn.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
			  browser.goBack();
			}
		});
    }
    
    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// if comment it out �no option menu is created
		populateMenu(menu);
		return (super.onCreateOptionsMenu(menu));
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {		
		return (applyMenuChoice(item) );
	}
	private void populateMenu(Menu menu) {
		menu.add(Menu.NONE, Sinyi_ID, Menu.NONE, "信義房屋");
		menu.add(Menu.NONE, Google_ID, Menu.NONE, "Google Inc.");
		menu.add(Menu.NONE, Hinet_ID, Menu.NONE, "中華電信");
		menu.add(Menu.NONE, Yahoo_ID, Menu.NONE, "Yahoo奇摩");
		menu.add(Menu.NONE, Pchome_ID, Menu.NONE, "Pchome");
		menu.add(Menu.NONE, Facebook_ID, Menu.NONE, "Facebook臉書");
		menu.add(Menu.NONE, Wretch_ID, Menu.NONE, "無名小站");
		}

	/////////////////////////////////////////////////////////////////////////
	
	private boolean applyMenuChoice(MenuItem item) {

		switch (item.getItemId()) {
		case Sinyi_ID:
			weburl.setText("http://www.sinyi.com.tw");
			browser.loadUrl("http://www.sinyi.com.tw");
			return (true);
		case Google_ID:
			weburl.setText("http://www.google.com.tw");
			browser.loadUrl("http://www.google.com.tw");			
			return (true);

		case Hinet_ID:
			weburl.setText("http://www.hinet.net");
			browser.loadUrl("http://www.hinet.net");			
			return (true);

		case Yahoo_ID:
			weburl.setText("http://www.yahoo.com.tw");
			browser.loadUrl("http://www.yahoo.com.tw");			
			return (true);
		case Pchome_ID:
			weburl.setText("http://www.pchome.com.tw");
			browser.loadUrl("http://www.pchome.com.tw");
			return (true);

		case Facebook_ID:
			weburl.setText("http://www.facebook.com.tw");
			browser.loadUrl("http://www.facebook.com.tw");			
			return (true);

		case Wretch_ID:
			weburl.setText("http://www.wretch.cc");
			browser.loadUrl("http://www.wretch.cc");
			return (true);
		}

		return (false);

	}// applyMenuChoice

}


