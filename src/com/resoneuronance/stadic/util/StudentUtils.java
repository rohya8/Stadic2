package com.resoneuronance.stadic.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.resoneuronance.campus.web.bo.domain.Student;
import com.resoneuronance.campus.web.bo.domain.StudentTeacher;
import com.resoneuronance.campus.web.domain.Notification;

public class StudentUtils implements AndroidConstants {
	

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
			if(teacher!=null && teacher.getId() == getCurrentTeacherId(context)) {
				notifications = teacher.getNotifications();
				break;
			}
		}
		return notifications;
	}

	private static int getCurrentTeacherId(Context context) {
		SharedPreferences prefs = context.getSharedPreferences(STUDENT_PREFERENCES, Context.MODE_PRIVATE);
		int teacherId = prefs.getInt(TEACHER_ID, 0);
		return teacherId;
	}
	
	public static void storeCurrentTeacherId(Context context,int teacherId) {
		SharedPreferences prefs = context.getSharedPreferences(STUDENT_PREFERENCES, Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = prefs.edit();
		editor.putInt(TEACHER_ID, teacherId);
		editor.commit();
	}

	public static String getTeacherName(int id,Context context) {
		if(CollectionUtils.isEmpty(getCurrentStudent(context).getTeachers())) {
			return "";
		}
		for(StudentTeacher teacher:getCurrentStudent(context).getTeachers()) {
			if(teacher!=null && id == teacher.getId()) {
				return teacher.getName();
			}
		}
		return "";
	}

	public static void addNotification(Notification notification,Context ctx) {
		Student student = getCurrentStudent(ctx);
		Log.d(TAG, "Got the Student :" + student.getName() + " Teachers :" + student.getTeachers());
		if(CollectionUtils.isEmpty(student.getTeachers())) {
			return;
		}
		for(StudentTeacher teacher:getCurrentStudent(ctx).getTeachers()) {
			if(teacher!=null && notification.getTeacherId() == teacher.getId()) {
				teacher.getNotifications().add(notification);
				return;
			}
		}
		storeCurrentStudent(ctx, new Gson().toJson(student));
	}
	
}
