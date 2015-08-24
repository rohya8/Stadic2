package com.resoneuronance.stadic.activity.teacher;

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

public class TeacherDepartmentActivity extends Activity implements OnClickListener {

	Button BtAddDepartment,BtMyDepartment;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_department);

		initialise();

		BtAddDepartment.setOnClickListener(this);
		BtMyDepartment.setOnClickListener(this);
	}


	private void initialise() {

		BtAddDepartment=(Button) findViewById(R.id.teacher_department_activity_Adddepartment_button);
		BtMyDepartment=(Button) findViewById(R.id.teacher_department_activity_Mydepartment_button);

	}


	@Override
	public void onClick(View view) {

		Intent i;

		switch(view.getId())
		{
		case R.id.teacher_department_activity_Mydepartment_button:
			i = new Intent(TeacherDepartmentActivity.this,TeacherDepartmentNotificationActivity.class);
			startActivity(i);
			break;

		case R.id.teacher_department_activity_Adddepartment_button:
		/////
			
			i = new Intent(TeacherDepartmentActivity.this,TeacherSendNotificationActivity.class);
			startActivity(i);
			break;


		}


	}

}
