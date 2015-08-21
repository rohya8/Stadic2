package com.resoneuronance.stadic.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.resoneuronance.campus.web.bo.domain.StudentTeacher;
import com.resoneuronance.campus.web.domain.Notification;
import com.resoneuronance.campus.web.domain.Student;
import com.resoneuronance.campus.web.util.Constants;
import com.resoneuronance.stadic.main.AndroidConstants;
import com.resoneuronance.stadic.main.CoreServerUtils;

public class StudentServerUtils implements AndroidConstants {

	private static String LOGIN_URL = "http://192.168.1.104:8080/CampusWebApp/loginStudentAndroid?student={student}&collegeName={collegeName}";
	private static String result = "";
	public static int teacherId = 0;
	
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
	
	public static void storeCurrentStudent(Context context, String student) {
		SharedPreferences prefs = context.getSharedPreferences(STUDENT_PREFERENCES, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putString(STUDENT_OBJECT, student);
		editor.putBoolean(LOGGED_IN, true);
		editor.commit();
		Log.d(TAG, "Saved the Student!!");
	}
	
	public static com.resoneuronance.campus.web.bo.domain.Student getCurrentStudent(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(STUDENT_PREFERENCES, Context.MODE_PRIVATE);
		String studentJson = prefs.getString(STUDENT_OBJECT, null);
		com.resoneuronance.campus.web.bo.domain.Student student = new com.resoneuronance.campus.web.bo.domain.Student();
		if(studentJson != null) {
			student = new Gson().fromJson(studentJson, com.resoneuronance.campus.web.bo.domain.Student.class);
			Log.d(TAG, "Got the Student!!");
		}
		return student;
	}
	
	public static List<Notification> getTeacherNotifications(Activity context) {
		List<Notification> notifications = new ArrayList<Notification>();
		com.resoneuronance.campus.web.bo.domain.Student student = getCurrentStudent(context);
		for(StudentTeacher teacher:student.getTeachers()) {
			if(teacher!=null && teacher.getId() == teacherId) {
				notifications = teacher.getNotifications();
				break;
			}
		}
		return notifications;
	}
	
}
