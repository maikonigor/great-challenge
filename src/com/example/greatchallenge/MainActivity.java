package com.example.greatchallenge;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private CustomPagerAdapter mCustomPagerAdapter;
	private UniformAdapter uAdapter;
	
	private ViewPager pagerPlayer1;
	private ViewPager pagerComputer;
	private ViewPager pagerPlayerUniform;
	private ViewPager pagerComputerUniform;
	
	
	private TextView title;
	private TextView tvPlayer;
	private TextView tvComputer;
	
	private Button btPreference;
	
	private Typeface fontEdo;
	private Typeface fontArabolic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar = getActionBar(); 
		if(actionBar != null)
			actionBar.hide();
		
		fontEdo = Typeface.createFromAsset(getApplicationContext().getAssets(), "font/"+Font.EDO);
		fontArabolic = Typeface.createFromAsset(getApplicationContext().getAssets(), "font/"+Font.ARABOLIC);
		
		mCustomPagerAdapter = new CustomPagerAdapter(this);
		uAdapter = new UniformAdapter(this);
		
		
		title = (TextView)findViewById(R.id.page_title);
		title.setTypeface(fontEdo);
		
		tvPlayer = (TextView)findViewById(R.id.txt_player);
		tvPlayer.setTypeface(fontArabolic);
		
		tvComputer = (TextView)findViewById(R.id.txt_computer);
		tvComputer.setTypeface(fontArabolic);
		
		btPreference = (Button) findViewById(R.id.bt_preference);
		btPreference.setTypeface(fontArabolic);
		
		pagerPlayer1 = (ViewPager) findViewById(R.id.pagerPlayer1);
		pagerPlayer1.setAdapter(mCustomPagerAdapter);
		
		pagerComputer = (ViewPager) findViewById(R.id.pagerComputer);
		pagerComputer.setAdapter(mCustomPagerAdapter);
		
		pagerPlayerUniform = (ViewPager) findViewById(R.id.pager_player1_uniform);
		pagerComputerUniform = (ViewPager) findViewById(R.id.pager_computer_uniform);
		
		pagerPlayerUniform.setAdapter(uAdapter);
		pagerComputerUniform.setAdapter(uAdapter);
		System.out.println("Item Atual = " + pagerPlayer1.getCurrentItem());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
