package com.sarah.p_physics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebChromeClient;

public class WebView4 extends Activity {

	private android.webkit.WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview4);
		webView = (android.webkit.WebView) findViewById(R.id.webView1);
		openBrowser();
	}

	private void openBrowser() {
		// TODO Auto-generated method stub
		String url = "https://www.youtube.com/watch?v=Xn5ByEZarNs";
		WebChromeClient wcc = new WebChromeClient();
		
		webView.setWebChromeClient(wcc);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setBuiltInZoomControls(true);
		webView.enablePlatformNotifications();
		webView.loadUrl(url);
	}

}
