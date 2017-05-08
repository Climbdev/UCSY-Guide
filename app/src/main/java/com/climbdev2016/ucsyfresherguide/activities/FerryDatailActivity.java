package com.climbdev2016.ucsyfresherguide.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;

public class FerryDatailActivity extends AppCompatActivity {

    Bundle bundle;
    TextView title, place, contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ferry_datail);

        bundle = getIntent().getExtras();

        Toolbar cToolbar = (Toolbar) findViewById(R.id.ferry_toolbar);
        setSupportActionBar(cToolbar);

        TextView cToolText = (TextView) findViewById(R.id.ferry_tool_text);
        cToolText.setText("Ferry");

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        title = (TextView) findViewById(R.id.title);
        place = (TextView) findViewById(R.id.places);
        contact = (TextView) findViewById(R.id.contacts);

        if (bundle != null) {
            title.setText(bundle.getString("title"));
            place.setText(bundle.getString("place"));
            contact.setText(bundle.getString("contact"));
        }
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
