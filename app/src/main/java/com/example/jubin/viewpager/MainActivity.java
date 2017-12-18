package com.example.jubin.viewpager;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ViewPagerAdapter adapter;
    int currentPage=0;
    Timer timer;

    private String[] images=
            {
                    "https://static.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg",
                    "https://www.google.co.in/search?dcr=0&biw=1309&bih=678&tbm=isch&sa=1&ei=sl43WonGOsXOvgSLt5-ABQ&q=wallpapers+&oq=wallpapers+&gs_l=psy-ab.3..0l10.375.5010.0.5619.12.11.0.1.1.0.482.1926.0j4j2j1j1.8.0....0...1c.1.64.psy-ab..6.6.1226...0i67k1.0.gzeQEziNb30#imgrc=6g9pvrevzR_4AM:",
                    "https://www.google.co.in/search?dcr=0&biw=1309&bih=678&tbm=isch&sa=1&ei=sl43WonGOsXOvgSLt5-ABQ&q=wallpapers+&oq=wallpapers+&gs_l=psy-ab.3..0l10.375.5010.0.5619.12.11.0.1.1.0.482.1926.0j4j2j1j1.8.0....0...1c.1.64.psy-ab..6.6.1226...0i67k1.0.gzeQEziNb30#imgrc=_QWrPkv4Kn42vM:",
                    "https://www.google.co.in/search?dcr=0&biw=1309&bih=678&tbm=isch&sa=1&ei=sl43WonGOsXOvgSLt5-ABQ&q=wallpapers+&oq=wallpapers+&gs_l=psy-ab.3..0l10.375.5010.0.5619.12.11.0.1.1.0.482.1926.0j4j2j1j1.8.0....0...1c.1.64.psy-ab..6.6.1226...0i67k1.0.gzeQEziNb30#imgrc=_Z-6ufUmXWTuZM:",
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), images);
        viewPager.setAdapter(adapter);
        setupAutoPager();



    }


        private void setupAutoPager()
        {
            final Handler handler = new Handler();

            final Runnable update = new Runnable() {
                public void run()
                {

                    viewPager.setCurrentItem(currentPage, true);
                    if(currentPage == Integer.MAX_VALUE)
                    {
                        currentPage = 0;
                    }
                    else
                    {
                        ++currentPage ;
                    }
                }
            };


            timer = new Timer();
            timer.schedule(new TimerTask() {

                @Override
                public void run() {
                    handler.post(update);
                }
            }, 500, 2500);
        }



    }

