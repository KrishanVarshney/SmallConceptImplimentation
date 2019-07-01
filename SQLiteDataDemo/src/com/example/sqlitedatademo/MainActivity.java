package com.example.sqlitedatademo;

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

public class MainActivity extends ActionBarActivity {

	Button b1,b2;
	EditText t1,t2,t3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1=(Button) findViewById(R.id.button1);
        b2=(Button) findViewById(R.id.button2);
        
        t1=(EditText) findViewById(R.id.editText1);
        t2=(EditText) findViewById(R.id.editText2);
        t3=(EditText) findViewById(R.id.editText3);
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String name,branch,rollno;
				name=t1.getText().toString();
				branch=t2.getText().toString();
				rollno=t3.getText().toString();
				
				SQLiteDatabase db= openOrCreateDatabase("college", MODE_PRIVATE, null);
				
				String sql="CREATE TABLE IF NOT EXISTS student(name varchar(100),branch varchar(100),rollno varchar(20));";
				db.execSQL(sql);
				
				sql="INSERT INTO student VALUES('"+name+"','"+branch+"','"+rollno+"');";
				db.execSQL(sql);
				
				db.close();
				
				t1.setText("");
				t2.setText("");
				t3.setText("");
				
				t1.requestFocus();
			}
		});
        
b2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent i1=new Intent(MainActivity.this,ShowData.class);
				startActivity(i1);
			}
		});
    }
}
