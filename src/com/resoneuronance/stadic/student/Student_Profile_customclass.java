package com.resoneuronance.stadic.student;

import java.util.ArrayList;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;

public class Student_Profile_customclass extends BaseAdapter 
{

	private ArrayList<String> name,notify_no;
	private ArrayList<Integer> image;
	Activity context;
	LayoutInflater inflater;

	public Student_Profile_customclass(StudentProfile studentProfile,
			ArrayList<String> objArrayListName, ArrayList<Integer> objArrayListImage, ArrayList<String> objArrayListNotify_no) 
	{
		// TODO Auto-generated constructor stub

		Log.d("sdsd","sdsd");
		this.name = objArrayListName;
		this.context=studentProfile;
		image=objArrayListImage;
		notify_no = objArrayListNotify_no;
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
		ImageView iv;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 

	{

		Log.d("sdsd","sdsd");
		ViewHolder holder;
		View view = convertView;

		if(view == null)
		{
			Log.d("sdsd","sdsd");
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.activity_student__profile_customclass, null);
			holder.name_tv = (TextView)view.findViewById(R.id.studentprofile_customclass_textView);
			holder.iv=(ImageView)view.findViewById(R.id.student_profile_customimageView);
			holder.notify_no_tv=(TextView)view.findViewById(R.id.student_profile_notification_no_textView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.name_tv.setText(name.get(position));
		holder.iv.setImageResource(image.get(position));
		holder.notify_no_tv.setText(notify_no.get(position));
		// TODO Auto-generated method stub

		return view;
	}
}
