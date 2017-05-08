package com.climbdev2016.ucsyfresherguide.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerItemClickListener;
import com.climbdev2016.ucsyfresherguide.adapters.GalleryAdapter;
import com.climbdev2016.ucsyfresherguide.model.GalleryModel;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    GalleryAdapter gAdapter;
    RecyclerView gRecyclerView;

    ArrayList<GalleryModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        Intent intent=getIntent();
        String[] IMGS=intent.getStringArrayExtra("gallery");

        Toolbar cToolbar = (Toolbar) findViewById(R.id.g_toolbar);
        setSupportActionBar(cToolbar);

        TextView cToolText = (TextView) findViewById(R.id.g_tool_text);
        cToolText.setText(intent.getStringExtra("title"));

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        for (int i = 0; i < IMGS.length; i++) {

            GalleryModel galleryModel = new GalleryModel();
            galleryModel.setName("Image " + i);
            galleryModel.setUrl(IMGS[i]);
            data.add(galleryModel);

        }

        gRecyclerView = (RecyclerView) findViewById(R.id.gallery);
        gRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        gRecyclerView.setHasFixedSize(true);


        gAdapter = new GalleryAdapter(Gallery.this, data);
        gRecyclerView.setAdapter(gAdapter);

        gRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(Gallery.this, GalleryDetail.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

}
