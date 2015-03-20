package com.example.greatchallenge;

import bean.Country;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

class CustomPagerAdapter extends PagerAdapter {
	 
    Context mContext;
    LayoutInflater mLayoutInflater;
    
    Country[] mResources = {
	        new Country(R.drawable.flag_01, "Brazil"),
	        new Country(R.drawable.flag_02, "Franch"),
	        new Country(R.drawable.flag_03, "Italy"),
	        new Country(R.drawable.flag_04, "Germany"),
	        new Country(R.drawable.flag_05, "Itay"),
	        new Country(R.drawable.flag_06, "Dinamark"),
	        new Country(R.drawable.flag_07, "Uruguai"),
	        new Country(R.drawable.flag_08, "Grece"),
	        new Country(R.drawable.flag_09, "Spain"),
	        new Country(R.drawable.flag_10, "Croatia"),
	        new Country(R.drawable.flag_11, "Country11"),
	        new Country(R.drawable.flag_12, "Camaroes"),
	        new Country(R.drawable.flag_13, "Japan"),
	        new Country(R.drawable.flag_14, "Country14"),
	        new Country(R.drawable.flag_15, "Australia")
	};
 
    public CustomPagerAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
 
    @Override
    public int getCount() {
        return mResources.length;
    }
 
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }
 
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        
        LinearLayout layout = (LinearLayout) itemView.findViewById(R.id.content_item);
        ImageView cflag = (ImageView) itemView.findViewById(R.id.cflag);
        TextView cname = (TextView) itemView.findViewById(R.id.cname);
        cflag.setImageResource(mResources[position].getFlag());
        cname.setText(mResources[position].getName());
 
        container.addView(itemView);
 
        return itemView;
    }
    @Override
    public float getPageWidth(int position) {
    	// TODO Auto-generated method stub
    	return 0.35f;
    }
 
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
    
}
