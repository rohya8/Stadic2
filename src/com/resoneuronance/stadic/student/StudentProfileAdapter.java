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

public class StudentProfileAdapter extends BaseAdapter 
{

	private ArrayList<String> name,notifyno;
	private ArrayList<Integer> image;
	Activity context;
	LayoutInflater inflater;

	public StudentProfileAdapter(StudentProfile studentProfile,
			ArrayList<String> objArrayListName, ArrayList<Integer> objArrayListImage, ArrayList<String> objArrayListNotifyno) 
	{

		this.name = objArrayListName;
		this.context=studentProfile;
		image=objArrayListImage;
		notifyno = objArrayListNotifyno;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() {
		return name.size();


	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public class ViewHolder
	{
		TextView NameTv,NotifyNotv;
		ImageView iv;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) 

	{

		ViewHolder holder;
		View view = convertView;

		if(view == null)
		{
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.activity_student__profile_adapter, null);
			holder.NameTv = (TextView)view.findViewById(R.id.studentprofile_adapter_textView);
			holder.iv=(ImageView)view.findViewById(R.id.student_profile_adapterimageView);
			holder.NotifyNotv=(TextView)view.findViewById(R.id.student_profile_notification_no_textView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.NameTv.setText(name.get(position));
		holder.iv.setImageResource(image.get(position));
		holder.NotifyNotv.setText(notifyno.get(position));

		return view;
	}
}
