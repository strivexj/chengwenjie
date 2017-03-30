package com.example.activitylifecycletest;

import android.content.DialogInterface;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class OtherActivity extends AppCompatActivity {
   /* private boolean mIsTitleHide = false;
    private boolean mIsAnim = false;
    private float lastX = 0;
    private float lastY = 0;
    @Override
    public boolean dispatchTouchEvent(MotionEvent event)
    {
        super.dispatchTouchEvent(event);
        if (mIsAnim) {
            return false;
        }
        final int action = event.getAction();

        float x = event.getX();
        float y = event.getY();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                lastY = y;
                lastX = x;
                return false;
            case MotionEvent.ACTION_MOVE:
                float dY = Math.abs(y - lastY);
                float dX = Math.abs(x - lastX);
                boolean down = y > lastY ? true : false;
                lastY = y;
                lastX = x;
                if (dX < 8 && dY > 8 && !mIsTitleHide && !down) {
                    Animation anim = AnimationUtils.loadAnimation(
                            BlogListActivity.this, R.anim.push_top_in);
//              anim.setFillAfter(true);
                    anim.setAnimationListener(BlogListActivity.this);
                    title_content.startAnimation(anim);
                } else if (dX < 8 && dY > 8 && mIsTitleHide && down) {
                    Animation anim = AnimationUtils.loadAnimation(
                            BlogListActivity.this, R.anim.push_top_out);
//              anim.setFillAfter(true);
                    anim.setAnimationListener(BlogListActivity.this);
                    title_content.startAnimation(anim);
                } else {
                    return false;
                }
                mIsTitleHide = !mIsTitleHide;
                mIsAnim = true;
                break;
            default:
                return false;
        }
        return false;
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        // TODO Auto-generated method stub
        if (mIsTitleHide) {
            title.setVisibility(View.GONE);
        } else {

        }
        mIsAnim = false;
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onAnimationStart(Animation animation) {
        // TODO Auto-generated method stub
        title.setVisibility(View.VISIBLE);
        if (mIsTitleHide) {
            FrameLayout.LayoutParams lp = (Toolbar.LayoutParams) mlinear_listview
                    .getLayoutParams();
            lp.setMargins(0, 0, 0, 0);
            mlinear_listview.setLayoutParams(lp);
        } else {
            FrameLayout.LayoutParams lp = (FrameLayout.LayoutParams) title
                    .getLayoutParams();
            lp.setMargins(0, 0, 0, 0);
            title.setLayoutParams(lp);
            FrameLayout.LayoutParams lp1 = (LayoutParams) mlinear_listview
                    .getLayoutParams();
            lp1.setMargins(0,
                    getResources().getDimensionPixelSize(R.dimen.title_height),
                    0, 0);
            mlinear_listview.setLayoutParams(lp1);
        }
    }*/
    private Tts tts;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActvitiyCollector.addActivity(this);
        setContentView(R.layout.activity_other);


        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
               OtherActivity.this,android.R.layout.simple_list_item_1,data3);
        ListView listview=(ListView)findViewById(R.id.list);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent, View view, int position, long id){
               /* String reg = "^[a-zA-Z]+$";
                Pattern pattern = Pattern.compile(reg);

                Matcher matcher = pattern.matcher(b[0]);

                //boolean b = matcher.matches();*/
                 tts=new Tts();
                try {
                    String a[] = data3[position].split(",");
                    String b[] = a[1].split("  ");
                    tts.speak(OtherActivity.this, b[0]);
                }catch (Exception e){};
                //Toast.makeText(OtherActivity.this,data3[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onDestroy(){
        super.onDestroy();
        ActvitiyCollector.removeActivity(this);
        //tts.close();
    }
    private static String data2="601, seek  [siːk]\n" +
            "vt. 寻求；寻找；探索；搜索\n" +
            "vi. 寻找；探索；搜索\n" +
            "602, drove off  []\n" +
            "驱散\n" +
            "击退\n" +
            "驾车离去\n" +
            "603, liberation  [lɪbə'reɪʃ(ə)n]\n" +
            "n. 释放，解放\n" +
            "604, presence  ['prez(ə)ns]\n" +
            "n. 存在;出席;参加;风度;仪态\n" +
            "605, open up  []\n" +
            "打开；开发；开始；展示，揭露\n" +
            "606, disobedience  [dɪsə'biːdɪəns]\n" +
            "n. 不服从;违反,违抗\n" +
            "607, original  [ə'rɪdʒənl]\n" +
            "n. 原件;原作;原物;原型\n" +
            "adj. 原始的;最初的;独创的;新颖的\n" +
            "608, down  [daʊn]\n" +
            "adv. 向下,下去;在下面\n" +
            "adj. 向下的\n" +
            "n. 软毛,绒毛;[地质] 开阔的高地\n" +
            "prep. 沿着,往下\n" +
            "vt. 打倒,击败\n" +
            "vi. 下降;下去\n" +
            "609, fabled  ['feɪbəld]\n" +
            "adj. 寓言中的,虚构的\n" +
            "v. 虚构(fable的过去分词)\n" +
            "610, branded  []\n" +
            "adj. 名牌商标的;打有烙印的;有斑纹的(等于brindled)\n" +
            "v. 铭刻(brand的过去式和过去分词)\n" +
            "611, glue  [gluː]\n" +
            "vt. 粘合;似胶般固着于\n" +
            "n. 胶;各种胶合物\n" +
            "612, stray  [streɪ]\n" +
            "vi. 流浪;迷路;偏离\n" +
            "adj. 迷路的;离群的;偶遇的\n" +
            "n. 走失的家畜;流浪者\n" +
            "613, take the case of  []\n" +
            "以……为例\n" +
            "614, adopted  [ə'dɒptɪd]\n" +
            "adj. 被收养的;被采用的\n" +
            "v. 采用;接受(adopt的过去式和过去分词)\n" +
            "615, ignorant  ['ɪgn(ə)r(ə)nt]\n" +
            "adj. 无知的;愚昧的\n" +
            "616, mute  [mjuːt]\n" +
            "adj. 哑的；沉默的；无声的\n" +
            "vt. 减弱……的声音；使……柔和\n" +
            "n. 哑巴；弱音器；闭锁音\n" +
            "617, scary  ['skeərɪ]\n" +
            "adj. 提心吊胆的；引起惊慌的；胆小的\n" +
            "618, thole  [θəʊl]\n" +
            "n. 桨架；钉桨架的钉\n" +
            "vt. 忍耐；容许\n" +
            "vi. 有耐心\n" +
            "619, prolong  [prə'lɒŋ]\n" +
            "vt. 延长；拖延\n" +
            "620, spark  [spɑːk]\n" +
            "n. 火花；朝气；闪光\n" +
            "vt. 发动；鼓舞；求婚\n" +
            "vi. 闪烁；发火花；求婚\n" +
            "621, skydiving  ['skaɪdaɪvɪŋ]\n" +
            "n. 跳伞运动(由飞机跳下时先自由坠落一段时间后再张开降落伞的)\n" +
            "v. 空中杂技跳伞(skydive的现在分词)\n" +
            "622, battle  ['bæt(ə)l]\n" +
            "n. 战役;斗争\n" +
            "vi. 斗争;作战\n" +
            "vt. 与…作战\n" +
            "623, filmed  [filmd]\n" +
            "v. 拍摄(复以薄膜)\n" +
            "adj. 电影录音的\n" +
            "624, desirable  [dɪ'zaɪərəb(ə)l]\n" +
            "adj. 令人满意的；值得要的\n" +
            "n. 合意的人或事物\n" +
            "625, tapping  [tæpɪŋ]\n" +
            "n. [冶] 出钢;开孔;出渣;轻敲声\n" +
            "v. 轻敲(tap的ing形式);轻拍\n" +
            "626, early  ['ɜːlɪ]\n" +
            "adj. 早期的；早熟的\n" +
            "adv. 提早；在初期\n" +
            "627, posture  ['pɒstʃə]\n" +
            "n. 姿势;态度;情形\n" +
            "vi. 摆姿势\n" +
            "vt. 作…的姿势\n" +
            "628, sniffle  ['snɪf(ə)l]\n" +
            "vi. 抽鼻涕;抽噎(等于snuffle)\n" +
            "n. 鼻塞声;不断的吸鼻子(等于snuffle)\n" +
            "629, splendor  ['splendə]\n" +
            "n. 光彩；壮丽；显赫\n" +
            "630, seaworthy  ['siːwɜːðɪ]\n" +
            "adj. 适于航海的;经得起航海的\n" +
            "631, stability  [stə'bɪlɪtɪ]\n" +
            "n. 稳定性；坚定，恒心\n" +
            "632, diamond-shaped  ['daiəmənd'ʃeipt]\n" +
            "adj. 菱形的；钻石形的\n" +
            "633, pursue  [pə'sjuː]\n" +
            "vt. 继续;从事;追赶;纠缠\n" +
            "vi. 追赶;继续进行\n" +
            "634, caretaker  ['keəteɪkə]\n" +
            "n. 看管者;看门人;守护者\n" +
            "adj. 临时代理的\n" +
            "635, 谈话  [tán huà]\n" +
            "talk\n" +
            "conversation\n" +
            "statement\n" +
            "chat\n" +
            "636, federal  ['fed(ə)r(ə)l]\n" +
            "adj. 联邦的;同盟的\n" +
            "n. 北部联邦同盟盟员;北京连邦软件产业发展公司,国内主要的正版软件经销商\n" +
            "637, nervously  [ˈnɜːvəsli]\n" +
            "adv. 神经质地;焦急地;提心吊胆地\n" +
            "638, strength  [streŋθ; streŋkθ]\n" +
            "n. 力量；力气；兵力；长处\n" +
            "639, multiply  ['mʌltɪplaɪ]\n" +
            "vt. 乘；使增加；使繁殖；使相乘\n" +
            "vi. 乘；繁殖；增加\n" +
            "adv. 多样地；复合地\n" +
            "adj. 多层的；多样的\n" +
            "640, at one point  []\n" +
            "一度；在某处；在某一时刻\n" +
            "641, learned  ['lɜːnɪd]\n" +
            "adj. 博学的;有学问的;学术上的\n" +
            "642, economical  [iːkə'nɒmɪk(ə)l; ek-]\n" +
            "adj. 经济的；节约的；合算的\n" +
            "643, scam  [skæm]\n" +
            "n. 骗局，诡计；故事\n" +
            "vt. 欺诈；诓骗\n" +
            "vi. 欺诈；诓骗\n" +
            "644, magnet  ['mægnɪt]\n" +
            "n. 磁铁;[电磁] 磁体;磁石\n" +
            "645, renewal  [rɪ'njuːəl]\n" +
            "n. 更新,恢复;复兴;补充;革新;续借;重申\n" +
            "646, babysitter  []\n" +
            "n. 临时照顾幼儿者\n" +
            "647, talk on  []\n" +
            "继续谈\n" +
            "648, shocking  ['ʃɒkɪŋ]\n" +
            "adj. 令人震惊的;可怕的,令人厌恶的;糟糕的\n" +
            "v. 感到震惊;震动;冲突(shock的ing形式)\n" +
            "649, stark  [stɑːk]\n" +
            "adj. 完全的;荒凉的;刻板的;光秃秃的;朴实的\n" +
            "adv. 完全;明显地;突出地;质朴地\n" +
            "650, modest  ['mɑdɪst]\n" +
            "adj. 谦虚的，谦逊的；适度的；端庄的；羞怯的\n" +
            "n. (Modest)人名；(罗)莫代斯特；(德)莫德斯特；(俄)莫杰斯特\n" +
            "651, chronological  [krɒnə'lɒdʒɪk(ə)l]\n" +
            "adj. 按年代顺序排列的;依时间前后排列而记载的\n" +
            "652, lotus  ['ləʊtəs]\n" +
            "n. 莲花;荷花;莲饰\n" +
            "653, stock  [stɒk]\n" +
            "n. 股份,股票;库存;血统;树干\n" +
            "adj. 存货的,常备的;平凡的\n" +
            "vt. 进货;备有;装把手于…\n" +
            "vi. 囤积;办货;出新芽\n" +
            "654, briefly  ['briːflɪ]\n" +
            "adv. 短暂地;简略地;暂时地\n" +
            "655, drive  [draɪv]\n" +
            "vi. 开车;猛击;飞跑\n" +
            "vt. 推动,发动(机器等);驾驶(马车,汽车等);驱赶\n" +
            "n. 驱动器;驾车;[心理] 内驱力,推进力;快车道\n" +
            "656, trustworthy  ['trʌs(t)wɜːðɪ]\n" +
            "adj. 可靠的;可信赖的\n" +
            "657, Pepsi  []\n" +
            "n. [食品] 百事可乐(一种饮料的商标名称)\n" +
            "658, penguin  ['peŋgwɪn]\n" +
            "n. 企鹅;空军地勤人员\n" +
            "659, blame  [bleɪm]\n" +
            "vt. 责备；归咎于\n" +
            "n. 责备；责任；过失\n" +
            "660, firecrackers  []\n" +
            "n. 鞭炮,爆竹(firecracker的复数)\n" +
            "661, get in  []\n" +
            "进入；到达；陷入；收获\n" +
            "662, bottled  ['bɒtld]\n" +
            "adj. 瓶装的\n" +
            "663, highlighting  ['haɪ,laɪtɪŋ]\n" +
            "n. 增强亮度;突出性,醒目性\n" +
            "v. 使…显著;以强光照射(highlight的ing形式)\n" +
            "664, productive  [prə'dʌktɪv]\n" +
            "adj. 能生产的;生产的,生产性的;多产的;富有成效的\n" +
            "665, goal  [gəʊl]\n" +
            "n. 目标；球门，得分数；终点\n" +
            "vi. 攻门，射门得分\n" +
            "666, monuments  []\n" +
            "n. 遗迹;纪念物;不朽的功业;有永久价值的作品(monument的复数形式)\n" +
            "667, heartbreaking  ['hɑrt,brekɪŋ]\n" +
            "adj. 悲伤或失望到难忍程度的；令人悲伤的\n" +
            "v. 使…心碎（heartbreak的ing形式）\n" +
            "668, strick  [strɪk]\n" +
            "n. 击球；小麻耙；一束麻，一束丝\n" +
            "669, closure  ['kləʊʒə]\n" +
            "n. 关闭;终止,结束\n" +
            "vt. 使终止\n" +
            "670, stream  [striːm]\n" +
            "n. 溪流;流动;潮流;光线\n" +
            "vi. 流;涌进;飘扬\n" +
            "vt. 流出;涌出;使飘动\n" +
            "671, block  [blɒk]\n" +
            "n. 块；街区；大厦；障碍物\n" +
            "vt. 阻止；阻塞；限制\n" +
            "adj. 成批的，大块的；交通堵塞的\n" +
            "672, switch  [swɪtʃ]\n" +
            "vt. 转换;用鞭子等抽打\n" +
            "vi. 转换;抽打;[体]换防\n" +
            "n. 开关;转换;鞭子\n" +
            "673, foolish  ['fuːlɪʃ]\n" +
            "adj. 愚蠢的；傻的\n" +
            "674, blanket  ['blæŋkɪt]\n" +
            "n. 毛毯,毯子;毯状物,覆盖层\n" +
            "adj. 总括的,全体的;没有限制的\n" +
            "vt. 覆盖,掩盖;用毯覆盖\n" +
            "675, twice  [twaɪs]\n" +
            "adv. 两次；两倍\n" +
            "676, tide  [taɪd]\n" +
            "n. 趋势,潮流;潮汐\n" +
            "vt. 随潮漂流\n" +
            "677, annually  ['ænjʊəlɪ; 'ænjʊlɪ]\n" +
            "adv. 每年;一年一次\n" +
            "678, resolve  [rɪ'zɒlv]\n" +
            "vt. 决定;溶解;使…分解;决心要做…\n" +
            "vi. 解决;决心;分解\n" +
            "n. 坚决;决定要做的事\n" +
            "679, blank  [blæŋk]\n" +
            "adj. 空白的;空虚的;单调的\n" +
            "n. 空白;空虚;空白表格\n" +
            "vt. 使…无效;使…模糊;封锁\n" +
            "vi. 消失;成为空白\n" +
            "680, theme  [θiːm]\n" +
            "n. 主题；主旋律；题目\n" +
            "adj. 以奇想主题布置的\n" +
            "681, drag  [dræg]\n" +
            "vt. 拖累；拖拉；缓慢而吃力地行进\n" +
            "vi. 拖曳；缓慢而吃力地行进\n" +
            "n. 拖；拖累\n" +
            "682, dramas  []\n" +
            "pl.戏剧\n" +
            "683, arrange  [ə'reɪn(d)ʒ]\n" +
            "vt. 安排;排列;整理\n" +
            "vi. 安排;排列;协商\n" +
            "684, shuffle  ['ʃʌf(ə)l]\n" +
            "v. 洗牌；推诿，推卸；拖曳，慢吞吞地走；搅乱\n" +
            "n. 洗牌，洗纸牌；混乱，蒙混；拖着脚走\n" +
            "685, beforehand  [bɪ'fɔːhænd]\n" +
            "adv. 事先；预先\n" +
            "adj. 提前的；预先准备好的\n" +
            "686, nanny  ['nænɪ]\n" +
            "n. 保姆;母山羊\n" +
            "687, standardize  []\n" +
            "vt. 使标准化;用标准检验\n" +
            "688, mall  [mæl; mɔːl; mɒl]\n" +
            "n. 购物商场；林荫路；铁圈球场\n" +
            "689, vows  []\n" +
            "n. 婚誓;誓约(vow的复数)\n" +
            "v. 发誓;郑重声明(vow的三单形式)\n" +
            "690, italian  [ɪ'tæljən]\n" +
            "adj. 意大利的；意大利语的；意大利文化的\n" +
            "n. 意大利人；意大利语\n" +
            "691, unwrap  [ʌn'ræp]\n" +
            "vt. 打开\n" +
            "692, way up  []\n" +
            "adv. 远远在上\n" +
            "adj. 高级的，优秀的\n" +
            "693, stabbed  [stæbd]\n" +
            "v. 刺伤(stab的过去式和过去分词);刺穿\n" +
            "694, patent  ['pæt(ə)nt; 'peɪt(ə)nt]\n" +
            "vt. 授予专利；取得…的专利权\n" +
            "adj. 专利的；新奇的；显然的\n" +
            "n. 专利权；执照；专利品\n" +
            "695, cross-country  ['krɔ:s'kʌntri]\n" +
            "adj. 越野的，横过田野的；横越全国的\n" +
            "n. 越野赛跑\n" +
            "696, heat  [hiːt]\n" +
            "n. 高温;压力;热度;热烈\n" +
            "vt. 使激动;把…加热\n" +
            "697, resident  ['rezɪd(ə)nt]\n" +
            "adj. 居住的；住院医师；定居的\n" +
            "n. 居民\n" +
            "698, cola  ['kəʊlə]\n" +
            "n. 可乐;可乐树(其子含咖啡碱)\n" +
            "699, upbringing  ['ʌpbrɪŋɪŋ]\n" +
            "n. 教养；养育；抚育\n" +
            "700, pass through  []\n" +
            "穿过…；通过…\n" +
            "701, swing  [swɪŋ]\n" +
            "n. 摇摆；摆动；秋千；音律；涨落\n" +
            "vi. 摇摆；转向；悬挂；大摇大摆地行走\n" +
            "vt. 使旋转；挥舞；悬挂\n" +
            "adj. 旋转的；悬挂的；强节奏爵士音乐的\n" +
            "702, throughout  [θruː'aʊt]\n" +
            "adv. 自始至终，到处；全部\n" +
            "prep. 贯穿，遍及\n" +
            "703, effectively  [ɪ'fektɪvlɪ]\n" +
            "adv. 有效地,生效地;有力地;实际上\n" +
            "704, coaster  ['kəʊstə]\n" +
            "n. 沿岸贸易船;杯托,小托盘;雪橇\n" +
            "705, agencies  []\n" +
            "n. 代理;代理处(agency的复数)\n" +
            "706, enterprise  ['entəpraɪz]\n" +
            "n. 企业;事业;进取心;事业心\n" +
            "707, bareheaded  [beə'hedɪd]\n" +
            "adj. 不戴帽子的；光着头的\n" +
            "adv. 不戴帽地；光着头\n" +
            "708, strip  [strɪp]\n" +
            "vt. 剥夺；剥去；脱去衣服\n" +
            "n. 带；条状；脱衣舞\n" +
            "vi. 脱去衣服\n" +
            "709, nutrition  [njʊ'trɪʃ(ə)n]\n" +
            "n. 营养,营养学;营养品\n" +
            "710, presentation  [prez(ə)n'teɪʃ(ə)n]\n" +
            "n. 描述,陈述;介绍;赠送\n" +
            "711, tray  [treɪ]\n" +
            "n. 托盘;文件盒;隔底匣;(无线电的)发射箱\n" +
            "712, stretch  [stretʃ]\n" +
            "vt. 伸展,张开\n" +
            "vi. 伸展\n" +
            "adj. 可伸缩的\n" +
            "n. 伸展，延伸\n" +
            "713, windpipe  ['wɪn(d)paɪp]\n" +
            "n. 气管;嗓门\n" +
            "714, golden  ['gəʊld(ə)n]\n" +
            "adj. 金色的,黄金般的;珍贵的;金制的\n" +
            "715, or so  []\n" +
            "大约，左右\n" +
            "716, calm  [kɑːm]\n" +
            "adj. 静的，平静的；沉着的\n" +
            "vt. 使平静；使镇定\n" +
            "vi. 平静下来；镇定下来\n" +
            "n. 风平浪静\n" +
            "717, exposure  [ɪk'spəʊʒə; ek-]\n" +
            "n. 暴露;曝光;揭露;陈列\n" +
            "718, retriever  [rɪ'triːvə]\n" +
            "n. (训练成能寻回猎物的)猎犬;取回的人\n" +
            "719, owning  []\n" +
            "有\n" +
            "720, heartbroken  ['hɑːtbrəʊkən]\n" +
            "adj. 悲伤的,伤心的\n" +
            "721, orderly  ['ɔːd(ə)lɪ]\n" +
            "adj. 有秩序的;整齐的;值班的\n" +
            "n. 勤务兵;传令兵;护理员\n" +
            "adv. 顺序地;依次地\n" +
            "722, upper  ['ʌpə]\n" +
            "adj. 上面的，上部的；较高的\n" +
            "723, adolescent  [ædə'les(ə)nt]\n" +
            "adj. 青春期的；未成熟的\n" +
            "n. 青少年 adolescent health 青少年健康 adj.青春期的；未成熟的 pubertal, hebetic n.[人类]青少年 youths, teener\n" +
            "724, implications  []\n" +
            "n. 蕴涵式;卷入(implication的复数)\n" +
            "725, dramatic  [drə'mætɪk]\n" +
            "adj. 戏剧的;引人注目的;激动人心的\n" +
            "726, toolkit  ['tuːlkɪt]\n" +
            "n. 工具包，工具箱\n" +
            "727, couple  ['kʌp(ə)l]\n" +
            "n. 对;夫妇;数个\n" +
            "vi. 结合;成婚\n" +
            "vt. 结合;连接;连合\n" +
            "728, ecology  [ɪ'kɒlədʒɪ; e-]\n" +
            "n. 生态学;社会生态学\n" +
            "729, blow  [bləʊ]\n" +
            "n. 吹；打击；殴打\n" +
            "vi. 风吹；喘气\n" +
            "vt. 风吹\n" +
            "730, troubling  ['trʌbliŋ]\n" +
            "n. 浊度；浑浊度\n" +
            "731, mammals  ['mæml]\n" +
            "n. [古生] 哺乳类;哺乳类动物(mammal的复数);哺乳纲\n" +
            "732, detect  [dɪ'tekt]\n" +
            "vt. 察觉;发现;探测\n" +
            "733, mess up  []\n" +
            "陷入困境；搞糟\n" +
            "734, leggy  ['legɪ]\n" +
            "adj. 长腿的;茎长的;腿细长的\n" +
            "735, attentively  [ə'tentivli]\n" +
            "adv. 注意地；聚精会神地；周到地\n" +
            "736, aerial  ['eərɪəl]\n" +
            "adj. 空中的,航空的;空气的;空想的\n" +
            "n. [电讯] 天线\n" +
            "737, teach  [tiːtʃ]\n" +
            "vt. 教；教授；教导\n" +
            "vi. 教授；讲授；当老师\n" +
            "738, goals  [gol]\n" +
            "n. 目标，目的；进球，射中次数\n" +
            "739, give away  ['givə,wei]\n" +
            "放弃；泄露；分发；出卖\n" +
            "740, chances  []\n" +
            "n. 机会；机遇（chance的复数形式）；可能性\n" +
            "vi. 偶然发生，碰巧（chance的三单形式）\n" +
            "vt. 冒…的险（chance的三单形式）\n" +
            "741, quite  [kwaɪt]\n" +
            "adv. 很；相当；完全\n" +
            "742, towel  ['taʊəl]\n" +
            "n. 毛巾,手巾;[纸] 纸巾\n" +
            "vt. 用毛巾擦\n" +
            "vi. 用毛巾擦干身体\n" +
            "743, significantly  [sɪg'nɪfɪk(ə)ntlɪ]\n" +
            "adv. 意味深长地;值得注目地\n" +
            "744, alcoholism  ['ælkəhɒlɪz(ə)m]\n" +
            "n. 酗酒;[内科] 酒精中毒\n" +
            "745, fragrance  ['freɪgr(ə)ns]\n" +
            "n. 香味，芬芳\n" +
            "746, fish  [fɪʃ]\n" +
            "vi. 捕鱼,钓鱼;用钩捞取\n" +
            "n. 鱼,鱼类\n" +
            "vt. 钓鱼,捕鱼;搜寻\n" +
            "747, bullshit  ['bʊlʃɪt]\n" +
            "n. 胡说\n" +
            "748, workforce  ['wɜːkfɔːs]\n" +
            "n. 劳动力;工人总数,职工总数\n" +
            "749, visit  ['vɪzɪt]\n" +
            "n. 访问；参观；逗留\n" +
            "vt. 访问；参观；视察\n" +
            "vi. 访问；暂住；闲谈\n" +
            "750, failing  ['feɪlɪŋ]\n" +
            "n. 失败；缺点，过失；弱点\n" +
            "prep. 如果没有…\n" +
            "adj. 失败的\n" +
            "v. 失败；不及格（fail的ing形式）\n" +
            "751, powerfully  ['paʊɚfəli]\n" +
            "adv. 强大地;强烈地;非常\n" +
            "752, principal  ['prɪnsɪp(ə)l]\n" +
            "adj. 主要的；资本的\n" +
            "n. 首长；校长；资本；当事人\n" +
            "753, faking  [fek]\n" +
            "n. 作伪;诈骗\n" +
            "v. 假装;编造;冒充(fake的ing形式)\n" +
            "754, turn up  []\n" +
            "出现；发生；开大；发现；卷起；使仰卧\n" +
            "755, search  [sɜːtʃ]\n" +
            "vi. 搜寻；调查；探求\n" +
            "vt. 搜索；搜寻；调查；搜查；探求\n" +
            "n. 搜寻；探究，查究\n" +
            "756, feverish  ['fiːv(ə)rɪʃ]\n" +
            "adj. 发热的;极度兴奋的\n" +
            "757, hoisting  [hɔɪst]\n" +
            "n. 提升;起重\n" +
            "v. 升高;举起(hoist的ing形式)\n" +
            "758, would rather  []\n" +
            "宁愿，宁可\n" +
            "759, accompanied  []\n" +
            "v. 陪伴,伴随;伴奏(accompany的过去分词)\n" +
            "adj. 伴随的;相伴的\n" +
            "760, slippery  ['slɪp(ə)rɪ]\n" +
            "adj. 滑的;狡猾的;不稳定的\n" +
            "761, snarl  [snɑːl]\n" +
            "n. 咆哮;怒骂;混乱\n" +
            "vi. 咆哮;怒骂;缠结\n" +
            "vt. 搞乱;咆哮着说;使…缠结\n" +
            "762, once  [wʌns]\n" +
            "adv. 一次；曾经\n" +
            "conj. 一旦\n" +
            "n. 一次，一回\n" +
            "763, creative  [kriː'eɪtɪv]\n" +
            "adj. 创造性的\n" +
            "764, observational  [,ɒbzə'veɪʃənəl]\n" +
            "adj. 观测的;根据观察的\n" +
            "765, harness  ['hɑːnɪs]\n" +
            "vt. 治理；套；驾驭；披上甲胄\n" +
            "n. 马具；甲胄；挽具状带子；降落伞背带\n" +
            "766, psychological  [saɪkə'lɒdʒɪk(ə)l]\n" +
            "adj. 心理的;心理学的;精神上的\n" +
            "767, comparable  ['kɒmp(ə)rəb(ə)l]\n" +
            "adj. 可比较的;比得上的\n" +
            "768, flyby  ['flaɪbaɪ]\n" +
            "n. 飞越;飞近探测;在低空飞过指定地点\n" +
            "769, amid  [ə'mɪd]\n" +
            "prep. 在其中,在其间\n" +
            "770, further  ['fɜːðə]\n" +
            "adv. 进一步地；而且；更远地\n" +
            "adj. 更远的；深一层的\n" +
            "vt. 促进，助长；增进\n" +
            "771, digit  ['dɪdʒɪt]\n" +
            "n. 数字；手指或足趾；一指宽\n" +
            "772, reservation  [rezə'veɪʃ(ə)n]\n" +
            "n. 预约,预订;保留\n" +
            "773, typically  ['tɪpɪkəlɪ]\n" +
            "adv. 代表性地;作为特色地\n" +
            "774, gift  [gɪft]\n" +
            "n. 礼物;天赋;赠品\n" +
            "vt. 赋予;向…赠送\n" +
            "775, barely  ['beəlɪ]\n" +
            "adv. 仅仅，勉强；几乎不；公开地；贫乏地\n" +
            "776, bleaching  ['blɪtʃɪŋ]\n" +
            "adj. 漂白的\n" +
            "n. 漂白\n" +
            "v. 漂白(bleach的ing形式)\n" +
            "777, expectancy  [ɪk'spekt(ə)nsɪ; ek-]\n" +
            "n. 期望,期待\n" +
            "778, flashed  []\n" +
            "n. 闪光\n" +
            "v. 闪烁(flash的过去分词)\n" +
            "779, upside down  []\n" +
            "颠倒；混乱\n" +
            "780, terminally  []\n" +
            "adv. 最后;在末端;处于末期症状上;致命地\n" +
            "781, laundering  ['lɔːndərɪŋ]\n" +
            "n. 洗烫\n" +
            "v. 洗涤;洗黑钱(launder的ing形式)\n" +
            "782, wage  [weɪdʒ]\n" +
            "vi. 进行；发动；从事\n" +
            "n. 工资；代价；报偿\n" +
            "vt. 进行；开展\n" +
            "783, miraculous  [mɪ'rækjʊləs]\n" +
            "adj. 不可思议的，奇迹的\n" +
            "784, intervention  [ɪntə'venʃ(ə)n]\n" +
            "n. 介入；调停；妨碍\n" +
            "785, backpack  ['bækpæk]\n" +
            "n. 双肩背包,背包;远足用的背包\n" +
            "vt. 挑运;把…放入背包\n" +
            "vi. 背负简便行李旅行;挑运\n" +
            "786, dos and don'ts  []\n" +
            "执政党与在野党；注意事项，行为准则\n" +
            "787, install  [ɪn'stɔl]\n" +
            "vt. 安装；任命；安顿\n" +
            "788, announcement  [ə'naʊnsm(ə)nt]\n" +
            "n. 公告;宣告;发表;通告\n" +
            "789, living  ['lɪvɪŋ]\n" +
            "adj. 活的；现存的；活跃的；逼真的\n" +
            "n. 生活；生存；生计\n" +
            "v. 生活；居住（live的ing形式）；度过\n" +
            "790, wilderness  ['wɪldənɪs]\n" +
            "n. 荒地;大量,茫茫一片\n" +
            "791, take out  []\n" +
            "v. 取出；去掉；出发；发泄；把…带出去；邀请（某人）外出；开始\n" +
            "792, barley  ['bɑːlɪ]\n" +
            "n. 大麦\n" +
            "793, virtual reality  []\n" +
            "虚拟现实\n" +
            "794, deeper  [di:pə(r)]\n" +
            "adj. 更深\n" +
            "795, sunset  ['sʌnset]\n" +
            "n. 日落，傍晚\n" +
            "796, yearbook  ['jɪəbʊk; 'jɜː-]\n" +
            "n. 年鉴;年刊\n" +
            "797, scenery  ['siːn(ə)rɪ]\n" +
            "n. 风景；景色；舞台布景\n" +
            "798, courtyard  ['kɔːtjɑːd]\n" +
            "n. 庭院,院子;天井\n" +
            "799, assessments  []\n" +
            "评价\n" +
            "800, straightened  []\n" +
            "v. 校直;使正确;转入直路(straighten的过去分词)\n" +
            "801, tragedy  ['trædʒɪdɪ]\n" +
            "n. 悲剧；灾难；惨案\n" +
            "802, Italy  ['itəli]\n" +
            "n. 意大利（欧洲南部国家）\n" +
            "803, premimum  []\n" +
            "保险费\n" +
            "804, conduct  ['kɒndʌkt]\n" +
            "vi. 导电；带领\n" +
            "vt. 管理；引导；表现\n" +
            "n. 进行；行为；实施\n" +
            "805, affairs  []\n" +
            "n. 事务,事宜;风流韵事\n" +
            "806, dignified  ['dɪgnɪfaɪd]\n" +
            "adj. 庄严的;有尊严的;高贵的\n" +
            "v. 使高贵(dignify的过去式)\n" +
            "807, passage  ['pæsɪdʒ]\n" +
            "n. 一段(文章);走廊;通路\n" +
            "808, expose  [ɪk'spəʊz; ek-]\n" +
            "vt. 揭露，揭发；使曝光；显示\n" +
            "809, dead  [ded]\n" +
            "adj. 无生命的;呆板的;废弃了的\n" +
            "adv. 完全地\n" +
            "n. 死者\n" +
            "810, pile up  []\n" +
            "积累，堆放起来\n" +
            "811, dignity  ['dɪgnɪtɪ]\n" +
            "n. 尊严;高贵\n" +
            "812, minced  [mɪns]\n" +
            "adj. 切碎的;切成末的\n" +
            "v. 剁碎;细分;委婉地说(mince的过去分词)\n" +
            "813, documented  []\n" +
            "adj. 备有证明文件的\n" +
            "814, to my amazement  []\n" +
            "\n" +
            "815, outlook  ['aʊtlʊk]\n" +
            "n. 展望;观点;景色\n" +
            "vt. 比……好看;用目光压倒\n" +
            "vi. 朝外看\n" +
            "816, grave  [greɪv]\n" +
            "adj. 重大的；严肃的；黯淡的\n" +
            "n. 墓穴，坟墓；死亡\n" +
            "vt. 雕刻；铭记\n" +
            "817, cough  [kɒf]\n" +
            "n. 咳嗽，咳嗽声；咳嗽病\n" +
            "vt. 咳出\n" +
            "vi. 咳嗽\n" +
            "818, executive  [ɪɡ'zɛkjətɪv]\n" +
            "adj. 行政的;经营的;执行的,经营管理的\n" +
            "n. 总经理;执行委员会;执行者;经理主管人员\n" +
            "819, staircase  ['steəkeɪs]\n" +
            "n. 楼梯\n" +
            "820, Paris  ['pærɪs]\n" +
            "n. 巴黎（法国首都）；帕里斯（特洛伊王子）\n" +
            "821, gravy  ['greɪvɪ]\n" +
            "n. 肉汁;不法利润;轻易得来的钱\n" +
            "822, trash  [træʃ]\n" +
            "n. 垃圾;废物\n" +
            "vt. 丢弃;修剪树枝\n" +
            "823, thrive  [θraɪv]\n" +
            "vi. 繁荣，兴旺；茁壮成长\n" +
            "824, wall  [wɔːl]\n" +
            "n. 墙壁,围墙;似墙之物\n" +
            "vt. 用墙围住,围以墙\n" +
            "adj. 墙壁的\n" +
            "825, youngster  ['jʌŋstə]\n" +
            "n. 年轻人;少年\n" +
            "826, boast  [bəʊst]\n" +
            "vt. 夸口说,自吹自擂说;以有…而自豪\n" +
            "n. 自夸;值得夸耀的事物,引以为荣的事物\n" +
            "vi. 自吹自擂\n" +
            "827, icy  ['aɪsɪ]\n" +
            "adj. 冰冷的;冷淡的;结满冰的\n" +
            "828, garage  ['gærɑː(d)ʒ; -ɪdʒ; gə'rɑːʒ]\n" +
            "n. 车库；汽车修理厂；飞机库\n" +
            "vt. 把……送入车库\n" +
            "829, destruction  [dɪ'strʌkʃ(ə)n]\n" +
            "n. 破坏,毁灭;摧毁\n" +
            "830, routine  [ruː'tiːn]\n" +
            "n. [计] 程序；日常工作；例行公事\n" +
            "adj. 日常的；例行的\n" +
            "831, safely  ['sefli]\n" +
            "adv. 安全地\n" +
            "832, milestone  ['maɪlstəʊn]\n" +
            "n. 里程碑,划时代的事件\n" +
            "n. (Milestone)人名;(英)迈尔斯通\n" +
            "833, legislative  ['ledʒɪslətɪv]\n" +
            "adj. 立法的;有立法权的\n" +
            "n. 立法权;立法机构\n" +
            "834, woolen  []\n" +
            "adj. 羊毛的;羊毛制的\n" +
            "n. 毛织品\n" +
            "835, gala  ['gɑːlə; 'geɪlə]\n" +
            "n. 祝贺，庆祝；节日，特别娱乐\n" +
            "adj. 节日的，欢庆的；欢乐的\n" +
            "836, metallic  [mɪ'tælɪk]\n" +
            "adj. 金属的,含金属的\n" +
            "837, swig  [swɪg]\n" +
            "vi. 牛饮;大喝特喝\n" +
            "n. 痛饮,大喝;牛饮\n" +
            "vt. 牛饮;大喝特喝,豪饮\n" +
            "838, functionality  [fʌŋkʃə'nælətɪ]\n" +
            "n. 功能;[数] 泛函性,函数性\n" +
            "839, parking lot  []\n" +
            "n. 停车场\n" +
            "840, objection  [əb'dʒekʃ(ə)n]\n" +
            "n. 异议,反对;缺陷,缺点;妨碍;拒绝的理由\n" +
            "841, uniform  ['juːnɪfɔːm]\n" +
            "adj. 统一的;一致的;相同的;均衡的;始终如一的\n" +
            "n. 制服\n" +
            "vt. 使穿制服;使成一样\n" +
            "842, instal  [in'stɔ:l]\n" +
            "vt. 安装；使就任；设置\n" +
            "843, apes  []\n" +
            "n. 猿；猩猩；类人猿（ape的复数）\n" +
            "v. 模仿；仿效（ape的三单形式）\n" +
            "844, ounce  [aʊns]\n" +
            "n. 盎司;少量;雪豹\n" +
            "845, turnout  ['tɜːnaʊt]\n" +
            "n. 产量；出席者；出动；清除；[公路] 岔道\n" +
            "846, blueprints  ['blu:prints]\n" +
            "n. 蓝图;模板(blueprint的复数)\n" +
            "v. 绘…的蓝图;为…制定详细规划(blueprint的单三形式)\n" +
            "847, capable  ['keɪpəb(ə)l]\n" +
            "adj. 能干的,能胜任的;有才华的\n" +
            "848, downtime  ['daʊntaɪm]\n" +
            "n. (工厂等由于检修,待料等的)停工期;[电子] 故障停机时间\n" +
            "849, mission  ['mɪʃ(ə)n]\n" +
            "n. 使命,任务;代表团;布道\n" +
            "vt. 派遣;向……传教\n" +
            "850, telecourse  ['telɪkɔːs]\n" +
            "电视课程\n" +
            "851, heating  ['hiːtɪŋ]\n" +
            "n. [热] 加热;[建] 供暖;暖气设备\n" +
            "adj. 加热的;供热的\n" +
            "v. [热] 加热(heat的现在分词)\n" +
            "852, manner  ['mænə]\n" +
            "n. 方式;习惯;种类;规矩;风俗\n" +
            "853, court  [kɔːt]\n" +
            "n. 法院；球场；朝廷；奉承\n" +
            "vt. 招致（失败、危险等）；向…献殷勤；设法获得\n" +
            "vi. 求爱\n" +
            "854, inclusive  [ɪn'kluːsɪv]\n" +
            "adj. 包括的,包含的\n" +
            "855, twisted  ['twɪstɪd]\n" +
            "adj. 扭曲的\n" +
            "v. 扭动(twist的过去式)\n" +
            "856, feast  [fiːst]\n" +
            "vt. 享受;款待,宴请\n" +
            "n. 筵席,宴会;节日\n" +
            "vi. 享受;参加宴会\n" +
            "857, tuition  [tjuː'ɪʃ(ə)n]\n" +
            "n. 学费；讲授\n" +
            "858, import  ['ɪmpɔt]\n" +
            "n. 进口,进口货;输入;意思,含义;重要性\n" +
            "vt. 输入,进口;含…的意思\n" +
            "vi. 输入,进口\n" +
            "859, contradictory  [kɒntrə'dɪkt(ə)rɪ]\n" +
            "adj. 矛盾的；反对的；反驳的；抗辩的\n" +
            "n. 对立物；矛盾因素\n" +
            "860, nemo  ['niːməʊ]\n" +
            "n. 现场转播节目\n" +
            "861, legally  ['li:gəli]\n" +
            "adv. 合法地;法律上\n" +
            "862, pigeon  ['pɪdʒɪn; 'pɪdʒ(ə)n]\n" +
            "n. 鸽子\n" +
            "863, structure  ['strʌktʃə]\n" +
            "n. 结构;构造;建筑物\n" +
            "vt. 组织;构成;建造\n" +
            "864, up until then  []\n" +
            "直到那时\n" +
            "865, submitted  []\n" +
            "v. 递交;主张;屈服(submit的过去分词)\n" +
            "866, museum  [mjuː'zɪəm]\n" +
            "n. 博物馆\n" +
            "867, guaranteed  []\n" +
            "adj. 有保证的,;有人担保的\n" +
            "v. 担保(guarantee的过去式和过去分词)\n" +
            "868, emotion  [ɪ'məʊʃ(ə)n]\n" +
            "n. 情感;情绪\n" +
            "869, geometry  [dʒɪ'ɒmɪtrɪ]\n" +
            "n. 几何学\n" +
            "870, take pride in  []\n" +
            "v. 以…为傲\n" +
            "871, flashlight  ['flæʃlaɪt]\n" +
            "n. 手电筒;闪光灯\n" +
            "872, county  ['kaʊntɪ]\n" +
            "n. 郡,县\n" +
            "873, on average  []\n" +
            "平均；普通，通常\n" +
            "874, region  ['riːdʒ(ə)n]\n" +
            "n. 地区;范围;部位\n" +
            "875, diplomats  []\n" +
            "外交官\n" +
            "876, proficiency  [prə'fɪʃ(ə)nsɪ]\n" +
            "n. 精通，熟练\n" +
            "877, strike a nerve  []\n" +
            "说到某人心事\n" +
            "878, dampen  ['dæmp(ə)n]\n" +
            "vt. 抑制;使…沮丧;使…潮湿\n" +
            "vi. 潮湿;丧气\n" +
            "879, handed  ['hændɪd]\n" +
            "adj. 有手的;用...手的\n" +
            "v. 帮助(hand的过去分词);递送\n" +
            "880, tiptoe  ['tɪptəʊ]\n" +
            "n. 脚尖；趾尖\n" +
            "vi. 用脚尖走\n" +
            "adv. 用脚尖\n" +
            "adj. 踮着脚走的；偷偷摸摸的\n" +
            "881, Italian  [ɪ'tæljən]\n" +
            "adj. 意大利的；意大利文化的；意大利语的\n" +
            "n. 意大利人；意大利语\n" +
            "882, in transit  []\n" +
            "在运输中；在途中\n" +
            "883, at once  []\n" +
            "马上，立刻\n" +
            "884, crawl  [krɔːl]\n" +
            "vi. 爬行；匍匐行进\n" +
            "vt. 爬行；缓慢地行进\n" +
            "n. 爬行；养鱼池；匍匐而行\n" +
            "885, delicious  [dɪ'lɪʃəs]\n" +
            "adj. 美味的；可口的\n" +
            "886, marriage  ['mærɪdʒ]\n" +
            "n. 结婚;婚姻生活;密切结合,合并\n" +
            "887, untied  [ʌn'taɪd]\n" +
            "adj. 没有打结的\n" +
            "v. 解开(untie的过去分词)\n" +
            "888, liny  ['laɪnɪ]\n" +
            "adj. 似线的;划线的;有皱纹的\n" +
            "889, as a rule  []\n" +
            "通常，一般说来\n" +
            "890, Germany  ['dʒɜːmənɪ]\n" +
            "n. 德国\n" +
            "891, wide-eyed  ['waid,aid]\n" +
            "adj. 天真的；睁大眼睛的；吃惊的\n" +
            "892, unblock  [ʌn'blɒk]\n" +
            "vt. 除去…的障碍；开启；接通\n" +
            "893, resembles  []\n" +
            "似\n" +
            "894, wages  ['wedʒɪs]\n" +
            "n. [劳经] 工资；报酬（wage的复数形式）\n" +
            "v. 开展（运动等）（wage的第三人称单数形式）\n" +
            "895, peper  []\n" +
            "n. 胡椒\n" +
            "896, pitiful  ['pɪtɪfʊl; -f(ə)l]\n" +
            "adj. 可怜的，令人同情的\n" +
            "897, buffet  ['bʊfeɪ; 'bʌfeɪ]\n" +
            "n. 自助餐；小卖部；打击；猛烈冲击\n" +
            "vt. 与…搏斗；连续猛击\n" +
            "vi. 斗争；奋勇前进\n" +
            "adj. 自助的；自助餐的\n" +
            "898, credit  ['kredɪt]\n" +
            "n. 信用,信誉;[金融] 贷款;学分;信任;声望\n" +
            "vt. 相信,信任;把…归给,归功于;赞颂\n" +
            "899, trials  []\n" +
            "n. 尝试,努力;审判;考验;顿顽(trial的复数)\n" +
            "900, scream  [skriːm]\n" +
            "vi. 尖叫；呼啸；发出尖锐刺耳的声音；令人触目惊心\n" +
            "vt. 尖声喊叫；大叫大嚷着要求\n" +
            "n. 尖叫声；尖锐刺耳的声音；极其滑稽可笑的人\n" +
            "901, panicky  []\n" +
            "adj. 恐慌的;惊慌失措的\n" +
            "902, poacher  ['pəʊtʃə]\n" +
            "n. 偷猎者；侵入者；炖蛋锅\n" +
            "903, tablets  []\n" +
            "n. 药片,匾(tablet的复数形式);便笺\n" +
            "v. 用碑牌纪念;将…制成小片(tablet的第三人称单数)\n" +
            "904, statement  ['steɪtm(ə)nt]\n" +
            "n. 声明；陈述，叙述；报表，清单\n" +
            "905, stout  [staʊt]\n" +
            "adj. 结实的；矮胖的；勇敢的；激烈的\n" +
            "n. 矮胖子；烈性啤酒\n" +
            "906, miserable  ['mɪz(ə)rəb(ə)l]\n" +
            "adj. 悲惨的；痛苦的；卑鄙的\n" +
            "907, late  [leɪt]\n" +
            "adj. 晚的；迟的；已故的；最近的\n" +
            "adv. 晚；迟；最近；在晚期\n" +
            "908, dust  [dʌst]\n" +
            "n. 灰尘;尘埃;尘土\n" +
            "vt. 撒;拂去灰尘\n" +
            "vi. 拂去灰尘;化为粉末\n" +
            "909, bulletin  ['bʊlɪtɪn]\n" +
            "n. 公告,公报\n" +
            "vt. 公布,公告\n" +
            "910, attendants  []\n" +
            "n. 服务员;侍者,众侍从(attendant的复数)\n" +
            "911, thin  [θɪn]\n" +
            "adj. 薄的；瘦的；稀薄的；微弱的\n" +
            "vt. 使瘦；使淡；使稀疏\n" +
            "vi. 变薄；变瘦；变淡\n" +
            "adv. 稀疏地；微弱地\n" +
            "n. 细小部分\n" +
            "n. (Thin)人名；(越)辰；(柬)廷\n" +
            "912, lawyer  ['lɔːjə; 'lɒɪə]\n" +
            "n. 律师；法学家\n" +
            "913, broke down  []\n" +
            "打破，折断（break down的过去分词）\n" +
            "临时出故障的,坏了的\n" +
            "914, virtue  ['vɜːtjuː; -tʃuː]\n" +
            "n. 美德；优点；贞操；功效\n" +
            "915, mining  ['maɪnɪŋ]\n" +
            "n. 矿业;采矿\n" +
            "916, earnest  ['ɜːnɪst]\n" +
            "adj. 认真的，热心的；重要的\n" +
            "n. 认真；定金；诚挚\n" +
            "917, 中华人民共和国  [zhōng huá rén mín gòng hé guó]\n" +
            "the People's Republic of China (PRC)\n" +
            "918, war  [wɔː]\n" +
            "n. 战争,斗争;军事,战术;冲突,对抗,竞争\n" +
            "vi. 打仗,作战;对抗\n" +
            "919, radically  ['rædɪkəlɪ]\n" +
            "adv. 根本上;彻底地;以激进的方式\n" +
            "920, sausages  []\n" +
            "n. 香肠, 腊肠(sausage的复数形式)\n" +
            "921, conservation  [kɒnsə'veɪʃ(ə)n]\n" +
            "n. 保存，保持；保护\n" +
            "922, extent  [ɪk'stent; ek-]\n" +
            "n. 程度;范围;长度\n" +
            "923, inability  [ɪnə'bɪlɪtɪ]\n" +
            "n. 无能力;无才能\n" +
            "924, tuned  [tjuːnd]\n" +
            "adj. 经调谐的；谱好曲的；调好台的\n" +
            "v. 调整；调音；发出乐音（tune的过去分词）\n" +
            "925, layout  ['leɪaʊt]\n" +
            "n. 布局；设计；安排；陈列\n" +
            "926, supportive  [sə'pɔːtɪv]\n" +
            "adj. 支持的;支援的;赞助的\n" +
            "927, lite  [laɪt]\n" +
            "adj. 清淡的；低盐的；简化的\n" +
            "n. 不重要的事物；简化物；软饮料\n" +
            "928, stuck  [stʌk]\n" +
            "v. 刺(stick的过去式)\n" +
            "adj. 被卡住的;不能动的\n" +
            "929, bilingual  [baɪ'lɪŋgw(ə)l]\n" +
            "adj. 双语的\n" +
            "n. 通两种语言的人\n" +
            "930, skipping  []\n" +
            "n. 跳跃;暂时把货物腾空\n" +
            "v. 跳过(skip的ing形式);轻快的跳;遗漏\n" +
            "931, playground  ['pleɪgraʊnd]\n" +
            "n. 运动场,操场\n" +
            "932, premium  ['priːmɪəm]\n" +
            "n. 保险费，额外费用；奖金\n" +
            "933, diligent  ['dɪlɪdʒ(ə)nt]\n" +
            "adj. 勤勉的；用功的，费尽心血的\n" +
            "934, taught  [tɔːt]\n" +
            "v. 教授（teach的过去分词）\n" +
            "935, am bound to  []\n" +
            "\n" +
            "936, 五四青年节  [wǔ sì qīng nián jié]\n" +
            "China's Youth Day\n" +
            "937, reception  [rɪ'sepʃ(ə)n]\n" +
            "n. 接待;接收;招待会;感受;反应\n" +
            "938, contraction  [kən'trækʃ(ə)n]\n" +
            "n. 收缩，紧缩；缩写式；害病\n" +
            "939, campsite  ['kæmpsaɪt]\n" +
            "n. 营地\n" +
            "940, vineyard  ['vɪnjɑːd; -jəd]\n" +
            "n. 葡萄园\n" +
            "941, handle  ['hænd(ə)l]\n" +
            "n. [建] 把手;柄;手感;口实\n" +
            "vt. 处理;操作;运用;买卖;触摸\n" +
            "vi. 搬运;易于操纵\n" +
            "942, straits  [streits]\n" +
            "n. 海峡;困难(strait的复数)\n" +
            "943, minimal  ['mɪnɪm(ə)l]\n" +
            "adj. 最低的;最小限度的\n" +
            "944, coherence  [kə(ʊ)'hɪər(ə)ns; kə(ʊ)'hɪərəns]\n" +
            "n. 一致;连贯性;凝聚\n" +
            "945, spot  [spɒt]\n" +
            "n. 地点;斑点\n" +
            "vt. 认出;弄脏;用灯光照射\n" +
            "vi. 沾上污渍;满是斑点\n" +
            "adj. 现场的;现货买卖的\n" +
            "adv. 准确地;恰好\n" +
            "946, conscientious  [,kɒnʃɪ'enʃəs]\n" +
            "adj. 认真的;尽责的;本着良心的;小心谨慎的\n" +
            "947, organisms  []\n" +
            "n. 生物体(organism的复数);有机体\n" +
            "948, forested  []\n" +
            "adj. 草木丛生的\n" +
            "v. 植树于(forest的过去式和过去分词)\n" +
            "949, nature  ['neɪtʃə]\n" +
            "n. 自然；性质；本性；种类\n" +
            "950, admission  [əd'mɪʃ(ə)n]\n" +
            "n. 承认；入场费；进入许可；坦白；录用\n" +
            "951, anticipate  [æn'tɪsɪpeɪt]\n" +
            "vt. 预期，期望；占先，抢先；提前使用\n" +
            "952, donor  ['dəʊnə; -nɔː]\n" +
            "n. 捐赠者;供者;赠送人\n" +
            "adj. 捐献的;经人工授精出生的\n" +
            "953, doodle  ['duːd(ə)l]\n" +
            "vi. 涂鸦;闲混;随意弹奏\n" +
            "n. 涂鸦;蠢人\n" +
            "vt. 乱涂出;闲混;随意弹奏\n" +
            "954, presidential  [,prezɪ'denʃəl]\n" +
            "adj. 总统的;首长的;统辖的\n" +
            "955, furiously  ['fjuəriəsli]\n" +
            "adv. 猛烈地；狂暴地\n" +
            "956, stick with  []\n" +
            "坚持；继续做；保持联系\n" +
            "957, humor  []\n" +
            "n. 幽默,诙谐;心情\n" +
            "vt. 迎合,迁就;顺应\n" +
            "958, anecdotes  []\n" +
            "n. 奇闻轶事(anecdote的复数)\n" +
            "959, serious  ['sɪərɪəs]\n" +
            "adj. 严肃的,严重的;认真的;庄重的;危急的\n" +
            "960, dying  ['daɪɪŋ]\n" +
            "adj. 临终的，垂死的\n" +
            "n. 死，死亡\n" +
            "v. 死，死亡；枯萎；失去活力（die的ing形式）\n" +
            "961, piece  [piːs]\n" +
            "n. 块;件;篇;硬币\n" +
            "vt. 修补;接合;凑合\n" +
            "962, disturbance  [dɪ'stɜːb(ə)ns]\n" +
            "n. 干扰；骚乱；忧虑\n" +
            "963, homogeneous  [,hɒmə(ʊ)'dʒiːnɪəs; -'dʒen-]\n" +
            "adj. 均匀的;[数] 齐次的;同种的\n" +
            "964, defined  [dɪˈfaɪnd]\n" +
            "adj. 有定义的,确定的;清晰的,轮廓分明的\n" +
            "v. 使明确;给...下定义;使...的轮廓分明(define的过去分词)\n" +
            "965, severely  [sɪ'vɪəlɪ]\n" +
            "adv. 严重地；严格地，严厉地；纯朴地\n" +
            "966, compassion  [kəm'pæʃ(ə)n]\n" +
            "n. 同情;怜悯\n" +
            "967, at ease  []\n" +
            "安逸，自由自在；舒适\n" +
            "968, subsurface  ['sʌbsɜːfɪs]\n" +
            "adj. 地下的;表面下的\n" +
            "n. 地表下岩石\n" +
            "969, chores  []\n" +
            "n. 杂务;零工;困难的工作(chore的复数)\n" +
            "970, corruption  [kə'rʌpʃ(ə)n]\n" +
            "n. 贪污,腐败;堕落\n" +
            "971, step out of  []\n" +
            "走出，失步；步调不一致\n" +
            "972, pesticides  []\n" +
            "n. 农药;杀虫剂(pesticide的复数)\n" +
            "973, assumed  [ə'sjuːmd]\n" +
            "adj. 假定的;假装的\n" +
            "974, punctuation  [pʌŋ(k)tʃʊ'eɪʃ(ə)n; -tjʊ-]\n" +
            "n. 标点；标点符号\n" +
            "975, bucket  ['bʌkɪt]\n" +
            "n. 桶，水桶；铲斗；一桶的量\n" +
            "v. 倾盆而下；颠簸着行进\n" +
            "976, estimate  ['estɪmeɪt]\n" +
            "vi. 估计，估价\n" +
            "n. 估计，估价；判断，看法\n" +
            "vt. 估计，估量；判断，评价\n" +
            "977, tempting  ['tem(p)tɪŋ]\n" +
            "adj. 吸引人的;诱惑人的\n" +
            "v. 引诱(tempt的ing形式)\n" +
            "978, dynamics  [daɪ'næmɪks]\n" +
            "n. 动力学,力学\n" +
            "979, assess  [ə'ses]\n" +
            "vt. 评定；估价；对…征税\n" +
            "980, caught  [kɔːt]\n" +
            "v. 捕捉(catch的过去分词)\n" +
            "981, reef  [riːf]\n" +
            "n. 暗礁;[地质] 矿脉;收帆\n" +
            "vt. 收帆;缩帆\n" +
            "vi. 缩帆;收帆\n" +
            "982, instincts  []\n" +
            "n. 本能(instinct的复数);直觉\n" +
            "983, snack  [snæk]\n" +
            "n. 小吃,快餐;一份,部分\n" +
            "vi. 吃快餐,吃点心\n" +
            "984, employ  [ɪm'plɒɪ; em-]\n" +
            "vt. 使用，采用；雇用；使忙于，使从事于\n" +
            "n. 使用；雇用\n" +
            "985, bottle up  []\n" +
            "隐藏，克制；装入瓶中控制，严密封锁\n" +
            "986, institute  ['ɪnstɪtjuːt]\n" +
            "vt. 开始(调查);制定;创立;提起(诉讼)\n" +
            "n. 学会,协会;学院\n" +
            "987, attend  [ə'tend]\n" +
            "vt. 出席；上（大学等）；照料；招待；陪伴\n" +
            "vi. 出席；致力于；照料；照顾\n" +
            "988, artistically  [ɑr'tɪstɪkli]\n" +
            "adv. 在艺术上;富有艺术地\n" +
            "989, getaway  ['getəweɪ]\n" +
            "n. 起步;逃走\n" +
            "adj. 逃跑用的\n" +
            "990, up and coming  []\n" +
            "精力旺盛的\n" +
            "991, pull  [pʊl]\n" +
            "vt. 拉；拔；拖\n" +
            "vi. 拉，拖；拔\n" +
            "n. 拉，拉绳；拉力，牵引力；拖\n" +
            "992, Thailand  ['tailænd; -lənd]\n" +
            "n. 泰国（东南亚国家名）\n" +
            "993, consistently  []\n" +
            "adv. 一贯地;一致地;坚实地\n" +
            "994, album  ['ælbəm]\n" +
            "n. 相簿；唱片集；集邮簿；签名纪念册\n" +
            "995, darken  ['dɑːk(ə)n]\n" +
            "vt. 使变暗;使模糊\n" +
            "vi. 变黑;变得模糊\n" +
            "996, substitute  ['sʌbstɪtjuːt]\n" +
            "n. 代用品;代替者\n" +
            "vi. 替代\n" +
            "vt. 代替\n" +
            "997, abrupt  [ə'brʌpt]\n" +
            "adj. 生硬的;突然的;唐突的;陡峭的\n" +
            "998, bakery  ['beɪk(ə)rɪ]\n" +
            "n. 面包店\n" +
            "999, busily  ['bɪzɪlɪ]\n" +
            "adv. 忙碌地,起劲地\n" +
            "1000, cherish  ['tʃerɪʃ]\n" +
            "vt. 珍爱\n" +
            "vt. 怀有(感情等);抱有(希望等)\n" +
            "1001, lemonade  [lemə'neɪd]\n" +
            "n. 柠檬水\n" +
            "1002, conference  ['kɒnf(ə)r(ə)ns]\n" +
            "n. 会议；协商；讨论；[篮]联盟\n" +
            "1003, go after  []\n" +
            "追求，追逐\n" +
            "1004, Thailand Kingdom of Thailand  []\n" +
            "\n" +
            "1005, collapse  [kə'læps]\n" +
            "vi. 倒塌；瓦解；暴跌\n" +
            "vt. 使倒塌，使崩溃；使萎陷\n" +
            "n. 倒塌；失败；衰竭\n" +
            "1006, demonstrate  ['demənstreɪt]\n" +
            "vt. 证明;展示;论证\n" +
            "vi. 示威\n" +
            "1007, maintenance  ['meɪnt(ə)nəns; -tɪn-]\n" +
            "n. 维护,维修;保持;生活费用\n" +
            "1008, poison  ['pɒɪz(ə)n]\n" +
            "vt. 污染；使中毒，放毒于；败坏；阻碍\n" +
            "vi. 放毒，下毒\n" +
            "n. 毒药，毒物；酒；有毒害的事物；[助剂] 抑制剂\n" +
            "adj. 有毒的\n" +
            "1009, physically  ['fɪzɪkəllɪ]\n" +
            "adv. 身体上,身体上地\n" +
            "1010, weigh  [weɪ]\n" +
            "vt. 权衡;考虑;称…重量\n" +
            "vi. 重量为…;具有重要性;成为…的重荷;起锚\n" +
            "n. 权衡;称重量\n" +
            "1011, utensil  [juː'tens(ə)l]\n" +
            "n. 用具,器皿\n" +
            "1012, adolescents  []\n" +
            "n. 青少年（adolescent复数）\n" +
            "1013, killer  ['kɪlə]\n" +
            "n. 杀手；致死；止痛药；宰杀的器具；断路器\n" +
            "1014, clumsy  ['klʌmzɪ]\n" +
            "adj. 笨拙的\n" +
            "1015, shunned  []\n" +
            "v. 避免;躲开(shun的过去分词)\n" +
            "1016, humble  ['hʌmbl]\n" +
            "谦逊的\n" +
            "简陋的\n" +
            "(级别或地位)低下的\n" +
            "不大的\n" +
            "使谦恭\n" +
            "轻松打败(尤指强大的对手)\n" +
            "低声下气\n" +
            "1017, tube  [tjuːb]\n" +
            "n. 管；电子管；隧道；电视机\n" +
            "vt. 使成管状；把…装管；用管输送\n" +
            "vi. 乘地铁；不及格\n" +
            "1018, dumb  [dʌm]\n" +
            "adj. 哑的,无说话能力的;不说话的,无声音的\n" +
            "1019, 光头  [guāng tóu]\n" +
            "bareheaded\n" +
            "1020, circles  ['sɝkl]\n" +
            "n. 园;循环(circle的复数);圆圈\n" +
            "v. 盘旋;环绕(circle的第三人称单数);包围\n" +
            "1021, meters  ['mi:tə(r)z]\n" +
            "n. 米;公尺(meter的复数形式)\n" +
            "1022, take on  []\n" +
            "承担；呈现；具有；流行；接纳；雇用；穿上\n" +
            "1023, halls  [hɔ:z]\n" +
            "n. 霍尔斯(姓氏);荷氏(公司名)\n" +
            "1024, clutch  [klʌtʃ]\n" +
            "n. 离合器；控制；手；紧急关头\n" +
            "vi. 攫；企图抓住\n" +
            "vt. 抓住；紧握\n" +
            "adj. 没有手提带或背带的；紧要关头的\n" +
            "1025, supply  [sə'plaɪ]\n" +
            "n. 供给,补给;供应品\n" +
            "vt. 供给,提供;补充\n" +
            "vi. 供给;替代\n" +
            "1026, plain  [pleɪn]\n" +
            "adj. 平的；简单的；朴素的；清晰的\n" +
            "n. 平原；无格式；朴实无华的东西\n" +
            "adv. 清楚地；平易地\n" +
            "n. (Plain)人名；(英)普莱恩；(法)普兰\n" +
            "1027, individualism  [ɪndɪ'vɪdjʊ(ə)lɪz(ə)m]\n" +
            "n. 个人主义;利己主义;个人特征\n" +
            "1028, emerged  []\n" +
            "vt. 出现（emerge的过去分词）；浮现，暴露\n" +
            "1029, track  [træk]\n" +
            "n. 轨道;足迹,踪迹;小道\n" +
            "vt. 追踪;通过;循路而行;用纤拉\n" +
            "vi. 追踪;走;留下足迹\n" +
            "1030, principles  []\n" +
            "n. 原则;法则;信念(principle的复数);本源\n" +
            "v. 向…灌输原则(principle的第三人称单数形式)\n" +
            "1031, multifunction  [,mʌltɪ'fʌŋkʃən]\n" +
            "n. 多功能;多用途;一体机\n" +
            "1032, misconduct  [mɪs'kɒndʌkt]\n" +
            "n. 不端行为;处理不当\n" +
            "vt. 处理不当;行为不检\n" +
            "1033, mighty  ['maɪtɪ]\n" +
            "adj. 有力的;强有力的;有势力的\n" +
            "adv. 很;极;非常\n" +
            "n. 有势力的人\n" +
            "1034, undivided  [ʌndɪ'vaɪdɪd]\n" +
            "adj. 专心的;专一的;未分开的;完整的\n" +
            "v. 未分开(undivide的过去式和过去分词)\n" +
            "1035, racism  ['reɪsɪz(ə)m]\n" +
            "n. 种族主义,种族歧视;人种偏见\n" +
            "1036, whitewater  [,wait'wɔ:tə]\n" +
            "n. 急流;白色水域\n" +
            "1037, tension  ['tenʃ(ə)n]\n" +
            "n. 张力,拉力;紧张,不安;电压\n" +
            "vt. 使紧张;使拉紧\n" +
            "1038, employees  []\n" +
            "n. 员工;雇员;从业人员(employee的复数)\n" +
            "1039, countryside  ['kʌntrɪsaɪd]\n" +
            "n. 农村，乡下；乡下的全体居民\n" +
            "1040, comrade  ['kɒmreɪd]\n" +
            "n. 同志；伙伴\n" +
            "1041, fox  [fɒks]\n" +
            "vt. 欺骗;使变酸\n" +
            "n. 狐狸;狡猾的人\n" +
            "vi. 假装;耍狡猾手段\n" +
            "1042, poultry  ['pəʊltrɪ]\n" +
            "n. 家禽\n" +
            "1043, put forward  []\n" +
            "v. 提出；拿出；放出；推举出\n" +
            "1044, falling  ['fɔlɪŋ]\n" +
            "adj. 下降的；落下的\n" +
            "n. 下降；落下；陷落\n" +
            "v. 落下（fall的ing形式）\n" +
            "1045, drama  ['drɑːmə]\n" +
            "n. 戏剧,戏剧艺术;剧本;戏剧性事件\n" +
            "1046, physician  [fɪ'zɪʃ(ə)n]\n" +
            "n. [医] 医师;内科医师\n" +
            "1047, come with  []\n" +
            "与……一起供给；伴随……发生；从……开始\n" +
            "1048, palmer  ['pɑːmə]\n" +
            "n. 朝圣者；变戏法的人；毛虫（尤指北美的小舌麦蛾幼虫）\n" +
            "1049, burden  ['bɜːd(ə)n]\n" +
            "n. 负担；责任；船的载货量\n" +
            "vt. 使负担；烦扰；装货于\n" +
            "1050, undergo  [ʌndə'gəʊ]\n" +
            "vt. 经历，经受；忍受\n" +
            "1051, supplements  []\n" +
            "n. 补充品;增补物;[昆] 补脉(supplement的复数)\n" +
            "1052, groups  []\n" +
            "n. 群组,组;团体(group的复数形式);用户组\n" +
            "v. 分组,归类(group的第三人称单数);聚合\n" +
            "1053, wine  [waɪn]\n" +
            "n. 酒,葡萄酒;紫红色\n" +
            "vi. 喝酒\n" +
            "vt. 请…喝酒\n" +
            "1054, amazonian  [,æmə'zəunjən]\n" +
            "adj. (女子)刚勇的\n" +
            "1055, alert  [ə'lɜːt]\n" +
            "vt. 警告；使警觉，使意识到\n" +
            "adj. 警惕的，警觉的；留心的\n" +
            "n. 警戒，警惕；警报\n" +
            "1056, atmosphere  ['ætməsfɪə]\n" +
            "n. 气氛；大气；空气\n" +
            "1057, guilty  ['gɪltɪ]\n" +
            "adj. 有罪的；内疚的\n" +
            "1058, runny  ['rʌnɪ]\n" +
            "adj. 流鼻涕的;水分过多的\n" +
            "1059, fort  [fɔːt]\n" +
            "n. 堡垒;要塞;(美)边界贸易站\n" +
            "vt. 设要塞保卫\n" +
            "vi. 构筑要塞\n" +
            "1060, ary  ['εəri]\n" +
            "n. 氩\n" +
            "1061, putting  ['pʊtɪŋ]\n" +
            "n. 投掷；（高尔夫球）打球入洞\n" +
            "v. 放置（put的ing形式）；轻击球；使球入洞的轻击（putt的ing形式）\n" +
            "1062, deafen  ['def(ə)n]\n" +
            "vt. 使聋;淹没\n" +
            "vi. 变聋\n" +
            "1063, quietly  [ˈkwaɪətli]\n" +
            "adv. 安静地；秘密地；平稳地\n" +
            "1064, booth  [buːð; buːθ]\n" +
            "n. 货摊；公用电话亭\n" +
            "1065, concrete  ['kɒŋkriːt]\n" +
            "adj. 混凝土的;实在的,具体的;有形的\n" +
            "vi. 凝结\n" +
            "vt. 使凝固;用混凝土修筑\n" +
            "n. 具体物;凝结物\n" +
            "1066, carriers  ['kærɪɚ]\n" +
            "n. 运送者,媒介物;运输公司(carrier复数)\n" +
            "1067, humidity  [hjʊ'mɪdɪtɪ]\n" +
            "n. [气象] 湿度;湿气\n" +
            "1068, photo album  []\n" +
            "相册；相簿\n" +
            "1069, cabin  ['kæbɪn]\n" +
            "n. 小屋;客舱;船舱\n" +
            "vt. 把…关在小屋里\n" +
            "vi. 住在小屋里\n" +
            "1070, in time  []\n" +
            "及时；适时\n" +
            "1071, additionally  [ə'dɪʃənəlɪ]\n" +
            "adv. 此外;又,加之\n" +
            "1072, dormitory  ['dɔːmɪt(ə)rɪ]\n" +
            "n. 宿舍，学生宿舍\n" +
            "adj. 住宅区的\n" +
            "1073, be obliged  []\n" +
            "感激的\n" +
            "有义务的\n" +
            "1074, spit  [spɪt]\n" +
            "vi. 吐痰；吐口水；发出劈啪声\n" +
            "vt. 吐，吐出；发出；发射\n" +
            "n. 唾液\n" +
            "1075, length  [leŋθ; leŋkθ]\n" +
            "n. 长度,长;时间的长短;(语)音长\n" +
            "1076, autoharp  ['ɔːtə(ʊ)hɑːp]\n" +
            "n. 自鸣筝（一种古琴）\n" +
            "1077, look into  []\n" +
            "观察；窥视；浏览\n" +
            "1078, algebra  ['ældʒɪbrə]\n" +
            "n. 代数学\n" +
            "1079, aging  ['eɪdʒɪŋ]\n" +
            "n. 老化;陈化,熟化\n" +
            "1080, shells  []\n" +
            "n. 贝壳(shell的复数)\n" +
            "v. 脱壳(shell的第三人称单数形式)\n" +
            "1081, acids  []\n" +
            "n. 酸,酸类;有酸味的东西(acid的复数)\n" +
            "1082, crisp  [krɪsp]\n" +
            "adj. 脆的；新鲜的；易碎的\n" +
            "vt. 使卷曲；使发脆\n" +
            "vi. 卷曲；发脆\n" +
            "n. 松脆物；油炸马铃薯片\n" +
            "1083, catch oneself  []\n" +
            "发觉自己讲错而突然住嘴\n" +
            "1084, carry out  []\n" +
            "vt. 执行，实行；贯彻；实现；完成\n" +
            "1085, access  ['ækses]\n" +
            "vt. 使用；存取；接近\n" +
            "n. 进入；使用权；通路\n" +
            "1086, research  [rɪ'sɜːtʃ; 'riːsɜːtʃ]\n" +
            "n. 研究；调查\n" +
            "vi. 研究；调查\n" +
            "vt. 研究；调查\n" +
            "1087, utterly  ['ʌtəlɪ ]\n" +
            "adv. 完全地；绝对地；全然地；彻底地，十足地\n" +
            "1088, shouting  ['ʃəʊtɪŋ]\n" +
            "n. 大喊大叫\n" +
            "vi. 大喊大叫（shout的现在分词）\n" +
            "1089, pronounce  [prə'naʊns]\n" +
            "vt. 发音;宣判;断言\n" +
            "vi. 发音;作出判断\n" +
            "1090, symptoms  []\n" +
            "n. 症状;症候;病徵\n" +
            "1091, doomed  [duːmd]\n" +
            "adj. 注定的;命定的\n" +
            "v. 注定;宣判(doom的过去分词)\n" +
            "1092, integrated  ['ɪntɪgreɪtɪd]\n" +
            "adj. 综合的;完整的;互相协调的\n" +
            "v. 整合;使…成整体(integrate的过去分词)\n" +
            "1093, USA  [ju: es 'ei]\n" +
            "abbr. 美国；美利坚合众国（the United States of America）\n" +
            "1094, take over  []\n" +
            "接管；接收\n" +
            "1095, shaken  ['ʃeɪkən]\n" +
            "v. 摇动，动摇（shake的过去分词）\n" +
            "1096, walker  ['wɔːkə]\n" +
            "n. 步行者;散步者;参加竞走者\n" +
            "1097, hardened  ['hɑːdənd]\n" +
            "adj. 变硬的;坚定的\n" +
            "v. 坚定,变硬(harden的过去分词)\n" +
            "1098, wander  ['wɒndə]\n" +
            "vi. 徘徊;漫步;迷路;离题\n" +
            "vt. 游荡,漫游\n" +
            "1099, bolt  [bəʊlt]\n" +
            "n. 博尔特(牙买加运动员,2012伦敦奥运会短跑冠军)\n" +
            "vt. 囫囵吞下;上门闩\n" +
            "vi. 逃跑;冲出\n" +
            "adv. 直立地;突然地\n" +
            "1100, metropolis  [mɪ'trɒp(ə)lɪs]\n" +
            "n. 大都市;首府;重要中心\n" +
            "1101, meanwhile  ['miːnwaɪl]\n" +
            "adv. 同时，其间\n" +
            "n. 其间，其时\n" +
            "1102, grant  [grɑːnt]\n" +
            "vt. 授予；允许；承认\n" +
            "vi. 同意\n" +
            "n. 拨款；[法] 授予物\n" +
            "1103, infer  [ɪn'fɜː]\n" +
            "vt. 推断；推论\n" +
            "vi. 推断；作出推论\n" +
            "1104, functional  ['fʌŋ(k)ʃ(ə)n(ə)l]\n" +
            "adj. 功能的\n" +
            "1105, Jupiter  ['dʒuːpɪtə]\n" +
            "n. [天] 木星;朱庇特(罗马神话中的宙斯神)\n" +
            "1106, fool  [fuːl]\n" +
            "vi. 欺骗；开玩笑；戏弄\n" +
            "n. 傻瓜；愚人；受骗者\n" +
            "vt. 欺骗，愚弄\n" +
            "adj. 傻的\n" +
            "1107, audition  [ɔː'dɪʃ(ə)n]\n" +
            "n. 听力，听觉；试听\n" +
            "vi. 试听；试音\n" +
            "vt. 对…进行面试；让…试唱\n" +
            "1108, pests  []\n" +
            "n. 害虫(pest的复数)\n" +
            "1109, explorer  [ek'splɔːrə(r)]\n" +
            "n. 探险家；探测者，探测器\n" +
            "1110, compromise  ['kɒmprəmaɪz]\n" +
            "vt. 妥协;危害\n" +
            "vi. 妥协;让步\n" +
            "n. 妥协,和解;折衷\n" +
            "1111, pensions  []\n" +
            "n. 养老金(pension的复数形式);退休金\n" +
            "v. 发放退休金(pension的第三人称单数形式)\n" +
            "1112, winery  ['waɪn(ə)rɪ]\n" +
            "n. 酿酒厂;葡萄酒酿造厂(复数wineries)\n" +
            "1113, autobiography  [ɔːtəbaɪ'ɒgrəfɪ]\n" +
            "n. 自传;自传文学\n" +
            "1114, cavalier  [,kævə'lɪə]\n" +
            "n. 骑士;武士;对女人献殷勤\n" +
            "adj. 傲慢的;漫不经心的;无忧无虑的\n" +
            "1115, faithful  ['feɪθfʊl; -f(ə)l]\n" +
            "adj. 忠实的,忠诚的;如实的;准确可靠的\n" +
            "1116, researchers  [rɪ'sɜ:tʃəz]\n" +
            "n. 研究人员,研究者(researcher的复数形式)\n" +
            "1117, flattering  ['flætərɪŋ]\n" +
            "adj. 奉承的;谄媚的\n" +
            "1118, rough  [rʌf]\n" +
            "adj. 粗糙的；粗略的；粗野的；艰苦的；未经加工的\n" +
            "vt. 使粗糙；粗暴对待；草拟\n" +
            "n. 艰苦；高低不平的地面；未经加工的材料；粗糙的部分\n" +
            "vi. 举止粗野\n" +
            "adv. 粗糙地；粗略地；粗暴地\n" +
            "1119, controversial  [kɒntrə'vɜːʃ(ə)l]\n" +
            "adj. 有争议的；有争论的\n" +
            "1120, cherub  ['tʃerəb]\n" +
            "n. 小天使；胖娃娃；天真美丽的儿童\n" +
            "1121, pathetic  [pə'θetɪk]\n" +
            "adj. 可怜的，悲哀的；感伤的；乏味的\n" +
            "1122, clerk  [klɑːk]\n" +
            "n. 职员，办事员；店员；书记；记帐员\n" +
            "vi. 当销售员，当店员\n" +
            "1123, even  ['iːv(ə)n]\n" +
            "adj. [数] 偶数的；平坦的；相等的\n" +
            "adv. 甚至；即使；还；实际上\n" +
            "vt. 使平坦；使相等\n" +
            "vi. 变平；变得可比较；成为相等\n" +
            "1124, brush  [brʌʃ]\n" +
            "n. 刷子；画笔；毛笔；争吵\n" +
            "vt. 刷；画\n" +
            "vi. 刷；擦过；掠过\n" +
            "1125, palace  ['pælɪs]\n" +
            "n. 宫殿；宅邸；豪华住宅\n" +
            "1126, ever  ['evə]\n" +
            "adv. 永远；曾经；究竟\n" +
            "1127, agents  []\n" +
            "n. 媒介;代理人;药剂(agent的复数)\n" +
            "1128, beneficial  [benɪ'fɪʃ(ə)l]\n" +
            "adj. 有益的，有利的；可享利益的\n" +
            "1129, undertake  [ʌndə'teɪk]\n" +
            "vt. 承担,保证;从事;同意;试图\n" +
            "1130, push  [pʊʃ]\n" +
            "vt. 推动；增加；推行；逼迫\n" +
            "vi. 推；推进；增加；伸展；努力争取\n" +
            "n. 推；决心；奋力；攻击；干劲；进取心\n" +
            "1131, coast  [kəʊst]\n" +
            "vi. 滑行；沿岸航行\n" +
            "vt. 沿…岸航行\n" +
            "n. 海岸；滑坡\n" +
            "n. (Coast)人名；(英)科斯特\n" +
            "1132, dim  [dɪm]\n" +
            "adj. 暗淡的,昏暗的;模糊的,看不清的;悲观的,怀疑的\n" +
            "vt. 使暗淡,使失去光泽;使变模糊\n" +
            "vi. 变模糊,变暗淡\n" +
            "n. 笨蛋,傻子\n" +
            "1133, girl  [gɜːl]\n" +
            "n. 女孩，姑娘；女儿；女朋友\n" +
            "1134, waistline  ['weɪs(t)laɪn]\n" +
            "n. 腰围;腰身部分\n" +
            "1135, outdo  [aʊt'duː]\n" +
            "vt. 超过;胜过\n" +
            "1136, weekday  ['wiːkdeɪ]\n" +
            "n. 平日，工作日\n" +
            "1137, interactive  [ɪntər'æktɪv]\n" +
            "adj. 交互式的;相互作用的\n" +
            "1138, a handful of  []\n" +
            "一把；少量的；一小部分\n" +
            "1139, defraud  [dɪ'frɔːd]\n" +
            "vt. 欺骗\n" +
            "vi. 进行诈骗(过去式defrauded,过去分词defrauded,现在分词defrauding,第三人称单数defrauds,名词defraudation)\n" +
            "1140, profit  ['prɒfɪt]\n" +
            "n. 利润;利益\n" +
            "vi. 获利;有益\n" +
            "vt. 有益于\n" +
            "1141, theoretically  [,θiə'rɛtɪkli]\n" +
            "adv. 理论地;理论上\n" +
            "1142, urgent  ['ɜːdʒ(ə)nt]\n" +
            "adj. 紧急的；急迫的\n" +
            "1143, moderate  ['mɒd(ə)rət]\n" +
            "adj. 稳健的,温和的;适度的,中等的;有节制的\n" +
            "vi. 变缓和,变弱\n" +
            "vt. 节制;减轻\n" +
            "1144, steel  [stiːl]\n" +
            "n. 钢铁；钢制品；坚固\n" +
            "vt. 钢化；使冷酷\n" +
            "adj. 钢制的；钢铁业的；坚强的\n" +
            "1145, domestic  [də'mestɪk]\n" +
            "adj. 国内的;家庭的;驯养的;一心只管家务的\n" +
            "n. 国货;佣人\n" +
            "1146, shock  [ʃɒk]\n" +
            "n. 休克；震惊；震动；打击；禾束堆\n" +
            "vt. 使休克；使震惊；使震动；使受电击；把…堆成禾束堆\n" +
            "vi. 感到震惊；受到震动；堆成禾束堆\n" +
            "adj. 浓密的；蓬乱的\n" +
            "1147, blonde  [blɒnd]\n" +
            "adj. 亚麻色的;白皙的;白肤金发碧眼的\n" +
            "n. 白肤金发碧眼的女人\n" +
            "1148, observe  [əb'zɜːv]\n" +
            "vt. 庆祝\n" +
            "vt. 观察;遵守;说;注意到;评论\n" +
            "vi. 观察;说;注意到;评论\n" +
            "1149, latin  ['lætɪn]\n" +
            "adj. 拉丁语的;拉丁人的\n" +
            "n. 拉丁语;拉丁人\n" +
            "1150, heartland  ['hɑːtlænd]\n" +
            "n. 中心地带；心脏地区\n" +
            "1151, beachfront  ['biːtʃfrʌnt]\n" +
            "n. 海滨地区\n" +
            "adj. 靠海滨的\n" +
            "1152, placeholders  \n" +
            "n. 占位符（placeholder的复数）\n" +
            "1153, syntax  ['sɪntæks]\n" +
            "n. 语法；句法；有秩序的排列\n" +
            "1154, reverse  [rɪ'vɜːs]\n" +
            "n. 背面；相反；倒退；失败;\n" +
            "vt. 颠倒；倒转;\n" +
            "adj. 反面的；颠倒的；反身的;\n" +
            "vi. 倒退；逆叫\n" +
            "1155, terminated  \n" +
            "v. 终止；结束；终结（terminate的过去分词） \n" +
            "adj. 终止的；有限的\n" +
            "1156, odd  [ɒd]\n" +
            "n. 奇数；怪人；奇特的事物 \n" +
            "adj. 奇数的；古怪的；剩余的；临时的；零散的 \n" +
            "n. (Odd)人名；(英、西、挪、瑞典)奥德\n" +
            "1157, EMULATOR  ['emjʊleɪtə]\n" +
            "n. 仿真器，模拟器；竞争者\n" +
            "1158, navigate  ['nævɪgeɪt]\n" +
            "vi. 航行，航空 \n" +
            "vt. 驾驶，操纵；使通过；航行于\n" +
            "1159, mplementation  \n" +
            "mplementation: 实现\n" +
            "1160, forth  [fɔːθ]\n" +
            "adv. 向前，向外；自…以后\n" +
            "n. (Forth)人名；(德)福特；(英)福思\n" +
            "1161, transcript  ['trænskrɪpt; 'trɑːn-]\n" +
            "n. 成绩单；抄本，副本；文字记录\n" +
            "1162, concert  ['kɒnsət]\n" +
            "n. 音乐会；一致；和谐\n" +
            "vt. 使协调；协同安排\n" +
            "vi. 协调；协力\n" +
            "adj. 音乐会用的；在音乐会上演出的\n" +
            "1163, synonymous  [sɪ'nɒnɪməs]\n" +
            "adj. 同义的；同义词的；同义突变的\n" +
            "1164, solemn  ['sɑləm]\n" +
            "adj. 庄严的，严肃的；隆重的，郑重的\n" +
            "1165, hall  [hɔːl]\n" +
            "n. 过道，门厅，走廊；会堂；食堂；学生宿舍；大厅，前厅；娱乐中心，会所\n" +
            "n. （土）哈勒（人名）；（德、波、丹、芬、瑞典）哈尔（人名）；（英）霍尔（人名）；（法）阿尔（人名）\n" +
            "1166, snap  [snæp]\n" +
            "vt. 突然折断，拉断；猛咬；啪地关上\n" +
            "vi. 咬；厉声说；咯嗒一声关上\n" +
            "n. 猛咬；劈啪声；突然折断\n" +
            "adj. 突然的\n" +
            "1167, assimilate  [ə'sɪmɪleɪt]\n" +
            "vt. 吸收；使同化；把…比作；使相似\n" +
            "vi. 吸收；同化\n" +
            "1168, french  [frɛntʃ]\n" +
            "adj. 法国的；法语的；法国人的\n" +
            "n. 法语；法国人\n" +
            "1169, ciphers  []\n" +
            "n. [计][通信] 密码，暗码；无价值的东西；密码文件（cipher的复数）\n" +
            "v. 运算；使用密码；算出；想出（cipher的三单形式）\n" +
            "1170, academic  [ækə'demɪk]\n" +
            "adj. 学术的；理论的；学院的\n" +
            "n. 大学生，大学教师；学者\n" +
            "1171, certificate  [səˈtɪfɪkɪt; (for v.,) səˈtɪfɪˌkeɪt]\n" +
            "vt. 发给证明书；以证书形式授权给…；用证书批准\n" +
            "n. 证书；执照，文凭\n" +
            "1172, social  ['səʊʃ(ə)l]\n" +
            "adj. 社会的，社交的；群居的\n" +
            "n. 联谊会；联欢会\n" +
            "1173, sophomore  ['sɒfəmɔː]\n" +
            "n. 大学二年级生；（美）有二年经验的人\n" +
            "adj. 二年级的；二年级学生的\n" +
            "1174, official  [ə'fɪʃ(ə)l]\n" +
            "adj. 官方的；正式的；公务的\n" +
            "n. 官员；公务员；高级职员\n" +
            "1175, hinder  ['hɪndə]\n" +
            "vi. 成为阻碍\n" +
            "vt. 阻碍；打扰\n" +
            "adj. 后面的\n" +
            "n. (Hinder)人名；(芬)欣德\n" +
            "1176, etiquette  ['etɪket; etɪ'ket]\n" +
            "n. 礼节，礼仪；规矩\n" +
            "1177, debit  ['debɪt]\n" +
            "vt. 记入借方，登入借方\n" +
            "n. 借方\n" +
            "1178, squash  [skwɒʃ]\n" +
            "vt. 镇压；把…压扁；使沉默\n" +
            "vi. 受挤压；发出挤压声；挤入\n" +
            "n. 壁球；挤压；咯吱声；南瓜属植物；（英）果汁饮料\n" +
            "1179, directly  [dɪ'rektlɪ; daɪ-]\n" +
            "adv. 直接地；立即；马上；正好地；坦率地\n" +
            "conj. 一…就\n" +
            "1180, bagel  ['beɪg(ə)l]\n" +
            "n. 百吉饼（先蒸后烤的发面圈）；（体育比赛中）零蛋\n" +
            "1181, baguette  [bæ'get]\n" +
            "n. 法国棍子面包；成长方形的宝石\n" +
            "n. (Baguette)人名；(法)巴盖特\n" +
            "1182, classes  [kla:siz]\n" +
            "n. 级别，阶级（class复数形式）\n" +
            "1183, canteen  [kæn'tiːn]\n" +
            "n. 食堂，小卖部；水壶\n" +
            "1184, financial  [faɪ'nænʃ(ə)l; fɪ-]\n" +
            "adj. 金融的；财政的，财务的\n" +
            "1185, society  [sə'saɪətɪ]\n" +
            "n. 社会；交往；社团；社交界\n" +
            "1186, laboratory  [lə'bɒrə,t(ə)rɪ; 'læb(ə)rə,t(ə)rɪ]\n" +
            "n. 实验室，研究室\n" +
            "1187, image  ['ɪmɪdʒ]\n" +
            "n. 影像；想象；肖像；偶像\n" +
            "vt. 想象；反映；象征；作…的像\n" +
            "n. (Image)人名；(法)伊马热\n" +
            "1188, problem  ['prɒbləm]\n" +
            "n. 难题；引起麻烦的人\n" +
            "adj. 成问题的；难处理的\n" +
            "1189, sponsor  ['spɒnsə]\n" +
            "n. 赞助者；主办者；保证人\n" +
            "vt. 赞助；发起\n" +
            "1190, soon  [suːn]\n" +
            "adv. 快；不久，一会儿；立刻；宁愿\n" +
            "1191, booklet  ['bʊklɪt]\n" +
            "n. 小册子\n" +
            "1192, residence  ['rezɪd(ə)ns]\n" +
            "n. 住宅，住处；居住\n" +
            "1193, permanent  ['pɜːm(ə)nənt]\n" +
            "adj. 永久的，永恒的；不变的\n" +
            "n. 烫发（等于permanent wave）\n" +
            "1194, explicit  [ɪk'splɪsɪt]\n" +
            "adj. 明确的；清楚的；直率的；详述的\n" +
            "1195, advisor  [əd'vaɪzə]\n" +
            "n. 顾问；指导教师；劝告者\n" +
            "1196, eloquent  ['eləkwənt]\n" +
            "adj. 意味深长的；雄辩的，有口才的；有说服力的；动人的\n" +
            "1197, prompt  [prɒm(p)t]\n" +
            "adj. 敏捷的，迅速的；立刻的\n" +
            "vt. 提示；促进；激起；（给演员）提白\n" +
            "n. 提示；付款期限；DOS命令：改变DOS系统提示符的风格\n" +
            "adv. 准时地\n" +
            "1198, compulsory  [kəm'pʌls(ə)rɪ]\n" +
            "adj. 义务的；必修的；被强制的\n" +
            "n. （花样滑冰、竞技体操等的）规定动作\n" +
            "1199, administration  [ədmɪnɪ'streɪʃ(ə)n]\n" +
            "n. 管理；行政；实施；行政机构\n" +
            "1200, faculty  ['fæk(ə)ltɪ]\n" +
            "n. 科，系；能力；全体教员\n" +
            "1201, semester  [sɪ'mestə]\n" +
            "n. 学期；半年\n" +
            "1202, campus  ['kæmpəs]\n" +
            "n. （大学）校园；大学，大学生活；校园内的草地\n" +
            "n. (Campus)人名；(英)坎帕斯；(意、罗)坎普斯；(法)康皮斯\n" +
            "1203, athletic  [æθ'letɪk]\n" +
            "adj. 运动的，运动员的；体格健壮的\n" +
            "1204, compat  \n" +
            "n. 兼容\n" +
            "1205, manifest  ['mænɪfest]\n" +
            "vt. 证明，表明；显示;\n" +
            "vi. 显示，出现;\n" +
            "n. 载货单，货单；旅客名单;\n" +
            "adj. 显然的，明显的；明白的\n" +
            "1206, drawable  ['drɔəbl]\n" +
            "adj. 可拉的，可曳的\n" +
            "1207, repositories  \n" +
            "n. 贮藏室；资源丰富地区；智囊人物（repository的复数）\n" +
            "1208, repository  [rɪ'pɒzɪt(ə)rɪ]\n" +
            "n. 贮藏室，仓库；知识库；智囊团\n" +
            "1209, script  [skrɪpt]\n" +
            "n. 脚本；手迹；书写用的字母;\n" +
            "vt. 把…改编为剧本;\n" +
            "vi. 写电影脚本\n" +
            "1210, Compile  [kəm'paɪl]\n" +
            "vt. 编译；编制；编辑；[图情] 汇编\n" +
            "1211, exclude  [ɪk'skluːd; ek-]\n" +
            "vt. 排除；排斥；拒绝接纳；逐出\n" +
            "1212, configuration  [kən,fɪgə'reɪʃ(ə)n; -gjʊ-]\n" +
            "n. 配置；结构；外形\n" +
            "1213, directory  [dɪ'rekt(ə)rɪ; daɪ-]\n" +
            "n. [计] 目录；工商名录；姓名地址录;\n" +
            "adj. 指导的；咨询的\n" +
            "1214, intent  [ɪn'tent]\n" +
            "n. 意图；目的；含义;\n" +
            "adj. 专心的；急切的；坚决的\n" +
            "1215, filter  ['fɪltə]\n" +
            "vi. 滤过；渗入；慢慢传开;\n" +
            "n. 滤波器；[化工] 过滤器；筛选；滤光器;\n" +
            "vt. 过滤；渗透；用过滤法除去;\n" +
            "n. (Filter)人名；(德)菲尔特\n" +
            "1216, inflate  [ɪn'fleɪt]\n" +
            "vt. 使充气；使通货膨胀;\n" +
            "vi. 膨胀；充气\n" +
            "1217, avatar  ['ævətɑː]\n" +
            "n. 电影《阿凡达》\n";
    public static String[] data3=data2.split("\\n");

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.a:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();break;
            case R.id.b:
                Toast.makeText(this,"You clicked Other",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(OtherActivity.this,OtherActivity.class);
                startActivity(intent);
                break;
            case R.id.c: {
                AlertDialog.Builder dialog=new AlertDialog.Builder(OtherActivity.this);
                dialog.setTitle("Exit");
                dialog.setMessage("Are you sure to exit this app?");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog,int which)
                    {
                        ActvitiyCollector.finishAll();
                    }
                });
                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();
                break;
            }
            default:
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
