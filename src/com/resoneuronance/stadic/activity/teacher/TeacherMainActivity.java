package com.resoneuronance.stadic.activity.teacher;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.drawable;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.activity.student.StudentMainActivity;
import com.resoneuronance.stadic.activity.student.StudentNotificationsTabActivity;
import com.resoneuronance.stadic.activity.student.StudentOptionsTabActivity;
import com.resoneuronance.stadic.activity.student.StudentProfileTabActivity;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TeacherMainActivity extends TabActivity 
{

	private TabHost tabHostTeacherProfile;
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

		tabHostTeacherProfile=getTabHost(); 


		tabProfile = tabHostTeacherProfile.newTabSpec("First Tab");
		tabNotification = tabHostTeacherProfile.newTabSpec("Second Tab");
		tabSetting = tabHostTeacherProfile.newTabSpec("Third Tab");

		tabHostTeacherProfile.getTabWidget().setDividerDrawable(null);
		// Set the Tab name and Activity
		// that will be opened when particular Tab will be selected

		tabProfile.setIndicator("",ressources.getDrawable(R.drawable.silhouette121) );
		tabProfile.setContent(new Intent(TeacherMainActivity.this,TeacherProfileTabActivity.class));

		tabNotification.setIndicator("",ressources.getDrawable(R.drawable.notifications) );
		tabNotification.setContent(new Intent(TeacherMainActivity.this,TeacherSendNotificationActivity.class));

		tabSetting.setIndicator("",ressources.getDrawable(R.drawable.gear39) );
		tabSetting.setContent(new Intent(TeacherMainActivity.this,TeacherOptionsTabActivity.class));


		tabHostTeacherProfile.addTab(tabProfile);
		tabHostTeacherProfile.addTab(tabNotification);
		tabHostTeacherProfile.addTab(tabSetting);


	}
}
