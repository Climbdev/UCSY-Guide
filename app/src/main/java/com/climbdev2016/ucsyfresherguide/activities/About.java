package com.climbdev2016.ucsyfresherguide.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.andexert.library.RippleView;
import com.climbdev2016.ucsyfresherguide.Fragment.PhonePermissionFragment;
import com.climbdev2016.ucsyfresherguide.R;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        RelativeLayout phone = (RelativeLayout) findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Phone", Toast.LENGTH_SHORT).show();
            }
        });

        RelativeLayout email = (RelativeLayout) findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] TO = {"dev.climb2016@gmail.com"};
                String[] CC = {""};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, " ");
                emailIntent.putExtra(Intent.EXTRA_TEXT, " ");

                startActivity(Intent.createChooser(emailIntent, "Send email"));
            }
        });

        RelativeLayout facebook = (RelativeLayout) findViewById(R.id.fb);
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("fb://page/1606932726280013"));
                    startActivity(intent);

                }catch (Exception e){
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.facebook.com/ucsyguide/")));
                }
            }
        });

    }
}
