package com.example.wallpaper;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	ImageView display,i1,i2,i3,i4,i5,i6;
	Button b1;
	int set_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        display = (ImageView) findViewById(R.id.imageView1);
        i1= (ImageView) findViewById(R.id.imageView2);
        i2= (ImageView) findViewById(R.id.imageView3);
        i3= (ImageView) findViewById(R.id.imageView4);
        i4= (ImageView) findViewById(R.id.imageView5);
        i5= (ImageView) findViewById(R.id.imageView6);
        i6= (ImageView) findViewById(R.id.imageView7);
        
        b1= (Button) findViewById(R.id.button1);
        
        
        i1.setOnClickListener(new a());
        i2.setOnClickListener(new a());
        i3.setOnClickListener(new a());
        i4.setOnClickListener(new a());
        i5.setOnClickListener(new a());
        i6.setOnClickListener(new a());
        
        b1.setOnClickListener(new b());

       
    }
    class a implements OnClickListener
    {
    	@Override
    	public void onClick(View v1) {
    		switch (v1.getId())
    		{
    		case R.id.imageView2:
    			set_image=R.drawable.a;
    			break;
    		case R.id.imageView3:
    			set_image=R.drawable.b;
    			break;
    		case R.id.imageView4:
    			set_image=R.drawable.c;
    			break;
    		case R.id.imageView5:
    			set_image=R.drawable.d;
    			break;
    		case R.id.imageView6:
    			set_image=R.drawable.e;
    			break;
    		case R.id.imageView7:
    			set_image=R.drawable.f;
    			break;
    			
    		}
    		if(set_image!=0)
    			display.setImageResource(set_image);
    		
    	}
    }
    class b implements OnClickListener
    {
    	@Override
    	public void onClick(View v1) {
    		Bitmap img =BitmapFactory.decodeStream(getResources().openRawResource(set_image));
    		try
    		{
    			getApplicationContext().setWallpaper(img);
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    		
    	}
    		
    }
    

}
