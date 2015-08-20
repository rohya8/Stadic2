package com.resoneuronance.stadic.student;

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

public class StudentProfileOptions extends Activity implements OnClickListener {

	private Button BtAddTeacher,BtAddDept;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_student_profile_options);

		initialise();

		BtAddDept.setOnClickListener(this);
		BtAddTeacher.setOnClickListener(this);

	}

	private void initialise() {

		BtAddTeacher=(Button) findViewById(R.id.student_profile_Addteachr_button);
		BtAddDept=(Button) findViewById(R.id.student_profile_Adddeparment_button);

	}


	@Override
	public void onClick(View view) {

		switch(view.getId())
		{
		case R.id.student_profile_Adddeparment_button:
			Intent i = new Intent(StudentProfileOptions.this,AddStudentDepartment.class);
			startActivity(i);
			break;

		case R.id.student_profile_Addteachr_button:
			Intent i1 = new Intent(StudentProfileOptions.this,AddStudentTeacher.class);
			startActivity(i1);

			break;

		}


	}
}
