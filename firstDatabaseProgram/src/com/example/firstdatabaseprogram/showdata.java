package com.example.firstdatabaseprogram;

import android.R.raw;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class showdata extends Activity 
{
	Button b1,b2,b3;
	EditText t1;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showdata);
        b1=(Button)findViewById(R.id.s_b1);
        b3=(Button)findViewById(R.id.s_b3);
        b2=(Button)findViewById(R.id.s_b2);
        t1=(EditText)findViewById(R.id.show_et1);
        b2.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				Intent i1=new Intent(showdata.this,MainActivity.class);
				startActivity(i1);
								
			}
		});
        b1.setOnClickListener(new OnClickListener()
        {
        	
			
			@Override
			public void onClick(View arg0) 
			{
				SQLiteDatabase db=openOrCreateDatabase("form", MODE_PRIVATE, null);
				String sql="SELECT * FROM details;";
				Cursor c=db.rawQuery(sql, null);
				String data="";
				int n=c.getCount(); 
				if(n>0)
				{
					
				
				for(c.moveToFirst();!c.isAfterLast();c.moveToNext())
				{
					String name,dob,contact,email;
					name=c.getString(c.getColumnIndex("fname"));
					dob=c.getString(c.getColumnIndex("dob"));
					contact=c.getString(c.getColumnIndex("contact"));
					email=c.getString(c.getColumnIndex("email"));
					
					data=data+name+"/"+dob+"/"+contact+"/"+email+"\n";
				}
				t1.setText(data);
				}
				else
				{
					Toast.makeText(showdata.this, "no data found", Toast.LENGTH_LONG).show(); 
				}
				db.close();
				
			}
		});
        b3.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View arg0) 
			{
				SQLiteDatabase db=openOrCreateDatabase("form", MODE_PRIVATE, null);
				String sql="DELETE FROM details;";
				db.execSQL(sql);
				t1.setText("");
				db.close();
								
			}
		});
    }   

}
