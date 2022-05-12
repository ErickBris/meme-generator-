package org.aynsoft.adapter;

import java.util.List;

import org.aynsoft.javafile.Utility;
import org.aynsoft.meme.maker.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

public class OldMemeAdapter extends ArrayAdapter<String> {

	private List<String> path;
	Activity activity;
	LayoutInflater inflater;

	public OldMemeAdapter(Activity activity, List<String> path) {
		super(activity, R.layout.single_meme_view, path);
		inflater = LayoutInflater.from(activity);
		this.activity = activity;
		this.path = path;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.single_meme_view, parent,
					false);
		}
		ImageView single_meme = (ImageView) convertView
				.findViewById(R.id.img_meme);
		new LoadImageFromFolder(position).execute(single_meme);
		return convertView;
	}

	class LoadImageFromFolder extends AsyncTask<Object, Void, Bitmap> {

		int position;
		ImageView view;

		public LoadImageFromFolder(int p) {
			this.position = p;
		}

		@Override
		protected Bitmap doInBackground(Object... params) {
			this.view = (ImageView) params[0];
			return Utility.scaleImage(path.get(position), 100, activity);
		}

		@Override
		protected void onPostExecute(Bitmap result) {
			if (result != null) {
				this.view.setImageBitmap(result);
			}
			super.onPostExecute(result);
		}
	}
}
