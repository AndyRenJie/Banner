package com.banner.point;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Andy.Ren on 2017/11/21.
 */

public class BannerAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<ImageView> mBannerList;

    public BannerAdapter(Context context, ArrayList<ImageView>bannerList){
        this.mContext = context;
        this.mBannerList = bannerList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mBannerList.get(position));
        return mBannerList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mBannerList.get(position));
    }

    @Override
    public int getCount() {
        return mBannerList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
