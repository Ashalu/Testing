package com.cpu_z;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.cpu_z.Adapter.CustomAdapter;

import java.util.ArrayList;

public class TagsList extends AppCompatActivity {
    ListView lv;
    Context context;

    ArrayList prgmName;
    public static int [] prgmImages={R.drawable.splash1,R.drawable.splash2,R.drawable.splash3,R.drawable.splash4,R.drawable.devices,R.drawable.system};
    public String [] prgmNameList=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tags_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Tags Categories");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        prgmNameList=getResources().getStringArray(R.array.all_tags);
        lv=(ListView) findViewById(R.id.list);
        lv.setAdapter(new CustomAdapter(this, prgmNameList,prgmImages));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(position==0)
               {
                   String title="System On Chip";
                      Intent intent=new Intent(TagsList.this,Description.class);
                        startActivity(intent);
               } else if (position == 1) {
                   String title="System On Chip";
                   Intent intent=new Intent(TagsList.this,Description.class);
                   intent.putExtra("images",prgmImages[position]);
                   intent.putExtra("title",title);
                   startActivity(intent);
               } else if (position == 2) {
                   String title="System On Chip";
                   Intent intent=new Intent(TagsList.this,Description.class);
                   startActivity(intent);
               }else if (position == 3) {
                   String title="System On Chip";
                   Intent intent=new Intent(TagsList.this,Description.class);
                   startActivity(intent);
               }else if (position == 4) {
                   String title="System On Chip";
                   Intent intent=new Intent(TagsList.this,Description.class);
                   startActivity(intent);
               }else if (position == 5) {
                   String title="System On Chip";
                   Intent intent=new Intent(TagsList.this,Description.class);
                   startActivity(intent);
               }else if (position == 6) {
                   String title="System On Chip";
                   Intent intent=new Intent(TagsList.this,Description.class);
                   startActivity(intent);
               }
            }
        });



    }
}
