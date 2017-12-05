package com.banner.point;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager bannerViewPager;
    private LinearLayout pointBgLayout;
    private int [] bannerArray = new int[]{R.mipmap.ic_banner_one, R.mipmap.ic_banner_two,R.mipmap.ic_banner_three, R.mipmap.ic_banner_four,R.mipmap.ic_banner_five};
    private ArrayList<ImageView> bannerList = new ArrayList<>();
    private ArrayList<ImageView> pointList = new ArrayList<>();
    private Handler handler = new Handler();
    private BannerRunnable bannerRunnable = new BannerRunnable();
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        fillData();
        initListener();
    }

    private void initListener() {
        bannerViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                currentIndex = position;
                for (ImageView pointIV : pointList) {
                    pointIV.setImageResource(R.mipmap.ic_point_nomorl);
                }
                pointList.get(position).setImageResource(R.mipmap.ic_point_press);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void fillData() {
        for (int i = 0; i < bannerArray.length; i++) {
            //初始化轮播图片
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageResource(bannerArray[i]);
            imageView.setOnClickListener(new ImageViewClickListener());
            bannerList.add(imageView);
            //初始化点
            ImageView pointIV = new ImageView(this);
            pointIV.setImageResource(R.mipmap.ic_point_nomorl);
            pointIV.setPadding(5,0,5,0);
            pointList.add(pointIV);
            pointBgLayout.addView(pointIV);
        }
        pointList.get(0).setImageResource(R.mipmap.ic_point_press);
        bannerViewPager.setAdapter(new BannerAdapter(MainActivity.this,bannerList));
        handler.postDelayed(bannerRunnable,1000);
    }

    private void initView() {
        bannerViewPager = (ViewPager) findViewById(R.id.banner_view_pager);
        pointBgLayout = (LinearLayout) findViewById(R.id.point_bg_ll);
    }

    class BannerRunnable implements Runnable{
        @Override
        public void run() {
            currentIndex ++;
            currentIndex = currentIndex % bannerArray.length;
            bannerViewPager.setCurrentItem(currentIndex);
            handler.postDelayed(bannerRunnable,3000);
        }
    }

    class ImageViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            //TODO
        }
    }
}
