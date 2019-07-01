package com.example.searchlistdemo;

import java.util.ArrayList;
import java.util.HashMap;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends ActionBarActivity 
{
	 private ListView lv;
     ArrayAdapter<String> adapter;
     EditText inputSearch;
     ArrayList<HashMap<String, String>> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        String products[] = {"computer",
                "androide",
                "Php",
                "java",
                "asp.net",
                "python",
                "c++"};
        lv = (ListView) findViewById(R.id.listView1);
        inputSearch = (EditText) findViewById(R.id.editText1);
        
        
        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.textView1, products);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() 
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                String s=adapterView.getAdapter().getItem(i).toString();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }
        });
        
        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                MainActivity.this.adapter.getFilter().filter(cs);
            }

            

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }



			@Override
			public void afterTextChanged(Editable arg0) {
				// TODO Auto-generated method stub
				
			}


        });

    }

}
