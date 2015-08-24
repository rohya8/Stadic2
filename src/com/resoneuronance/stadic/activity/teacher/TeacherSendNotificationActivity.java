package com.resoneuronance.stadic.activity.teacher;

import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.resoneuronance.stadic.R;

public class TeacherSendNotificationActivity extends Activity {

	private EditText EtMessage;

	private Button BtType,BtYear,BtDepartment;

	private	ImageButton IbSend,IbAttachment;
	final Context context = this;
	private AlertDialog levelDialog;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_teacher_profile);

		initialise();

		IbAttachment.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v)
			{
				// TODO Auto-generated method stub

				Intent i = new Intent();
				i.setAction(Intent.ACTION_GET_CONTENT);
				i.setType("file/*");
				startActivity(i);

			}


		});

		IbSend.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub

				Toast.makeText(getApplicationContext(), "Message send successfully",Toast.LENGTH_SHORT).show();

			}
		});


		BtType.setOnClickListener(new OnClickListener() 
		{


			@Override
			public void onClick(View v) 
			{

				alertSimpleTypeListView();

			}
		});


		BtYear.setOnClickListener(new OnClickListener() 
		{


			@Override
			public void onClick(View v) 
			{

				alertSimpleYearListView();



			}
		});


		BtDepartment.setOnClickListener(new OnClickListener() 
		{


			@Override
			public void onClick(View v) 
			{

				alertSimpleDepartmentListView();




			}
		});


	}

	protected void alertSimpleTypeListView() 
	{
		// TODO Auto-generated method stub

		final CharSequence[] items = { "Notes", "Assignment" ,"Other"};

		AlertDialog.Builder builder = new AlertDialog.Builder(TeacherSendNotificationActivity.this);
		builder.setTitle("Make your selection");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {

				// will toast your selection
				//showToast("Name: " + items[item]);
				BtType.setText(""+items[item].toString());

				dialog.dismiss();

			}
		}).show();

	}

	protected void alertSimpleYearListView() 
	{
		// TODO Auto-generated method stub

		final CharSequence[] items = { "FE", "SE", "TE", "BE" };

		AlertDialog.Builder builder = new AlertDialog.Builder(TeacherSendNotificationActivity.this);
		builder.setTitle("Make your selection");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {

				BtYear.setText(""+items[item].toString());
				dialog.dismiss();

			}
		}).show();

	}

	protected void alertSimpleDepartmentListView() 
	{
		// TODO Auto-generated method stub

		final CharSequence[] items = { "IT","EnTC" ,"Computer", "Electrical", "Mechanical" };

		AlertDialog.Builder builder = new AlertDialog.Builder(TeacherSendNotificationActivity.this);
		builder.setTitle("Make your selection");
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {

				BtDepartment.setText(""+items[item].toString());
				dialog.dismiss();

			}
		}).show();

	}


	private void initialise() {

		BtType = (Button)findViewById(R.id.teacher_sendnotification_type_button);
		BtYear = (Button)findViewById(R.id.teacher_sendnotification_year_button);
		BtDepartment = (Button)findViewById(R.id.teacher_sendnotification_department_button);


		EtMessage = (EditText)findViewById(R.id.teacher_sendnotification_sendmessage_editText);
		IbSend = (ImageButton)findViewById(R.id.teacher_sendnotification_Send_ImageButton);
		IbAttachment = (ImageButton)findViewById(R.id.teacher_sendnotification_Attachment_IamgeButton);

	}

}
