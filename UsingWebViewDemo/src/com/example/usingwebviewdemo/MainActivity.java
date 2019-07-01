package com.example.usingwebviewdemo;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity 
{
	Button b1;
	EditText t1;
	WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1=(Button)findViewById(R.id.button1);
        t1=(EditText) findViewById(R.id.editText1);
        w1=(WebView)findViewById(R.id.webView1);
        w1.getSettings().setJavaScriptEnabled(true);
        w1.setWebViewClient(new MyBrowser());
        w1.getSettings().setBuiltInZoomControls(true);
        w1.getSettings().setSupportZoom(true);
        w1.getSettings().setUseWideViewPort(true);
        w1.getSettings().setLoadWithOverviewMode(true);
        
        b1.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				String url=t1.getText().toString();
				w1.loadUrl(url);
				
				
			}
		});

    }
    
    class MyBrowser extends WebViewClient
    {
    	MyBrowser()
    	{
    		super();
    	}
    	@Override
    	public boolean shouldOverrideUrlLoading(WebView view,String url)
    	{
    		view.loadUrl(url);
    		return true;
    		
    	}
    }

}
