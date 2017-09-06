package com.cpu_z;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.cpu_z.Adapter.DeviceAdapter;
import com.cpu_z.Utils.BaseData;

import java.util.ArrayList;

public class Description extends AppCompatActivity {
        int images=0;
    BaseData baseData;
    ListView listView;
    String title;
    String deviceTitle[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        baseData = (BaseData) getApplication().getApplicationContext();
        deviceTitle=getResources().getStringArray(R.array.deviceinfo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView=(ImageView)findViewById(R.id.imageView);
        Intent intent=getIntent();
          images=intent.getIntExtra("images",R.drawable.helpus);
            title=intent.getStringExtra("title");
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        imageView.setImageDrawable(getResources().getDrawable(images));
        listView=(ListView) findViewById(R.id.list);
//        baseData.setDeviceList(GetdeviceInfo());
        listView.setAdapter(new DeviceAdapter(this, deviceTitle,GetdeviceInfo()));

    }


    public ArrayList<String> GetdeviceInfo()
    {
        ArrayList<String> deviceinfo=new ArrayList<>();
        deviceinfo.add(Build.ID);
        deviceinfo.add(Build.BOARD);
        deviceinfo.add(Build.BRAND);
        deviceinfo.add(Build.DEVICE);
        deviceinfo.add(Build.DISPLAY);
        deviceinfo.add(Build.FINGERPRINT);
        deviceinfo.add(Build.MODEL);
        deviceinfo.add(Build.TAGS);
        deviceinfo.add(Build.HARDWARE);
        deviceinfo.add(Build.MANUFACTURER);
        deviceinfo.add(Build.PRODUCT);
        deviceinfo.add(Build.SERIAL);
        deviceinfo.add(Build.HOST);
        deviceinfo.add(Build.VERSION.RELEASE);
        deviceinfo.add(Build.getRadioVersion());

        //Screen Size
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        double x = Math.pow(dm.widthPixels/dm.xdpi,2);
        double y = Math.pow(dm.heightPixels/dm.ydpi,2);
        double screenInches = Math.sqrt(x+y);
        Log.d("debug","Screen inches : " + screenInches);
        deviceinfo.add(screenInches+"");

        //Screen Density
        int densityDpi = (int)(dm.density * 160f);
        deviceinfo.add(densityDpi+"");

        //Screen Resolution

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        deviceinfo.add(height+"X"+width);



        return deviceinfo;
    }


}
