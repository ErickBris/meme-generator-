package org.aynsoft.meme.maker;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class ShowOldMemeActivity extends Activity {

	private String path;
	private ImageView old_meme_image;
	public InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.show_meme_layout);

		AdView ad=(AdView)findViewById(R.id.adView);
		 AdRequest request = new AdRequest.Builder().build();
	        ad.loadAd(request);
	        interstitial=new InterstitialAd(getBaseContext());
	        interstitial.setAdUnitId(getResources().getString(R.string.admob_id));
	        interstitial.loadAd(request);
		
		
		path = getIntent().getStringExtra("imagePath");
		old_meme_image = (ImageView) findViewById(R.id.img_show_meme);
		old_meme_image.setImageURI(Uri.parse(path));
	}
	@Override
	public void onBackPressed() {
		if(interstitial.isLoaded()){
			interstitial.show();
		}
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.share_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu_share:
			shareImage();
			break;
		default:
			break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void shareImage() {
		Uri imageUri = Uri.parse("file://" + path);
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("image/png");
		intent.putExtra(Intent.EXTRA_STREAM, imageUri);
		startActivity(Intent.createChooser(intent, "Share"));
	}
}
