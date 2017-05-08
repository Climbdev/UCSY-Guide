package com.climbdev2016.ucsyfresherguide.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerItemClickListener;
import com.climbdev2016.ucsyfresherguide.adapters.PlaceAdapter;
import com.climbdev2016.ucsyfresherguide.model.PlacesModel;

import java.util.ArrayList;
import java.util.List;

public class Places extends AppCompatActivity {

    private RecyclerView pRecyclerView;
    private PlaceAdapter pAdapter;
    private List<PlacesModel> pList = new ArrayList<>();

    private String[] titles = {"သာဓုကန္","ေတာင္ေပၚဘုရား","Resource Center","Library","Canteen","ဘူတာရံု","ေလွာ္ကား"};
    private int[] images={R.drawable.pagoda,R.drawable.mountains,R.drawable.resource_center,R.drawable.book,R.drawable.canteen,R.drawable.train,R.drawable.hlawgar};

    private String[] pagoda={"https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15181179_343661299330374_4208681423940694563_n.jpg?oh=c512050ac436c238f0a4736b15a254fa&oe=58CED303",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15241276_343661459330358_4981121934754036083_n.jpg?oh=fcd1c3a585da866900c8fd1f5cd9cae7&oe=58C5D2E3",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/l/t1.0-9/15171315_343663845996786_7377274300088092460_n.jpg?oh=bc002be14d8a8d7deee9863ba0c838e1&oe=58B66A0B",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15192763_343662392663598_8772527309616204132_n.jpg?oh=b9c0088610def744b74405572960f5af&oe=58C05F21",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15202613_343662429330261_7835907964161445_n.jpg?oh=5915e0600e09f778a03ae14f7fd31799&oe=58B39914",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15284972_343661355997035_6427607472313895839_n.jpg?oh=5c14752b9f04584e3da97b1a2cddee34&oe=58CC1E46",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15230820_343661389330365_2358796313953823493_n.jpg?oh=e931ad682e2491a6d8f761029563ff02&oe=58CA7373",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15268063_343661392663698_1981072192798273730_n.jpg?oh=f9dbcd2313fe8e900cf7531bae9a02c3&oe=58BAE396",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15193509_343661462663691_3528309008149725361_n.jpg?oh=b8cea98de2e32f044e9e1b24707ded07&oe=58C9718A",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15284825_343661472663690_617843692937610681_n.jpg?oh=5276fd8f13415d526a1ed6a6622783bb&oe=58FBF46E",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15219995_343662442663593_5395682999150280474_n.jpg?oh=7f1a87066df59261daf9d73d6a7c6091&oe=58C2105C",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15241969_343663029330201_3265888374464243450_n.jpg?oh=eae819f050dbe34fe95c8d6b0b064edf&oe=58F94156",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15171091_343663045996866_799071634734750060_n.jpg?oh=80d83c11231d4717cb58eb9b451ab438&oe=58FC0A2A"};

    private String[] mountain={"https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15178311_343661519330352_1449376963402990418_n.jpg?oh=ed8727f7c8cf1f225f08df50533b3587&oe=58B4D609",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/11212743_343661522663685_5365777107521192101_n.jpg?oh=bdb64e266f48f914de62a0808a351be3&oe=58C7A408",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15253368_343661819330322_8603389195943127231_n.jpg?oh=f50c15324bbae182995edadc9780b2e8&oe=58F939F8",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15171090_343661842663653_4680266115909651733_n.jpg?oh=657663cd31fb15ce5ba92097e48a6176&oe=58F75FDA",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15203192_343661875996983_534013881645279784_n.jpg?oh=d4b620553484789172600cb22fb61213&oe=58CD7826",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15267967_343661895996981_8221092819382969029_n.jpg?oh=f350d9edf3eb2ed8bc4ecdbb74374127&oe=58C1D8D1",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15202691_343661912663646_7745724958188668533_n.jpg?oh=cca58493bac618278d39ebeecfcc686e&oe=58B6A2F0"};

    private String[] canteen={"https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15220196_343662949330209_1548799267620062993_n.jpg?oh=c029aee6b24435b432e530007304f55b&oe=58FBC745",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15230715_343662969330207_6689950166471242775_n.jpg?oh=59499a1c67b847fb9ad6721c65e58397&oe=58FD2F4A",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15253557_343663125996858_624309686362439627_n.jpg?oh=848d0d9cac72ecd97fba5f1edbadee29&oe=58B47936",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15241966_343662469330257_1902577246675471974_n.jpg?oh=d981b50b5735f74511bf30d7d6c67998&oe=58B09860",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15171138_343663729330131_7182292617818114288_n.jpg?oh=41ec052b164e13c747265cee68e41ef7&oe=58AF8A18"};

    private String[] hlawgar={"http://yangonlife.cdn3.mspiral.biz/cdn/farfuture/Ke3bN2RmGtAno7A48cnKOEzH0p4XLeTzX-8WNSzUO3o/mtime:1454925321/sites/yangonlife.com.mm/files/styles/article_detail_image/public/article_images/IMG_0871.JPG?itok=bc2U1jVM",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15283962_343663589330145_7017362937948665405_n.jpg?oh=ad001af612b0331dc30df3ea7340aa3e&oe=58B1B23D",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15202549_343663642663473_2686407646799478506_n.jpg?oh=51aec56a9940de2fc5ff0128006bf6d1&oe=58C4D8EE",
            "http://www.bfftravelmyanmar.com/img/hlawgar-1.jpg",
            "http://www.bfftravelmyanmar.com/img/hlawgar-2.jpg",
            "http://static.panoramio.com/photos/large/88477409.jpg",
            "https://i.ytimg.com/vi/1zvi94ETwis/maxresdefault.jpg",
            "http://www.yangonite.com/wp-content/uploads/2013/07/Hlawgar-Wildlife-Park-Bears1.jpg",
            "http://www.bfftravelmyanmar.com/img/hlawgar-3.jpg",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15285044_343663669330137_3377693266916378881_n.jpg?oh=b3c1678276b1758eace9ab7fa412d776&oe=58BF7366"};

    private String[] resource={"https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15232278_343662822663555_7106904799944351361_n.jpg?oh=0cad9993ede7ca1d698f7286b02ac5dc&oe=58B92634",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15241311_343662835996887_3946972037472636642_n.jpg?oh=1a92453956702abd7873edbc12a12ab6&oe=58B0FEB9",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15230714_343662859330218_8266863576305786109_n.jpg?oh=e79090ee629ef5a7267cd49edb76920e&oe=58FACADE",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15267647_343662892663548_5773060230471721649_n.jpg?oh=0ca82ab8e797dffca7351c9f7d689b7b&oe=58B08C7D",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15203112_343662912663546_6569266337709915866_n.jpg?oh=2bf8007beadea4783d99832910eafead&oe=58C9F084"};

    private String[] library={"http://ucsy.edu.mm/ucsy/gallery/ucsy/08.JPG",
            "http://ucsy.edu.mm/ucsy/gallery/ucsy/09.JPG",
            "http://ucsy.edu.mm/ucsy/images/slideLibrary2.jpg",
            "http://ucsy.edu.mm/ucsy/images/slideLibrary.jpg"};

    private String[] train ={"https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15171237_343662489330255_487130017217499310_n.jpg?oh=1c124c1510f1b0ebc30775352597a668&oe=58F7FD4F",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15202513_343662529330251_8818884721985928139_n.jpg?oh=79ff0b3ea2f142f77c382b5830be7123&oe=58CE9B5F",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15193668_343662552663582_453732388112177854_n.jpg?oh=28c132e29defb6219cfb0a044184635a&oe=58B96DFF",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15253438_343662585996912_8179980013116635639_n.jpg?oh=de5873097f4cef9225dd3407acaa8c67&oe=58C26855",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15219548_343662615996909_7910369838733544484_n.jpg?oh=d2ca2ce972530ba08a925c72fb006f88&oe=58C3E899",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15179004_343662672663570_4834265390510979184_n.jpg?oh=ff418faab046134a0259c7e9dd62ee18&oe=58CC2022",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15267510_343662715996899_6036266935313856929_n.jpg?oh=9c6d44dbfa7d48ac8e6562c36f18b577&oe=58B422AE",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15203243_343662779330226_5119522159910888481_n.jpg?oh=eb38f0ed8f6028d97b434ddd92bf7110&oe=58B3C188",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/15107358_1248646478535227_4871840482415281894_n.jpg?oh=7488bcb5667c291a1567505938a49d79&oe=58C00FA8",
            "https://scontent.fbkk3-1.fna.fbcdn.net/v/t1.0-9/13451002_1118371798229363_3418768077770846946_n.jpg?oh=a4ddf8a8a3a9efbbc49df5367697a2f3&oe=58AE41A3"};
    private Intent intent=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);

        Toolbar cToolbar = (Toolbar) findViewById(R.id.place_toolbar);
        setSupportActionBar(cToolbar);

        TextView pToolText = (TextView) findViewById(R.id.place_tool_text);
        pToolText.setText("Places");

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        pRecyclerView = (RecyclerView) findViewById(R.id.rv_places);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        pRecyclerView.setLayoutManager(manager);

        pAdapter = new PlaceAdapter(this,pList);
        pRecyclerView.setAdapter(pAdapter);

        prepareData();


        pRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {

            @Override
            public void onItemClick(View view, int position) {

                Resources res = getResources();
                String[] desc = res.getStringArray(R.array.places_desc);
                String[] loc = res.getStringArray(R.array.places_loc);

                intent = new Intent(Places.this,PlacesDetails.class);
                intent.putExtra("ptitle",titles[position]);
                intent.putExtra("pdesc",desc[position]);
                intent.putExtra("ploc",loc[position]);

                switch (position){
                    case 0:
                        intent.putExtra("place",pagoda);
                        break;
                    case 1:
                        intent.putExtra("place",mountain);
                        break;
                    case 2:
                        intent.putExtra("place",resource);
                        break;
                    case 3:
                        intent.putExtra("place",library);
                        break;
                    case 4:
                        intent.putExtra("place",canteen);
                        break;
                    case 5:
                        intent.putExtra("place",train);
                        break;
                    case 6:
                        intent.putExtra("place",hlawgar);
                        break;
                }

                startActivity(intent);
            }
        }));
    }

    private void prepareData() {
        for (int i=0;i<titles.length;i++){
        PlacesModel model = new PlacesModel(titles[i],images[i]);
        pList.add(model);
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
