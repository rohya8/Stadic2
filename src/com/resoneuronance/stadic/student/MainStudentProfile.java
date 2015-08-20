package com.resoneuronance.stadic.student;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.drawable;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.main.AdminLoginTab;
import com.resoneuronance.stadic.main.LoginMain;
import com.resoneuronance.stadic.main.StudentloginTab;
import com.resoneuronance.stadic.main.TeacherLoginTab;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainStudentProfile extends TabActivity {


	private TabHost tabHostStudentProfile;
	private TabSpec tabProfile,tabNotification,tabSetting;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_student_profile);
		String abc;

		StudentProfiletab();

	}

	private void StudentProfiletab() {

		Resources resources = getResources(); 

		tabHostStudentProfile=getTabHost(); 


		tabProfile = tabHostStudentProfile.newTabSpec("First Tab");




		tabNotification = tabHostStudentProfile.newTabSpec("Second Tab");
		tabSetting = tabHostStudentProfile.newTabSpec("Third Tab");

		tabHostStudentProfile.getTabWidget().setDividerDrawable(null);
		// Set the Tab name and Activity
		// that will be opened when particular Tab will be selected

		tabProfile.setIndicator("",resources.getDrawable(R.drawable.silhouette121) );
		tabProfile.setContent(new Intent(MainStudentProfile.this,MyProfileStudent.class));

		tabNotification.setIndicator("",resources.getDrawable(R.drawable.notifications) );
		tabNotification.setContent(new Intent(MainStudentProfile.this,StudentProfile.class));

		tabSetting.setIndicator("",resources.getDrawable(R.drawable.gear39) );
		tabSetting.setContent(new Intent(MainStudentProfile.this,StudentProfileOptions.class));


		tabHostStudentProfile.addTab(tabProfile);
		tabHostStudentProfile.addTab(tabNotification);
		tabHostStudentProfile.addTab(tabSetting);

	}


}
