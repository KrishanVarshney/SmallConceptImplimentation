package com.example.multipledialog;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity 
{
	Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button) findViewById(R.id.main_b1);
        b1.setOnClickListener(new a());
        b2=(Button) findViewById(R.id.main_b2);
        b2.setOnClickListener(new b());
        
    }
    class a implements OnClickListener
    {

		@Override
		public void onClick(View arg0) 
		{
			LayoutInflater li=LayoutInflater.from(MainActivity.this);
			View v0=li.inflate(R.layout.first, null);
			AlertDialog.Builder adb=new AlertDialog.Builder(MainActivity.this);
			adb.setView(v0);
			final EditText t1=(EditText)v0.findViewById(R.id.first_et1);			
			final EditText t2=(EditText)v0.findViewById(R.id.first_et2);
			adb.setPositiveButton("sum", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) 
				{
					int a,b,c;
					a=Integer.parseInt(t1.getText().toString());
					b=Integer.parseInt(t2.getText().toString());
					c=a+b;
					Toast.makeText(MainActivity.this, "addition is "+c, Toast.LENGTH_LONG).show();
					AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
					ab.setMessage("result is"+c);
					ab.setPositiveButton("ok", new op1());
					ab.setNegativeButton("cancel", new op2());
					ab.create();
					ab.show();	
				}
				class op1 implements DialogInterface.OnClickListener
				{

					@Override
					public void onClick(DialogInterface arg0, int arg1) 
					{
						arg0.cancel();	
					}
					
				}
				class op2 implements DialogInterface.OnClickListener
				{

					@Override
					public void onClick(DialogInterface arg0, int arg1) 
					{
						arg0.cancel();	
					}
					
				}
			});
			adb.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					arg0.cancel();
					
				}
			});
			adb.create();
			adb.show();
			
			
		}
    	
    }
    class b implements OnClickListener
    {

		@Override
		public void onClick(View arg0) {
			LayoutInflater li = LayoutInflater.from(MainActivity.this);
			View v0=li.inflate(R.layout.second, null);
			AlertDialog.Builder a=new AlertDialog.Builder(MainActivity.this);
			a.setView(v0);
			final EditText t1=(EditText)v0.findViewById(R.id.second_et1);
			a.setPositiveButton("factorial", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1)
				{
					int a,b=1;
					a=Integer.parseInt(t1.getText().toString());
					for(int i=1;i<=a;i++)
					{
						b=b*i;
						
						
					}
					Toast.makeText(MainActivity.this, "result is  "+b, Toast.LENGTH_LONG).show();
					LayoutInflater l=LayoutInflater.from(MainActivity.this);
					View v1 =l.inflate(R.layout.third, null);
					
					AlertDialog.Builder ab=new AlertDialog.Builder(MainActivity.this);
					ab.setView(v1);
					final EditText t2=(EditText)v1.findViewById(R.id.third_et1);
					t2.setText("result"+b);
					ab.setPositiveButton("ok", new op3());
					ab.setNegativeButton("cancel", new op4());
					ab.create();
					ab.show();
				}
				class op3 implements android.content.DialogInterface.OnClickListener
				{

					@Override
					public void onClick(DialogInterface arg0, int arg1)
					{
						arg0.cancel();
						
					}
					
				}
				class op4 implements android.content.DialogInterface.OnClickListener
				{

					@Override
					public void onClick(DialogInterface arg0, int arg1)
					{
						arg0.cancel();
						
					}
					
				}
				
			});
			a.setNegativeButton("cancle", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					arg0.cancel();
					
				}
			});
			a.create();
			a.show();
			
		}
    	
    }

}
