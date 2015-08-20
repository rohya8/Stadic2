package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.layout;
import com.resoneuronance.stadic.department.DepartmentNotifyAdaptor.ViewHolder;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class AddStudentDepartmentAdapter extends BaseAdapter {


	private ArrayList<String> name;
	private ArrayList<Integer> image;
	Activity context;
	LayoutInflater inflater;

	public AddStudentDepartmentAdapter(AddStudentDepartment addStudDepartment,
			ArrayList<String> objArrayListName) {
		this.name = objArrayListName;
		this.context=addStudDepartment;

		inflater = LayoutInflater.from(context);

	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return name.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int arg0) {
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
			view = inflater.inflate(R.layout.activity_add_student__department_adapter, null);
			holder.name_tv = (TextView)view.findViewById(R.id.addstudent_department_customclass_textView);
			//holder.iv=(ImageView)view.findViewById(R.id.departmentnotify_customimageView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.name_tv.setText(name.get(position));
		//holder.iv.setImageResource(image.get(position));
		// TODO Auto-generated method stub
		return view;

	}

}
