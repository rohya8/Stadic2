package com.resoneuronance.stadic.activity.teacher;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.activity.student.StudentNotificationsTabActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TeacherLoginTabActivity extends Activity implements OnClickListener {

	private Button BtTeacherSubmit;
	private EditText EtTeacherUserName,EtTeacherPassword;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacherlogintab);

		initialise();


		BtTeacherSubmit.setOnClickListener(this);

	}



	private void initialise() {



		EtTeacherUserName=(EditText) findViewById(R.id.editTextTeacherUsername);
		EtTeacherPassword=(EditText) findViewById(R.id.editTextTeacherPassword);


		BtTeacherSubmit=(Button) findViewById(R.id.buttonTeacherSubmit);



	}






	@Override
	public void onClick(View view) {

		Intent intent=null;

		switch (view.getId()) {
		case R.id.buttonTeacherSubmit:
			intent=new Intent(TeacherLoginTabActivity.this,TeacherSendNotificationActivity.class);
			startActivity(intent);
			break;



		}

	}

}
