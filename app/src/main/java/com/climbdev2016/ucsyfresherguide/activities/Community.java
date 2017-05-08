package com.climbdev2016.ucsyfresherguide.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.climbdev2016.ucsyfresherguide.R;
import com.climbdev2016.ucsyfresherguide.RecyclerTouchListener;
import com.climbdev2016.ucsyfresherguide.adapters.CommunityAdapter;
import com.climbdev2016.ucsyfresherguide.model.CommunityModel;

import java.util.ArrayList;
import java.util.List;

public class Community extends AppCompatActivity {

    private RecyclerView rvCommunity;
    private CommunityAdapter cadapter;
    private List<CommunityModel> communityList = new ArrayList<>();
    private String[] cTitle = {"ရန္ကုန္ကြန္ပ်ဴတာတကၠသိုလ္ေက်ာင္းသားသမဂၢ ","UCSY Computer Science Club","စာေပႏွင့္ အႏုပညာ အသင္း","အျဖဴေရာင္ေမတၱာလူငယ္မ်ားပရဟိတအသင္း"};
    private int[] cimage = {R.drawable.ucsysu, R.drawable.cslogo, R.drawable.sarpay, R.drawable.whitelogo};
    private String[] cdes;
    private int[] cBackImage = {R.drawable.ucsysu_bg,R.drawable.csclub_bg,R.drawable.sarpay_bg,R.drawable.white_bg};
    private Intent intent;

    private String[] csclub={"http://ucsycs.club/img/portfolio/2016/photo2.jpg",
            "http://ucsycs.club/img/portfolio/2016/photo3.jpg",
            "http://ucsycs.club/img/portfolio/2016/photo4.jpg",
            "http://ucsycs.club/img/portfolio/2016/photo5.jpg",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13892083_543887852470969_5238441006556690353_n.jpg?oh=ce33729dbd42a6dfec53aec8882c086a&oe=58BC8130",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13686508_541800372679717_3517415848598513640_n.png?oh=3a40fb7fbe755d8df6e883063c579287&oe=58B0AE36",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12368972_450538098472612_6897122635259154246_n.jpg?oh=f6825870ab7fb771afb809801287403b&oe=58C95FB8",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12359922_447335418792880_2576767938223954628_n.jpg?oh=059d368ed03c3d2c5600c95283c85062&oe=58CCBD60",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12313774_446641238862298_2189521412317460952_n.jpg?oh=5b0a6ff1192b7637e67f54e88d5b35ef&oe=58BE77F7",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11863475_409493115910444_9211621397200357798_n.jpg?oh=03f2cfac08dc198a55d0cfb927b7b327&oe=58BAA372",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11800253_402588453267577_6277046904802212856_n.jpg?oh=fcb8e796621245f13c8d9d2da78fe957&oe=58D0C0A6",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11781761_398192450373844_30070686718111179_n.jpg?oh=65c5abc7887f6905c591d9255c55d024&oe=58B30CB4",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11800312_398192143707208_8260245576152978990_n.jpg?oh=29b59ccc4e2d71756211e2e5aedc9e9c&oe=58C39056",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11402671_379692285557194_3354401336408558650_n.jpg?oh=7aa5acddb924bab53077083427eae315&oe=58C77D2E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11391516_378094212383668_1824818862523661410_n.jpg?oh=51d6d89f0065fbb890430f797e8212b8&oe=58AF5880",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11224683_367739670085789_5748606994309308992_n.jpg?oh=e48cc613498175581b6ab89beede2a9a&oe=58CC208B",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11215773_367193856807037_895535710931584293_n.jpg?oh=8e054da07857e8dae437c2ae8e488cd1&oe=58BA55A0",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11265527_367193603473729_8591205849447078466_n.jpg?oh=514e7a174266d2a90377ccb8ca8fdb42&oe=58B67474",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11246362_366687840190972_7509397077244581235_n.jpg?oh=9a946272c6eaa4804d3a065cdd451012&oe=58BC0DA2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10479231_366687213524368_7832827034920771801_n.jpg?oh=6e2c53697083ea9b33bf41e25e691da2&oe=58CD577C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/19687_366687083524381_55335453478783735_n.jpg?oh=98817bed7bbe145f0d679976287ae504&oe=58CBFA8E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11218533_366383203554769_5502394727831440071_n.jpg?oh=53edad61aa27bcd7dc7ffaf241ca84dc&oe=58B4ACF6",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10403369_338826372977119_7269259904160371313_n.jpg?oh=1a967aa6dcf4f9b2d8080b07a7579685&oe=58BC0B91",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/1450887_335689183290838_4796546305528886942_n.jpg?oh=1ca7dff9d3570762367d8db0328ea070&oe=58B43426",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10415628_335262930000130_3345758865211240052_n.jpg?oh=b76d157045f17d5e1f1c9254e18c69d3&oe=58BE8CD2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10425140_335240250002398_7366058253966760961_n.jpg?oh=ca7b63b5bbb02eecdf72cfabaf478dbf&oe=58D29587",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10984308_334868523372904_38819443451160196_n.jpg?oh=655f372d4d964a85568fdb5d45e900ed&oe=58CEAB67",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/1947816_331935240332899_536686075099243455_n.jpg?oh=0a1c2463aca22f8f891ef636529bcec4&oe=58C883CC",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10953147_330328673826889_8723122695060912854_n.jpg?oh=a15df5dbd21bd0aafc502ba4d8824dd7&oe=58BE5E68",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10978617_329973010529122_4485030913269899000_n.jpg?oh=f6d51cab927f291cb88b108b7936975d&oe=58C7B77E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10968406_329513673908389_1601794133544161392_n.jpg?oh=3aee27b209ce6b1c41ccb7bca6999951&oe=58CDEFAD",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10952259_325219094337847_6628817123168878018_n.jpg?oh=c26bd0e201d61834977a2257aedd8339&oe=58CF18DE",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/1601419_325219041004519_2205625425927722820_n.jpg?oh=b085dd0aa7ebacab349ee263026fd411&oe=58D37353",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10392445_322783751248048_7189426910410645037_n.jpg?oh=e5cf7ea7e244bd872cf2d3e28f0d2893&oe=58C7033C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/10550994_322085144651242_4369218227606659658_n.jpg?oh=741268bf3d9de7f7cedff29816b6b727&oe=58CCC778"};

    private String[] whiteheart={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13619901_1188308224534100_1852847553427640757_n.jpg?oh=346055af2c92bfb4b47b6ed9db4eb47a&oe=58BA6558",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13615454_1188308254534097_1388963676930727893_n.jpg?oh=196a80d28d527da59637473b422d70d6&oe=58B355ED",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13620310_1188308384534084_5835987259272394279_n.jpg?oh=b29803696c2b49aed2d9f6403a591584&oe=58B8634F",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13599846_1188309397867316_6597480274325385524_n.jpg?oh=b52214fae0d4a0b6fd99ab473295991b&oe=58BF358",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13606763_1188309447867311_8146012869465594931_n.jpg?oh=dbd304b4eb5b5d7c8ac6ac0b41b16113&oe=58C49617",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13615297_1188309584533964_3841900051002963373_n.jpg?oh=3797611a12f15f389f98be2986abdadc&oe=58C045C0",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13654187_1188309644533958_6095235489164304501_n.jpg?oh=111b3e9e9404da352c7627d5c01b1cf9&oe=58CEA102",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13606533_1188309814533941_1217371301923483635_n.jpg?oh=4a809fa24212c87520de2cd81dde0245&oe=58D1B24E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13435455_1188309971200592_6436639914996994821_n.jpg?oh=2e4436c67708cebef04bf51371df1680&oe=58D027DF",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13606606_1188310567867199_6402652839653963872_n.jpg?oh=daf2543fbed9c7c0fbc35065c0cab2cb&oe=58D3CB0A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13620749_1188310747867181_6252310442480701741_n.jpg?oh=ae9b934ff507440c425205ee85b25122&oe=58C2A635",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13606560_1188311127867143_1816309594721955362_n.jpg?oh=91618f4c773d3ba612f2f2302aae7acc&oe=58BF2DB9",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13619984_1188312607866995_4914661897730863510_n.jpg?oh=85eeb4e5f9387eb060fd3b0d168af90a&oe=58CB9F3C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13626573_1188312671200322_5331455140257123712_n.jpg?oh=f35fcd691c6996cab7bd57533bdb9b30&oe=58B68F7C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13612309_1188312771200312_6688839248088425674_n.jpg?oh=d5838bb35e440d71be649db1e4b12c03&oe=58D3320E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13615106_1188312917866964_3816873746198185001_n.jpg?oh=6d606f3660d7a1c4408b0dd6cb672e74&oe=58BECE1A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13592698_1188313054533617_6613738330528701849_n.jpg?oh=654707acfe92f6ad8736ae321e1c6c6f&oe=58CAB175",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13631445_1188313111200278_4354646327026939023_n.jpg?oh=b805fd3b59dceff1d99b0c1aac0fcf44&oe=58BBE22A",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13619954_1188313204533602_1893059317319530356_n.jpg?oh=aa2aa88c44f3e4e51ec7e31215900517&oe=58D45A0D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13620226_1188313251200264_329235281021259398_n.jpg?oh=2a32cd7ea37bcc5ae736ca0bed7a5f50&oe=58BC6AE1",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13620385_1188313321200257_8620015083669951990_n.jpg?oh=6d29fa244adc305d4405956522b58d68&oe=58BF8A6F",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13590375_1188313441200245_3723994308221699647_n.jpg?oh=fbb260b72e4314c3391f6351539fcc3c&oe=58C09196",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13620327_1188313464533576_2248610423289317442_n.jpg?oh=5afb3cc36dbf55c6b56e1ecc417fe625&oe=58AF28B5",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13600263_1188313511200238_8865507423272462858_n.jpg?oh=712f9d8fa5da455b219e95e697a50242&oe=58CE5CAF",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13590314_1188313541200235_6088992985815755373_n.jpg?oh=131260e8c60c39b2b08546a1d3d588a8&oe=58CE8ED1",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13614943_1188313591200230_7541083168634576147_n.jpg?oh=01bdf73693dfff1bd1f92405ff8f5953&oe=58C4B427",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13627171_1188313621200227_6781532064400297054_n.jpg?oh=e8dc675f351f09c165591a08dddef389&oe=58BB593D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13567365_1188313667866889_5415666021930668348_n.jpg?oh=d13341da7e2dd5f793a1dffed4bb2d84&oe=58B10C49",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13599921_1188313751200214_8997556884252679510_n.jpg?oh=6174e176d2ac95a46a06eb1bcb0b4464&oe=58C3D98C",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13626977_1188313801200209_5236605893600740745_n.jpg?oh=529f0acd82ea08c32d5e26afb9e499c7&oe=58B412C1",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13619967_1188313817866874_3751490587364171650_n.jpg?oh=e5aee62ca649efa1a298d6958d1c4ced&oe=58BC5873",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12472501_1208901682474754_3749416235781099222_n.jpg?oh=d04dd73002cbff0a52773921f40766b1&oe=58CB074E",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13887122_1208901849141404_7036248929090299487_n.jpg?oh=c95dde7ec5434a5f487257a21c7e2a47&oe=58BE294F",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13882620_1208901869141402_441820347869719574_n.jpg?oh=827da4dbe3b5d56a024462cd16a4fa95&oe=58D1A1B2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13932928_1208901892474733_3239388001131971028_n.jpg?oh=00cb43441af1c9c9150fbf4bb8ce19de&oe=58BEA8E0",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13938426_1208901919141397_7124651285078605610_n.jpg?oh=4c3b5335f5a0adb81b223d5c08fb9853&oe=58BED7E4",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13882565_1208901955808060_1712362467829002031_n.jpg?oh=a027a1522370ce322850aa24cb461cd6&oe=58C6A773",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13902578_1208902029141386_8244335805142306674_n.jpg?oh=84ad9fe509ffdb0042a74da02c182879&oe=58AE8A38",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13876611_1208902055808050_3148894850895501525_n.jpg?oh=0c44d00126ceefa5f4307aff146f64bd&oe=58C3F60D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13938581_1208902099141379_3875550926421029839_n.jpg?oh=8374f4357ac075408bc890f65c92b0c7&oe=58CFF1E0",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13882249_1208902165808039_3731231115011949562_n.jpg?oh=d8f305b536be5b220b91b33f55da44b1&oe=58CCB8B8",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13900121_1208902209141368_6109137365824528653_n.jpg?oh=fb2172030809d10b1721af9899dfba58&oe=58B890C0"};


    private String[] sarpay ={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/1450274_149211798782317_1858669984423526016_n.jpg?oh=d5f149a0ee5b43c526a4c8dafddda487&oe=58B13F01",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12507659_152513298452167_8659104077352089349_n.jpg?oh=31c8b1943283371f3d9bc35b4395ff0b&oe=58D1F458",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12509708_152824261754404_2929074774712652584_n.jpg?oh=32dfdcd94b81401d3feca690fe65b363&oe=58CDE3D7",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/11237922_161139167589580_4742190433945502377_n.jpg?oh=f54de7839b44ee014ac805a0af6021e5&oe=58C5D3DA",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/1017655_170473889989441_5721272510509983812_n.jpg?oh=3fafae92a94e2b1241c479674ec47df7&oe=58C55CF1",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12642614_172251496478347_7681481223731875685_n.jpg?oh=21f9cd13540677e101ca5d0a0fd13b32&oe=58C965C6",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13567272_260046581032171_244936562748020461_n.jpg?oh=cf6f9127bd6a40c4b0e644b4d1a73a79&oe=58FD3BB6",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13612325_260448327658663_3740453271405654102_n.jpg?oh=c2376040c208cb2cce13361872b429ac&oe=58C79CB9",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13939523_278852622484900_4181217093616717510_n.jpg?oh=529113feaff83b0efd759b81c2335fe9&oe=58CD5947",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/12642873_173592203010943_8933678616206099969_n.jpg?oh=e71befbb8b9302906d2a955aa60672a3&oe=58CBC245"};

    private String[] ucsysu={"https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13620946_1151981561530404_7096325360981936525_n.jpg?oh=0a4adbd7323a6febd386824181dfa386&oe=58D178D7",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13912585_1151981574863736_2038199125935345314_n.jpg?oh=b3ed70857bffdadd8b0add348d34bfaa&oe=58D2B425",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13912833_1151981611530399_7420792141011228811_n.jpg?oh=5c18d2f5d8e57bcb53dbd307bbdbcd4e&oe=58C8FAB2",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13906865_1151981644863729_2287817874385508985_n.jpg?oh=7e0dc27b81139953fbbb201a81d33201&oe=58CD0D37",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13886492_1151981778197049_3736504114211796947_n.jpg?oh=c3f65301b9160cf85606695a307d3929&oe=58C14D6D",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13935159_1151981881530372_380131251532892300_n.jpg?oh=138efd564fc382ac0f00246d33722288&oe=58CD1AFC",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13902610_1151981954863698_4031617198120434346_n.jpg?oh=a7e11f765dcacfd17720001089943fd9&oe=58C8BEF9",
            "https://scontent-sit4-1.xx.fbcdn.net/v/t1.0-9/13895441_1151982074863686_5395363393870273308_n.jpg?oh=17c70ce0950812059d3bfe3fd796f041&oe=58AFAD24"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        Toolbar cToolbar = (Toolbar) findViewById(R.id.comm_toolbar);
        setSupportActionBar(cToolbar);

        TextView cToolText = (TextView) findViewById(R.id.comm_tool_text);
        cToolText.setText("Community");

        final ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);

        cadapter = new CommunityAdapter(this,communityList);
        rvCommunity = (RecyclerView) findViewById(R.id.rv_community);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        rvCommunity.setLayoutManager(manager);

        prepareData();

        Resources res = getResources();
        cdes=res.getStringArray(R.array.cDes);

        rvCommunity.addOnItemTouchListener(new RecyclerTouchListener(this, rvCommunity, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                intent = new Intent(Community.this,CommunityDetail.class);
                intent.putExtra("CTitle",cTitle[position]);
                intent.putExtra("CImage",cimage[position]);
                intent.putExtra("CDes",cdes[position]);
                intent.putExtra("CBackImage",cBackImage[position]);

                switch (position){
                    case 0:
                        intent.putExtra("community",ucsysu);
                        break;
                    case 1:
                        intent.putExtra("community",csclub);
                        break;
                    case 2:
                        intent.putExtra("community",sarpay);
                        break;
                    case 3:
                        intent.putExtra("community",whiteheart);
                        break;
                }

                startActivity(intent);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        rvCommunity.setAdapter(cadapter);
    }

    private void prepareData() {

        for (int i =0 ; i<cTitle.length;i++){
        CommunityModel communityModel = new CommunityModel(cTitle[i],cimage[i]);
        communityList.add(communityModel);
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
