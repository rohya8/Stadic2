package com.resoneuronance.stadic.activity.student;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.activity.LoginMainActivity;

public class StudentRegistrationActivity extends Activity {

	private TextView TvLogin;
	
	private AutoCompleteTextView collegename;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_registration);
		initialise();


		TvLogin.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(StudentRegistrationActivity.this,LoginMainActivity.class);
				startActivity(intent);

			}
		});

	}


	private void initialise() {


		TvLogin=(TextView) findViewById(R.id.student_registeration_login_textview);
	}




}
