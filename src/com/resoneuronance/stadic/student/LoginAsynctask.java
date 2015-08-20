package com.resoneuronance.stadic.student;

import com.resoneuronance.campus.web.util.Constants;
import com.resoneuronance.stadic.main.StudentloginTab;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;


public class LoginAsynctask extends AsyncTask<String, String, String> {

	Activity mlogin;
	ProgressDialog progressdialog;
	private String username,password,response=null;
	private String collegeName;


	public LoginAsynctask(Activity mainActivity) {

		mlogin=mainActivity;
		progressdialog=new ProgressDialog(mlogin);

	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		progressdialog.setMessage("Please Wait...");
		//pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressdialog.setCancelable(false);
		progressdialog.show();
	}

	@Override
	protected String doInBackground(String... args) {
		username=args[0];
		password=args[1];
		collegeName = args[2];
		return StudentServerUtils.studentLogin(username, password, collegeName);
	}


	/*public void run() {
		for (int i = 0; i <= 10; i++) {
			final int value = i;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}*/

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		progressdialog.dismiss();
		if(!result.equalsIgnoreCase(Constants.RESPONSE_INVALID)){
			Toast.makeText(mlogin, "Login Successfull !!!", Toast.LENGTH_LONG).show();
			Intent i=new Intent(mlogin,MainStudentProfile.class);
			StudentServerUtils.storeCurrentStudent(mlogin, result);
			mlogin.startActivity(i);

		}
		else
		{
			Toast.makeText(mlogin, "Invalid Credentials", Toast.LENGTH_LONG).show();
		}
	}

}
