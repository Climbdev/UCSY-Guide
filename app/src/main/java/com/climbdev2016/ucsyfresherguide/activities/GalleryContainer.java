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
import com.climbdev2016.ucsyfresherguide.adapters.GalleryContainerAdapter;
import com.climbdev2016.ucsyfresherguide.model.GalleryContainerModel;

import java.util.ArrayList;
import java.util.List;

public class GalleryContainer extends AppCompatActivity {


    private RecyclerView gcRecyclerView;
    private GalleryContainerAdapter gcAdapter;
    private List<GalleryContainerModel> gcList = new ArrayList<>();
    private String[] title = {"ေမာင္မယ္သစ္လြင္ျကိဳဆိုပြဲ",
            "Google I/O extented UCSY",
            "MCPA Days",
            "မိုးရာသီအားကစားပြဲ နွင့္ဆုေပးပြဲ",
            "ကထိန္သကၤန္းကပ္လွဴပြဲ",
            "GeekGirls MM",
            "ဝါဆိုသကၤန္းကပ္လွဴပြဲ",
            "Asia Yangon Progamming Contest",
            "UCSY Student Showcase 2016",
            "Web Design Skill Competition",
            "ေသြးလွဴပြဲ",
            "တတိယအျကိမ္ေျမာက္စာေပေဟာေျပာပြဲ",
            "UCSY Water Festival",
            "ဗိုလ္ခ်ဳပ္ေအာင္ဆန္းေမြးေန့အမွတ္တရ"};
    private String[] image ={"https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/1604814_1008717575855119_3436625197493265124_n.jpg?oh=b4a2691e35f8a5613189d7d609bdfea4&oe=58C887AC",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13450285_806922986105804_1900653335844582658_n.jpg?oh=a55dc842d66206db0c675348d0fa7711&oe=58C13884",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13729068_1733709730218010_1927504254194447098_n.jpg?oh=3145c7107e217642a27ba02560d1ec4a&oe=58B61406",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/15178230_344183412611496_930915507783806467_n.jpg?oh=ca0703130dfe5b77ab958c91b59f8891&oe=58B912AF",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/15055650_1784510561804593_6421520863028206008_n.jpg?oh=98c4bd5f1420970b85eb668e4fa96eb9&oe=58BD9341",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13781813_1735649153357401_6245661783111024981_n.jpg?oh=c45fdc38738b0ffafc211b29e878c3ba&oe=58FA6D98",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13690776_1730306290558354_6741646252575657389_n.jpg?oh=6b94b9aa99aa39631e732fef314b822e&oe=58C6CEBF",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13537682_1722124381376545_1120505805347810912_n.jpg?oh=de4e20b144d0b38e22cf35b1b06ce58a&oe=58B32D7D",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13921105_10208055852328799_6168160706914240087_n.jpg?oh=f035928fc42f3ee70d4d80d26f1cb58d&oe=58C31336",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13669197_567795973428744_2155984429748148984_n.jpg?oh=e7a196ed11fd39c162bc8c8e911afe0c&oe=58B48224",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-0/s480x480/13680973_1730783230510660_6120669513639668162_n.jpg?oh=9119a1077701ff8f2f345f33cda3a199&oe=58B7A1C2",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/13592567_1727077974214519_465878828380057375_n.jpg?oh=e39f05a914ca7620ec941d322b222218&oe=58B879F2",
            "https://1.bp.blogspot.com/-VCd-eHMPf9o/WCN6Sbm83uI/AAAAAAAAAGw/QOoCcDiedKstZAfqLTi8UGhf5CFsfaU9QCLcB/s320/FB_IMG_1469857738097.jpg",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12687936_499733723568303_7737046947119159613_n.jpg?oh=3fa5a733d8cbf496524a9dc38a095247&oe=58CE1692"};

    private String[] fresher ={"https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12524311_1008710622522481_8611871972332930332_n.jpg?oh=c4a3bf545aaf37aee0a61c9ba2500a1d&oe=58FA3F62",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/10632581_1008710855855791_6029092236819290254_n.jpg?oh=baeaa0f0763dc980265bab36b3072507&oe=58C7EC57",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12510483_1008712092522334_5924435397956988890_n.jpg?oh=52c4dd980cdae6a5fac47184083451cd&oe=58F72834",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12540593_1008714729188737_4361503087658029882_n.jpg?oh=2ec50527b9f1b3e5fe6fde697fad5cc9&oe=58C3695F",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/1170819_1008714875855389_358590615180292612_n.jpg?oh=baa3f84387ca5f3723cdf4b972dc0eb1&oe=58B51AD7",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12400977_1008715019188708_3799501505488020999_n.jpg?oh=fb78b5522fc70236007268af713b7242&oe=58CB06C2",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12507234_1008715162522027_5342655796389940530_n.jpg?oh=3a20f81e7b97ed18b785c22a0dca5126&oe=58C2A265",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/946125_1008715195855357_8961615993901427287_n.jpg?oh=4fd77d549a0d4c6d081dc603f1b1b458&oe=58B5461D",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/1544_1008715559188654_5372271901366981590_n.jpg?oh=e4c2e6d2fd722483155b5db9fca70566&oe=58B45FF3",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/1929791_1008715332522010_5209710449817910697_n.jpg?oh=3193eb78a76656035d7d54a0bf936e2d&oe=58C4459D",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/11204897_1008715412522002_7717441965017656729_n.jpg?oh=230e06f6807ea0f0a8cfcad64af3a76a&oe=58BF3D17",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12509501_1008715562521987_257355583441600403_n.jpg?oh=dcdd683efc023c3da7ee110e6dedebf4&oe=58CB9FF9",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12507538_1008715962521947_315040787397220022_n.jpg?oh=979ad354006ed65381b2b507b837ed2b&oe=58B613A0",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/10650037_1008716255855251_3473726955879288051_n.jpg?oh=8cdda9b4e0a4f392d868a748e2648d46&oe=58B77B6C",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/10367158_1008716615855215_6205029185190461180_n.jpg?oh=7df53d5eb88dd1e85b2c24d45b1a48d3&oe=58C26A6D",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/1454983_1008716945855182_6587876090887826415_n.jpg?oh=f17c6356f2a773c08b9ff9aa33f6aafd&oe=58CAA582",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12522993_1008717345855142_5258099331301490418_n.jpg?oh=4398f968c34a087d5eead070a81b78e9&oe=58BB90D0",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/l/t1.0-9/12400741_1008717982521745_12087846476718697_n.jpg?oh=c841937285b3d1cccac19f3dec4d6fbe&oe=58BF875B",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12509497_1008718182521725_1156305753490121220_n.jpg?oh=7cf19da5fe8f099c5c413af3e667eaf4&oe=58F61260",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/1528526_1008718222521721_3471643515412673429_n.jpg?oh=f60bf59436393f211fc949646281c0d1&oe=58F68DDC",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/10584099_1008718269188383_6503217573696992228_n.jpg?oh=02a7311c9b05f6a78287cc3f440cb345&oe=58F7C5BA",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12400614_1008718382521705_5704855254837683515_n.jpg?oh=08538781d7883f76628aae3a39028994&oe=58B0D298",
            "https://scontent.fbkk3-2.fna.fbcdn.net/v/t1.0-9/12509164_1008718732521670_8498635551031215083_n.jpg?oh=648a5349a2c31454fd9366eeea2128b6&oe=58BA9BD6"};

    private String[] ioextended ={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13528937_1721362601452723_3419443581296612555_n.jpg?oh=31f6844272cd29580e0349053a67b59c&oe=58C0C1F0",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13466081_1721362598119390_7886229876559550806_n.jpg?oh=ecd8f5aa703fcbf0093211830c80cab6&oe=58D2CA42",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13516363_1721362651452718_4314768734011468852_n.jpg?oh=d3bcc6e1f8c97b27aed9e10c04487a3d&oe=58B88B8A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13450278_1721362658119384_4373635653516724977_n.jpg?oh=7a689e7961aef5cbc2342fe863933973&oe=58B4DE6C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13509093_1721362704786046_1944692552488043768_n.jpg?oh=32f442bfdbc3d8be7d1cbaba2f984fc8&oe=58B9A7A9"};

    private String[] mcpa={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13718737_1733709510218032_1271768158039688672_n.jpg?oh=c6126f424446992f7829f8f68d54f680&oe=58BD6560",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13718762_1733709523551364_6916235434700860368_n.jpg?oh=efe72961a19f72a6e2ca6c74b3a7b9d1&oe=58B2051C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13692540_1733709540218029_3868092173535473212_n.jpg?oh=6d70a3d99372ac6f449010fdf5fb27dd&oe=58B382BC",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13781816_1733709563551360_2352877680914311003_n.jpg?oh=e43d04f5b40ca3065187370e2680f02f&oe=58C8E785",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13781843_1733709660218017_7838877723089455348_n.jpg?oh=d5fb5eebb0870dd04cba2f85fd91edef&oe=58C10E8D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13707759_1733709713551345_4873675243893811210_n.jpg?oh=5a1be5f1f83191c197c7b46a45ba285b&oe=58B48488",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13729068_1733709730218010_1927504254194447098_n.jpg?oh=3145c7107e217642a27ba02560d1ec4a&oe=58B61406",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13709824_1733709773551339_2033646601146050658_n.jpg?oh=64f92d3f27adc101a3c563c34b9d4ca1&oe=58CCFBDC",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13716060_1733709823551334_4123113879143253294_n.jpg?oh=588d813c34bfeca049c81c941ced70ac&oe=58CBB2F2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13769401_1733709850217998_922384200066797696_n.jpg?oh=b2906519bc15b061fa7583fa40efa1f8&oe=58CCAF16"};

    private String[] sport={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13321901_1715490865373230_9150639165986410372_n.jpg?oh=e58fa232cdfcb723a2e8a4c1e324a5b3&oe=58CAB980",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13335917_1715490888706561_3680419046975659203_n.jpg?oh=b65f4cb26e3c4f2e393909aaa75697f7&oe=58BFCF52",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13322069_1715490905373226_3611134985570974776_n.jpg?oh=25485ebfc67396cd33357413efd0ce1d&oe=58B99E4F",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13336150_1715491092039874_5189955077313327222_n.jpg?oh=47939737144363d142fe1f6eb74600a4&oe=58B0A1CF",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13392291_1715491235373193_8312610863297308133_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13411999_1715491482039835_2395673407706038300_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13350397_1715491688706481_9003376009736201981_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13403378_1715491812039802_4526403902199510192_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13346958_1715492202039763_2801476525118163129_n.jpg?oh=d66896ca08a2f88f1cd7d126c2c83dd2&oe=58CC86FF",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13413560_1715492302039753_6356827792692761798_n.jpg?oh=d5920e1439b46dc8a8c39947e1ca983d&oe=58C52697",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13315733_1715492322039751_6377972948749707460_n.jpg?oh=d59291b682ca4be9e300158fd8a776f4&oe=58C42B1D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12991126_1715492392039744_9194957567421017067_n.jpg?oh=10b962d68b8609944a7d778dd904dfa5&oe=58BD4A7C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13394142_1715492435373073_9116377689198736907_n.jpg?oh=495a4afb175411b7f6451fee02694ca4&oe=58CAB8B3",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13445254_552149364993405_8063002203668508075_n.jpg?oh=06b0129877e78ff31dde76b962037943&oe=58CBD595",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13435315_552130981661910_5180038640949604910_n.jpg?oh=d9fba52dd5be4b0e10a106a313d00dcd&oe=58CAE376",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13507160_552131014995240_7384329459389150413_n.jpg?oh=3087751fb0b677c4e269c97c77b3f904&oe=58B9DE2C",
            "https://scontent-sin6-1.xx.fbcdn.net/v/l/t1.0-9/13508947_552131064995235_3126517698564641656_n.jpg?oh=9f555c8d2383123a5ba9d412b802c583&oe=58B2581C",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-0/p320x320/13466190_551034578438217_5295041183165441891_n.jpg?oh=a39b9c59d2178e1670a15e6a2d0c43e8&oe=58C6E582",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13427941_551034765104865_5336959657284375186_n.jpg?oh=93b90db5a9fc3b52b78a15263485b192&oe=58C2619B",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13450809_550253505182991_374624492531063426_n.jpg?oh=91b854a6e028bb660940fab57067aa2b&oe=58D25FB8",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13494990_1720890584833258_5869937170988117583_n.jpg?oh=1a0448ffbfdfa51cc8a62cd0f4fc38c6&oe=58B101A2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13450039_1720890588166591_6436989510126929785_n.jpg?oh=deaed749d241bb267d5060edc0f547bb&oe=58C5FFD7",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13407050_1720881904834126_4131369054778572591_n.jpg?oh=471eaf60a1bcab5c6e88b72353eb06c2&oe=58C69884",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13495548_1720881988167451_5847707116666358159_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13497828_1720881994834117_4174027506187630106_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13443238_1720882054834111_4780399646862057586_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13490752_1720882214834095_5158878983792903828_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13475039_1720882431500740_6241074232999231314_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13495060_1720882428167407_3488200381961768345_n.jpg?oh=424f33990d61c6266c732624fb12d9d3&oe=58D2FC7D",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13498006_1720890734833243_6973143366157581632_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13475053_1720890988166551_2061631254148219872_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13495458_1720891064833210_6438797660633592111_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13517556_1720891208166529_6151091574528597556_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13413789_1720891228166527_6490336416290671174_n.jpg?oh=eda6acf6e3ef1c67ded118cff02ab9e8&oe=58B665D2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13512146_1720891531499830_877648568586467616_n.jpg?oh=cb683db41a097db173470fc1dcc2c14d&oe=58BE9C75",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13510956_1720893028166347_1998078641448541566_n.jpg?oh=1937428f7e1a385093bb35f33bf7d0f4&oe=58CF91E3",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13509028_1720893038166346_735375298640021499_n.jpg?oh=b256f724faeac5a8360fc378d4a186ab&oe=58B33A27",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13502021_1720893138166336_5381764103291203544_n.jpg?oh=a41ff5b11bdb38bbae9215e6e3ff6a26&oe=58B67E12",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13495212_1720893178166332_6501398192029845913_n.jpg?oh=b8ba529cc19f84f7e6b4e8d759546f7d&oe=58BA6051",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13494985_1720893231499660_450441458261865923_n.jpg?oh=14bec175c31ce819f1e706cb132db148&oe=58B83FCC",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13501717_1720893241499659_1085042036635726929_n.jpg?oh=1dceab17ebe7efc0168b8757ac7e3780&oe=58BC3C13",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13442408_1720893401499643_5551031467719777388_n.jpg?oh=d3d374235f4b98bbc4463cff44142e24&oe=58C50B04",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13502030_1720893474832969_5196359878434821626_n.jpg?oh=eceb6988b98771c7bccd31b32e57f370&oe=58C0B51D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13466397_1720893534832963_3240037067083991718_n.jpg?oh=39584d131c9ef20ab164276873675025&oe=58BFC054",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13501683_1720893604832956_3346491839955980217_n.jpg?oh=f68db8cdfd1a2b06e8032efcdae69b32&oe=58D27B64",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/13482928_1720893624832954_7905143264428530335_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13445664_1720891841499799_7195095938550286062_n.jpg?oh=cdddd5b4d1ec32ab645f0a054855eaa3&oe=58FB7217",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13445296_1720891938166456_1657035876751285263_n.jpg?oh=441a9bd00b852d0ad3f0375833190b58&oe=58B760FF",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13450201_1720891974833119_5372778970919274567_n.jpg?oh=e5e41302734921f8dbb7bf5f59869959&oe=58B2F3E5",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13445440_1720891988166451_4446660809857952968_n.jpg?oh=1a047859006bc431cc9d9be944b09f12&oe=58BB9D46",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13445350_1720892051499778_506236226982379162_n.jpg?oh=4758fa7a62e110bcb73f6012928c8538&oe=58C95785",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13502143_1720892074833109_2202306805178825848_n.jpg?oh=f4ed1394dd35f4bd9e2008d71e0e9464&oe=58C81C75",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13508978_1720892084833108_5308896599531437697_n.jpg?oh=679422823eb564004385b6f60ba4bc69&oe=58CBD789",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13512233_1720892188166431_5387089414495052352_n.jpg?oh=5d170738248a0313ae68b563f81bbe7c&oe=58C69B9D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13509122_1720892261499757_2464764554403044904_n.jpg?oh=9ebf6c26bbdb6dbcccfc87738a6444d1&oe=58BE087D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13466534_1720892324833084_4892294145570735299_n.jpg?oh=0d0a62bb26da1fbf19f472f0e885bdbd&oe=58D14593",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13501728_1720892634833053_2550714481764671709_n.jpg?oh=6fe64ca65df43a4de3a7e9d35093c4dc&oe=58C2C0AB"};

    private String[] kahtain ={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15055650_1784510561804593_6421520863028206008_n.jpg?oh=98c4bd5f1420970b85eb668e4fa96eb9&oe=58BD9341",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/14976542_1784510628471253_2363978826039316289_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/15123016_1784510631804586_4930433551610266356_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/s960x960/15025613_1784510598471256_2822666240105662912_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15136018_1784510641804585_5253743398779780082_n.jpg?oh=9417db92fc052ac6dd595a6cb11ebc9d&oe=58B2EF22",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15032811_1784510688471247_3007627560112647696_n.jpg?oh=42a001d2e3ef5f4b26dc8b06586ab617&oe=58D01F65",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15027472_1784510708471245_5082643342213062973_n.jpg?oh=4e8cb24029d39872e539b63a2f01b7cf&oe=58C00BA2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15136018_1784510835137899_1209934815488747218_n.jpg?oh=96db1830d7cba1701584403e7e6940eb&oe=58B2DEA0",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15027841_1784510908471225_3910029870815217326_n.jpg?oh=8b40aba5fec6ee3851acbb1b8e414380&oe=58CC2DD3",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15032650_1784510975137885_1969595436999116716_n.jpg?oh=dccc8d59b6fc2da9424a16311a01b2b6&oe=58AED724",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15094277_1784511115137871_6887414627982729029_n.jpg?oh=5a425cb88fc68bf0bd63ed20e7e3990a&oe=58CBE20E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15135931_1784511178471198_3643534167971486800_n.jpg?oh=94fbee941067c9226e013df0ebe40f29&oe=58D3195C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15078815_1784511241804525_6243490739997616808_n.jpg?oh=2eb0f5a1d8a3620ee2f69715b46c16c4&oe=58CA4515",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/15055650_1784510561804593_6421520863028206008_n.jpg?oh=98c4bd5f1420970b85eb668e4fa96eb9&oe=58BD9341"};

    private String[] geekgirl = {"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13781813_1735649153357401_6245661783111024981_n.jpg?oh=4583e95c0bbbde4b5ca27c7fcb7991c5&oe=58D2E098",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13872770_1735649163357400_5791924121450167966_n.jpg?oh=857e52c3b800a82fe3a3280b31d34ce7&oe=58B4A72D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13680879_1735649233357393_2514540819086010439_n.jpg?oh=9d7896c6617beaaba2ecbb9afddb8fff&oe=58CDCC7E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13707734_1735649476690702_7088712359062724233_n.jpg?oh=5da50b4874b257976fdfffd52811bc6b&oe=58B2EDB2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13872665_1735649746690675_6505463490243024647_n.jpg?oh=85e5740fe291ef62cccc65696124b7f0&oe=58BC996C"};

    private String[] waso ={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13690776_1730306290558354_6741646252575657389_n.jpg?oh=6b94b9aa99aa39631e732fef314b822e&oe=58C6CEBF",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13731530_1730306370558346_1359025298751819799_n.jpg?oh=78da87ae55af934d754a4164df728465&oe=58B58DA8",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13654377_1730306417225008_6046207536038780090_n.jpg?oh=18dbe73c16f25471b2f6f25a7bda638a&oe=58BF1ADF",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13686537_1730306473891669_3644795935212427913_n.jpg?oh=f49326423dcb48269e1ebf2bc75f3810&oe=58C3452D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13680571_1730306533891663_4877194807953492872_n.jpg?oh=083c4ee5d1dd9861d7754a706fc86376&oe=58B2DD26",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13681021_1730306587224991_7423603460725023374_n.jpg?oh=8d684c41c50b96d4c70c3ff8f282f242&oe=58C3F35E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13716262_1730306707224979_1439383032997034905_n.jpg?oh=815a3fc0a57c15b9cf9c00a1ff797c1f&oe=58C4F2E0",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13692649_1730306793891637_2932508407613080787_n.jpg?oh=e6ab75ba01140fb639afd925523ca7d2&oe=58CBF40F",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13690722_1730306863891630_1416234866248266321_n.jpg?oh=b29927b91e5e9c59bb70a27e0cda8764&oe=58B6E257",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13716141_1730306907224959_4344437008525116530_n.jpg?oh=57361f3ea39b279521e8e53ecce1cbc8&oe=58BA3561",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13716141_1730306907224959_4344437008525116530_n.jpg?oh=57361f3ea39b279521e8e53ecce1cbc8&oe=58BA3561",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13731641_1730306947224955_2521040048137943779_n.jpg?oh=378b10940bec25d9350a60a3233a30fb&oe=58D177E5",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13697030_1730306987224951_6338487383157299837_n.jpg?oh=313dc1db7aff9bd75543b33f9abc073a&oe=58D14E99",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13728900_1730307017224948_1234144038685921727_n.jpg?oh=486cfdce97596a963408e0a8741671f3&oe=58B9771C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13680979_1730307063891610_3050543696783412624_n.jpg?oh=0e538abc6380d45c5af43fc1c9567a1a&oe=58B1B961"};

    private String[] asia={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-0/p320x320/13516183_1722588761330107_4686936135508057132_n.jpg?oh=6b064b9eed053d36dc47f80f40ce5c80&oe=58B489D7",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13439096_1722762304646086_8306108200700382751_n.jpg?oh=f8877a4ab2bc28c991165f178ce5c0f4&oe=58B74F8F",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13533105_1722762301312753_8336687405651839393_n.jpg?oh=2f630361d4f79bcee69d749e6ac2e5ef&oe=58CB044D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13533186_1722758191313164_5068324404650940970_n.jpg?oh=997e38601bf721d116154aa64e6d2c8c&oe=58CE5853",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13508989_1722758124646504_7195832331168394714_n.jpg?oh=ae21b82663183793a742d2552e69d32a&oe=58BA8ED3",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13510774_1722758117979838_4505382067615798315_n.jpg?oh=3f823cf45fe05485f6814726015a4f12&oe=58CC4561",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13494964_1722588754663441_1491401581216032079_n.jpg?oh=e30fba98f89e0f71bf2b74905df9a041&oe=58B21BDB",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13516372_1722588757996774_5388861701137765039_n.jpg?oh=b8836f6eacd397d8be4f80183b153684&oe=58BBA411",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13537756_1722588937996756_397278682427449478_n.jpg?oh=1dae8c76510b28d9e97f4642bd2e1ff0&oe=58D19708",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13466123_1722109054711411_6639187302919782375_n.jpg?oh=22f8dda5a8d946d2099df9f3d7302bbb&oe=58B3AE28",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13516710_1722109898044660_6888510217120457414_n.jpg?oh=4afa1b251d631c98aac589fcefad3a4c&oe=58C9C404",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13516408_1722109988044651_4652211623514304018_n.jpg?oh=b6115835f5c17b04b4e721521eedae9b&oe=58B762FB",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13501707_1722110171377966_5955830892904658096_n.jpg?oh=e4cb38a783b433c899963e9388f79d5e&oe=58D03EF9",
            "https://scontent-sit4-1.xx.fbcdn.net/v/l/t1.0-9/13516647_1722588947996755_990324891569089799_n.jpg?oh=42a05397c7f038144e0f1b133dcd2825&oe=58C1C772",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13528833_1722589014663415_4580123111136531109_n.jpg?oh=1e7bfc5ca562c730a88ceded36d907c5&oe=58C75172",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13434847_1722589047996745_1282656964576051060_n.jpg?oh=13b3ad90fd1f8a7b20030e245d6e56fe&oe=58C69A9A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13510918_1722589677996682_2555458921112771304_n.jpg?oh=6ec3133f0d1cd841aaf29eee3a6b52b2&oe=58BE0CCB",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13529128_1722589674663349_7080461033829007526_n.jpg?oh=906ff65175fcd7bfb93ee927cba6ac1a&oe=58AEF4F8",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13494964_1722589824663334_2320216257520964815_n.jpg?oh=8529a973a9e09abe7981105d1e84ddb7&oe=58BC235D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13466296_1722589874663329_2941365984416666052_n.jpg?oh=3f0c43f38a22067ddd994baf2d5bf1f1&oe=58B0DB1A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13511947_1722589954663321_7444153440095944650_n.jpg?oh=07cc92ba80b4791ed7ca6f9216c9b577&oe=58B75443",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13510790_1722589947996655_1729891002916685012_n.jpg?oh=d470b418b07884e8d5fa5d9832c5b94b&oe=58CEDD9D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13507245_1722765111312472_5205464621371705750_n.jpg?oh=988911329a48844629a5b9ef4d807627&oe=58C2D74D"};

    private String[] showcase={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13891816_1738696933052623_6436897601535602964_n.jpg?oh=64ed3c2a254b74971183a01d77a9fb04&oe=58D14148",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13891960_1738697189719264_483758237530559869_n.jpg?oh=b01f0bcc9493945383f29cad97d77ee3&oe=58CE167B",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13921032_1738697206385929_577417291783098919_n.jpg?oh=18c523bea6a24ab4a99c3dbbeefe61e7&oe=58FB1931",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13892231_1738697246385925_3168177857194593844_n.jpg?oh=454117d19ca3f0b065ad40eaed95beec&oe=58B4CC76",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13906861_1738697279719255_7674708204897320225_n.jpg?oh=8944424a996897cb10efa4a387180010&oe=58CBCC42",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13882230_1738697299719253_6179128361205131124_n.jpg?oh=2b5a6d9f10e0c9083c8845fbcb86b916&oe=58C4C947",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13912616_1738697323052584_4605213984706722301_n.jpg?oh=4cc4888da50c2659a1cbcfdbeb39006d&oe=58C3F22B",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13938573_1738697349719248_8771934610240212138_n.jpg?oh=17ae3f45278d66d5142f559f7d5c8ea5&oe=58FBCA64",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13886840_1738697499719233_2411684180346990185_n.jpg?oh=af783eb80285fc1eb916fc9c36d86c16&oe=58D1C28C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13882134_1738697583052558_2684200495271354573_n.jpg?oh=fe2c828950e5bc704557a7c2a697db65&oe=58C9AEC4",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13924832_1738697753052541_4940562454679769883_n.jpg?oh=4d27b2061edb339daba7c5f0bc6292fa&oe=58C56A51",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13900217_1738697793052537_1048069147419022576_n.jpg?oh=185d9b77102a64492f9c5f775ba69085&oe=58B77B3C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13882087_1738697833052533_6545385173653052567_n.jpg?oh=31023f7399386af9918d7851362a4a8e&oe=58C37C1A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13876625_1738697886385861_4559014948936008818_n.jpg?oh=8452ba1159f8f5c2b415102e8723c5e0&oe=58FBD6BE",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13879348_1738697929719190_2729305994551988734_n.jpg?oh=40707d432568304db69e3a8ff6f8558a&oe=58BF753C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13886419_1738697656385884_3942561133496108061_n.jpg?oh=a5544cac535baad835ef9bc55080d127&oe=58C5F3AB",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13903213_569464166595258_5216687609299787536_n.jpg?oh=9add57ae1df577120c9b9f3a439d70a3&oe=58CCE5E3",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13932864_569464256595249_5971616512758059254_n.jpg?oh=bff5822e058c155c2b7f689e956ec97d&oe=58C1C2D3",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13907157_569464266595248_6823574238978542805_n.jpg?oh=4f0e5c355e9fd8409263926e33ce8b79&oe=58B8EAF3",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13876510_1738697156385934_7194491187516988022_n.jpg?oh=dbb402b1a03850a4b10ebede9fa7f0ea&oe=58C1966A",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13681018_569464343261907_8765757696285192891_n.jpg?oh=7ff4da83442cd54ce7f0e91103c5dd77&oe=58AFA5CE",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13879315_569464389928569_2187893529609995210_n.jpg?oh=c13e3c3f466b8acbc7c8bc72d797dac5&oe=58BAEEC0",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13934613_569464499928558_7564777307324824500_n.jpg?oh=c9ff4eae9b57c44ddb652a02d0d723cf&oe=58C3ABAC",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13924992_569465706595104_153079446890214543_n.jpg?oh=85cc33d9931a91e05b7118e98f35b3aa&oe=58CC7AE4",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13882576_569465759928432_4058766873856690010_n.jpg?oh=2f37665f49762702da3951778b7d72bf&oe=58C16538",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13907144_569465779928430_5871898148979026526_n.jpg?oh=2ed62106c94ee75eefb7af3f8070143e&oe=58B0894C",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13932858_569465829928425_526418027128851143_n.jpg?oh=541cea0d72498e8736fddadb7fb02245&oe=58BF1BD5"};

    private String[] web ={"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13669197_567795973428744_2155984429748148984_n.jpg?oh=e7a196ed11fd39c162bc8c8e911afe0c&oe=58B48224",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13891818_567795996762075_4788448116533848812_n.jpg?oh=02b0dd02101cbd6da59fee37c6d5080f&oe=58CE6A2D",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13886270_567796010095407_2246513337622088438_n.jpg?oh=7df87ce635f4a489f984d8039b59567a&oe=58C73324",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13882664_567796066762068_6865909793004052885_n.jpg?oh=1401c28d9afc2d3e03aef87281a4c4f2&oe=58B6D636"};

    private String[] blood ={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13680973_1730783230510660_6120669513639668162_n.jpg?oh=7bf17c716f879f900c0524a81de7c1d6&oe=58CB7C09",
            "https://2.bp.blogspot.com/-RguTBFF4WYM/WCYbl4dPePI/AAAAAAAAAHg/BP7b9AR87MUCILMillr0zrUBGMHtQoBigCLcB/s320/FormatFactoryIMG_4023.jpg",
            "https://4.bp.blogspot.com/-N-S_OBdnwdE/WCYblJ1UaCI/AAAAAAAAAHc/EUm6OVa3hSMRmlkyeQBON4RO8Lu4kab7gCLcB/s320/FormatFactoryIMG_4031.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13658916_1730783297177320_5651863160996552799_n.jpg?oh=86f2132877eac00add15465d70cab6a6&oe=58AE4AB9",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13669241_1730783570510626_3108603017524186817_n.jpg?oh=5912f3f49ee31dfd3604cde745c56526&oe=58C610F2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13680658_1730783747177275_8726018792966771148_n.jpg?oh=c5aeafd69da07151ce2edf9cf483233f&oe=58B3255B",
            "https://2.bp.blogspot.com/-P1zyibque98/WCYbl2h4SYI/AAAAAAAAAHk/sMDH_8zurwsPVLPudZj_O_FUmcWW-LFTACLcB/s320/FormatFactoryIMG_4039.jpg",
            "https://3.bp.blogspot.com/-vKJ5rDLQZhg/WCYbpj4bI6I/AAAAAAAAAHs/AXwckFJohbIM-yDJIXHPUW2RfCPgGUk6ACLcB/s320/FormatFactoryIMG_4071.jpg",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13669614_561992234009118_1040158308372258867_n.jpg?oh=7ba1817e1c804b42d0f663977c30ab2a&oe=58B76496",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13718749_561992320675776_7494096115391636769_n.jpg?oh=54dad74ddb23a932c536951b5c517327&oe=58CA8766",
            "https://4.bp.blogspot.com/-Dn5HxNDQQIc/WCYbrLKYmMI/AAAAAAAAAH0/WaO376Qc7WENg5pweqmZDC68xoWCvw9iQCLcB/s320/FormatFactoryIMG_4105.jpg"};

    private String[] sarpay={"https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13592567_1727077974214519_465878828380057375_n.jpg?oh=e39f05a914ca7620ec941d322b222218&oe=58B879F2",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13606829_1727084057547244_3212677518639745158_n.jpg?oh=528d114e009e6b3ab0ec1bec1a4cb993&oe=58CBB413",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13606471_1727084167547233_5401657899023731811_n.jpg?oh=83bcb867f3edb78b6ef0a15da4bc11f5&oe=58CECE8E",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13533163_1727084314213885_7276714640821020328_n.jpg?oh=1f94f9140bb5ff841e220f5718c3d998&oe=58B39724",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13620021_1727084440880539_3658012809789666578_n.jpg?oh=fef37dfa19eca8f7e6918498a08ef1d2&oe=58B89CF7",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13533163_1727084420880541_2804720915632033859_n.jpg?oh=9d68d567b84b26489fbc5396aa0da1f0&oe=58FBC849",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13626549_1727084490880534_4241245462169645963_n.jpg?oh=1532daddbd2bd8752824d287a8b9a4fd&oe=58BE4029",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13592292_1727084447547205_6302698353603019010_n.jpg?oh=8dc624724e65fecdeb51d63c477f3202&oe=58B6C6AF",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13567477_1727084510880532_3986283926249014676_n.jpg?oh=385a3533d3da16ada938e54e9d925be1&oe=58D0929D",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13619856_1727084990880484_4194492634466861990_n.jpg?oh=0a7323893f1714ffcaa9656a8639a113&oe=58FC6DC6",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13567022_1727084974213819_610748623601283450_n.jpg?oh=a6d40a27b4f17ec893acc7c497d103d6&oe=58B39BC7",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13626455_1727085184213798_8263403021011192470_n.jpg?oh=3b9b2252a217f8c3800e24d5d8b276f3&oe=58BA360D",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13600150_1727085207547129_1879845354621650999_n.jpg?oh=d2f254780d30722facc27ac6789b5ed6&oe=58BC091A",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13620111_1727085250880458_2296774002397744184_n.jpg?oh=d6549ecae5949d99c3b0548a9ec77772&oe=58C791A3",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13620023_1727085274213789_92970199543244125_n.jpg?oh=bfd10ee0b7cbd40b753dae9c89e10020&oe=58BD91D8",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13620981_1727085314213785_4944078491535914589_n.jpg?oh=c70ceba0e672d1b7e92a0c02bb46baae&oe=58B67398",
            "https://scontent-sin6-1.xx.fbcdn.net/v/t1.0-9/13592708_1727085387547111_192726264232700056_n.jpg?oh=5e26c936ae77fbc216991c181faa189c&oe=58B23193"};

    private String[] water = {"https://1.bp.blogspot.com/-VCd-eHMPf9o/WCN6Sbm83uI/AAAAAAAAAGw/QOoCcDiedKstZAfqLTi8UGhf5CFsfaU9QCLcB/s320/FB_IMG_1469857738097.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12814455_1040651315995078_6953684305371611381_n.jpg?oh=3e343dee09abe640bf581b9f412bda8a&oe=58CD42EF",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12799014_1040730839320459_9072980825588302546_n.jpg?oh=2a41d3b12e33a1766365acdab494498d&oe=58FC8279",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/247178_1040730572653819_7847624041197495163_n.jpg?oh=31a36b46f66455d45dbd148e7ee9bb40&oe=58B82075",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12795467_1040730679320475_5699296477548332850_n.jpg?oh=c3a8a38748be7f9b96d75e508bafa0ec&oe=58B6B06A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12801672_1040730775987132_3776565838100052596_n.jpg?oh=d96a14ba518f58b2a58d047f8423bde8&oe=58C63918",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12805767_1040730862653790_3389487730508692741_n.jpg?oh=c667029076cdb08b4553f6a31fb6515e&oe=58CB50D4",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12814036_1040651142661762_4461484190723458844_n.jpg?oh=abdd6443ee66265086e2f97294597384&oe=58FB5ACA",
            "https://scontent-sit4-1.xx.fbcdn.net/t31.0-8/p960x960/12828404_1040651109328432_1939207738586672351_o.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12794341_1040651222661754_6715567366916207056_n.jpg?oh=5a2418cfd6e99353a941987453db65af&oe=58C2E23A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12798939_1040651305995079_5029376578738266394_n.jpg?oh=7d5a1b00786d717e0fdb8b49f34f709f&oe=58CCF07E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12814158_1040651185995091_5658864860147153748_n.jpg?oh=3e90f24db78fe871f35a947d86ddcca5&oe=58CAC8FB",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12832336_1040474962679380_453679795639162200_n.jpg?oh=69f18297dd839f6694cf99d9df24812e&oe=58C0C4BB",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/600726_1040474976012712_6989087827588587290_n.jpg?oh=93ba1d2bc73bf1bfa1b2df8e22a4272b&oe=58CD3293",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10357525_1040475039346039_5655101660583120032_n.jpg?oh=3b84de6e0c7a0316a41c0f138d498090&oe=58B09132"};

    private String[] general ={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12717761_499733556901653_6363151004596923227_n.jpg?oh=fe979a3f3a1c4dd86d1ae9f282e671c3&oe=58B7CB5A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12715689_499733590234983_7523573105924764570_n.jpg?oh=91a0766390b49f4265e676dd899fb9f9&oe=58C29BE4",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12717645_499733620234980_2615212082071718413_n.jpg?oh=750c66c3afeb1e97630a05341b317c75&oe=58FC1F26",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12650988_499733633568312_2087779363333023446_n.jpg?oh=e3c2bf9cc1a904de510fc4a17dfa0731&oe=58CEE455",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12670271_499733650234977_5846113282456543832_n.jpg?oh=4dcea9f40677a354083a3f29a9e8d4ee&oe=58C52F02",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12687936_499733723568303_7737046947119159613_n.jpg?oh=3fa5a733d8cbf496524a9dc38a095247&oe=58CE1692",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12715537_499733773568298_9194966873513137008_n.jpg?oh=bd7128d3665abf4441e8e68803c037b1&oe=58B4DD6D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12717232_499733786901630_2238435118325055156_n.jpg?oh=82b7f52fc324872d7d5ee8f1c1ebe25d&oe=58BE5C0E"};

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_container);

        Toolbar gcToolbar = (Toolbar) findViewById(R.id.gc_toolbar);
        setSupportActionBar(gcToolbar);

        TextView gcToolText = (TextView) findViewById(R.id.gc_tool_text);
        gcToolText.setText("Gallery");

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        gcAdapter = new GalleryContainerAdapter(this,gcList);
        gcRecyclerView = (RecyclerView) findViewById(R.id.rv_galley_container);
        RecyclerView.LayoutManager manager = new GridLayoutManager(this,2);
        gcRecyclerView.setLayoutManager(manager);
        gcRecyclerView.setAdapter(gcAdapter);
        prepareData();

        gcRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {
                        switch (position){
                            case 0:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",fresher);
                                startActivity(intent);
                                break;
                            case 1:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",ioextended);
                                startActivity(intent);
                                break;
                            case 2:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",mcpa);
                                startActivity(intent);
                                break;
                            case 3:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",sport);
                                startActivity(intent);
                                break;
                            case 4:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",kahtain);
                                startActivity(intent);
                                break;
                            case 5:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",geekgirl);
                                startActivity(intent);
                                break;
                            case 6:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",waso);
                                startActivity(intent);
                                break;
                            case 7:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",asia);
                                startActivity(intent);
                                break;
                            case 8:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",showcase);
                                startActivity(intent);
                                break;
                            case 9:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",web);
                                startActivity(intent);
                                break;
                            case 10:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",blood);
                                startActivity(intent);
                                break;
                            case 11:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",sarpay);
                                startActivity(intent);
                                break;
                            case 12:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",water);
                                startActivity(intent);
                                break;
                            case 13:
                                intent = new Intent(GalleryContainer.this,Gallery.class);
                                intent.putExtra("title",title[position]);
                                intent.putExtra("gallery",general);
                                startActivity(intent);
                                break;

                        }
                    }
                }));
    }

    private void prepareData() {

        for (int i = 0 ;i<title.length;i++){
            GalleryContainerModel model = new GalleryContainerModel(title[i],image[i]);
            gcList.add(model);
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
