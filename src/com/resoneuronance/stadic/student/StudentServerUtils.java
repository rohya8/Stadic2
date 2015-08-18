package com.resoneuronance.stadic.student;

import java.util.HashMap;
import java.util.Map;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.resoneuronance.campus.web.domain.Student;
import com.resoneuronance.campus.web.util.Constants;
import com.resoneuronance.stadic.main.AndroidConstants;
import com.resoneuronance.stadic.main.CoreServerUtils;

public class StudentServerUtils implements AndroidConstants {

	private static String LOGIN_URL = "http://192.168.1.104:8080/CampusWebApp/loginStudentAndroid?student={student}&collegeName={collegeName}";
	private static String result = "";
	
	public static String studentLogin(String email,String password,String collegeName) {
		Student student = new Student();
		student.setEmail(email);
		student.setPassword(password);
		final Map<String, Object> uriVariables = new HashMap<String, Object>();
		String jsonString = new Gson().toJson(student);
		uriVariables.put(Constants.STUDENT_OBJECT, jsonString);
		uriVariables.put(Constants.COLLEGE_NAME_ATTR, collegeName);
		result = CoreServerUtils.postServerCall(LOGIN_URL, uriVariables).getBody();
		/*AsyncTask<Void, Void, String> studentLoginTask = new AsyncTask<Void, Void, String>() {
			
			@Override
			protected String doInBackground(Void... params) {
				result = CoreServerUtils.postServerCall(LOGIN_URL, uriVariables).getBody();
				return result;
			}

			@Override
			protected void onPostExecute(String msg) {
				//Toast.makeText(context,"Logged In!", Toast.LENGTH_LONG).show();
				Log.d(TAG, msg);
			}
		};
		studentLoginTask.execute(null, null, null);*/
		Log.d(TAG, "Result of Login :" + result);
		return result;
	}
	
}
