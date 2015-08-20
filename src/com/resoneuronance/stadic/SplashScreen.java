package com.resoneuronance.stadic;

import com.resoneuronance.stadic.main.LoginMain;
import com.resoneuronance.stadic.student.AddStudentTeacher;
import com.resoneuronance.stadic.student.MainStudentProfile;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class SplashScreen extends Activity 
{

	Typeface roboto;
	TextView name;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		name = (TextView)findViewById(R.id.splash_stadic_textview);

		roboto = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
		name.setTypeface(roboto);


		Thread thread = new Thread() 
		{


			public void run() {

				try {
					sleep(2000);

					Intent i = new Intent(SplashScreen.this,AddStudentTeacher.class);
					startActivity(i);

					//startActivity(new Intent(getApplicationContext(),AddStudentTeacher.class));

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


			}


		};

		thread.start();

	}
}
