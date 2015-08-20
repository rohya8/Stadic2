package com.resoneuronance.stadic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.resoneuronance.stadic.main.LoginMain;
import com.resoneuronance.stadic.student.MainStudentProfile;
import com.resoneuronance.stadic.student.StudentServerUtils;

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
		
		if(StudentServerUtils.getCurrentStudent(this).getName() == null) {
			new GetCollegesAsyncTask(this,LoginMain.class).execute(null,null,null);
		}
		else {
			Intent i = new Intent(this, MainStudentProfile.class);
			startActivity(i);
		}
	}
}
