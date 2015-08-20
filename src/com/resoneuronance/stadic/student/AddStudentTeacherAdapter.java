package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.student.AddStudentDepartmentAdapter.ViewHolder;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class AddStudentTeacherAdapter extends BaseAdapter {

	private ArrayList<String> name;
	private ArrayList<Integer> image;
	Activity context;
	LayoutInflater inflater;

	public AddStudentTeacherAdapter(AddStudentTeacher addStudTeacher,
			ArrayList<String> objArrayListName) {
		this.name = objArrayListName;
		this.context=addStudTeacher;

		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public class ViewHolder
	{
		TextView name_tv,notify_no_tv;

	}

	public View getView(int position, View convertView, ViewGroup parent) 

	{

		ViewHolder holder;
		View view = convertView;

		if(view == null)
		{
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.activity_add_student_teacher_adapter, null);
			holder.name_tv = (TextView)view.findViewById(R.id.addstudent_teacher_adapter_textView);
			//holder.iv=(ImageView)view.findViewById(R.id.departmentnotify_customimageView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.name_tv.setText(name.get(position));
		return view;

	}

}
