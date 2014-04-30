package com.example.androidinstallapk;

import java.io.File;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;

public class MainActivity extends ActionBarActivity
{
	
	private RatingBar ratingBar;
	private TextView txtRatingValue;
	private Button btnSubmit;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		addListenerOnRatingBar();
		addListenerOnButton();
		
		Button b=(Button)findViewById(R.id.button1);
		b.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				runOnUiThread(new Runnable() 
				{

	                @Override
	                public void run()
	                {
	                    // TODO show the dialog
	                	AppRater.showRateDialog(MainActivity.this, null);
	                }
	            });
				  
			}
		});

//		String appPackageName= getPackageName();
//		Intent marketIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+"com.paulmaidment.games.flagsoftheworld"));
//		marketIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET|Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
//		startActivity(marketIntent);
		
		
//		Intent goToMarket = new Intent(Intent.ACTION_VIEW)
//	    .setData(Uri.parse("market://details?id=com.paulmaidment.games.flagsoftheworld"));
//	startActivity(goToMarket); 
	
//		AppRater appRater = new AppRater(this);
//		appRater.setDaysBeforePrompt(3);
//		appRater.setLaunchesBeforePrompt(7);
//		appRater.setPhrases("a", "b", "c", "d", "e");
//		mAlertDialog = appRater.show();
//		new AppRater(this).show();
		
	}
	
	public void addListenerOnRatingBar() {

		ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		txtRatingValue = (TextView) findViewById(R.id.txtRatingValue);

		//if rating is changed,
		//display the current rating value in the result (textview) automatically
		ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {

				txtRatingValue.setText(String.valueOf(rating));

			}
		});
	}

	public void addListenerOnButton() {

		ratingBar = (RatingBar) findViewById(R.id.ratingBar);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);

		//if click on me, then display the current rating value.
		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(MainActivity.this,
						String.valueOf(ratingBar.getRating()),
						Toast.LENGTH_SHORT).show();

			}

		});

	}

	public void installFromSdCard()
	{
		//installs .apk file from the sd card
		File file = new File(Environment.getExternalStorageDirectory(), "phonicsApp/phonicsApp.apk");
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
		startActivity(intent);
	}
	
	public void redirectToApp()
	{
		//in Uri.parse section, just change the package name
		Intent goToMarket = null;
		goToMarket = new Intent(
		                   Intent.ACTION_VIEW,
		                   Uri.parse("market://details?id=com.paulmaidment.games.flagsoftheworld"));
		startActivity(goToMarket);
	}

}
