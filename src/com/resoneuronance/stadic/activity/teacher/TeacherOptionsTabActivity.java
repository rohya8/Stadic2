package com.resoneuronance.stadic.activity.teacher;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.activity.student.StudentDepartmentActivity;
import com.resoneuronance.stadic.activity.student.StudentTeacherActivity;
import com.resoneuronance.stadic.activity.student.StudentOptionsTabActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TeacherOptionsTabActivity extends Activity implements OnClickListener {

	private Button BtDepartment;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_options_tab);

		initialise();

		BtDepartment.setOnClickListener(this);

	}

	private void initialise() {

		BtDepartment=(Button) findViewById(R.id.teacher_options_tabactivity_deparment_button);

	}


	@Override
	public void onClick(View view) {

		switch(view.getId())
		{
		case R.id.teacher_options_tabactivity_deparment_button:
			Intent i = new Intent(TeacherOptionsTabActivity.this,TeacherDepartmentActivity.class);
			startActivity(i);
			break;


		}


	}
}
