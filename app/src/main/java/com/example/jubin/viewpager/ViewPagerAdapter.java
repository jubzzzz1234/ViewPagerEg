package com.example.jubin.viewpager;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by jubin on 18/12/17.
 */

public class ViewPagerAdapter extends PagerAdapter{

    Activity activity;
    String[] images;
    LayoutInflater layoutInflater;
    int pos=0;

    public ViewPagerAdapter(Activity activity, String[] images) {
        this.activity = activity;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater=(LayoutInflater)activity.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=layoutInflater.inflate(R.layout.viewpager,container,false);

        ImageView imageView;
        imageView=(ImageView)itemView.findViewById(R.id.imageview);
        /*DisplayMetrics dis=new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getMetrics(dis);
        int height =dis.heightPixels;
        int width=dis.widthPixels;
        imageView.setImageResource(height);
        imageView.setImageResource(width);*/

        try {
            Picasso.with(activity.getApplicationContext())
                    .load(images[position])
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(imageView);
        }catch (Exception ex){}

        container.addView(itemView);


        return itemView;
    }



    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }
}
