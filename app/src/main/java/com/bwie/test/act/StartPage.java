package com.bwie.test.act;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bwie.test.R;


/**
 * 1. 类的用途
 * 2. @author dell
 * 3. @date 2017/3/16 09:33
 */

public class StartPage extends BaseActivity {
    private int[] images = {R.mipmap.guidance_1, R.mipmap.guidance_2, R.mipmap.guidance_3, R.mipmap.guidance_4, R.mipmap.guidance_5};
    private Adapter adapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startpage);
        viewPager = (ViewPager) findViewById(R.id.startpage_vp);
        adapter = new Adapter();
        viewPager.setAdapter(adapter);
        
    }
    class Adapter extends PagerAdapter {
        @Override
        public int getCount() {
            return images == null ? 0 : images.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            View view = View.inflate(StartPage.this, R.layout.startpage_vp, null);
            ImageView imageView = (ImageView) view.findViewById(R.id.startpage_vp);
            imageView.setImageResource(images[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(view);
            if (position == 4) {
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(StartPage.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //super.destroyItem(container, position, object);
            container.removeView((View) object);
        }
        
       
    }
    
}
