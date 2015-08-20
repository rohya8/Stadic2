package com.resoneuronance.stadic.main;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.Toast;

import com.resoneuronance.stadic.R;

public class LoginMain extends TabActivity {

	private TabHost tabHostloginmain;
	private TabSpec tabAdmin,tabStudent,tabTeacher;

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

		tabAdmin = tabHostloginmain.newTabSpec("First Tab");
		tabStudent = tabHostloginmain.newTabSpec("Second Tab");
		tabTeacher = tabHostloginmain.newTabSpec("Third Tab");

		tabHostloginmain.getTabWidget().setDividerDrawable(null);
		// Set the Tab name and Activity
		// that will be opened when particular Tab will be selected
		Log.d("abc","xyz");

		tabAdmin.setIndicator("Admin");
		tabAdmin.setContent(new Intent(LoginMain.this,AdminLoginTab.class));

		tabStudent.setIndicator("Student");
		tabStudent.setContent(new Intent(LoginMain.this,StudentloginTab.class));

		tabTeacher.setIndicator("Teacher");
		tabTeacher.setContent(new Intent(LoginMain.this,TeacherLoginTab.class));


		/** Add the tabs  to the TabHost to display. */
		tabHostloginmain.addTab(tabAdmin);
		tabHostloginmain.addTab(tabStudent);
		tabHostloginmain.addTab(tabTeacher);

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