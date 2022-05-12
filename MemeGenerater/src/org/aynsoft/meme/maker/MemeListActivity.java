package org.aynsoft.meme.maker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.aynsoft.adapter.OldMemeAdapter;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MemeListActivity extends Activity {

	private List<String> path;
	private GridView meme_list;
	private OldMemeAdapter adapter;
	public InterstitialAd interstitial;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.old_meme_list);
		
		/**Admob Code*/
		 AdView ad=(AdView)findViewById(R.id.adView);
		 AdRequest request = new AdRequest.Builder().build();
	        ad.loadAd(request);
	        interstitial=new InterstitialAd(getBaseContext());
	        interstitial.setAdUnitId(getResources().getString(R.string.admob_id));
	        interstitial.loadAd(request);
		
		
		path = new ArrayList<String>();
		oldCreatedMeme();
		meme_list = (GridView) findViewById(R.id.list_of_meme);
		adapter = new OldMemeAdapter(this, path);
		meme_list.setAdapter(adapter);
		
		meme_list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {				
				Intent open = new Intent(MemeListActivity.this, ShowOldMemeActivity.class);
				open.putExtra("imagePath",path.get(arg2));
				startActivity(open);
			}
		});
	}

	private void oldCreatedMeme() {
		File folder = new File(Environment.getExternalStorageDirectory()
				+ "/meme_generator");
		if (folder.isDirectory()) {
			File[] listOfFiles = folder.listFiles();
			for (File file : listOfFiles) {
				if (file.isFile()) {
					path.add(file.getAbsolutePath());
					Log.i("image path", file.getAbsolutePath());
				}
			}
		} else
			Toast.makeText(getBaseContext(), "First Save Meme",
					Toast.LENGTH_SHORT).show();

	}
	@Override
	public void onBackPressed() {
		if(interstitial.isLoaded()){
			interstitial.show();
		}
		super.onBackPressed();
	}
}
