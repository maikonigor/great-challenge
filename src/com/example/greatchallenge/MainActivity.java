package com.example.greatchallenge;

import bean.Country;
import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
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
	private TextView tvPlayerUniform;
	private TextView tvComputerUniform;
	
	private ImageButton arrowPlayerLeft;
	private ImageButton arrowPlayerRight;
	private ImageButton arrowComputerLeft;
	private ImageButton arrowComputerRigth;

	private ImageButton arrowPlayerUniformLeft;
	private ImageButton arrowPlayerUniformRigth;
	private ImageButton arrowComputerUniformLeft;
	private ImageButton arrowComputerUniformRigth;
	
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
//		uAdapter = new UniformAdapter(this);
		
		
		title = (TextView)findViewById(R.id.page_title);
		title.setTypeface(fontEdo);
		
		tvPlayer = (TextView)findViewById(R.id.txt_player);
		tvPlayer.setTypeface(fontArabolic);
		
		tvComputer = (TextView)findViewById(R.id.txt_computer);
		tvComputer.setTypeface(fontArabolic);
		
		tvPlayerUniform = (TextView) findViewById(R.id.txt_player_uniform);
		tvPlayerUniform.setTypeface(fontArabolic);
		tvComputerUniform = (TextView) findViewById(R.id.txt_computer_uniform);
		tvComputerUniform.setTypeface(fontArabolic);
		
		btPreference = (Button) findViewById(R.id.bt_preference);
		btPreference.setTypeface(fontArabolic);
		
		
		arrowPlayerLeft = (ImageButton) findViewById(R.id.arrow_player_left);
		arrowPlayerLeft.setOnClickListener(new ArrowPlayerLeft());
		
		arrowPlayerRight = (ImageButton) findViewById(R.id.arrow_player_right);
		arrowPlayerRight.setOnClickListener(new ArrowPlayerRight());
		
		pagerPlayer1 = (ViewPager) findViewById(R.id.pagerPlayer1);
		pagerPlayer1.setAdapter(mCustomPagerAdapter);
		pagerPlayer1.setPageTransformer(true, new ZoomOutPageTransformer());
		
		arrowComputerLeft = (ImageButton) findViewById(R.id.arrow_computer_left);
		arrowComputerLeft.setOnClickListener(new ArrowComputerLeft());
		
		arrowComputerRigth = (ImageButton) findViewById(R.id.arrow_computer_rigth);
		arrowComputerRigth.setOnClickListener(new ArrowComputerRight());
		
		pagerComputer = (ViewPager) findViewById(R.id.pagerComputer);
		pagerComputer.setAdapter(mCustomPagerAdapter);
		pagerComputer.setPageTransformer(true, new ZoomOutPageTransformer());
		
		arrowPlayerUniformLeft = (ImageButton) findViewById(R.id.arrow_player_uniform_left);
		arrowPlayerUniformLeft.setOnClickListener(new ArrowUniformPlayerLeft());
		
		arrowPlayerUniformRigth = (ImageButton) findViewById(R.id.arrow_player_uniform_right);
		arrowPlayerUniformRigth.setOnClickListener(new ArrowUniformPlayerRight());
		
		pagerPlayerUniform = (ViewPager) findViewById(R.id.pager_player1_uniform);
		pagerPlayerUniform.setPageTransformer(true, new ZoomOutPageTransformer());
		
		arrowComputerUniformLeft = (ImageButton) findViewById(R.id.arrow_computer_uniform_left);
		arrowComputerUniformLeft.setOnClickListener(new ArrowUniformComputerLeft());
		arrowComputerUniformRigth = (ImageButton) findViewById(R.id.arrow_computer_uniform_rigth);
		arrowComputerUniformRigth.setOnClickListener(new ArrowUniformComputerRight());
		
		pagerComputerUniform = (ViewPager) findViewById(R.id.pager_computer_uniform);
		
		pagerPlayer1.setOnPageChangeListener(new PagePlayerChanged(pagerPlayerUniform,this,pagerPlayer1.getChildCount()));
		pagerComputer.setOnPageChangeListener(new PagePlayerChanged(pagerComputerUniform,this,pagerPlayer1.getChildCount()));
		
//		pagerPlayerUniform.setAdapter(uAdapter);
//		pagerComputerUniform.setAdapter(uAdapter);
		
	}
	/*
	private class PagePlayerChanged implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}

		@Override
		public void onPageSelected(int position) {
			position +=1;
			
			int res = 0;
			
			switch(position){
				case 1 :  res = R.drawable.flag_01; break;
				case 2 :  res = R.drawable.flag_02; break;
				case 3 :  res = R.drawable.flag_03; break;
				case 4 :  res = R.drawable.flag_04; break;
				case 5 :  res = R.drawable.flag_05; break;
				case 6 :  res = R.drawable.flag_06; break;
				case 7 :  res = R.drawable.flag_07; break;
				case 8 :  res = R.drawable.flag_08; break;
				case 9 :  res = R.drawable.flag_09; break;
				case 10 : res = R.drawable.flag_10; break;
				case 11 : res = R.drawable.flag_11; break;
				case 12 : res = R.drawable.flag_12; break;
				case 13 : res = R.drawable.flag_13; break;
				case 14 : res = R.drawable.flag_14; break;
				case 15 : res = R.drawable.flag_15; break;
			}
			
			Country c = new Country(res, "", 0);
			uAdapter = new UniformAdapter(getApplicationContext(), c);
			pagerPlayerUniform.setAdapter(uAdapter);
			
		}
		
	}
	*/
	
	/* player1 left team*/
	private class ArrowPlayerLeft implements OnClickListener{
		@Override
		public void onClick(View v) {
			prevItem(pagerPlayer1);
		}
	}
	
	/* player1 right team*/
	private class ArrowPlayerRight implements OnClickListener{
		@Override
		public void onClick(View v) {
			nextItem(pagerPlayer1);
		}
	}
	
	/* computer left team*/
	private class ArrowComputerLeft implements OnClickListener{
		@Override
		public void onClick(View v) {
			prevItem(pagerComputer);
		}
	}
	
	/* computer right team*/
	private class ArrowComputerRight implements OnClickListener{
		@Override
		public void onClick(View v) {
			nextItem(pagerComputer);
		}
	}
	
	private class ArrowUniformPlayerLeft implements OnClickListener{
		@Override
		public void onClick(View v) {
			prevItem(pagerPlayerUniform);
		}
	}
	
	private class ArrowUniformPlayerRight implements OnClickListener{
		@Override
		public void onClick(View v) {
			nextItem(pagerPlayerUniform);
		}
	}
	
	private class ArrowUniformComputerLeft implements OnClickListener{
		@Override
		public void onClick(View v) {
			prevItem(pagerComputerUniform);
		}
	}
	
	private class ArrowUniformComputerRight implements OnClickListener{
		@Override
		public void onClick(View v) {
			nextItem(pagerComputerUniform);
		}
	}
	
	
	
	/**
	 * Go to next position
	 * @param pager
	 */
	public void nextItem(ViewPager pager){
		int item = pager.getCurrentItem();
		int nextItem = item+1;
		int count = pager.getChildCount();
		
		pager.setCurrentItem(nextItem, true);

	}
	
	/**
	 * go to prev position
	 * @param pager
	 */
	public void prevItem(ViewPager pager){
		int item = pager.getCurrentItem();
		int count = pager.getChildCount();
		
//		if(item >=0 && item <count)
			pager.setCurrentItem(item-1,true);
	}
}


