package com.resoneuronance.stadic.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.activity.student.StudentMainActivity;
import com.resoneuronance.stadic.task.GetCollegesAsyncTask;
import com.resoneuronance.stadic.util.GCMUtil;
import com.resoneuronance.stadic.util.StudentServerUtils;

public class SplashScreenActivity extends Activity 
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
			new GetCollegesAsyncTask(this,LoginMainActivity.class).execute(null,null,null);
		}
		else {
			//GCMUtil.registerGCM(this);
			Intent i = new Intent(this, StudentMainActivity.class);
			startActivity(i);
		}
	}
}
