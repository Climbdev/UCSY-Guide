package com.climbdev2016.ucsyfresherguide.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerTouchListener;
import com.climbdev2016.ucsyfresherguide.adapters.RecyclerMainAdapter;
import com.climbdev2016.ucsyfresherguide.model.MainModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<MainModel> mainList = new ArrayList<>();
    private RecyclerMainAdapter mAdapter;
    private String[] titles = {"Information","Department","Community","Places","Gallery","Transportation"};
    private int[] images = {R.drawable.unilogo,R.drawable.deplogo,R.drawable.comlogo,R.drawable.placeslogo,R.drawable.gallerylogo,R.drawable.carlogo};
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_main);
        mAdapter = new RecyclerMainAdapter(this, mainList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));

        prepareData();

        mRecyclerView.addOnItemTouchListener(new RecyclerTouchListener(this, mRecyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this,Info.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,Departments.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(MainActivity.this,Community.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(MainActivity.this,Places.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this,GalleryContainer.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this,Transportation.class);
                        startActivity(intent);
                        break;
                }

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        mRecyclerView.setAdapter(mAdapter);
    }

    private void prepareData() {
        for (int i=0 ; i<titles.length;i++){
            MainModel model = new MainModel(titles[i],images[i]);
            mainList.add(model);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this,About.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
