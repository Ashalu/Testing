package com.cpu_z;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cpu_z.Adapter.SliderPagerAdapter;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private ViewPager vp_slider;
    private LinearLayout ll_dots;
    TextView viewAll;
    SliderPagerAdapter sliderPagerAdapter;
    ArrayList<Integer> slider_image_list;
    private TextView[] dots;
    int page_position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        viewAll=(TextView)findViewById(R.id.viewid);
        viewAll.setOnClickListener(this);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        init();

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {


                if (page_position == slider_image_list.size()) {
                       page_position = 0;
                     vp_slider.setCurrentItem(1, true);
//
                } else {
                    page_position = page_position + 1;
                }




                vp_slider.setCurrentItem(page_position, true);
            }
        };

        new Timer().schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 100, 1500);




    }

    private void init() {

        vp_slider = (ViewPager) findViewById(R.id.vp_slider);
        slider_image_list = new ArrayList<>();
        slider_image_list.add(R.drawable.splash1);
        slider_image_list.add(R.drawable.splash2);
        slider_image_list.add(R.drawable.splash3);
        slider_image_list.add(R.drawable.splash4);


        sliderPagerAdapter = new SliderPagerAdapter(HomeScreen.this, slider_image_list);
        vp_slider.setAdapter(sliderPagerAdapter);

        vp_slider.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.soc) {
//            Intent intent = new Intent(HomeScreen.this, DoctorList.class);
//            startActivity(intent);

        } else if (id == R.id.device) {
//            Intent intent = new Intent(HomeScreen.this, PatientList.class);
//            startActivity(intent);

        } else if (id == R.id.system) {
//            Intent intent = new Intent(HomeScreen.this, AboutActivity.class);
//            startActivity(intent);

        } else if (id == R.id.battery) {

        } else if (id == R.id.thermal) {
//            Logout();
        } else if (id == R.id.sensors) {
//            Intent intent = new Intent(HomeScreen.this, AboutActivity.class);
//            startActivity(intent);

        } else if (id == R.id.nav_help) {

        } else if (id == R.id.about) {
//            Logout();
        }





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.viewid:
                Intent intent=new Intent(HomeScreen.this,TagsList.class);
                startActivity(intent);
        }
    }
}
