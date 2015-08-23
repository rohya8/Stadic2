package com.resoneuronance.stadic.activity;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.activity.student.StudentLoginTabActivity;
import com.resoneuronance.stadic.activity.teacher.TeacherLoginTabActivity;

public class LoginMainActivity extends TabActivity {

	private TabHost tabHostloginmain;
	private TabSpec tabStudent,tabTeacher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {


		super.onCreate(savedInstanceState);

		//Hello world
		setContentView(R.layout.activity_login_main);

		initialise();

		logintab();

	}

	private void logintab() {

		Resources ressources = getResources(); 

		tabTeacher = tabHostloginmain.newTabSpec("First Tab");
		tabStudent = tabHostloginmain.newTabSpec("Second Tab");

		tabHostloginmain.getTabWidget().setDividerDrawable(null);
		// Set the Tab name and Activity
		// that will be opened when particular Tab will be selected
		Log.d("abc","xyz");

		tabStudent.setIndicator("Student");
		tabStudent.setContent(new Intent(LoginMainActivity.this,StudentLoginTabActivity.class));

		tabTeacher.setIndicator("Teacher");
		tabTeacher.setContent(new Intent(LoginMainActivity.this,TeacherLoginTabActivity.class));


		/** Add the tabs  to the TabHost to display. */
		tabHostloginmain.addTab(tabTeacher);
		tabHostloginmain.addTab(tabStudent);

	}

	private void initialise() {

		tabHostloginmain = (TabHost)findViewById(android.R.id.tabhost);
		/*new AsyncTask<Void, Void, String>() {
			protected String doInBackground(Void[] params) {
				CoreServerUtils.getAllColleges();
				return "Got Colleges!";
			};

			protected void onPostExecute(String result) {
				Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
			};
		}.execute(null, null, null);*/
	}

}