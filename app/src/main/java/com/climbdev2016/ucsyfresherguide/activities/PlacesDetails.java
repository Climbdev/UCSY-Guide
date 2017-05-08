package com.climbdev2016.ucsyfresherguide.activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
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

public class PlacesDetails extends AppCompatActivity {

    private TextView tvTitle,tvDec,tvLoc;
    private GalleryAdapter adapter;
    private ArrayList<GalleryModel> data = new ArrayList<>();
    private RecyclerView placeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_details);
        Intent intent = getIntent();

        Toolbar cToolbar = (Toolbar) findViewById(R.id.placedetail_toolbar);
        setSupportActionBar(cToolbar);

        TextView cToolText = (TextView) findViewById(R.id.placedetail_tool_text);
        cToolText.setText(intent.getStringExtra("ptitle"));

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        tvTitle = (TextView) findViewById(R.id.tv_places_title);
        tvDec = (TextView) findViewById(R.id.tv_places_des);
        tvLoc = (TextView) findViewById(R.id.tv_places_loc);

        tvTitle.setText(intent.getStringExtra("ptitle"));
        tvDec.setText(intent.getStringExtra("pdesc"));
        tvLoc.setText(intent.getStringExtra("ploc"));

        String[] IMGS=intent.getStringArrayExtra("place");

        for (int i = 0; i < IMGS.length; i++) {

            GalleryModel galleryModel = new GalleryModel();
            galleryModel.setName("Image " + i);
            galleryModel.setUrl(IMGS[i]);
            data.add(galleryModel);

        }

        placeRecyclerView= (RecyclerView) findViewById(R.id.rv_places_gallery);
        placeRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        placeRecyclerView.setHasFixedSize(true);


        adapter = new GalleryAdapter(PlacesDetails.this, data);
        placeRecyclerView.setAdapter(adapter);

        placeRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(PlacesDetails.this, GalleryDetail.class);
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
