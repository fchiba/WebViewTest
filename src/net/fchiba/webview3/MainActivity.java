package net.fchiba.webview3;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private static class HelloWebViewClient extends WebViewClient {
	    @Override
	    public boolean shouldOverrideUrlLoading(WebView view, String url) {
	        view.loadUrl(url);
	        return true;
	    }
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		final WebView webView = (WebView)findViewById(R.id.webView1);
		
		webView.setWebViewClient(new HelloWebViewClient());
		
//		webView.setBackgroundColor(Color.BLACK);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.addJavascriptInterface(this, "nativeIf");

		webView.loadUrl("http://fchiba.net/jsif/index.html");

	}
	
	@JavascriptInterface
	public void func() {
		
	}

}
