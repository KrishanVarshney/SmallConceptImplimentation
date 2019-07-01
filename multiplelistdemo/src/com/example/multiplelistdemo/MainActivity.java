package com.example.multiplelistdemo;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity {

	 ListView list;
	 ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       list=(ListView) findViewById(R.id.listView1);
        Button b1=(Button)findViewById(R.id.button1);
        
		
		
        String[] values = new String[] { "a","b","c","d","e"};
        
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice, values);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        list.setAdapter(adapter);
        
        b1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) 
			{
				SparseBooleanArray checked = list.getCheckedItemPositions();
		        ArrayList<String> selectedItems = new ArrayList<String>();
		        for (int i = 0; i < checked.size(); i++) {
		            
		            int position = checked.keyAt(i);
		            if (checked.valueAt(i))
		                selectedItems.add(adapter.getItem(position));
		        }
		 
		        String[] outputStrArr = new String[selectedItems.size()];
		 
		        for (int i = 0; i < selectedItems.size(); i++) {
		            outputStrArr[i] = selectedItems.get(i);
		            Toast.makeText(MainActivity.this, ""+outputStrArr[i], Toast.LENGTH_SHORT).show();
		        }
		        
		        
				
			}
		});
        
        



                                       


       
    }

}
