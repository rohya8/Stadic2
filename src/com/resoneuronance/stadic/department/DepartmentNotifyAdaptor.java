package com.resoneuronance.stadic.department;

import java.util.ArrayList;

import com.resoneuronance.stadic.R;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class DepartmentNotifyAdaptor extends BaseAdapter 
{

	private ArrayList<String> name,notify_no;
	private ArrayList<Integer> image;
	Activity context;
	LayoutInflater inflater;


	public DepartmentNotifyAdaptor(DepartmentNotify departmentnotify,
			ArrayList<String> objArrayListName,
			ArrayList<String> objArrayListNotify_no) 
	{
		// TODO Auto-generated constructor stub
		this.name = objArrayListName;
		this.context=departmentnotify;

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

	}

	public View getView(int position, View convertView, ViewGroup parent) 

	{

		ViewHolder holder;
		View view = convertView;

		if(view == null)
		{
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.activity_department__notify_customclass, null);
			holder.name_tv = (TextView)view.findViewById(R.id.departmentnotify_customclass_textView);
			//holder.iv=(ImageView)view.findViewById(R.id.departmentnotify_customimageView);
			holder.notify_no_tv=(TextView)view.findViewById(R.id.departmentnotify_notification_no_textView);
			view.setTag(holder);
		}
		else
			holder = (ViewHolder)view.getTag();

		holder.name_tv.setText(name.get(position));
		//holder.iv.setImageResource(image.get(position));
		holder.notify_no_tv.setText(notify_no.get(position));
		// TODO Auto-generated method stub
		return view;

	}




}
