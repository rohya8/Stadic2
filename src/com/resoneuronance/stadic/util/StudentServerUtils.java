package com.resoneuronance.stadic.util;

import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.google.gson.Gson;
import com.resoneuronance.campus.web.domain.Student;
import com.resoneuronance.campus.web.util.Constants;

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
		Log.d(TAG, "Result of Login :" + result);
		return result;
	}
	
}
