package com.example.sqlitedatademo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ShowData extends Activity 
{
	Button b1,b2;
	ListView lst1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showdata);
		
		b1=(Button) findViewById(R.id.show_b1);
		b2=(Button) findViewById(R.id.show_b2);
		
		lst1=(ListView) findViewById(R.id.listView1);
		
		b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				SQLiteDatabase db= openOrCreateDatabase("college", MODE_PRIVATE, null);
				String sql="select * from student;";
				Cursor cr=db.rawQuery(sql, null); //rawQuery() executes select command
				int n=cr.getCount(); //How many rows in result
				String items[]=new String[n];
				if(n>0)
				{
					
					int i=0;
					for(cr.moveToFirst(); !cr.isAfterLast(); cr.moveToNext())
					{
						String name,branch,roll;
						name=cr.getString(cr.getColumnIndex("name"));
						branch=cr.getString(cr.getColumnIndex("branch"));
						roll=cr.getString(cr.getColumnIndex("rollno"));
						items[i]=name+"/"+branch+"/"+roll;
						
						i++;
					}
					ArrayAdapter< String> adapter=new ArrayAdapter<String>(ShowData.this,android.R.layout.simple_list_item_1,android.R.id.text1,items);
					lst1.setAdapter(adapter);
				}
				else
				{
					Toast.makeText(ShowData.this, "No data found", Toast.LENGTH_LONG).show();
				}
				cr.close();
			}
		});
		
		b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i1=new Intent(ShowData.this,MainActivity.class);
				startActivity(i1);
			}
		});
	}
}
