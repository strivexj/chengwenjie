package com.example.activitylifecycletest;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import  java.lang.*;
public  class DialogActivity extends AppCompatActivity {
    private Tts tts;

    protected void onDestroy(){
       super.onDestroy();
       ActvitiyCollector.removeActivity(this);
       // tts.close();
   }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActvitiyCollector.addActivity(this);
        setContentView(R.layout.activity_dialog);
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(
                DialogActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listview=(ListView)findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent, View view, int position, long id){
                 tts=new Tts();

                    try {
                        String a[] = data[position].split(",");
                        String b[] = a[1].split("  ");
                        tts.speak(DialogActivity.this, b[0]);
                    }catch (Exception e){};

               // Toast.makeText(DialogActivity.this,data[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.a:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();break;
            case R.id.b:
                Toast.makeText(this,"You clicked Other",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(DialogActivity.this,OtherActivity.class);
                startActivity(intent);
                break;
            case R.id.c: {
                AlertDialog.Builder dialog=new AlertDialog.Builder(DialogActivity.this);
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
                //Toast.makeText(this, "You clicked Exit", Toast.LENGTH_SHORT).show();
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
    private static String data1="1, constitute  ['kɒnstɪtjuːt]\n" +
            "vt. 组成，构成；建立；任命\n" +
            "2, mountain  ['maʊntɪn]\n" +
            "n. 山；山脉\n" +
            "n. (Mountain)人名；(英)芒廷\n" +
            "3, compete  [kəm'piːt]\n" +
            "vi. 竞争；比赛；对抗\n" +
            "4, pride  [praɪd]\n" +
            "n. 自豪；骄傲；自尊心\n" +
            "vt. 使得意，以…自豪\n" +
            "vi. 自豪\n" +
            "5, roll  [rəʊl]\n" +
            "vt. 卷；滚动，转动；辗\n" +
            "vi. 卷；滚动；转动；起伏，摇晃\n" +
            "n. 卷，卷形物；名单；摇晃\n" +
            "6, refer  [rɪ'fɜː]\n" +
            "vi. 参考；涉及；提到；查阅\n" +
            "vt. 涉及；委托；归诸于；使…求助于\n" +
            "7, sail  [seɪl]\n" +
            "vi. 航行；启航，开船\n" +
            "n. 帆，篷；航行\n" +
            "vt. 航行\n" +
            "8, quantity  ['kwɒntɪtɪ]\n" +
            "n. 量，数量；大量；总量\n" +
            "9, slow  [sləʊ]\n" +
            "adj. 慢的；减速的；迟钝的\n" +
            "vi. 变慢；变萧条\n" +
            "vt. 放慢；阻碍\n" +
            "adv. 慢慢地；迟缓地\n" +
            "n. (Slow)人名；(英)斯洛\n" +
            "10, instant  ['ɪnst(ə)nt]\n" +
            "adj. 立即的；紧急的；紧迫的\n" +
            "n. 瞬间；立即；片刻\n" +
            "11, bureau  ['bjʊərəʊ]\n" +
            "n. 局，处；衣柜；办公桌\n" +
            "n. (Bureau)人名；(法)比罗\n" +
            "12, ordinary  ['ɔːdɪn(ə)rɪ; -d(ə)n-]\n" +
            "adj. 普通的；平凡的；平常的\n" +
            "n. 普通；平常的人（或事）\n" +
            "13, adequate  ['ædɪkwət]\n" +
            "adj. 充足的；适当的；胜任的\n" +
            "14, soul  [səʊl]\n" +
            "n. 灵魂；心灵；精神；鬼魂\n" +
            "adj. 美国黑人文化的\n" +
            "n. (Soul)人名；(英、法)苏尔\n" +
            "15, parent  ['peər(ə)nt]\n" +
            "n. 父亲（或母亲）；父母亲；根源\n" +
            "16, regard  [rɪ'gɑːd]\n" +
            "n. 注意；尊重；问候；凝视\n" +
            "vt. 注重，考虑；看待；尊敬；把…看作；与…有关\n" +
            "vi. 注意，注重；注视\n" +
            "n. (Regard)人名；(西、意)雷加德；(法)勒加尔\n" +
            "17, quiet  ['kwaɪət]\n" +
            "adj. 安静的；安定的；不动的；温顺的\n" +
            "n. 安静；和平\n" +
            "vt. 使平息；安慰\n" +
            "vi. 平静下来\n" +
            "18, blood  [blʌd]\n" +
            "n. 血，血液；血统\n" +
            "vt. 从…抽血；使先取得经验\n" +
            "19, convince  [kən'vɪns]\n" +
            "vt. 说服；使确信，使信服\n" +
            "20, pure  [pjʊə]\n" +
            "adj. 纯的；纯粹的；纯洁的；清白的；纯理论的\n" +
            "21, dawn  [dɔːn]\n" +
            "n. 黎明；开端\n" +
            "vt. 破晓；出现；被领悟\n" +
            "n. (Dawn)人名；(西)道恩\n" +
            "22, struggle  ['strʌg(ə)l]\n" +
            "vi. 奋斗，努力；挣扎\n" +
            "n. 努力，奋斗；竞争\n" +
            "vt. 使劲移动；尽力使得\n" +
            "23, butter  ['bʌtə]\n" +
            "vt. 涂黄油于；讨好\n" +
            "n. 黄油；奶油；奉承话\n" +
            "24, favor  ['feɪvə]\n" +
            "vt. 赞成；喜欢；像；赐予；证实\n" +
            "n. 喜爱；欢心；好感\n" +
            "25, conflict  ['kɒnflɪkt]\n" +
            "n. 冲突，矛盾；斗争；争执\n" +
            "vi. 冲突，抵触；争执；战斗\n" +
            "26, advocate  ['ædvəkət]\n" +
            "vt. 提倡，主张，拥护\n" +
            "n. 提倡者；支持者；律师\n" +
            "27, uncle  ['ʌŋk(ə)l]\n" +
            "n. 叔叔；伯父；伯伯；舅父；姨丈；姑父\n" +
            "28, discovery  [dɪ'skʌv(ə)rɪ]\n" +
            "n. 发现，发觉；被发现的事物\n" +
            "29, steady  ['stedɪ]\n" +
            "adj. 稳定的；不变的；沉着的\n" +
            "vi. 稳固\n" +
            "vt. 使稳定；稳固；使坚定\n" +
            "adv. 稳定地；稳固地\n" +
            "n. 关系固定的情侣；固定支架\n" +
            "30, harm  [hɑːm]\n" +
            "n. 伤害；损害\n" +
            "vt. 伤害；危害；损害\n" +
            "n. (Harm)人名；(德)哈尔姆\n" +
            "31, superior  [suː'pɪərɪə; sjuː-]\n" +
            "adj. 上级的；优秀的，出众的；高傲的\n" +
            "n. 上级，长官；优胜者，高手；长者\n" +
            "32, servant  ['sɜːv(ə)nt]\n" +
            "n. 仆人，佣人；公务员；雇工\n" +
            "33, prohibit  [prə(ʊ)'hɪbɪt]\n" +
            "vt. 阻止，禁止\n" +
            "34, surrounding  [sə'raʊndɪŋ]\n" +
            "adj. 周围的，附近的\n" +
            "n. 环境，周围的事物\n" +
            "35, allergic  [ə'lɜːdʒɪk]\n" +
            "adj. 对…过敏的；对…极讨厌的\n" +
            "36, punctual  ['pʌŋ(k)tʃʊəl; -tjʊəl]\n" +
            "adj. 准时的，守时的；精确的\n" +
            "37, fierce  [fɪəs]\n" +
            "adj. 凶猛的；猛烈的；暴躁的\n" +
            "n. (Fierce)人名；(英)菲尔斯\n" +
            "38, liberate  ['lɪbəreɪt]\n" +
            "vt. 解放；放出；释放\n" +
            "39, bath  [bɑːθ]\n" +
            "n. 沐浴；浴室；浴盆\n" +
            "vt. 洗澡\n" +
            "vi. 洗澡\n" +
            "40, donate  [də(ʊ)'neɪt]\n" +
            "vt. 捐赠；捐献\n" +
            "vi. 捐赠；捐献\n" +
            "n. 捐赠；捐献\n" +
            "n. (Donate)人名；(西)多纳特\n" +
            "41, gold  [gəʊld]\n" +
            "n. 金，黄金；金色；金币\n" +
            "adj. 金的，金制的；金色的\n" +
            "42, slide  [slaɪd]\n" +
            "n. 滑动；幻灯片；滑梯；雪崩\n" +
            "vi. 滑动；滑落；不知不觉陷入\n" +
            "vt. 滑动；使滑动；悄悄地迅速放置\n" +
            "43, fasten  ['fɑːs(ə)n]\n" +
            "vt. 使固定；集中于；扎牢；强加于\n" +
            "vi. 扣紧；抓住；集中注意力\n" +
            "44, sheet  [ʃiːt]\n" +
            "n. 薄片，纸张；薄板；床单\n" +
            "vt. 覆盖；盖上被单；使成大片\n" +
            "vi. 成片流动；大片落下\n" +
            "adj. 片状的\n" +
            "45, sensitive  ['sensɪtɪv]\n" +
            "adj. 敏感的；感觉的；[仪] 灵敏的；感光的；易受伤害的；易受影响的\n" +
            "n. 敏感的人；有灵异能力的人\n" +
            "46, citizen  ['sɪtɪz(ə)n]\n" +
            "n. 公民；市民；老百姓\n" +
            "47, scratch  [skrætʃ]\n" +
            "n. 擦伤；抓痕；刮擦声；乱写\n" +
            "adj. 打草稿用的；凑合的；碰巧的\n" +
            "vt. 抓；刮；挖出；乱涂\n" +
            "vi. 抓；搔；发刮擦声；勉强糊口；退出比赛\n" +
            "48, previous  ['priːvɪəs]\n" +
            "adj. 以前的；早先的；过早的\n" +
            "adv. 在先；在…以前\n" +
            "49, contrary  ['kɒntrərɪ]\n" +
            "adj. 相反的；对立的\n" +
            "adv. 相反地\n" +
            "n. 相反；反面\n" +
            "50, allocate  ['æləkeɪt]\n" +
            "vt. 分配；拨出；使坐落于\n" +
            "vi. 分配；指定\n" +
            "51, addicted  [ə'dɪktɪd]\n" +
            "adj. 沉溺于某种（尤其是不良的）嗜好的；入了迷的，上了瘾的\n" +
            "v. 使…上瘾（addict的过去分词）\n" +
            "52, fault  [fɔːlt; fɒlt]\n" +
            "n. 故障；[地质] 断层；错误；缺点；毛病；（网球等）发球失误\n" +
            "vi. 弄错；产生断层\n" +
            "vt. （通常用于疑问句或否定句）挑剔\n" +
            "53, eventually  [ɪ'ventʃʊəlɪ]\n" +
            "adv. 最后，终于\n" +
            "54, thirst  [θɜːst]\n" +
            "n. 渴望；口渴；热望\n" +
            "vi. 渴望；口渴\n" +
            "55, stain  [steɪn]\n" +
            "vt. 沾污；败坏；给…着色\n" +
            "vi. 污染；被沾污；被染污\n" +
            "n. 污点；瑕疵；着色剂\n" +
            "56, represent  [reprɪ'zent]\n" +
            "vt. 代表；表现；描绘；回忆；再赠送\n" +
            "vi. 代表；提出异议\n" +
            "57, field  [fiːld]\n" +
            "n. 领域；牧场；旷野；战场；运动场\n" +
            "vi. 担任场外队员\n" +
            "adj. 扫描场；田赛的；野生的\n" +
            "vt. 把暴晒于场上；使上场\n" +
            "n. (Field)人名；(英、法、德、葡)菲尔德\n" +
            "58, familiar  [fə'mɪlɪə]\n" +
            "adj. 熟悉的；常见的；亲近的\n" +
            "n. 常客；密友\n" +
            "n. (Familiar)人名；(西)法米利亚尔\n" +
            "59, register  ['redʒɪstə]\n" +
            "vt. 登记；注册；记录；挂号邮寄；把…挂号；正式提出\n" +
            "vi. 登记；注册；挂号\n" +
            "n. 登记；注册；记录；寄存器；登记簿\n" +
            "60, possession  [pə'zeʃ(ə)n]\n" +
            "n. 拥有；财产；领地；自制；着迷\n" +
            "61, comfort  ['kʌmfət]\n" +
            "n. 安慰；舒适；安慰者\n" +
            "vt. 安慰；使（痛苦等）缓和\n" +
            "62, thirsty  ['θɜːstɪ]\n" +
            "adj. 口渴的，口干的；渴望的，热望的\n" +
            "63, mixture  ['mɪkstʃə]\n" +
            "n. 混合；混合物；混合剂\n" +
            "64, frighten  ['fraɪt(ə)n]\n" +
            "vt. 使惊吓；吓唬…\n" +
            "vi. 害怕，惊恐\n" +
            "65, aunt  [ɑːnt]\n" +
            "n. 阿姨；姑妈；伯母；舅妈\n" +
            "66, construct  [kən'strʌkt]\n" +
            "vt. 建造，构造；创立\n" +
            "n. 构想，概念\n" +
            "67, queue  [kjuː]\n" +
            "n. 队列；长队；辫子\n" +
            "vi. 排队；排队等候\n" +
            "vt. 将…梳成辫子；使…排队\n" +
            "68, basis  ['beɪsɪs]\n" +
            "n. 基础；底部；主要成分；基本原则或原理\n" +
            "69, both  [bəʊθ]\n" +
            "adj. 两个的；两者的\n" +
            "adv. 并；又；两者皆\n" +
            "pron. 双方都；两者都\n" +
            "conj. 既…且…\n" +
            "70, centre  ['sentə]\n" +
            "vi. 以…为中心\n" +
            "vt. 集中；将…放在中央\n" +
            "n. 中心\n" +
            "adj. 中央的\n" +
            "71, root  [ruːt]\n" +
            "n. 根；根源；词根；祖先\n" +
            "vi. 生根；根除\n" +
            "vt. 生根，固定；根源在于\n" +
            "72, drop  [drɒp]\n" +
            "vt. 滴；使降低；使终止；随口漏出\n" +
            "vi. 下降；终止\n" +
            "n. 滴；落下；空投；微量；滴剂\n" +
            "73, normal  ['nɔːm(ə)l]\n" +
            "adj. 正常的；正规的，标准的\n" +
            "n. 正常；标准；常态\n" +
            "74, earthquake  ['ɜːθkweɪk]\n" +
            "n. 地震；大动荡\n" +
            "75, round  [raʊnd]\n" +
            "n. 圆；循环；一回合；圆形物\n" +
            "adj. 圆的；完全的；大概的；肥胖的\n" +
            "adv. 在周围；迂回地；朝反方向；挨个\n" +
            "vt. 完成；围捕；绕行；弄圆\n" +
            "vi. 进展；变圆；环行；发胖\n" +
            "prep. 附近；绕过；大约；在…周围\n" +
            "76, boundary  ['baʊnd(ə)rɪ]\n" +
            "n. 边界；范围；分界线\n" +
            "77, mankind  [,mæn'kaɪnd]\n" +
            "n. 人类；男性\n" +
            "78, personnel  [pɜːsə'nel]\n" +
            "n. 人事部门；全体人员\n" +
            "adj. 人员的；有关人事的\n" +
            "79, curious  ['kjʊərɪəs]\n" +
            "adj. 好奇的，有求知欲的；古怪的；爱挑剔的\n" +
            "80, swallow  ['swɒləʊ]\n" +
            "vt. 忍受；吞没\n" +
            "vi. 吞下；咽下\n" +
            "n. 燕子；一次吞咽的量\n" +
            "n. (Swallow)人名；(英)斯沃洛\n" +
            "81, bank  [bæŋk]\n" +
            "n. 银行；岸；浅滩；储库\n" +
            "vt. 将…存入银行；倾斜转弯\n" +
            "vi. 堆积；倾斜转弯\n" +
            "82, electricity  [,ɪlek'trɪsɪtɪ;]\n" +
            "n. 电力；电流；强烈的紧张情绪\n" +
            "83, climate  ['klaɪmət]\n" +
            "n. 气候；风气；思潮；风土\n" +
            "84, victory  ['vɪkt(ə)rɪ]\n" +
            "n. 胜利；成功；克服\n" +
            "85, shallow  ['ʃæləʊ]\n" +
            "adj. 浅的；肤浅的\n" +
            "n. [地理] 浅滩\n" +
            "vt. 使变浅\n" +
            "vi. 变浅\n" +
            "n. (Shallow)人名；(英)沙洛\n" +
            "86, victim  ['vɪktɪm]\n" +
            "n. 受害人；牺牲品；牺牲者\n" +
            "87, select  [sɪ'lekt]\n" +
            "vt. 挑选；选拔\n" +
            "adj. 精选的；挑选出来的；极好的\n" +
            "vi. 挑选\n" +
            "n. 被挑选者；精萃\n" +
            "88, horizon  [hə'raɪz(ə)n]\n" +
            "n. [天] 地平线；视野；眼界；范围\n" +
            "89, youth  [juːθ]\n" +
            "n. 青年；青春；年轻；青少年时期\n" +
            "90, period  ['pɪərɪəd]\n" +
            "n. 周期，期间；时期；月经；课时；（语法学）句点，句号\n" +
            "adj. 某一时代的\n" +
            "91, economic  [,iːkə'nɒmɪk; ek-]\n" +
            "adj. 经济的，经济上的；经济学的\n" +
            "92, sweep  [swiːp]\n" +
            "vt. 扫除；猛拉；掸去\n" +
            "vi. 扫，打扫；席卷；扫视；袭击\n" +
            "n. 打扫，扫除；范围；全胜\n" +
            "93, sale  [seɪl]\n" +
            "n. 销售；出售；拍卖；销售额；廉价出售\n" +
            "94, salute  [sə'l(j)uːt]\n" +
            "n. 致敬，欢迎；敬礼\n" +
            "vt. 行礼致敬，欢迎\n" +
            "vi. 致意，打招呼；行礼\n" +
            "95, failure  ['feɪljə]\n" +
            "n. 失败；故障；失败者；破产\n" +
            "96, cast  [kɑːst]\n" +
            "vt. 投，抛；计算；浇铸；投射（光、影、视线等）\n" +
            "n. 投掷，抛；铸件，[古生] 铸型；演员阵容；脱落物\n" +
            "vi. 投，抛垂钓鱼钩；计算，把几个数字加起来\n" +
            "n. (Cast)人名；(法)卡斯特\n" +
            "97, railway  ['reɪlweɪ]\n" +
            "n. （英）铁路；轨道；铁道部门\n" +
            "vi. 乘火车旅行\n" +
            "98, ceiling  ['siːlɪŋ]\n" +
            "n. 天花板；上限\n" +
            "99, sound  [saʊnd]\n" +
            "vt. 听（诊）；测量，测…深；使发声；试探；宣告\n" +
            "n. 声音，语音；噪音；海峡；吵闹；听力范围；[医] 探条\n" +
            "adj. 健全的，健康的；合理的；可靠的；有效彻底的\n" +
            "adv. 彻底地，充分地\n" +
            "vi. 听起来；发出声音；回响；测深\n" +
            "100, distinguish  [dɪ'stɪŋgwɪʃ]\n" +
            "vt. 区分；辨别；使杰出，使表现突出\n" +
            "vi. 区别，区分；辨别\n" +
            "101, contradict  [kɒntrə'dɪkt]\n" +
            "vt. 反驳；否定；与…矛盾；与…抵触\n" +
            "vi. 反驳；否认；发生矛盾\n" +
            "102, factory  ['fækt(ə)rɪ]\n" +
            "n. 工厂；制造厂；代理店\n" +
            "103, constitution  [kɒnstɪ'tjuːʃ(ə)n]\n" +
            "n. 宪法；体质；章程；构造；建立，组成；体格\n" +
            "104, straight  [streɪt]\n" +
            "adj. 直的；连续的；笔直的；正直的；整齐的\n" +
            "adv. 直接地；不断地；立即；坦率地\n" +
            "n. 直；直线\n" +
            "n. (Straight)人名；(英)斯特雷特\n" +
            "105, minority  [maɪ'nɒrɪtɪ; mɪ-]\n" +
            "n. 少数民族；少数派；未成年\n" +
            "adj. 少数的；属于少数派的\n" +
            "106, measure  ['meʒə]\n" +
            "n. 测量；措施；程度；尺寸\n" +
            "vt. 测量；估量；权衡\n" +
            "vi. 测量；估量\n" +
            "107, rainy  ['reɪnɪ]\n" +
            "adj. 下雨的；多雨的\n" +
            "n. (Rainy)人名；(英)雷尼\n" +
            "108, consensus  [kən'sensəs]\n" +
            "n. 一致；舆论；合意\n" +
            "109, purchase  ['pɜ:tʃəs]\n" +
            "n. 购买；紧握；起重装置\n" +
            "vt. 购买；赢得\n" +
            "vi. 购买东西\n" +
            "110, hang  [hæŋ]\n" +
            "vt. 悬挂，垂下；装饰；绞死；使悬而未决\n" +
            "vi. 悬着，垂下；被绞死；悬而不决\n" +
            "n. 悬挂；暂停，中止\n" +
            "111, analysis  [ə'nælɪsɪs]\n" +
            "n. 分析；分解；验定\n" +
            "112, recommend  [rekə'mend]\n" +
            "vt. 推荐，介绍；劝告；使受欢迎；托付\n" +
            "vi. 推荐；建议\n" +
            "113, disturb  [dɪ'stɜːb]\n" +
            "vt. 打扰；妨碍；使不安；弄乱；使恼怒\n" +
            "vi. 打扰；妨碍\n" +
            "114, generous  ['dʒen(ə)rəs]\n" +
            "adj. 慷慨的，大方的；宽宏大量的；有雅量的\n" +
            "115, consume  [kən'sjuːm]\n" +
            "vt. 消耗，消费；使…著迷；挥霍\n" +
            "vi. 耗尽，毁灭；耗尽生命\n" +
            "116, troop  [truːp]\n" +
            "n. 军队；组；群；多数\n" +
            "vi. 群集；成群而行；结队\n" +
            "vt. 把（骑兵）编成骑兵连\n" +
            "117, liberty  ['lɪbətɪ]\n" +
            "n. 自由；许可；冒失\n" +
            "n. (Liberty)人名；(英)利伯蒂\n" +
            "118, throw  [θrəʊ]\n" +
            "vt. 投；抛；掷\n" +
            "vi. 抛；投掷\n" +
            "n. 投掷；冒险\n" +
            "119, defence  [dɪ'fens]\n" +
            "n. 防御；防卫；答辩；防卫设备\n" +
            "120, complete  [kəm'pliːt]\n" +
            "adj. 完整的；完全的；彻底的\n" +
            "vt. 完成\n" +
            "121, performance  [pə'fɔːm(ə)ns]\n" +
            "n. 性能；绩效；表演；执行\n" +
            "122, companion  [kəm'pænjən]\n" +
            "n. 同伴；朋友；指南；手册\n" +
            "vt. 陪伴\n" +
            "123, coal  [kəʊl]\n" +
            "vi. 上煤；加煤\n" +
            "vt. 给…加煤；把…烧成炭\n" +
            "n. 煤；煤块；木炭\n" +
            "124, cottage  ['kɒtɪdʒ]\n" +
            "n. 小屋；村舍；（农舍式的）小别墅\n" +
            "125, swim  [swɪm]\n" +
            "vi. 游泳；漂浮；浸；眩晕\n" +
            "vt. 游过；使浮起\n" +
            "n. 游泳；漂浮；眩晕\n" +
            "adj. 游泳时穿戴的\n" +
            "126, fuel  [fjʊəl]\n" +
            "vi. 得到燃料\n" +
            "vt. 供以燃料，加燃料\n" +
            "n. 燃料；刺激因素\n" +
            "127, drill  [drɪl]\n" +
            "n. 训练；钻孔机；钻子；播种机\n" +
            "vi. 钻孔；训练\n" +
            "vt. 钻孔；训练；条播\n" +
            "128, stubborn  ['stʌbən]\n" +
            "adj. 顽固的；顽强的；难处理的\n" +
            "129, inspire  [ɪn'spaɪə]\n" +
            "vt. 激发；鼓舞；启示；产生；使生灵感\n" +
            "130, transparent  [træn'spær(ə)nt; trɑːn-; -'speə-]\n" +
            "adj. 透明的；显然的；坦率的；易懂的\n" +
            "131, rain  [reɪn]\n" +
            "n. 雨；下雨；雨天；雨季\n" +
            "vi. 下雨；降雨\n" +
            "vt. 大量地给；使大量落下\n" +
            "n. (Rain)人名；(法)兰；(英)雷恩；(罗、捷)赖恩\n" +
            "132, beneath  [bɪ'niːθ]\n" +
            "prep. 在…之下\n" +
            "adv. 在下方\n" +
            "133, quarrel  ['kwɒr(ə)l]\n" +
            "vi. 吵架；争论；挑剔\n" +
            "n. 吵架；反目；怨言；争吵的原因；方头凿\n" +
            "134, bowl  [bəʊl]\n" +
            "n. 碗；木球；大酒杯\n" +
            "vi. 玩保龄球；滑动；平稳快速移动\n" +
            "vt. 投球；旋转；平稳快速移动\n" +
            "135, constant  ['kɒnst(ə)nt]\n" +
            "adj. 不变的；恒定的；经常的\n" +
            "n. [数] 常数；恒量\n" +
            "136, dull  [dʌl]\n" +
            "adj. 钝的；迟钝的；无趣的；呆滞的；阴暗的\n" +
            "vt. 使迟钝；使阴暗；缓和\n" +
            "vi. 减少；变迟钝\n" +
            "n. (Dull)人名；(罗、匈)杜尔；(柬)杜；(英)达尔\n" +
            "137, percentage  [pə'sentɪdʒ]\n" +
            "n. 百分比；百分率，百分数\n" +
            "138, glory  ['glɔːrɪ]\n" +
            "n. 光荣，荣誉；赞颂\n" +
            "vi. 自豪，骄傲；狂喜\n" +
            "139, fluent  ['fluːənt]\n" +
            "adj. 流畅的，流利的；液态的；畅流的\n" +
            "140, ahead  [ə'hed]\n" +
            "adj. 向前；在前的；领先\n" +
            "adv. 向前地；领先地；在（某人或某事物的）前面；预先；在将来，为未来\n" +
            "141, approval  [ə'pruːv(ə)l]\n" +
            "n. 批准；认可；赞成\n" +
            "142, punish  ['pʌnɪʃ]\n" +
            "vt. 惩罚；严厉对待；贪婪地吃喝\n" +
            "vi. 惩罚\n" +
            "143, mourn  [mɔːn]\n" +
            "v. 哀悼；忧伤；服丧\n" +
            "144, equal  ['i:kwəl]\n" +
            "adj. 平等的；相等的；胜任的\n" +
            "vt. 等于；比得上\n" +
            "n. 对手；匹敌；同辈；相等的事物\n" +
            "145, adult  ['ædʌlt; ə'dʌlt]\n" +
            "adj. 成年的；成熟的\n" +
            "n. 成年人\n" +
            "146, 十分  [shí fēn]\n" +
            "completely\n" +
            "fully\n" +
            "very\n" +
            "147, reference  ['ref(ə)r(ə)ns]\n" +
            "n. 参考，参照；涉及，提及；参考书目；介绍信；证明书\n" +
            "vi. 引用\n" +
            "vt. 引用\n" +
            "148, representative  [reprɪ'zentətɪv]\n" +
            "adj. 典型的，有代表性的；代议制的\n" +
            "n. 代表；典型；众议员\n" +
            "149, furnished  ['fɜːnɪʃt]\n" +
            "adj. 家具，有家具的\n" +
            "v. 供应；装备（furnish的过去分词）\n" +
            "150, advantage  [əd'vɑːntɪdʒ]\n" +
            "n. 优势；利益；有利条件\n" +
            "vi. 获利\n" +
            "vt. 有利于；使处于优势\n" +
            "151, widen  ['waɪd(ə)n]\n" +
            "vt. 放宽\n" +
            "vi. 变宽\n" +
            "152, privilege  ['prɪvɪlɪdʒ]\n" +
            "n. 特权；优待；基本权利\n" +
            "vt. 给与…特权；特免\n" +
            "153, service  ['sɜːvɪs]\n" +
            "n. 服务，服侍；服役；仪式\n" +
            "adj. 服务性的；耐用的；服现役的\n" +
            "vt. 维修，检修；保养\n" +
            "154, scan  [skæn]\n" +
            "vt. 扫描；浏览；细看；详细调查；标出格律\n" +
            "vi. 扫描；扫掠\n" +
            "n. 扫描；浏览；审视；细看\n" +
            "155, certain  ['sɜːt(ə)n; -tɪn]\n" +
            "adj. 某一；必然的；确信；无疑的；有把握的\n" +
            "pron. 某些；某几个\n" +
            "n. (Certain)人名；(葡)塞尔塔因；(法)塞尔坦\n" +
            "156, blind  [blaɪnd]\n" +
            "adj. 盲目的；瞎的\n" +
            "adv. 盲目地；看不见地\n" +
            "n. 掩饰，借口；百叶窗\n" +
            "vt. 使失明；使失去理智\n" +
            "n. (Blind)人名；(法)布兰；(德、瑞典)布林德\n" +
            "157, comedian  [kə'miːdɪən]\n" +
            "n. 喜剧演员；滑稽人物\n" +
            "158, surface  ['sɜːfɪs]\n" +
            "n. 表面；表层；外观\n" +
            "adj. 表面的，肤浅的\n" +
            "vi. 浮出水面\n" +
            "vt. 使浮出水面；使成平面\n" +
            "159, diverse  [daɪ'vɜːs; 'daɪvɜːs]\n" +
            "adj. 不同的；多种多样的；变化多的\n" +
            "160, supreme  [suː'priːm]\n" +
            "adj. 最高的；至高的；最重要的\n" +
            "n. 至高；霸权\n" +
            "161, acquaintance  [ə'kweɪnt(ə)ns]\n" +
            "n. 熟人；相识；了解；知道\n" +
            "162, rescue  ['reskjuː]\n" +
            "vt. 营救；援救\n" +
            "n. 营救；援救；解救\n" +
            "163, deliberate  [dɪ'lɪb(ə)rət]\n" +
            "adj. 故意的；深思熟虑的；从容的\n" +
            "vt. 仔细考虑；商议\n" +
            "164, energetic  [,enə'dʒetɪk]\n" +
            "adj. 精力充沛的；积极的；有力的\n" +
            "165, technical  ['teknɪk(ə)l]\n" +
            "adj. 工艺的，科技的；技术上的；专门的\n" +
            "166, sailor  ['seɪlə]\n" +
            "n. 水手，海员；乘船者\n" +
            "n. (Sailor)人名；(英)赛勒\n" +
            "167, beyond  [bɪ'jɒnd]\n" +
            "prep. 超过；越过；那一边；在...较远的一边\n" +
            "adv. 在远处；在更远处\n" +
            "n. 远处\n" +
            "168, avoid  [ə'vɒɪd]\n" +
            "vt. 避免；避开，躲避；消除\n" +
            "169, sacrifice  ['sækrɪfaɪs]\n" +
            "n. 牺牲；祭品；供奉\n" +
            "vt. 牺牲；献祭；亏本出售\n" +
            "vi. 献祭；奉献\n" +
            "170, vacant  ['veɪk(ə)nt]\n" +
            "adj. 空虚的；空的；空缺的；空闲的；茫然的\n" +
            "171, whisper  ['wɪspə]\n" +
            "n. 私语；谣传；飒飒的声音\n" +
            "vi. 耳语；密谈；飒飒地响\n" +
            "vt. 低声说出\n" +
            "172, fail  [feɪl]\n" +
            "vi. 失败，不及格；破产；缺乏；衰退\n" +
            "vt. 不及格；使失望；忘记；舍弃\n" +
            "n. 不及格\n" +
            "n. (Fail)人名；(葡、捷)法伊尔；(法)法伊\n" +
            "173, damp  [dæmp]\n" +
            "vt. 使潮湿；使阻尼；使沮丧，抑制\n" +
            "vi. 减幅，阻尼；变潮湿\n" +
            "n. 潮湿，湿气\n" +
            "adj. 潮湿的\n" +
            "174, file  [faɪl]\n" +
            "n. 文件；档案；文件夹；锉刀\n" +
            "vt. 提出；锉；琢磨；把…归档\n" +
            "vi. 列队行进；用锉刀锉\n" +
            "175, shadow  ['ʃædəʊ]\n" +
            "n. 阴影；影子；幽灵；庇护；隐蔽处\n" +
            "vt. 遮蔽；使朦胧；尾随；预示\n" +
            "vi. 渐变；变阴暗\n" +
            "adj. 影子内阁的\n" +
            "176, desperate  ['desp(ə)rət]\n" +
            "adj. 不顾一切的；令人绝望的；极度渴望的\n" +
            "177, describe  [dɪ'skraɪb]\n" +
            "vt. 描述，形容；描绘\n" +
            "178, clarify  ['klærɪfaɪ]\n" +
            "vt. 澄清；阐明\n" +
            "vi. 得到澄清；变得明晰；得到净化\n" +
            "179, pour  [pɔː]\n" +
            "n. 倾泻；流出；骤雨\n" +
            "vt. 灌，注；倒；倾泻；倾吐\n" +
            "vi. 倾泻；涌流；斟茶\n" +
            "n. (Pour)人名；(伊朗)普尔；(捷)保尔\n" +
            "180, pleasant  ['plez(ə)nt]\n" +
            "adj. 令人愉快的，舒适的；讨人喜欢的，和蔼可亲的\n" +
            "n. (Pleasant)人名；(英)普莱曾特\n" +
            "181, focus  ['fəʊkəs]\n" +
            "n. 焦点；中心；清晰；焦距\n" +
            "vt. 使集中；使聚焦\n" +
            "vi. 集中；聚焦；调节焦距\n" +
            "182, shelf  [ʃelf]\n" +
            "n. 架子；搁板；搁板状物\n" +
            "183, voluntary  ['vɒlənt(ə)rɪ]\n" +
            "adj. 自愿的；志愿的；自发的；故意的\n" +
            "n. 志愿者；自愿行动\n" +
            "184, industry  ['ɪndəstrɪ]\n" +
            "n. 产业；工业；勤勉\n" +
            "185, commercial  [kə'mɜːʃ(ə)l]\n" +
            "adj. 商业的；营利的；靠广告收入的\n" +
            "n. 商业广告\n" +
            "186, worth  [wɜːθ]\n" +
            "adj. 值…的\n" +
            "n. 价值；财产\n" +
            "187, knife  [naɪf]\n" +
            "n. 刀；匕首\n" +
            "vt. 用刀切；（口）伤害\n" +
            "vi. 劈开；划过\n" +
            "188, exchange  [ɪks'tʃeɪndʒ; eks-]\n" +
            "n. 交换；交流；交易所；兑换\n" +
            "vt. 交换；交易；兑换\n" +
            "vi. 交换；交易；兑换\n" +
            "189, frankly  ['fræŋklɪ]\n" +
            "adv. 真诚地，坦白地\n" +
            "190, glad  [glæd]\n" +
            "adj. 高兴的；乐意的；令人高兴的；灿烂美丽的\n" +
            "vt. 使高兴\n" +
            "191, wild  [waɪld]\n" +
            "adj. 野生的；野蛮的；狂热的；荒凉的\n" +
            "n. 荒野\n" +
            "adv. 疯狂地；胡乱地\n" +
            "n. (Wild)人名；(英)怀尔德；(法、德、葡、捷、匈)维尔德\n" +
            "192, church  [tʃɜːtʃ]\n" +
            "n. 教堂；礼拜；教派\n" +
            "adj. 教会的；礼拜的\n" +
            "vt. 领…到教堂接受宗教仪式\n" +
            "n. (Church)人名；(英)丘奇\n" +
            "193, preparation  [,prepə'reɪʃ(ə)n]\n" +
            "n. 预备；准备\n" +
            "194, extra  ['ekstrə]\n" +
            "adv. 特别地，非常；另外\n" +
            "n. 临时演员；号外；额外的事物；上等产品\n" +
            "adj. 额外的，另外收费的；特大的\n" +
            "195, welfare  ['welfeə]\n" +
            "n. 福利；幸福；福利事业；安宁\n" +
            "adj. 福利的；接受社会救济的\n" +
            "196, flexible  ['fleksɪb(ə)l]\n" +
            "adj. 灵活的；柔韧的；易弯曲的\n" +
            "197, boil  [bɒɪl]\n" +
            "vi. 煮沸，沸腾；激动，激昂\n" +
            "vt. 煮沸，烧开；使…激动；使…蒸发\n" +
            "n. 沸腾，煮沸；疖子\n" +
            "198, shall  [ʃæl; ʃ(ə)l]\n" +
            "aux. 应；会；将；必须\n" +
            "199, solid  ['sɒlɪd]\n" +
            "adj. 固体的；可靠的；立体的；结实的；一致的\n" +
            "n. 固体；立方体\n" +
            "200, violate  ['vaɪəleɪt]\n" +
            "vt. 违反；侵犯，妨碍；亵渎\n" +
            "201, branch  [brɑːn(t)ʃ]\n" +
            "vt. 分支；出现分歧\n" +
            "vi. 分支；出现分歧\n" +
            "n. 树枝，分枝；分部；支流\n" +
            "202, participant  [pɑː'tɪsɪp(ə)nt]\n" +
            "adj. 参与的；有关系的\n" +
            "n. 参与者；关系者\n" +
            "203, bravery  ['breɪv(ə)rɪ]\n" +
            "n. 勇敢；勇气\n" +
            "n. (Bravery)人名；(英)布雷弗里；(法)布拉韦里\n" +
            "204, shrink  [ʃrɪŋk]\n" +
            "vi. 收缩；畏缩\n" +
            "vt. 使缩小，使收缩\n" +
            "n. 收缩\n" +
            "205, glove  [glʌv]\n" +
            "n. 手套\n" +
            "vt. 给…戴手套\n" +
            "206, conclusion  [kən'kluːʒ(ə)n]\n" +
            "n. 结论；结局；推论\n" +
            "207, compensate  ['kɒmpenseɪt]\n" +
            "vi. 补偿，赔偿；抵消\n" +
            "vt. 补偿，赔偿；付报酬\n" +
            "208, bar  [bɑː]\n" +
            "n. 条，棒；酒吧；障碍；法庭\n" +
            "vt. 禁止；阻拦\n" +
            "prep. 除……外\n" +
            "n. (Bar)人名；(阿拉伯、德、法、俄、罗、捷、波、葡、以)巴尔\n" +
            "209, comment  ['kɒment]\n" +
            "n. 评论；意见；批评\n" +
            "vi. 发表评论；发表意见\n" +
            "vt. 为…作评语\n" +
            "n. (Comment)人名；(德)科门特；(法)科芒\n" +
            "210, strict  [strɪkt]\n" +
            "adj. 严格的；绝对的；精确的；详细的\n" +
            "211, shore  [ʃɔː]\n" +
            "vt. 支撑，使稳住；用支柱撑住\n" +
            "n. 海滨；支柱\n" +
            "n. (Shore)人名；(英)肖尔\n" +
            "212, plant  [plɑːnt]\n" +
            "n. 工厂，车间；植物；设备；庄稼\n" +
            "vt. 种植；培养；栽培；安置\n" +
            "vi. 种植\n" +
            "n. (Plant)人名；(英、西、意)普兰特；(法)普朗\n" +
            "213, evaluate  [ɪ'væljʊeɪt]\n" +
            "vt. 评价；估价；求…的值\n" +
            "vi. 评价；估价\n" +
            "214, hesitate  ['hezɪteɪt]\n" +
            "vi. 踌躇，犹豫；不愿\n" +
            "vt. 踌躇，犹豫；有疑虑，不愿意\n" +
            "215, comedy  ['kɒmɪdɪ]\n" +
            "n. 喜剧；喜剧性；有趣的事情\n" +
            "216, joy  [dʒɒɪ]\n" +
            "n. 欢乐，快乐；乐趣；高兴\n" +
            "vi. 欣喜，欢喜\n" +
            "vt. 高兴，使快乐\n" +
            "217, crew  [kruː]\n" +
            "n. 队，组；全体人员，全体船员\n" +
            "vi. 一起工作\n" +
            "vt. 使当船员\n" +
            "n. (Crew)人名；(英、西)克鲁\n" +
            "218, vehicle  ['viːɪk(ə)l]\n" +
            "n. [车辆] 车辆；工具；交通工具；运载工具；传播媒介；媒介物\n" +
            "219, secure  [sɪ'kjʊə; sɪ'kjɔː]\n" +
            "adj. 安全的；无虑的；有把握的；稳当的\n" +
            "vt. 保护；弄到；招致；缚住\n" +
            "vi. 获得安全；船抛锚；停止工作\n" +
            "220, rewind  [riː'waɪnd]\n" +
            "n. 重绕；倒带器\n" +
            "vt. 倒回；重绕\n" +
            "vi. 倒回；重绕\n" +
            "221, build  [bɪld]\n" +
            "vt. 建立；建筑\n" +
            "vi. 建筑；建造\n" +
            "n. 构造；体形；体格\n" +
            "222, stranger  ['streɪn(d)ʒə]\n" +
            "n. 陌生人；外地人；局外人\n" +
            "n. (Stranger)人名；(瑞典)斯特朗格；(英)斯特兰杰\n" +
            "223, wound  [wuːnd]\n" +
            "n. 创伤，伤口\n" +
            "vt. 使受伤\n" +
            "vi. 受伤，伤害\n" +
            "224, cruel  [krʊəl]\n" +
            "adj. 残酷的，残忍的；使人痛苦的，让人受难的；无情的，严酷的\n" +
            "225, private  ['praɪvət]\n" +
            "adj. 私人的；私有的；私下的\n" +
            "n. 列兵；二等兵\n" +
            "226, modern  ['mɒd(ə)n]\n" +
            "adj. 现代的，近代的；时髦的\n" +
            "n. 现代人；有思想的人\n" +
            "227, thrill  [θrɪl]\n" +
            "n. 激动；震颤；紧张\n" +
            "vt. 使…颤动；使…紧张；使…感到兴奋或激动\n" +
            "vi. 颤抖；感到兴奋；感到紧张\n" +
            "228, bathe  [beɪð]\n" +
            "vt. 沐浴；用水洗\n" +
            "vi. 洗澡；沐浴\n" +
            "n. 洗澡；游泳\n" +
            "n. (Bathe)人名；(德)巴特；(英)巴思\n" +
            "229, circumstance  ['sɜːkəmst(ə)ns]\n" +
            "n. 环境，情况；事件；境遇\n" +
            "230, clean  [kliːn]\n" +
            "adj. 清洁的，干净的；清白的\n" +
            "vt. 使干净\n" +
            "vi. 打扫，清扫\n" +
            "adv. 完全地\n" +
            "n. 打扫\n" +
            "n. (Clean)人名；(英)克林\n" +
            "231, subscribe  [səb'skraɪb]\n" +
            "vi. 订阅；捐款；认购；赞成；签署\n" +
            "vt. 签署；赞成；捐助\n" +
            "232, upset  [ʌp'set]\n" +
            "vt. 使心烦；颠覆；扰乱\n" +
            "vi. 翻倒\n" +
            "adj. 心烦的；混乱的；弄翻的\n" +
            "n. 混乱；翻倒\n" +
            "233, tendency  ['tend(ə)nsɪ]\n" +
            "n. 倾向，趋势；癖好\n" +
            "234, endless  ['endlɪs]\n" +
            "adj. 无止境的；连续的；环状的；漫无目的的\n" +
            "235, spin  [spɪn]\n" +
            "vi. 旋转；纺纱；吐丝；晕眩\n" +
            "vt. 使旋转；纺纱；编造；结网\n" +
            "n. 旋转；疾驰\n" +
            "236, sharpen  ['ʃɑːp(ə)n]\n" +
            "vt. 削尖；磨快；使敏捷；加重\n" +
            "vi. 尖锐；变锋利\n" +
            "237, district  ['dɪstrɪkt]\n" +
            "n. 区域；地方；行政区\n" +
            "238, primitive  ['prɪmɪtɪv]\n" +
            "adj. 原始的，远古的；简单的，粗糙的\n" +
            "n. 原始人\n" +
            "239, analyse  ['æn(ə)laɪz]\n" +
            "vt. 分析；分解；细察\n" +
            "240, similar  ['sɪmɪlə]\n" +
            "adj. 相似的\n" +
            "n. 类似物\n" +
            "241, steal  [stiːl]\n" +
            "vt. 剽窃；偷偷地做；偷窃\n" +
            "vi. 窃取；偷偷地行动；偷垒\n" +
            "n. 偷窃；便宜货；偷垒；断球\n" +
            "242, silk  [sɪlk]\n" +
            "n. 丝绸；蚕丝；丝织物\n" +
            "adj. 丝的；丝绸的；丝制的\n" +
            "vi. （玉米）处于长须的阶段中\n" +
            "n. (Silk)人名；(英、瑞典)西尔克\n" +
            "243, extreme  [ɪk'striːm; ek-]\n" +
            "adj. 极端的；极度的；偏激的；尽头的\n" +
            "n. 极端；末端；最大程度；极端的事物\n" +
            "244, ball  [bɔːl]\n" +
            "n. 球；舞会\n" +
            "vi. 成团块\n" +
            "vt. 捏成球形\n" +
            "245, edge  [edʒ]\n" +
            "n. 边缘；优势；刀刃；锋利\n" +
            "vt. 使锐利；将…开刃；给…加上边\n" +
            "vi. 缓缓移动；侧着移动\n" +
            "246, dozen  ['dʌz(ə)n]\n" +
            "n. 十二个，一打\n" +
            "adj. 一打的\n" +
            "247, creature  ['kriːtʃə]\n" +
            "n. 动物，生物；人；创造物\n" +
            "248, faith  [feɪθ]\n" +
            "n. 信仰；信念；信任；忠实\n" +
            "n. (Faith)人名；(匈)福伊特；(英)费思，费丝(女名)；(瑞典)法伊特\n" +
            "249, prejudice  ['predʒʊdɪs]\n" +
            "n. 偏见；侵害\n" +
            "vt. 损害；使有偏见\n" +
            "250, injure  ['ɪndʒə]\n" +
            "vt. 伤害，损害\n" +
            "251, frequent  ['friːkw(ə)nt]\n" +
            "adj. 频繁的；时常发生的；惯常的\n" +
            "vt. 常到，常去；时常出入于\n" +
            "252, dangerous  ['deɪn(d)ʒ(ə)rəs]\n" +
            "adj. 危险的\n" +
            "253, secretary  ['sekrɪt(ə)rɪ]\n" +
            "n. 秘书；书记；部长；大臣\n" +
            "254, product  ['prɒdʌkt]\n" +
            "n. 产品；结果；[数] 乘积；作品\n" +
            "255, mountainous  ['maʊntɪnəs]\n" +
            "adj. 多山的；巨大的；山一般的\n" +
            "256, prison  ['prɪz(ə)n]\n" +
            "n. 监狱；监禁；拘留所\n" +
            "vt. 监禁，关押\n" +
            "257, injury  ['ɪn(d)ʒ(ə)rɪ]\n" +
            "n. 伤害，损害；受伤处\n" +
            "258, spirit  ['spɪrɪt]\n" +
            "n. 精神；心灵；情绪；志气；烈酒\n" +
            "vt. 鼓励；鼓舞；诱拐\n" +
            "259, method  ['meθəd]\n" +
            "n. 方法；条理；类函数\n" +
            "adj. 使用体验派表演方法的\n" +
            "260, finance  [faɪ'næns; fɪ-; 'faɪnæns]\n" +
            "n. 财政，财政学；金融\n" +
            "vt. 负担经费，供给…经费\n" +
            "vi. 筹措资金\n" +
            "261, within  [wɪð'ɪn]\n" +
            "prep. 在…之内\n" +
            "adv. 在内部\n" +
            "n. 里面\n" +
            "262, tour  [tʊə]\n" +
            "n. 旅游，旅行；巡回演出\n" +
            "vt. 旅行，在……旅游；在……作巡回演出\n" +
            "vi. 旅行，旅游；作巡回演出\n" +
            "263, produce  [prə'djuːs]\n" +
            "vt. 生产；引起；创作\n" +
            "n. 农产品，产品\n" +
            "vi. 生产，创作\n" +
            "264, count  [kaʊnt]\n" +
            "vt. 计算；认为\n" +
            "vi. 计数；有价值\n" +
            "n. 计数；计算；伯爵\n" +
            "265, ruin  ['ruːɪn]\n" +
            "n. 废墟；毁坏；灭亡\n" +
            "vt. 毁灭；使破产\n" +
            "vi. 破产；堕落；被毁灭\n" +
            "266, decline  [dɪ'klaɪn]\n" +
            "n. 下降；衰退；斜面\n" +
            "vi. 下降；衰落；谢绝\n" +
            "vt. 谢绝；婉拒\n" +
            "267, courage  ['kʌrɪdʒ]\n" +
            "n. 勇气；胆量\n" +
            "268, carpet  ['kɑːpɪt]\n" +
            "vt. 在…上铺地毯，把地毯铺在…上；斥责\n" +
            "n. 地毯；地毯状覆盖物\n" +
            "269, fortune  ['fɔːtʃuːn; -tʃ(ə)n]\n" +
            "n. 财富；命运；运气\n" +
            "vt. 给予财富\n" +
            "vi. 偶然发生\n" +
            "270, skin  [skɪn]\n" +
            "n. 皮肤；外皮\n" +
            "vt. 剥皮\n" +
            "vi. 愈合；长皮\n" +
            "271, function  ['fʌŋ(k)ʃ(ə)n]\n" +
            "n. 功能；[数] 函数；职责；盛大的集会\n" +
            "vi. 运行；活动；行使职责\n" +
            "272, explode  [ɪk'spləʊd; ek-]\n" +
            "vi. 爆炸，爆发；激增\n" +
            "vt. 使爆炸；爆炸；推翻\n" +
            "273, silly  ['sɪlɪ]\n" +
            "adj. 愚蠢的\n" +
            "n. 傻瓜\n" +
            "n. (Silly)人名；(匈)希伊；(法)西利\n" +
            "274, poisonous  ['pɒɪzənəs]\n" +
            "adj. 有毒的；恶毒的；讨厌的\n" +
            "275, postpone  [pəʊs(t)'pəʊn; pə'spəʊn]\n" +
            "vt. 使…延期；把…放在次要地位；把…放在后面\n" +
            "vi. 延缓，延迟；延缓发作\n" +
            "276, toward  [tə'wɔːd; twɔːd; tɔːd]\n" +
            "prep. 向；对于；为了；接近\n" +
            "adj. 即将来到的，进行中的\n" +
            "n. (Toward)人名；(英)特沃德\n" +
            "277, disturbing  [dɪ'stɜːbɪŋ]\n" +
            "adj. 令人不安的；烦扰的\n" +
            "v. 干扰；打断（disturb的ing形式）\n" +
            "278, experiment  [ɪk'sperɪm(ə)nt; ek-]\n" +
            "vi. 尝试；进行实验\n" +
            "n. 实验，试验；尝试\n" +
            "279, exact  [ɪg'zækt; eg-]\n" +
            "adj. 准确的，精密的；精确的\n" +
            "vt. 要求；强求；急需\n" +
            "vi. 勒索钱财\n" +
            "280, primary  ['praɪm(ə)rɪ]\n" +
            "adj. 主要的；初级的；基本的\n" +
            "n. 原色；最主要者\n" +
            "281, medicine  ['meds(ə)n; 'medɪsɪn]\n" +
            "n. 药；医学；内科；巫术\n" +
            "vt. 用药物治疗；给…用药\n" +
            "282, spell  [spel]\n" +
            "vt. 拼，拼写；意味着；招致；拼成；迷住；轮值\n" +
            "n. 符咒；一段时间；魅力\n" +
            "vi. 拼字；轮替\n" +
            "n. (Spell)人名；(英)斯佩尔\n" +
            "283, especial  [ɪ'speʃ(ə)l; e-]\n" +
            "adj. 特殊的，特别的\n" +
            "284, tongue  [tʌŋ]\n" +
            "n. 舌头；语言\n" +
            "vt. 舔；斥责；用舌吹\n" +
            "vi. 说话；吹管乐器\n" +
            "285, literature  ['lɪt(ə)rətʃə]\n" +
            "n. 文学；文献；文艺；著作\n" +
            "286, pleasure  ['pleʒə]\n" +
            "n. 快乐；希望；娱乐；令人高兴的事\n" +
            "vt. 使高兴；使满意\n" +
            "vi. 高兴；寻欢作乐\n" +
            "287, league  [liːg]\n" +
            "n. 联盟；社团；范畴\n" +
            "vt. 使…结盟；与…联合\n" +
            "vi. 团结；结盟\n" +
            "288, depth  [depθ]\n" +
            "n. [海洋] 深度；深奥\n" +
            "289, condemn  [kən'dem]\n" +
            "vt. 谴责；判刑，定罪；声讨\n" +
            "290, junior  ['dʒuːnɪə]\n" +
            "adj. 年少的；后进的；下级的\n" +
            "n. 年少者，晚辈；地位较低者；大学三年级学生\n" +
            "291, promote  [prə'məʊt]\n" +
            "vt. 促进；提升；推销；发扬\n" +
            "vi. 成为王后或其他大于卒的子\n" +
            "292, fountain  [ˈfaʊntən]\n" +
            "n. 喷泉，泉水；源泉\n" +
            "293, bomb  [bɒm]\n" +
            "vt. 轰炸，投弹于\n" +
            "vi. 轰炸，投弹；失败\n" +
            "n. 炸弹\n" +
            "294, vain  [veɪn]\n" +
            "adj. 徒劳的；自负的；无结果的；无用的\n" +
            "295, senior  ['siːnɪə; 'siːnjə]\n" +
            "adj. 高级的；年长的；地位较高的；年资较深的，资格较老的\n" +
            "n. 上司；较年长者；毕业班学生\n" +
            "n. (Senior)人名；(英)西尼尔\n" +
            "296, soil  [sɒɪl]\n" +
            "n. 土地；土壤；国家；粪便；务农；温床\n" +
            "vt. 弄脏；污辱\n" +
            "vi. 变脏\n" +
            "297, concept  ['kɒnsept]\n" +
            "n. 观念，概念\n" +
            "298, volunteer  [,vɒlən'tɪə]\n" +
            "n. 志愿者；志愿兵\n" +
            "adj. 志愿的\n" +
            "vi. 自愿\n" +
            "vt. 自愿\n" +
            "299, restaurant  ['restrɒnt]\n" +
            "n. 餐馆；[经] 饭店\n" +
            "300, disease  [dɪ'ziːz]\n" +
            "n. 病，[医] 疾病；弊病\n" +
            "vt. 传染；使…有病\n" +
            "301, guider  ['ɡaɪdə]\n" +
            "n. 指导者；导星望远镜；导向器\n" +
            "302, flame  [fleɪm]\n" +
            "n. 火焰；热情；光辉\n" +
            "v. 焚烧；泛红\n" +
            "303, disadvantage  [dɪsəd'vɑːntɪdʒ]\n" +
            "n. 缺点；不利条件；损失\n" +
            "304, bond  [bɒnd]\n" +
            "n. 债券；结合；约定；粘合剂\n" +
            "vi. 结合，团结在一起\n" +
            "vt. 使结合；以…作保\n" +
            "305, tolerate  ['tɒləreɪt]\n" +
            "vt. 忍受；默许；宽恕\n" +
            "306, illness  [ɪlnɪs]\n" +
            "n. 病；疾病\n" +
            "307, rule  [ruːl]\n" +
            "vi. 统治；管辖；裁定\n" +
            "n. 统治；规则\n" +
            "vt. 统治；规定；管理；裁决；支配\n" +
            "308, suspect  [sə'spekt]\n" +
            "n. 嫌疑犯\n" +
            "adj. 可疑的；不可信的\n" +
            "vt. 怀疑；猜想\n" +
            "vi. 怀疑；猜想\n" +
            "309, participate  [pɑː'tɪsɪpeɪt]\n" +
            "vi. 参与，参加；分享\n" +
            "vt. 分享；分担\n" +
            "[ 过去式participated 过去分词participated 现在分词participating ]\n" +
            "310, gifted  ['gɪftɪd]\n" +
            "adj. 有天赋的；有才华的\n" +
            "v. 给予（gift的过去分词）\n" +
            "311, exhibition  [eksɪ'bɪʃ(ə)n]\n" +
            "n. 展览，显示；展览会；展览品\n" +
            "312, relevant  ['relɪv(ə)nt]\n" +
            "adj. 有关的；中肯的；有重大作用的\n" +
            "313, drug  [drʌg]\n" +
            "n. 药；毒品；麻醉药；滞销货\n" +
            "vt. 使服麻醉药；使服毒品；掺麻醉药于\n" +
            "vi. 吸毒\n" +
            "314, abstract  ['æbstrækt]\n" +
            "n. 摘要；抽象；抽象的概念\n" +
            "adj. 抽象的；深奥的\n" +
            "vt. 摘要；提取；使……抽象化\n" +
            "vi. 做摘要；写梗概\n" +
            "315, sincerely  [sɪn'sɪəlɪ]\n" +
            "adv. 真诚地；由衷地，诚恳地\n" +
            "316, sharp  [ʃɑːp]\n" +
            "adj. 急剧的；锋利的；强烈的；敏捷的；刺耳的\n" +
            "adv. 急剧地；锐利地；突然地\n" +
            "n. 尖头；骗子；内行\n" +
            "vt. 磨快；把音调升高\n" +
            "vi. 打扮；升音演奏\n" +
            "317, error  ['erə]\n" +
            "n. 误差；错误；过失\n" +
            "318, origin  ['ɒrɪdʒɪn]\n" +
            "n. 起源；原点；出身；开端\n" +
            "319, gesture  ['dʒestʃə]\n" +
            "n. 姿态；手势\n" +
            "vi. 作手势；用动作示意\n" +
            "vt. 用动作表示\n" +
            "320, century  ['sentʃʊrɪ]\n" +
            "n. 世纪，百年；（板球）一百分\n" +
            "321, potential  [pəˈtenʃl]\n" +
            "n. 潜能；可能性；[电] 电势\n" +
            "adj. 潜在的；可能的；势的\n" +
            "322, soft  [sɒft]\n" +
            "adj. 软的，柔软的；温柔的，温和的；软弱的；笨的\n" +
            "adv. 柔软地；温和地\n" +
            "n. 柔性；柔软的东西；柔软部分\n" +
            "323, schedule  ['ʃedjuːl; 'sked-]\n" +
            "vt. 安排，计划；编制目录；将……列入计划表\n" +
            "n. 时间表；计划表；一览表\n" +
            "324, address  [ə'dres]\n" +
            "vt. 演说；从事；忙于；写姓名地址；向…致辞\n" +
            "n. 地址；演讲；致辞；说话的技巧\n" +
            "325, unconscious  [ʌn'kɒnʃəs]\n" +
            "adj. 无意识的；失去知觉的；不省人事的；未发觉的\n" +
            "326, bleed  [bliːd]\n" +
            "vt. 使出血；榨取\n" +
            "vi. 流血；渗出；悲痛\n" +
            "327, target  ['tɑːgɪt]\n" +
            "n. 目标；靶子\n" +
            "vt. 把……作为目标；规定……的指标；瞄准某物\n" +
            "n. (Target)人名；(法)塔尔热；(英)塔吉特\n" +
            "328, instead  [ɪn'sted]\n" +
            "adv. 代替；反而\n" +
            "329, continent  ['kɒntɪnənt]\n" +
            "n. 大陆，洲，陆地\n" +
            "adj. 自制的，克制的\n" +
            "330, secret  ['siːkrɪt]\n" +
            "n. 秘密；秘诀；机密\n" +
            "adj. 秘密的；机密的\n" +
            "331, guarantee  [gær(ə)n'tiː]\n" +
            "n. 保证；担保；保证人；保证书；抵押品\n" +
            "vt. 保证；担保\n" +
            "332, special  ['speʃ(ə)l]\n" +
            "n. 特使，特派人员；特刊；特色菜；专车；特价商品\n" +
            "adj. 特别的；专门的，专用的\n" +
            "333, swap  [swɑp]\n" +
            "n. 交换；交换之物\n" +
            "vt. 与...交换；以...作交换\n" +
            "vi. 交换；交易\n" +
            "334, spread  [spred]\n" +
            "vi. 传播；伸展\n" +
            "vt. 传播，散布；展开；伸展；铺开\n" +
            "n. 传播；伸展\n" +
            "adj. 伸展的\n" +
            "335, earn  [ɜːn]\n" +
            "vt. 赚，赚得；获得，挣得；使得到；博得\n" +
            "n. (Earn)人名；(泰)炎\n" +
            "336, channel  ['tʃæn(ə)l]\n" +
            "vt. 引导，开导；形成河道\n" +
            "n. 通道；频道；海峡\n" +
            "337, average  ['æv(ə)rɪdʒ]\n" +
            "n. 平均；平均数；海损\n" +
            "adj. 平均的；普通的\n" +
            "vt. 算出…的平均数；将…平均分配；使…平衡\n" +
            "vi. 平均为；呈中间色\n" +
            "338, storage  ['stɔːrɪdʒ]\n" +
            "n. 存储；仓库；贮藏所\n" +
            "339, president  ['prezɪd(ə)nt]\n" +
            "n. 总统;董事长;校长\n" +
            "340, take advantage of  []\n" +
            "利用\n" +
            "341, in rent  []\n" +
            "\n" +
            "342, indecisiveness  ['ɪndɪ'sɪʒən]\n" +
            "n. 犹豫不定\n" +
            "343, chance  [tʃɑːns]\n" +
            "n. 机会，际遇；运气，侥幸；可能性\n" +
            "vt. 偶然发生；冒……的险\n" +
            "vi. 碰巧；偶然被发现\n" +
            "344, warehouse  ['weəhaʊs]\n" +
            "n. 仓库;货栈;大商店\n" +
            "vt. 储入仓库;以他人名义购进(股票)\n" +
            "345, oscar  ['ɔskə]\n" +
            "n. 奥斯卡（男子名）；（美）奥斯卡金像奖；钱\n" +
            "346, spacecraft  ['speɪskrɑːft]\n" +
            "n. [航] 宇宙飞船,航天器\n" +
            "347, banquet  ['bæŋkwɪt]\n" +
            "n. 宴会，盛宴；宴请，款待\n" +
            "vt. 宴请，设宴款待\n" +
            "vi. 参加宴会\n" +
            "348, trick  [trɪk]\n" +
            "n. 诡计;恶作剧;窍门;花招;骗局;欺诈\n" +
            "vt. 欺骗;哄骗;装饰;打扮\n" +
            "vi. 哄骗;戏弄\n" +
            "adj. 特技的;欺诈的;有决窍的\n" +
            "349, objects  ['ɔbjekts]\n" +
            "n. 物体(object的复数);目标\n" +
            "350, jet  [dʒet]\n" +
            "n. 喷射,喷嘴;喷气式飞机;黑玉\n" +
            "adj. 墨黑的\n" +
            "vt. 射出\n" +
            "vi. 射出;[航] 乘喷气式飞机\n" +
            "351, bought  [bɔːt]\n" +
            "v. 买（buy的过去式和过去分词）\n" +
            "352, distinction  [dɪ'stɪŋ(k)ʃ(ə)n]\n" +
            "n. 区别;差别;特性;荣誉、勋章\n" +
            "353, essential  [ɪ'senʃ(ə)l]\n" +
            "adj. 基本的；必要的；本质的；精华的\n" +
            "n. 本质；要素；要点；必需品\n" +
            "354, duplicate  ['djuːplɪkət]\n" +
            "vt. 复制;使加倍\n" +
            "n. 副本;复制品\n" +
            "adj. 复制的;二重的\n" +
            "vi. 复制;重复\n" +
            "355, comic  ['kɒmɪk]\n" +
            "adj. 喜剧的;滑稽的;有趣的\n" +
            "n. 连环漫画;喜剧演员;滑稽人物\n" +
            "356, heel  [hiːl]\n" +
            "n. 脚后跟；踵\n" +
            "vt. 倾侧\n" +
            "vi. 倾侧\n" +
            "357, differentiate  [,dɪfə'renʃɪeɪt]\n" +
            "vi. 区分,区别\n" +
            "vt. 区分,区别\n" +
            "358, enjoyable  [ɪn'dʒɒɪəb(ə)l; en-]\n" +
            "adj. 快乐的;令人愉快的\n" +
            "359, outlets  []\n" +
            "n. 出路;销售点;排水口;批发商点(outlet的复数形式)\n" +
            "360, neutral  ['njuːtr(ə)l]\n" +
            "adj. 中立的,中性的;中立国的;非彩色的\n" +
            "n. 中立国;中立者;非彩色;齿轮的空档\n" +
            "361, at the other extreme  []\n" +
            "在另一个极端\n" +
            "362, washing  ['wɒʃɪŋ]\n" +
            "n. 洗涤；洗涤剂；要洗的衣物\n" +
            "adj. 洗涤用的，清洗用的\n" +
            "v. 洗；使受洗礼（wash的ing形式）\n" +
            "363, evolution  [,iːvə'luːʃ(ə)n; 'ev-]\n" +
            "n. 演变;进化论;进展\n" +
            "364, extract  [ɪk'strækt; ek-]\n" +
            "vt. 提取；取出；摘录；榨取\n" +
            "n. 汁；摘录；榨出物；选粹\n" +
            "365, sprinkler  ['sprɪŋklə]\n" +
            "n. 洒水车;洒水器\n" +
            "366, authorities  []\n" +
            "n. 当局,官方(authority的复数)\n" +
            "367, urge  ['ɜːdʒ]\n" +
            "vt. 力劝，催促；驱策，推进\n" +
            "n. 强烈的欲望，迫切要求；推动力\n" +
            "vi. 强烈要求\n" +
            "368, sticker  ['stɪkə]\n" +
            "n. 尖刀；难题；张贴物；坚持不懈的人\n" +
            "vt. 给…贴上标签价\n" +
            "adj. 汽车价目标签的；汽车标签价的\n" +
            "369, quality  ['kwɒlɪtɪ]\n" +
            "n. 质量,[统计] 品质;特性;才能\n" +
            "370, bitter  ['bɪtə]\n" +
            "adj. 苦的；痛苦的；尖刻的；充满仇恨的\n" +
            "n. 苦味；苦啤酒\n" +
            "adv. 激烈地；严寒刺骨地\n" +
            "vt. 使变苦\n" +
            "371, overjoy  [,əʊvə'dʒɒɪ]\n" +
            "vt. 使狂喜；使万分高兴\n" +
            "372, liner  ['laɪnə]\n" +
            "n. 班轮,班机;衬垫;画线者\n" +
            "373, 有益的  []\n" +
            "beneficial\n" +
            "helpful\n" +
            "salutary\n" +
            "rewarding\n" +
            "advantageous\n" +
            "374, what are you up to  []\n" +
            "你在忙什么呢\n" +
            "375, distracting  [dɪ'stræktɪŋ]\n" +
            "adj. 分心的;分散注意力的\n" +
            "v. 使分心(distract的ing形式);转移注意力\n" +
            "376, sped  [sped]\n" +
            "v. 加速；飞驰（speed的过去分词）\n" +
            "377, secondary  ['sek(ə)nd(ə)rɪ]\n" +
            "adj. 第二的;中等的;次要的;中级的\n" +
            "n. 副手;代理人\n" +
            "378, made  [meɪd]\n" +
            "adj. 成功的；创造的\n" +
            "v. 做，使，安排（make的过去式和过去分词）\n" +
            "379, jammed  [dʒæmd]\n" +
            "adj. 堵塞的；拥挤的；轧住了的\n" +
            "380, authority  [ɔː'θɒrɪtɪ]\n" +
            "n. 权威;权力;当局\n" +
            "381, suburb  ['sʌbɜːb]\n" +
            "n. 郊区；边缘\n" +
            "382, lettuce  ['letɪs]\n" +
            "n. [园艺] 生菜;莴苣;(美)纸币\n" +
            "383, conversation  [kɒnvə'seɪʃ(ə)n]\n" +
            "n. 交谈；会话；社交\n" +
            "384, foundation  [faʊn'deɪʃ(ə)n]\n" +
            "n. 基础;地基;基金会;根据;创立\n" +
            "385, ropes  []\n" +
            "n. 绳索(rope的复数);围绳\n" +
            "386, trial  ['traɪəl]\n" +
            "n. 试验；审讯；努力；磨炼\n" +
            "adj. 试验的；审讯的\n" +
            "387, fritter  ['frɪtə]\n" +
            "vt. 浪费；细切；剁碎\n" +
            "n. 细片；屑；带馅油炸面团\n" +
            "vi. 浪费；减少；消散\n" +
            "388, ignore  [ɪg'nɔː]\n" +
            "vt. 驳回诉讼；忽视；不理睬\n" +
            "389, define  [dɪ'faɪn]\n" +
            "vt. 定义；使明确；规定\n" +
            "n. (Define)人名；(英)德法恩；(葡)德菲内\n" +
            "390, emptiness  ['em(p)tɪnɪs]\n" +
            "n. 空虚;无知\n" +
            "391, pumpkins  []\n" +
            "n. 南瓜(pumpkin的复数)\n" +
            "392, meaning  ['miːnɪŋ]\n" +
            "n. 意义；含义；意图\n" +
            "adj. 意味深长的\n" +
            "v. 意味；意思是（mean的ing形式）\n" +
            "393, drown  [draʊn]\n" +
            "vt. 淹没;把…淹死\n" +
            "vi. 淹死;溺死\n" +
            "394, analyze  ['ænə,laɪz]\n" +
            "vt. 对…进行分析，分解（等于analyse）\n" +
            "395, stress on  []\n" +
            "对…的强调\n" +
            "396, legend  ['ledʒ(ə)nd]\n" +
            "n. 传奇;说明;图例;刻印文字\n" +
            "397, landscapes  []\n" +
            "n. 风景;风景地貌(landscape的复数)\n" +
            "v. 从事庭园设计;美化(landscape的三单形式)\n" +
            "398, dominoes  []\n" +
            "n. 多米诺骨牌(效应);牙齿;骰子(domino的复数)\n" +
            "399, try out  []\n" +
            "试验；提炼；考验\n" +
            "400, specimens  []\n" +
            "n. 试样,样本(specimen的复数)\n" +
            "401, ham  [hæm]\n" +
            "n. 火腿;业余无线电爱好者;蹩脚演员\n" +
            "vi. 表演过火\n" +
            "vt. 演得过火\n" +
            "adj. 过火的;做作的\n" +
            "402, sputnik  ['spʌtnɪk]\n" +
            "n. 人造卫星(前苏联制造)\n" +
            "403, regulations  []\n" +
            "n. 条例;规程(regulation的复数);章则\n" +
            "404, exception  [ɪk'sepʃ(ə)n; ek-]\n" +
            "n. 例外;异议\n" +
            "405, silverware  ['sɪlvəweə]\n" +
            "n. 银器;镀银餐具\n" +
            "406, cruise  [kruːz]\n" +
            "vi. 巡航,巡游;漫游\n" +
            "vt. 巡航,巡游;漫游\n" +
            "n. 巡航,巡游;乘船游览\n" +
            "407, expenses  []\n" +
            "n. 费用（expense的复数形式）；[会计] 开支\n" +
            "v. 向…收取费用；被花掉（expense的第三人称单数形式）\n" +
            "408, resembling  []\n" +
            "vt. 像\n" +
            "409, height  [haɪt]\n" +
            "n. 高地;高度;身高;顶点\n" +
            "410, grits  [grɪts]\n" +
            "n. 粗磨粉;粗燕麦粉;(美)粗玉米粉\n" +
            "411, in person  []\n" +
            "亲自；外貌上\n" +
            "412, invasion  [ɪn'veɪʒ(ə)n]\n" +
            "n. 入侵,侵略;侵袭;侵犯\n" +
            "413, perspective  [pə'spektɪv]\n" +
            "n. 观点;远景;透视图\n" +
            "adj. 透视的\n" +
            "414, 耐心  [nài xīn]\n" +
            "patience\n" +
            "take pains\n" +
            "take pain\n" +
            "415, stay out of  []\n" +
            "vt. 置身于……之外\n" +
            "416, guilt  [gɪlt]\n" +
            "n. 犯罪，过失；内疚\n" +
            "417, crack  [kræk]\n" +
            "vt. 使破裂;打开;变声\n" +
            "vi. 破裂;爆裂\n" +
            "n. 裂缝;声变;噼啪声\n" +
            "adj. 最好的;高明的\n" +
            "418, fulfill  [ful'fil]\n" +
            "vt. 履行;实现;满足;使结束(等于fulfil)\n" +
            "419, scared  [skeəd]\n" +
            "adj. 害怕的\n" +
            "v. 使害怕（scare的过去分词）\n" +
            "420, rarity  ['reərɪtɪ]\n" +
            "n. 罕见;珍贵;珍品(需用复数);稀薄\n" +
            "421, timid  ['tɪmɪd]\n" +
            "adj. 胆小的;羞怯的\n" +
            "422, rural  ['rʊər(ə)l]\n" +
            "adj. 农村的,乡下的;田园的,有乡村风味的\n" +
            "423, horseback  ['hɔːsbæk]\n" +
            "n. 马背;峻峭的山脊\n" +
            "adv. 在马背上\n" +
            "adj. 性急的;草率的;未经充分考虑的\n" +
            "424, tremble  ['tremb(ə)l]\n" +
            "vi. 发抖；战栗；焦虑；摇晃\n" +
            "vt. 使挥动；用颤抖的声音说出\n" +
            "n. 颤抖；战栗；摇晃\n" +
            "425, items  []\n" +
            "n. 项目;名目;所有物品(item的复数形式)\n" +
            "v. 记下(item的第三人称单数形式);逐条记载\n" +
            "426, assumptions  []\n" +
            "n. 假定,设想(assumption复数形式)\n" +
            "427, delivering  []\n" +
            "v. 发表(deliver的ing形式);投递\n" +
            "428, make  [meɪk]\n" +
            "vt. 使得；进行；布置，准备，整理；制造；认为；获得；形成；安排；引起；构成\n" +
            "vi. 开始；前进；增大；被制造\n" +
            "n. 制造；构造；性情\n" +
            "429, crabs  [kræbz]\n" +
            "n. 蟹类;吊钳;脾气坏的人(crab的复数)\n" +
            "v. 捕蟹;抱怨;侧航(crab的三单形式)\n" +
            "430, room  [ruːm; rʊm]\n" +
            "n. 房间；空间；余地；机会\n" +
            "vt. 为…提供住处\n" +
            "vi. 居住；住宿\n" +
            "431, up to  []\n" +
            "一直到；相当于；忙于…，在做…；由…决定的\n" +
            "432, membership  ['membəʃɪp]\n" +
            "n. 资格;成员资格;会员身分\n" +
            "433, granted  ['ɡrɑːntɪd]\n" +
            "vt. 授予;同意(grant的过去式)\n" +
            "434, remarks  []\n" +
            "n. 评论(remark的复数);摘要;附注\n" +
            "435, released  []\n" +
            "v. 释放(release的过去式);已发布\n" +
            "436, honeymoon  ['hʌnɪmuːn]\n" +
            "n. 蜜月;蜜月假期;(新生事物、新建关系等的)短暂的和谐时期\n" +
            "vi. 度蜜月\n" +
            "437, shepherd  ['ʃepəd]\n" +
            "vt. 牧羊;带领;指导;看管\n" +
            "n. 牧羊人;牧师;指导者\n" +
            "438, balls  [bɔːlz]\n" +
            "n. 球(ball的复数)\n" +
            "v. 把…捏成球状(ball的第三人称单数)\n" +
            "439, faceless  ['feɪslɪs]\n" +
            "adj. 匿名的,不知名的;无个性的;无脸面的\n" +
            "440, mercantile  ['mɜːk(ə)ntaɪl]\n" +
            "adj. 商业的;商人的;重商主义的\n" +
            "n. 商品\n" +
            "441, implied  [ɪm'plaɪd]\n" +
            "vt. 暗示;意味(imply的过去式)\n" +
            "adj. 含蓄的;暗指的\n" +
            "442, trained  [treɪnd]\n" +
            "adj. 培训;训练过的,受过培训的\n" +
            "v. 训练(train的过去分词)\n" +
            "443, calendar  ['kælɪndə]\n" +
            "n. 日历；[天] 历法；日程表\n" +
            "vt. 将…列入表中；将…排入日程表\n" +
            "444, tort  [tɔːt]\n" +
            "n. 侵权行为\n" +
            "445, shadowy  ['ʃædəʊɪ]\n" +
            "adj. 朦胧的;有阴影的;虚无的;暗黑的\n" +
            "446, estimates  ['estiməts]\n" +
            "n. 估计;预算(estimate的复数);概数\n" +
            "v. 评价(estimate的三单形式);估量\n" +
            "447, messed  []\n" +
            "弄脏\n" +
            "弄乱( mess的过去式和过去分词 )\n" +
            "448, lay  [leɪ]\n" +
            "vt. 躺下；产卵；搁放\n" +
            "adj. 世俗的；外行的\n" +
            "n. 位置；短诗；花纹方向\n" +
            "vi. 下蛋；打赌\n" +
            "v. 躺；位于（lie的过去式）\n" +
            "449, cable  ['keɪb(ə)l]\n" +
            "n. 电缆;海底电报\n" +
            "vt. 打电报\n" +
            "vi. 打海底电报\n" +
            "450, injection  [ɪn'dʒekʃ(ə)n]\n" +
            "n. 注射;注射剂;充血;射入轨道\n" +
            "451, departure  [dɪ'pɑːtʃə]\n" +
            "n. 离开;出发;违背\n" +
            "452, scenic  ['siːnɪk]\n" +
            "adj. 风景优美的;舞台的;戏剧的\n" +
            "n. 风景胜地;风景照片\n" +
            "453, destiny  ['destɪnɪ]\n" +
            "n. 命运，定数，天命\n" +
            "454, incurable  [ɪn'kjʊərəb(ə)l]\n" +
            "adj. 不能治愈的;无可救药的\n" +
            "n. 患不治之症者,不能治愈的人\n" +
            "455, transformation  [trænsfə'meɪʃ(ə)n; trɑːns-; -nz-]\n" +
            "n. [遗] 转化;转换;改革;变形\n" +
            "456, obliged  []\n" +
            "adj. 必须的;感激的;有责任的\n" +
            "v. 要求;约束;施恩惠(oblige的过去分词)\n" +
            "457, Europa  []\n" +
            "n. 欧罗巴（腓尼基王阿革诺耳之女）；[天] 木卫二\n" +
            "458, never  ['nevə]\n" +
            "adv. 从未；决不\n" +
            "459, assessment  [ə'sesmənt]\n" +
            "n. 评定；估价\n" +
            "460, lower  ['ləʊə]\n" +
            "vt. 减弱,减少;放下,降下;贬低\n" +
            "vi. 降低;减弱;跌落\n" +
            "adj. 下游的;下级的;下等的\n" +
            "461, somehow  ['sʌmhaʊ]\n" +
            "adv. 以某种方法;莫明其妙地\n" +
            "462, hasty  ['heɪstɪ]\n" +
            "adj. 轻率的;匆忙的;草率的;性怠的\n" +
            "n. (Hasty)人名;(英)黑斯蒂\n" +
            "[ 比较级 hastier 最高级 hastiest ]\n" +
            "463, paddling  ['pædlɪŋ]\n" +
            "n. [皮革] 划动\n" +
            "v. 用桨划;在水中行进(paddle的现在分词)\n" +
            "464, layers  []\n" +
            "n. 图层面板,图层集合(layer复数形式);层面板\n" +
            "465, sugary  ['ʃʊg(ə)rɪ]\n" +
            "adj. 含糖的;甜的;糖状的;甜言蜜语的\n" +
            "466, rock  [rɒk]\n" +
            "n. 岩石；摇滚乐；暗礁\n" +
            "vt. 摇动；使摇晃\n" +
            "vi. 摇动；摇晃\n" +
            "467, refer to  []\n" +
            "参考；涉及；指的是；适用于\n" +
            "468, historic  [hɪ'stɒrɪk]\n" +
            "adj. 有历史意义的;历史上著名的\n" +
            "469, mindfulness  ['maindfulnis]\n" +
            "n. 留心,警觉\n" +
            "470, haste  [heɪst]\n" +
            "n. 匆忙;急忙;轻率\n" +
            "vi. 匆忙;赶紧\n" +
            "vt. 赶快\n" +
            "n. (Haste)人名;(英)黑斯特;(法)阿斯特\n" +
            "471, haunting  ['hɔːntɪŋ]\n" +
            "adj. 不易忘怀的,萦绕于心头的;给人以强烈感受的\n" +
            "v. 常去;缠住某人;萦绕在…心中(haunt的ing形式)\n" +
            "472, outdated  [aʊt'deɪtɪd]\n" +
            "adj. 过时的；旧式的\n" +
            "v. 使过时（outdate的过去式和过去分词）\n" +
            "473, awesome  ['ɔːs(ə)m]\n" +
            "adj. 令人敬畏的；使人畏惧的；可怕的；极好的\n" +
            "474, among  [ə'mʌŋ]\n" +
            "prep. 在…中间；在…之中\n" +
            "475, backyard  [bæk'jɑːd]\n" +
            "n. 后院；后庭\n" +
            "476, come up  []\n" +
            "走近；发生；开始；上升；发芽；被提出\n" +
            "477, excuse me  []\n" +
            "对不起，打扰一下\n" +
            "478, manufacturers  [,mænju'fæktʃərəz]\n" +
            "制造商;厂商\n" +
            "479, career  [kə'rɪə]\n" +
            "n. 事业，职业；生涯\n" +
            "480, alerting  [ə'lə:tiŋ]\n" +
            "n. 报警;警示讯号\n" +
            "v. 报警;发信号(alert的ing形式)\n" +
            "481, assured  [ə'ʃʊəd]\n" +
            "adj. 确定的;自信的\n" +
            "n. 被保险人\n" +
            "v. 保证;确实(assure的过去分词)\n" +
            "482, cool off  []\n" +
            "变凉；平静下来\n" +
            "483, category  ['kætɪg(ə)rɪ]\n" +
            "n. 种类,分类;[数] 范畴\n" +
            "484, raining  [ren]\n" +
            "adj. 下雨的\n" +
            "v. 下雨（rain的ing形式）\n" +
            "485, perfume  ['pɜːfjuːm]\n" +
            "n. 香水;香味\n" +
            "vt. 洒香水于…;使…带香味\n" +
            "vi. 散发香气\n" +
            "486, scene  [siːn]\n" +
            "n. 场面；情景；景象；事件\n" +
            "487, compartment  [kəm'pɑːtm(ə)nt]\n" +
            "n. [建] 隔间;区划;卧车上的小客房\n" +
            "vt. 分隔;划分\n" +
            "488, crossword  ['krɒswɜːd]\n" +
            "n. 纵横字谜;纵横填字谜(等于cross puzzle)\n" +
            "489, upon  [ə'pɒn]\n" +
            "prep. 根据；接近；在…之上\n" +
            "490, finest  [fɪ'nest]\n" +
            "n. 警察\n" +
            "adj. 好的,出色的(fine的最高级)\n" +
            "491, tropical  ['trɒpɪk(ə)l]\n" +
            "adj. 热带的;热情的;酷热的\n" +
            "492, announce  [ə'naʊns]\n" +
            "vt. 宣布；述说；预示；播报\n" +
            "vi. 宣布参加竞选；当播音员\n" +
            "493, babysit  ['beɪbɪsɪt]\n" +
            "vi. (临时代人)照看婴孩\n" +
            "494, thought  [θɔːt]\n" +
            "n. 思想；思考；想法；关心\n" +
            "v. 想，思考；认为（think的过去式和过去分词）\n" +
            "495, newlyweds  []\n" +
            "n. 新婚夫妇;新婚的人(newlywed的复数)\n" +
            "496, in a statement  []\n" +
            "正在翻译\n" +
            "在一份声明\n" +
            "在一项声明中\n" +
            "497, symbolize  ['sɪmbəlaɪz]\n" +
            "vt. 象征;用符号表现\n" +
            "vi. 采用象征;使用符号;作为…的象征\n" +
            "498, destroyed  [dɪ'strɔi]\n" +
            "adj. 被毁，毁坏；遭破坏的\n" +
            "v. 破坏（destroy的过去分词）\n" +
            "499, alerts  []\n" +
            "n. 警报;警戒状态;通告(alert的复数形式)\n" +
            "v. 通知(alert的第三人称单数);使…警觉\n" +
            "500, what is up  []\n" +
            "未来会怎样；近来可好\n" +
            "501, dependable  [dɪ'pendəb(ə)l]\n" +
            "adj. 可靠的,可信赖的;可信任的\n" +
            "502, productivity  [prɒdʌk'tɪvɪtɪ]\n" +
            "n. 生产力;生产率;生产能力\n" +
            "503, diversity  [daɪ'vɜːsɪtɪ; dɪ-]\n" +
            "n. 多样性;差异\n" +
            "504, enormous  [ɪ'nɔːməs]\n" +
            "adj. 庞大的,巨大的;凶暴的,极恶的\n" +
            "505, foster  ['fɒstə]\n" +
            "vt. 培养;养育,抚育;抱(希望等)\n" +
            "adj. 收养的,养育的\n" +
            "506, migratory  ['maɪgrət(ə)rɪ; maɪ'greɪt(ə)rɪ]\n" +
            "adj. 迁移的;流浪的\n" +
            "507, recall  [rɪ'kɔːl]\n" +
            "vt. 召回；回想起，记起；取消\n" +
            "n. 召回；回忆；撤消\n" +
            "508, concluded  []\n" +
            "v. 结束;推断;作结论(conclude的过去分词)\n" +
            "adj. 推论的\n" +
            "509, settle  ['set(ə)l]\n" +
            "vi. 解决；定居；沉淀；下陷\n" +
            "vt. 解决；安排；使…定居\n" +
            "n. 有背长椅\n" +
            "510, freeway  ['friːweɪ]\n" +
            "n. 高速公路\n" +
            "511, tofu  ['təʊfuː]\n" +
            "n. 豆腐\n" +
            "512, tougher  []\n" +
            "较坚强的\n" +
            "较艰苦的(tough的比较级)\n" +
            "513, acre  ['eɪkə]\n" +
            "n. 土地,地产;英亩\n" +
            "514, preferably  ['prefrəblɪ]\n" +
            "adv. 较好;宁可,宁愿;更适宜\n" +
            "515, flunk  [flʌŋk]\n" +
            "vi. 失败;放弃;考试不及格\n" +
            "vt. 使…不及格\n" +
            "n. 不及格;失败\n" +
            "516, retreat  [rɪ'triːt]\n" +
            "n. 撤退；休息寓所；撤退\n" +
            "vi. 撤退；退避；向后倾\n" +
            "vt. 退（棋）；使后退\n" +
            "517, foundations  []\n" +
            "n. 基础(foundation的复数);房基\n" +
            "518, hit  [hɪt]\n" +
            "vt. 打击；袭击；碰撞；偶然发现；伤…的感情\n" +
            "vi. 打；打击；碰撞；偶然碰上\n" +
            "n. 打；打击；（演出等）成功；讽刺\n" +
            "519, practically  ['præktɪk(ə)lɪ]\n" +
            "adv. 实际地;几乎;事实上\n" +
            "520, tear  [tɪə]\n" +
            "n. 眼泪, （撕破的）洞或裂缝, 撕扯\n" +
            "vt. 撕掉, 扯下, 扰乱\n" +
            "vi. 流泪, 撕破\n" +
            "521, interviewing  []\n" +
            "vi. 面试；参加面试（interview的ing形式）\n" +
            "522, calculator  ['kælkjʊleɪtə]\n" +
            "n. 计算器；计算者\n" +
            "523, flexibility  [,fleksɪ'bɪlɪtɪ]\n" +
            "n. 灵活性;弹性;适应性\n" +
            "524, argument  ['ɑːgjʊm(ə)nt]\n" +
            "n. 论证；论据；争吵；内容提要\n" +
            "525, wrap  [ræp]\n" +
            "vt. 包；缠绕；隐藏；掩护\n" +
            "vi. 包起来；缠绕；穿外衣\n" +
            "n. 外套；围巾\n" +
            "526, carcasses  []\n" +
            "n. 尸体；兽体（carcass的复数形式）\n" +
            "527, earn one's living  []\n" +
            "v. 挣钱维持生计\n" +
            "528, discourage  [dɪs'kʌrɪdʒ]\n" +
            "vt. 阻止；使气馁\n" +
            "529, console  [kən'səʊl]\n" +
            "n. [计] 控制台;[电] 操纵台\n" +
            "vt. 安慰;慰藉\n" +
            "530, playback  ['pleɪbæk]\n" +
            "n. [电视][广播] 重放；录音重放装置\n" +
            "531, fined  [faind]\n" +
            "v. 罚钱(fine的过去式)\n" +
            "532, fingertips  []\n" +
            "指尖\n" +
            "533, installing  [ɪn'stɔl]\n" +
            "n. 安装；插入；任命\n" +
            "v. 安装；安置（install的ing形式）；正式任命\n" +
            "adj. 安装的\n" +
            "534, invigilator  [ɪn'vɪdʒɪleɪtə]\n" +
            "n. 监考人;[自] 监视器\n" +
            "535, tiny  ['taɪnɪ]\n" +
            "adj. 微小的;很少的\n" +
            "536, coral  ['kɒr(ə)l]\n" +
            "n. 珊瑚;珊瑚虫\n" +
            "adj. 珊瑚的;珊瑚色的\n" +
            "537, digest  [daɪ'dʒest; dɪ-]\n" +
            "vt. 消化；吸收；融会贯通\n" +
            "vi. 消化\n" +
            "n. 文摘；摘要\n" +
            "538, security  [sɪ'kjʊərɪtɪ; sɪ'kjɔːrɪtɪ]\n" +
            "n. 安全；保证；证券；抵押品\n" +
            "adj. 安全的；保安的；保密的\n" +
            "539, roller  ['rəʊlə]\n" +
            "n. [机] 滚筒;[机] 滚轴;辊子;滚转机\n" +
            "540, mouthful  ['maʊθfʊl; -f(ə)l]\n" +
            "n. 一口,满口\n" +
            "541, distribute  [dɪ'strɪbjuːt; 'dɪstrɪbjuːt]\n" +
            "vt. 分配；散布；分开；把…分类\n" +
            "542, permium  []\n" +
            "额外价格\n" +
            "二叠纪\n" +
            "543, below  [bɪ'ləʊ]\n" +
            "adv. 在下面，在较低处；在本页下面\n" +
            "prep. 在…下面\n" +
            "544, economically  [iːkə'nɒmɪklɪ]\n" +
            "adv. 经济地;在经济上;节俭地\n" +
            "545, conjure  ['kʌndʒə]\n" +
            "vt. 念咒召唤；用魔法驱赶；提出，想象；恳求\n" +
            "vi. 施魔法；变魔术\n" +
            "546, despair  [dɪ'speə]\n" +
            "n. 绝望;令人绝望的人或事\n" +
            "vi. 绝望,丧失信心\n" +
            "547, alias  ['eɪlɪəs]\n" +
            "n. 别名，化名\n" +
            "adv. 别名叫；化名为\n" +
            "548, pedestrians  []\n" +
            "n. 行人(pedestrian的复数)\n" +
            "549, sport  [spɔːt]\n" +
            "n. 运动;游戏;娱乐;运动会;玩笑\n" +
            "vi. 游戏\n" +
            "vt. 游戏;参加体育运动;夸耀\n" +
            "adj. 运动的\n" +
            "550, registration  [redʒɪ'streɪʃ(ə)n]\n" +
            "n. 登记；注册；挂号\n" +
            "551, paradise  ['pærədaɪs]\n" +
            "n. 天堂\n" +
            "552, amazon  ['æməzən]\n" +
            "亚马逊;古希腊女战士\n" +
            "553, ongoing  ['ɒngəʊɪŋ]\n" +
            "adj. 不间断的,进行的;前进的\n" +
            "n. 前进;行为,举止\n" +
            "554, pin  [pɪn]\n" +
            "n. 大头针，针；栓；琐碎物\n" +
            "vt. 钉住；压住；将……用针别住\n" +
            "555, fought  [fɔt]\n" +
            "v. 战斗（fight的过去分词）；打架\n" +
            "556, competitive  [kəm'petɪtɪv]\n" +
            "adj. 竞争的；比赛的；求胜心切的\n" +
            "557, timeout  ['taɪm'aʊt]\n" +
            "n. 超时；暂时休息；工间休息\n" +
            "558, for once  []\n" +
            "仅此一次\n" +
            "559, there is no way of  []\n" +
            "没有办法（做）……\n" +
            "560, kicking  ['kɪkɪŋ]\n" +
            "n. 踢腿;反撞\n" +
            "adj. 活泼热烈的;激动人心的\n" +
            "v. 踢;反冲;加速;活跃(kick的ing形式)\n" +
            "561, hardship  ['hɑːdʃɪp]\n" +
            "n. 困苦；苦难；艰难险阻\n" +
            "562, maintain  [meɪn'teɪn; mən'teɪn]\n" +
            "vt. 维持；继续；维修；主张；供养\n" +
            "563, declines  []\n" +
            "vi. 下降;衰退;拒绝(decline的第三人称单数)\n" +
            "564, conducted  [kən'dʌktid]\n" +
            "v. 管理(conduct的过去分词);引导;指挥\n" +
            "565, groundwork  ['graʊn(d)wɜːk]\n" +
            "n. 基础;地基,根基\n" +
            "566, pop  [pɒp]\n" +
            "n. 流行音乐；汽水；砰然声；枪击\n" +
            "vi. 突然出现；爆开；射击；瞪大；发出爆裂声\n" +
            "vt. 取出；开枪打；抛出；突然伸出；突然行动\n" +
            "adj. 流行的；通俗的；热门的\n" +
            "adv. 突然；砰地\n" +
            "abbr. 邮局协议（post office protocol）\n" +
            "567, validate  ['vælɪdeɪt]\n" +
            "vt. 证实，验证；确认；使生效\n" +
            "568, evident  ['evɪd(ə)nt]\n" +
            "adj. 明显的；明白的\n" +
            "569, basically  ['beɪsɪk(ə)lɪ]\n" +
            "adv. 主要地,基本上\n" +
            "570, two-way  [,tu:'weɪ]\n" +
            "adj. 双向的；相互的；两路的\n" +
            "571, feature  ['fiːtʃə]\n" +
            "n. 特色,特征;容貌;特写或专题节目\n" +
            "vi. 起重要作用\n" +
            "vt. 特写;以…为特色;由…主演\n" +
            "572, gonna  ['gɒnə]\n" +
            "abbr. （美）将要（等于going to）\n" +
            "573, nowhere  ['nəʊhweə]\n" +
            "adv. 无处;任何地方都不;毫无结果\n" +
            "n. 无处;任何地方;无名之地\n" +
            "adj. 不存在的;毫无结果的;不知名的\n" +
            "574, on edge  []\n" +
            "adv. 紧张；急切；竖着\n" +
            "575, modifications  [,mɑdəfə'keʃən]\n" +
            "n. 修改;修饰;变型;条款修订(modification的复数)\n" +
            "576, ageing  ['eɪdʒɪŋ]\n" +
            "n. 老化;变老,成熟\n" +
            "adj. 变老的,老化的\n" +
            "v. 变老(age的现在分词)\n" +
            "577, florist  ['flɒrɪst]\n" +
            "n. 花商，种花人；花卉研究者\n" +
            "578, obey  [ə(ʊ)'beɪ]\n" +
            "vt. 服从，听从；按照……行动\n" +
            "vi. 服从，顺从；听话\n" +
            "579, conscious  ['kɒnʃəs]\n" +
            "adj. 意识到的；故意的；神志清醒的\n" +
            "580, lot  [lɒt]\n" +
            "n. 命运；一块地；一堆；抽签；份额\n" +
            "vt. 划分\n" +
            "vi. 抽签；抓阄\n" +
            "adv. 非常；相当\n" +
            "581, meditation  [medɪ'teɪʃ(ə)n]\n" +
            "n. 冥想;沉思,深思\n" +
            "582, referred  []\n" +
            "v. 参考,查阅(refer的过去式);归类,谈及,送交\n" +
            "adj. 援引的\n" +
            "583, clownfish  []\n" +
            "n. 小丑鱼；海葵鱼\n" +
            "584, god  [ɡɒd]\n" +
            "n. 神；（大写首字母时）上帝\n" +
            "vt. 膜拜，崇拜\n" +
            "585, annoyance  [ə'nɒɪəns]\n" +
            "n. 烦恼;可厌之事;打扰\n" +
            "586, payback  ['pebæk]\n" +
            "n. 偿付；投资的回收\n" +
            "587, chase  [tʃeɪs]\n" +
            "vt. 追逐；追捕；试图赢得；雕镂\n" +
            "vi. 追逐；追赶；奔跑\n" +
            "n. 追逐；追赶；追击\n" +
            "588, on the top of that  []\n" +
            "在最重要的是\n" +
            "顶部的\n" +
            "在那的上面\n" +
            "589, exoplanet  []\n" +
            "外星行星\n" +
            "590, strike  [straɪk]\n" +
            "vi. 打，打击；罢工；敲，敲击；抓；打动；穿透\n" +
            "vt. 打，击；罢工；撞击，冲击；侵袭；打动；到达\n" +
            "n. 罢工；打击；殴打\n" +
            "591, be used up  []\n" +
            "用完；筋疲力尽\n" +
            "592, as well as  []\n" +
            "也；和…一样；不但…而且\n" +
            "593, go over  []\n" +
            "复习，重温；仔细检查；转变；润色\n" +
            "594, secy  []\n" +
            "秘书（secretary）\n" +
            "分泌作用的分，泌的，促进分泌的（secretary）\n" +
            "595, parachute  ['pærəʃuːt]\n" +
            "n. 降落伞\n" +
            "vi. 跳伞\n" +
            "空投\n" +
            "596, candidates  []\n" +
            "n. 候选人;申请者;应征人员(candidate的复数)\n" +
            "597, dismissed  [dis'mist]\n" +
            "v. 开除,解散(dismiss的过去分词);摒弃\n" +
            "adj. 解雇的;解散的,被排除的\n" +
            "598, definitely  ['defɪnɪtlɪ]\n" +
            "adv. 清楚地,当然;明确地,肯定地\n" +
            "599, cancellation  [,kænsə'leɪʃ(ə)n]\n" +
            "n. 取消;删除\n" +
            "600, Korea  [kə'rɪə]\n" +
            "n. 韩国；朝鲜";
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
    public static String[] data=data1.split("\\n");
    public static String[] data3=data2.split("\\n");


}


