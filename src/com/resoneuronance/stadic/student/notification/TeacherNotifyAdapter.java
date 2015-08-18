package com.resoneuronance.stadic.student.notification;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;
import com.resoneuronance.stadic.R.id;
import com.resoneuronance.stadic.R.layout;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TeacherNotifyAdapter extends BaseAdapter
{

	private ArrayList<String> name,notify_no;
	private ArrayList<Integer> image;
	Activity context;
	LayoutInflater inflater;


	public TeacherNotifyAdapter(TeacherNotify teacherNotify,
			ArrayList<String> objArrayListName,
			ArrayList<Integer> objArrayListImage,
			ArrayList<String> objArrayListNotify_no) 
	{
		// TODO Auto-generated constructor stub

		this.name = objArrayListName;
		this.context=teacherNotify;
		image=objArrayListImage;
		notify_no = objArrayListNotify_no;
		inflater = LayoutInflater.from(context);

	}

	@Override
	public int getCount() 
	{
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

		ViewHolder holder;
		View view = convertView;

		if(view == null)
		{
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.activity_teacher_notification_list_adapter, null);
			holder.name_tv = (TextView)view.findViewById(R.id.teachernotificationlist_adapter_textView);
			holder.iv=(ImageView)view.findViewById(R.id.teachernotificationlist_adapter_imageView);
			holder.notify_no_tv=(TextView)view.findViewById(R.id.teachernotificationlist_adapter_notification_no_textView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.name_tv.setText(name.get(position));
		holder.iv.setImageResource(image.get(position));
		holder.notify_no_tv.setText(notify_no.get(position));
		return view;

	}

}
