package com.resoneuronance.stadic.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageDownloadAsynctask extends AsyncTask<String, Void, Bitmap> {

	private Context mcont;
	ProgressDialog mProgressDialog;
	Bitmap bitmap;
	private String Filename;
	File mediaFile;
	
	public ImageDownloadAsynctask(Context context) {
		mcont=context;
	}

	@Override
	protected void onPreExecute() {
		super.onPreExecute();

		mProgressDialog = new ProgressDialog(mcont);
		mProgressDialog.setTitle("Download Image ");
		mProgressDialog.setMessage("Loading...");
		mProgressDialog.setCancelable(false);
		mProgressDialog.show();
		System.out.println("roh onpre");
	}


	@Override
	protected void onPostExecute(Bitmap result) {

		//ImageDownload.setImageBitmap(result);
		//mProgressDialog.dismiss();

		if(result != null){

			System.out.println("roh post1");
			storeImage(result);

			mProgressDialog.dismiss();

			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);

			/*
			//////
			 * 
			file is downloaded
			
							File path is shown but not file
							 
			
			/////
			*/
			
			String path=Environment.getExternalStorageDirectory()
					+ "/dl/myfolder/"+Filename;
			intent.setDataAndType(Uri.parse(path), "image/*");
			mcont.startActivity(intent);



		}else{
			System.out.println("roh onpost2");
			mProgressDialog.dismiss();
			Toast.makeText(mcont, "Image Does Not exist or Network Error ", Toast.LENGTH_SHORT).show();

		}

	}

	@Override
	protected Bitmap doInBackground(String... arg0) {

		try {
			InputStream input = new java.net.URL(arg0[0]).openStream();
			bitmap = BitmapFactory.decodeStream(input);

			//bitmap = BitmapFactory.decodeStream((InputStream)new URL(arg0[0]).getContent());

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("roh doin");
		return bitmap;
	}


	private void storeImage(Bitmap image) {

		createdirectory();

		File pictureFile = getOutputMediaFile();
		if (pictureFile == null) {
			Log.d("abc",
					"Error creating media file, check storage permissions: ");// e.getMessage());
			return;
		} 
		try {
			FileOutputStream fos = new FileOutputStream(pictureFile);
			image.compress(Bitmap.CompressFormat.PNG, 100, fos);
			fos.close();
		} catch (FileNotFoundException e) {
			Log.d("abc", "File not found: " + e.getMessage());
		} catch (IOException e) {
			Log.d("abc", "Error accessing file: " + e.getMessage());
		}  
	}


	private void createdirectory() {

		File direct = new File(Environment.getExternalStorageDirectory()+"/dl/myfolder");

		if(!direct.exists()) {
			if(direct.mkdir()); //directory is created;
		}

	}

	private  File getOutputMediaFile(){
		File mediaStorageDir = new File(Environment.getExternalStorageDirectory()
				+ "/dl/myfolder"); 

		// Create the storage directory if it does not exist
		if (! mediaStorageDir.exists()){
			if (! mediaStorageDir.mkdirs()){
				return null;
			}
		} 
		// Create a media file name
		String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmm").format(new Date());
		File mediaFile;
		String mImageName="STADIC_"+ timeStamp +".png";
		Filename=mImageName;
		mediaFile = new File(mediaStorageDir.getPath() + File.separator + mImageName);
		return mediaFile;
	} 
}