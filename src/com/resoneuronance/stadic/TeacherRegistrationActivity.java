package com.resoneuronance.stadic;

import com.resoneuronance.stadic.activity.LoginMainActivity;
import com.resoneuronance.stadic.activity.student.StudentRegistrationActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class TeacherRegistrationActivity extends Activity {

	private AutoCompleteTextView collegename;
	private TextView TextviewLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_registration);

		initialise();

		TextviewLogin.setOnClickListener(new OnClickListener() {


			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(TeacherRegistrationActivity.this,LoginMainActivity.class);
				startActivity(intent);

			}
		});

	}

	private void initialise() {


		TextviewLogin=(TextView) findViewById(R.id.teacher_registeration_login_textview);
	}


}
