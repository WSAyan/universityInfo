package com.wsayan28.universityinfo;

import com.wsayan28.universityinfo.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
	    Thread StartPage = new Thread(){
	    	public void run() {
	            
	            try {
	                sleep(500);
	                 
	                Intent intent=new Intent(MainActivity.this,UniversityList.class);
	        		startActivity(intent);
	                //Remove activity
	                finish();
	                 
	            } catch (Exception e) {
	             e.printStackTrace();
	            }
	        }
	    };
	 // start thread
	    StartPage.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
