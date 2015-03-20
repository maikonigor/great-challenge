package com.example.greatchallenge;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class UniformAdapter extends PagerAdapter {

	private FragmentManager fm;
	private LayoutInflater mLayoutInflater;
	private Context context;
	
	int resources[] = {
			R.drawable.flag_02,
			R.drawable.flag_02,
			R.drawable.flag_02,
			R.drawable.flag_02
	};
	
	public UniformAdapter(Context c) {
		this.context = c;
		mLayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return resources.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		
		return view == ((LinearLayout) object);
	}
	
	 @Override
	    public Object instantiateItem(ViewGroup container, int position){
		 View item = mLayoutInflater.inflate(R.layout.uniform_item, container, false);
		 
		 ImageView flag = (ImageView) item.findViewById(R.id.uniform_flag);
		 flag.setImageResource(resources[position]);
		 
		 container.addView(item);
		 return item;
	 }
	 
	 @Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	        container.removeView((LinearLayout) object);
	    }
	 
	 @Override
	    public float getPageWidth(int position) {
	    	// TODO Auto-generated method stub
	    	return 0.35f;
	    }
	
	
}
