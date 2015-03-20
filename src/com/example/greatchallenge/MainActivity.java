package com.example.greatchallenge;

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
		uAdapter = new UniformAdapter(this);
		
		
		title = (TextView)findViewById(R.id.page_title);
		title.setTypeface(fontEdo);
		
		tvPlayer = (TextView)findViewById(R.id.txt_player);
		tvPlayer.setTypeface(fontArabolic);
		
		tvComputer = (TextView)findViewById(R.id.txt_computer);
		tvComputer.setTypeface(fontArabolic);
		
		btPreference = (Button) findViewById(R.id.bt_preference);
		btPreference.setTypeface(fontArabolic);
		
		
		arrowPlayerLeft = (ImageButton) findViewById(R.id.arrow_player_left);
		arrowPlayerLeft.setOnClickListener(new ArrowPlayerLeft());
		
		arrowPlayerRight = (ImageButton) findViewById(R.id.arrow_player_right);
		arrowPlayerRight.setOnClickListener(new ArrowPlayerRight());
		
		pagerPlayer1 = (ViewPager) findViewById(R.id.pagerPlayer1);
		pagerPlayer1.setAdapter(mCustomPagerAdapter);
		pagerPlayer1.setOnPageChangeListener(new PageSelectedItem(pagerPlayer1));
		
		arrowComputerLeft = (ImageButton) findViewById(R.id.arrow_computer_left);
		arrowComputerLeft.setOnClickListener(new ArrowComputerLeft());
		
		arrowComputerRigth = (ImageButton) findViewById(R.id.arrow_computer_rigth);
		arrowComputerRigth.setOnClickListener(new ArrowComputerRight());
		pagerComputer = (ViewPager) findViewById(R.id.pagerComputer);
		pagerComputer.setAdapter(mCustomPagerAdapter);
		
		arrowPlayerUniformLeft = (ImageButton) findViewById(R.id.arrow_player_uniform_left);
		arrowPlayerUniformLeft.setOnClickListener(new ArrowUniformPlayerLeft());
		
		arrowPlayerUniformRigth = (ImageButton) findViewById(R.id.arrow_player_uniform_right);
		arrowPlayerUniformRigth.setOnClickListener(new ArrowUniformPlayerRight());
		
		pagerPlayerUniform = (ViewPager) findViewById(R.id.pager_player1_uniform);
		
		arrowComputerUniformLeft = (ImageButton) findViewById(R.id.arrow_computer_uniform_left);
		arrowComputerUniformLeft.setOnClickListener(new ArrowUniformComputerLeft());
		arrowComputerUniformRigth = (ImageButton) findViewById(R.id.arrow_computer_uniform_rigth);
		arrowComputerUniformRigth.setOnClickListener(new ArrowUniformComputerRight());
		pagerComputerUniform = (ViewPager) findViewById(R.id.pager_computer_uniform);
		
		pagerPlayerUniform.setAdapter(uAdapter);
		pagerComputerUniform.setAdapter(uAdapter);
		
	}
	
	private class PageSelectedItem implements OnPageChangeListener{
		
		private ViewPager pager;
		
		public PageSelectedItem(ViewPager pager){
			this.pager = pager;
		}

		@Override
		public void onPageScrollStateChanged(int position) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int position) {
			View v = pager.getChildAt(position);
			if(v !=null ){
				ImageView image = (ImageView) v.findViewById(R.id.cflag);
				int h = image.getLayoutParams().height;
				int w = image.getLayoutParams().width;
				image.getLayoutParams().height = h+5;
				
			}
			
		}
		
	}
	
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
		int count = pager.getChildCount();
		
//		if(item >=0 && item <count)
			pager.setCurrentItem(item+1, true);
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

