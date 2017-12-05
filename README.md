# Android 简单实现图片轮播效果

前言：随着Android开发需求越来越多，效果也越来越复杂，也会有很多开发者要求手机上显示像网页那样的轮播效果，有些轮播做的比较复杂，其实实现这个效果的方法也有很多，贴出自己写的一个轮播，个人感觉是比较简单的，效果上没有什么区别。还是一样先上图：

![image](https://github.com/AndyRenJie/Banner/blob/master/device-2017-12-05-120210.png)

### 一、程序主页面MainActivity：

（1）成员变量：

```
private ViewPager bannerViewPager;
private LinearLayout pointBgLayout;
private int [] bannerArray = new int[]{R.mipmap.ic_banner_one, R.mipmap.ic_banner_two,R.mipmap.ic_banner_three, R.mipmap.ic_banner_four,R.mipmap.ic_banner_five};
private ArrayList<ImageView> bannerList = new ArrayList<>();
private ArrayList<ImageView> pointList = new ArrayList<>();
private Handler handler = new Handler();
private BannerRunnable bannerRunnable = new BannerRunnable();
private int currentIndex;
```
（2）初始化轮播图片：创建ImageView，设置基本属性，添加到轮播图集合

```
//初始化轮播图片
ImageView imageView = new ImageView(this);
imageView.setScaleType(ImageView.ScaleType.FIT_XY);
imageView.setImageResource(bannerArray[i]);
imageView.setOnClickListener(new ImageViewClickListener());
bannerList.add(imageView);
```

（3）初始化点：创建点的ImageView，添加到点背景的layout中

```
//初始化点
ImageView pointIV = new ImageView(this);
pointIV.setImageResource(R.mipmap.ic_point_nomorl);
pointIV.setPadding(5,0,5,0);
pointList.add(pointIV);
pointBgLayout.addView(pointIV);
```

（4）handler发送轮播消息
```
handler.postDelayed(bannerRunnable,1000);
```

（5）bannerRunable处理发来的消息，计算当前ViewPager显示的当前下标位置，实现循环效果

```
class BannerRunnable implements Runnable{
        @Override
        public void run() {
            currentIndex ++;
            currentIndex = currentIndex % bannerArray.length;
            bannerViewPager.setCurrentItem(currentIndex);
            handler.postDelayed(bannerRunnable,3000);
        }
    }
```

