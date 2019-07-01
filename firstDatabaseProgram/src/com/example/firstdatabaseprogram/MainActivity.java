package com.example.firstdatabaseprogram;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Build;

public class MainActivity extends ActionBarActivity 
{
	Button b1,b2;
	EditText t1,t2,t3,t4,t5;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1= (Button)findViewById(R.id.button1);
        b2= (Button)findViewById(R.id.button2);
        t1=(EditText)findViewById(R.id.et1);
        t2=(EditText)findViewById(R.id.editText2);
        t3=(EditText)findViewById(R.id.editText3);
        t4=(EditText)findViewById(R.id.editText4);
        t5=(EditText)findViewById(R.id.editText5);
        
        b1.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				String fname,dob,contact,email;
				fname=t1.getText().toString()+t2.getText().toString();
				dob=t3.getText().toString();
				contact=t4.getText().toString();
				email=t5.getText().toString();
				
				
				SQLiteDatabase db=openOrCreateDatabase("form", MODE_PRIVATE, null);
				String sql="CREATE TABLE IF NOT EXISTS details(fname varchar(100),dob varcha0r(50),contact varchar(20),email varchar(50));";
				db.execSQL(sql);
				
				sql="INSERT INTO details VALUES('"+fname+"','"+dob+"','"+contact+"','"+email+"');";
				db.execSQL(sql);
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				
				t1.requestFocus();
				db.close();
				
				
				
								
			}
		});
        
        b2.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				Intent i1=new Intent(MainActivity.this,showdata.class);
				startActivity(i1);
								
			}
		});
        
    }

}
