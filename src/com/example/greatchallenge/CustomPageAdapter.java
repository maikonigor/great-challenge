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
    		new Country(0, "",0),
	        new Country(R.drawable.flag_01, "Brazil",Constantes.BRAZIL),
	        new Country(R.drawable.flag_02, "Franch",Constantes.FRANCH),
	        new Country(R.drawable.flag_03, "Netherland",Constantes.NETHERLAND),
	        new Country(R.drawable.flag_04, "Germany",Constantes.GERMANY),
	        new Country(R.drawable.flag_05, "Itay",Constantes.ITALY),
	        new Country(R.drawable.flag_06, "Dinamark",Constantes.DINAMARK),
	        new Country(R.drawable.flag_07, "Uruguai",Constantes.URUGUAI),
	        new Country(R.drawable.flag_08, "Grece",Constantes.GRECE),
	        new Country(R.drawable.flag_09, "Spain",Constantes.SPAIN),
	        new Country(R.drawable.flag_10, "Croatia",Constantes.CROATIA),
	        new Country(R.drawable.flag_11, "Country11",Constantes.C11),
	        new Country(R.drawable.flag_12, "Camaroes",Constantes.CAMAROES),
	        new Country(R.drawable.flag_13, "Japan",Constantes.JAPAN),
	        new Country(R.drawable.flag_14, "Chile",Constantes.CHILE),
	        new Country(R.drawable.flag_15, "Australia",Constantes.AUSTRALIA),
	        new Country(0, "",0)
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
        cname.setTag(mResources[position].getTag());
 
        container.addView(itemView);
 
        return itemView;
    }
    @Override
    public float getPageWidth(int position) {
    	// TODO Auto-generated method stub
    	return mContext.getResources().getDimension(R.dimen.page_width_ofset);
    }
 
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
    
}
