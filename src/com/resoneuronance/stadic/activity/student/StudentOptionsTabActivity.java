package com.resoneuronance.stadic.activity.student;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class StudentOptionsTabActivity extends Activity implements OnClickListener {

	private Button BtTeacher,BtDept;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_profile_options);

		initialise();

		BtDept.setOnClickListener(this);
		BtTeacher.setOnClickListener(this);

	}

	private void initialise() {

		BtTeacher=(Button) findViewById(R.id.student_profile_teachr_button);
		BtDept=(Button) findViewById(R.id.student_profile_deparment_button);

	}


	@Override
	public void onClick(View view) {

		switch(view.getId())
		{
		case R.id.student_profile_deparment_button:
			Intent i = new Intent(StudentOptionsTabActivity.this,StudentDepartmentActivity.class);
			startActivity(i);
			break;

		case R.id.student_profile_teachr_button:
			Intent i1 = new Intent(StudentOptionsTabActivity.this,StudentTeacherActivity.class);
			startActivity(i1);

			break;

		}


	}
}
