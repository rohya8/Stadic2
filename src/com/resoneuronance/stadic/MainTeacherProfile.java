package com.resoneuronance.stadic;

import com.resoneuronance.stadic.student.MainStudentProfile;
import com.resoneuronance.stadic.student.MyProfileStudent;
import com.resoneuronance.stadic.student.StudentProfile;
import com.resoneuronance.stadic.student.StudentProfileOptions;
import com.resoneuronance.stadic.teacher.TeacherProfile;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainTeacherProfile extends TabActivity 
{

	private TabHost tabHostStudentProfile;
	private TabSpec tabProfile,tabNotification,tabSetting;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_teacher_profile);

		TeacherProfiletab();

	}

	private void TeacherProfiletab() 
	{
		// TODO Auto-generated method stub

		Resources ressources = getResources(); 

		tabHostStudentProfile=getTabHost(); 


		tabProfile = tabHostStudentProfile.newTabSpec("First Tab");
		tabNotification = tabHostStudentProfile.newTabSpec("Second Tab");
		tabSetting = tabHostStudentProfile.newTabSpec("Third Tab");

		tabHostStudentProfile.getTabWidget().setDividerDrawable(null);
		// Set the Tab name and Activity
		// that will be opened when particular Tab will be selected

		tabProfile.setIndicator("",ressources.getDrawable(R.drawable.silhouette121) );
		tabProfile.setContent(new Intent(MainTeacherProfile.this,MyProfileTeacher.class));

		tabNotification.setIndicator("",ressources.getDrawable(R.drawable.notifications) );
		tabNotification.setContent(new Intent(MainTeacherProfile.this,TeacherProfile.class));

		tabSetting.setIndicator("",ressources.getDrawable(R.drawable.gear39) );
		tabSetting.setContent(new Intent(MainTeacherProfile.this,StudentProfileOptions.class));


		tabHostStudentProfile.addTab(tabProfile);
		tabHostStudentProfile.addTab(tabNotification);
		tabHostStudentProfile.addTab(tabSetting);

 
	}
}
