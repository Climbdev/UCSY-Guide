package com.climbdev2016.ucsyfresherguide.activities;

import android.content.Intent;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerItemClickListener;
import com.climbdev2016.ucsyfresherguide.adapters.GalleryAdapter;
import com.climbdev2016.ucsyfresherguide.model.GalleryModel;

import java.util.ArrayList;

public class CommunityDetail extends AppCompatActivity implements AppBarLayout.OnOffsetChangedListener{


    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR  = 0.9f;
    private static final float PERCENTAGE_TO_HIDE_TITLE_DETAILS     = 0.3f;
    private static final int ALPHA_ANIMATIONS_DURATION              = 200;

    private boolean mIsTheTitleVisible          = false;
    private boolean mIsTheTitleContainerVisible = true;

    private GalleryAdapter adapter;
    private ArrayList<GalleryModel> data = new ArrayList<>();
    private LinearLayout mTitleContainer;
    private TextView mTitle,commDesc,commName;
    private AppBarLayout mAppBarLayout;
    private Toolbar mToolbar;
    private ImageView commImage,commBackImage;
    private Intent intent;
    private RecyclerView cgRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community_detail);

        bindActivity();

        intent=getIntent();

        mTitle.setText(intent.getStringExtra("CTitle"));
        commName.setText(intent.getStringExtra("CTitle"));
        commDesc.setText(intent.getStringExtra("CDes"));
        commImage.setImageResource(intent.getIntExtra("CImage",R.drawable.csclub_bg));
        commBackImage.setImageResource(intent.getIntExtra("CBackImage",R.drawable.csclub_bg));
        mAppBarLayout.addOnOffsetChangedListener(this);

        String[] IMGS=intent.getStringArrayExtra("community");

        for (int i = 0; i < IMGS.length; i++) {

            GalleryModel galleryModel = new GalleryModel();
            galleryModel.setName("Image " + i);
            galleryModel.setUrl(IMGS[i]);
            data.add(galleryModel);

        }

        cgRecyclerView= (RecyclerView) findViewById(R.id.rv_community_gallery);
        cgRecyclerView.setLayoutManager(new GridLayoutManager(this,3));
        cgRecyclerView.setHasFixedSize(true);


        adapter = new GalleryAdapter(CommunityDetail.this, data);
        cgRecyclerView.setAdapter(adapter);

        cgRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(CommunityDetail.this, GalleryDetail.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));

        startAlphaAnimation(mTitle, 0, View.INVISIBLE);

    }

    private void bindActivity() {
        mToolbar        = (Toolbar) findViewById(R.id.main_toolbar);
        mTitle          = (TextView) findViewById(R.id.comm_toolbar_title);
        mTitleContainer = (LinearLayout) findViewById(R.id.main_linearlayout_title);
        mAppBarLayout   = (AppBarLayout) findViewById(R.id.main_appbar);
        commDesc = (TextView) findViewById(R.id.comm_desc);
        commName = (TextView) findViewById(R.id.comm_name);
        commImage = (ImageView) findViewById(R.id.comm_logo);
        commBackImage = (ImageView) findViewById(R.id.comm_background);
    }


    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int offset) {
        int maxScroll = appBarLayout.getTotalScrollRange();
        float percentage = (float) Math.abs(offset) / (float) maxScroll;

        handleAlphaOnTitle(percentage);
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if(!mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleVisible = true;
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(mTitle, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleVisible = false;
            }
        }
    }

    private void handleAlphaOnTitle(float percentage) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if(mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.INVISIBLE);
                mIsTheTitleContainerVisible = false;
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mTitleContainer, ALPHA_ANIMATIONS_DURATION, View.VISIBLE);
                mIsTheTitleContainerVisible = true;
            }
        }
    }

    public static void startAlphaAnimation (View v, long duration, int visibility) {
        AlphaAnimation alphaAnimation = (visibility == View.VISIBLE)
                ? new AlphaAnimation(0f, 1f)
                : new AlphaAnimation(1f, 0f);

        alphaAnimation.setDuration(duration);
        alphaAnimation.setFillAfter(true);
        v.startAnimation(alphaAnimation);
    }
}
