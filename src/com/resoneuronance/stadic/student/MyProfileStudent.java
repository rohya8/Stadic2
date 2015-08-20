package com.resoneuronance.stadic.student;

import com.resoneuronance.campus.web.bo.domain.Student;
import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MyProfileStudent extends Activity implements OnClickListener 
{

	private Button BtEditProfile,BtSaveProfile;
	private EditText EtEmail,EtPhone;
	private TextView TxChangePic,txName,txEmail;
	private Student currentStudent;
	
	ImageView profilePic;
	int position = 0;

	Uri selectImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_profile_student);

		ActionBar bar = getActionBar();								               //sets action bar colour
		//bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1e8bc3")));
		intialise();

		BtEditProfile.setOnClickListener(this);
		BtSaveProfile.setOnClickListener(this);
		TxChangePic.setOnClickListener(this);
	}

	private void intialise() 
	{
		currentStudent = StudentServerUtils.getCurrentStudent(this);
		
		txName = (TextView) findViewById(R.id.mystudent_profile_name_tv);
		txEmail = (TextView) findViewById(R.id.mystudent_profileemail);
		BtEditProfile=(Button) findViewById(R.id.mystudent_profile_edit_button);
		BtSaveProfile=(Button) findViewById(R.id.mystudent_profile_save_button);
		EtEmail=(EditText) findViewById(R.id.mystudent_profile_emailid_et);
		EtPhone=(EditText) findViewById(R.id.mystudent_profile_phoneno_et);
		TxChangePic=(TextView)findViewById(R.id.mystudent_profile_changepic_tv);
		profilePic = (ImageView)findViewById(R.id.mystudent_profile_image_iv);
		
		txName.setText(currentStudent.getName());
		txEmail.setText(currentStudent.getEmail());
	}

	@Override
	public void onClick(View vw) 
	{

		switch(vw.getId())
		{
		case R.id.mystudent_profile_edit_button:
			BtSaveProfile.setVisibility(View.VISIBLE);
			BtEditProfile.setVisibility(View.GONE);
			EtPhone.setEnabled(true);
			EtEmail.setEnabled(true);
			TxChangePic.setVisibility(View.VISIBLE);
			EtEmail.setFocusableInTouchMode(true);
			EtPhone.setFocusableInTouchMode(true);
			break;

		case R.id.mystudent_profile_save_button:
			BtEditProfile.setVisibility(View.VISIBLE);
			BtSaveProfile.setVisibility(View.GONE);
			TxChangePic.setVisibility(View.GONE);
			EtPhone.setEnabled(false);
			EtEmail.setEnabled(false);
			break;

		case R.id.mystudent_profile_changepic_tv:
			Intent i = new Intent(
					Intent.ACTION_PICK,
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

			startActivityForResult(i, position);
			break;

		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == position && resultCode == RESULT_OK && null != data) 
		{
			Uri selectedImage = data.getData();
			String[] filePathColumn = { MediaStore.Images.Media.DATA };

			Cursor cursor = getContentResolver().query(selectedImage,
					filePathColumn, null, null, null);
			cursor.moveToFirst();

			int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
			String picturePath = cursor.getString(columnIndex);
			cursor.close();

			ImageView imageView = (ImageView) findViewById(R.id.mystudent_profile_image_iv);
			imageView.setImageBitmap(BitmapFactory.decodeFile(picturePath));

		}


	}




}
