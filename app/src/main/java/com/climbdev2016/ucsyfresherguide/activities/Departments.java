package com.climbdev2016.ucsyfresherguide.activities;

import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.adapters.DepartmentAdapter;
import com.climbdev2016.ucsyfresherguide.model.DepartmentModel;

import java.util.ArrayList;
import java.util.List;

public class Departments extends AppCompatActivity {

    private RecyclerView depRecyclerView;
    private List<DepartmentModel> departmentList = new ArrayList<>();
    private DepartmentAdapter dAdapter;

    private String[] images={"https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15181347_343622592667578_6875390754487936813_n.jpg?oh=75deaa77c37f36182f65521e0314d1cc&oe=58C6046B",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15202605_343622599334244_6163054426146727092_n.jpg?oh=5cd62ac870bf2e350a268519d803d630&oe=58B583F2",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15170948_343622596000911_602359817672596903_n.jpg?oh=e16410843b6482f95ba9ea8b89d004e4&oe=58B7806E",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15267922_343622732667564_8892895644725765232_n.jpg?oh=944260565014c850394c9a9fce4e52cd&oe=58B8E04A",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15241835_343622739334230_1912307015716655967_n.jpg?oh=0db043328eb0c367ecccbf26bfd8156c&oe=58FA2AA0",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15267608_343622742667563_1441303944134007698_n.jpg?oh=a08ee14873076d8b24c9033c4664cc91&oe=58CE32BF",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15178265_343622779334226_8456634951170652491_n.jpg?oh=8904519cbfc9c5498731e5177bb050a0&oe=58C22D5A",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15253518_343622819334222_4750534590196814933_n.jpg?oh=f8023405e5891bab9e76db36c999aa4e&oe=58B9F0EC",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15232205_343622902667547_7572299387926644603_n.jpg?oh=ef6eb0d4f2bc533aeb4e6cd21c2d263e&oe=58B3B23A",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15203369_343622929334211_3944933761221887720_n.jpg?oh=d27c4f0d8a35b3df84d511032d1cbbc8&oe=58FB2BDD",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15241770_343623002667537_6663993111662251600_n.jpg?oh=62bf85cd31cbf9e6eb5071f704365da5&oe=58C5A726",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15267958_343623016000869_8731933904304574991_n.jpg?oh=82a99b4464f9dc7b9d6ae888437879e9&oe=58C582CF",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15283912_343623136000857_312362941408143936_n.jpg?oh=f7a94734c81a7ab7ac026b0cb8041b9e&oe=58CF2D80",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15267822_343623166000854_4132013625907504321_n.jpg?oh=b211aa435e504051d2f3aa5625be73bd&oe=58C7EA36",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15193488_343623209334183_5912601417854920582_n.jpg?oh=eb081dd0e980bb47248c2f0637361ea9&oe=58AEC781",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15179207_343623282667509_8340066168544774746_n.jpg?oh=5a542a8d183b5720d13533bd68537171&oe=58C4ADB5",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15181470_343623319334172_3123725416983388434_n.jpg?oh=f3d03419143bf9c7fb67142f72b29acb&oe=58B63DF3",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15179108_343623366000834_1137838743938756882_n.jpg?oh=2a99ce2c5923e0bd5e3e07581f022b1b&oe=58C50C33",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15192634_343623376000833_1018570390424207297_n.jpg?oh=58fa3fe738f02fe543ad4561325a9778&oe=58C90B42",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15192688_343623392667498_4664641607093743614_n.jpg?oh=7bb685d6736e8d658644cae57d02132d&oe=58BFAAAC",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15267914_343623426000828_1284323350019750094_n.jpg?oh=27452a34cf0b1357c4fe5cec1c21837d&oe=58CEB746",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15241279_343623452667492_4713661421081931612_n.jpg?oh=e9f7508d4b2f22a90dc3b37462d3147f&oe=58B1CBC8",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15267828_343623476000823_6403986751852576109_n.jpg?oh=50458d3f78a275c4b0657f4a9a1fafc4&oe=58BEFDB5",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15193590_343623599334144_8486885251984951493_n.jpg?oh=ef353f867d734b215761e81bbac47d95&oe=58F8238D",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15253633_343623616000809_7804479854140429068_n.jpg?oh=ed44a3256579b4289532e148adddf322&oe=58C24856",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15181154_343623642667473_8351098106418816151_n.jpg?oh=73b1fd9b4b64b1b384de52efefcb497f&oe=58BE1612",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15219608_343623732667464_1111952189184694257_n.jpg?oh=77a2897a783c5acd59d3e6c87a41531c&oe=58FA7217",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15241281_343623736000797_625198278262125602_n.jpg?oh=8b4bf51465a37df1c1aa375c1b38c92c&oe=58CB6DB4",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15171274_343623792667458_3616133240241888327_n.jpg?oh=977ba1adf3a5d0a4a89b3d42181312f1&oe=58C12159",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15178252_343623836000787_2198151377374357978_n.jpg?oh=9bb270627669ceffda01299d4c8e4ace&oe=58BA98FC",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15267852_343623869334117_2040041270588462451_n.jpg?oh=c6a24ffbd755b7797b9ef8d746b9d51f&oe=58FC9589",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15170796_343623876000783_6914390651157522924_n.jpg?oh=6b3ca0d5f1053c2bdd85ca45300fa5ef&oe=58B1911C",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15181642_343624019334102_2975127720121954844_n.jpg?oh=30b40a80a1dd28602b19ad71884e9963&oe=58F742A9",
            "https://scontent.fbkk4-1.fna.fbcdn.net/v/t1.0-9/15202783_343624026000768_3018265568619150053_n.jpg?oh=0ec06f00e9971d17199c02b466068def&oe=58C8DF90"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        Toolbar depToolbar = (Toolbar) findViewById(R.id.dep_toolbar);
        setSupportActionBar(depToolbar);

        TextView depToolText = (TextView) findViewById(R.id.dep_tool_text);
        depToolText.setText("Department");

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        dAdapter = new DepartmentAdapter(this,departmentList);
        depRecyclerView = (RecyclerView) findViewById(R.id.rv_dep);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        depRecyclerView.setLayoutManager(manager);

        depRecyclerView.setAdapter(dAdapter);

        prepareData();


    }

    private void prepareData() {
        Resources res = getResources();
        String[] dTitle = res.getStringArray(R.array.dep_name);
        for (int i = 0; i<dTitle.length;i++){
            DepartmentModel model = new DepartmentModel(dTitle[i],images[i]);
            departmentList.add(model);
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
