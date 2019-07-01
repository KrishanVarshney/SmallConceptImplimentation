package com.example.voice_commond;

import java.util.Locale;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity 
{
	EditText et1;
	Button b1;
	TextToSpeech tts;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tts=new TextToSpeech(MainActivity.this, new b());
        et1=(EditText)findViewById(R.id.editText1);
        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(new a());
    }
    class a implements OnClickListener
    {

		@Override
		public void onClick(View arg0)
		{
			speakOut();			
		}
    }
    private void speakOut()
    {
    	String text=et1.getText().toString();
    	tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }
    class b implements TextToSpeech.OnInitListener
    {

		@Override
		public void onInit(int arg0) 
		{
			if(arg0==TextToSpeech.SUCCESS)
			{
				int result=tts.setLanguage(Locale.UK);
				if(result==TextToSpeech.LANG_MISSING_DATA ||result == TextToSpeech.LANG_NOT_SUPPORTED)
				{
					Toast.makeText(MainActivity.this, "this LANGUAGE is not SUPPORTED", Toast.LENGTH_LONG).show();
					
				}
				else
				{
					b1.setEnabled(true);
					speakOut();
				}
			}
			else
			{
				Toast.makeText(MainActivity.this, "Initialization Failed", Toast.LENGTH_LONG).show();
				
			}
			
			
		}
    	
    }
    @Override
    protected void onDestroy() 
    {
    	if(tts!=null)
    	{
    		tts.stop();
    		tts.shutdown();
    	}
    	super.onDestroy();
    }

}
