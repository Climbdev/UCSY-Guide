package com.climbdev2016.ucsyfresherguide.activities;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.climbdev2016.ucsyfresherguide.Fragment.BusFragment;
import com.climbdev2016.ucsyfresherguide.Fragment.FerryFragment;
import com.climbdev2016.ucsyfresherguide.Fragment.TrainFragment;
import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.adapters.ViewPagerAdapter;

public class Transportation extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private Toolbar toolbar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private AppBarLayout appBarLayout;
    private ViewFlipper flipper;
    private float initialX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transportation);

        setupToolbar();

        setupViewPager();

    }

    private void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView tran = (TextView) findViewById(R.id.tran_tool_text);
        tran.setText("Transportation");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapse_toolbar);
        collapsingToolbarLayout.setTitleEnabled(false);

        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar);
        appBarLayout.setExpanded(true);

        flipper = (ViewFlipper) findViewById(R.id.tranpo_flipper);
        flipper.setAutoStart(true);
        flipper.setFlipInterval(4000);
        flipper.startFlipping();

    }

    @Override
    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                initialX = touchevent.getX();
                break;
            case MotionEvent.ACTION_UP:
                float finalX = touchevent.getX();
                if (initialX > finalX) {
                    if (flipper.getDisplayedChild() == 1)
                        break;

                    flipper.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.out_from_left));

                    flipper.showNext();
                } else {
                    if (flipper.getDisplayedChild() == 0)
                        break;

                    flipper.setInAnimation(AnimationUtils.loadAnimation(this, R.anim.in_from_right));
                    flipper.setOutAnimation(AnimationUtils.loadAnimation(this, R.anim.out_from_right));

                    flipper.showPrevious();
                }
                break;
        }
        return false;
    }

    private void setupViewPager() {

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        viewPager.setOffscreenPageLimit(2);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FerryFragment(),"Ferry");
        viewPagerAdapter.addFragment(new BusFragment(), "Bus");
        viewPagerAdapter.addFragment(new TrainFragment(), "Train");
        viewPager.setAdapter(viewPagerAdapter);

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
