package dong.relativelayout;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private List<WeChatContents> mList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setTitle("关于微信");
            setContentView(R.layout.activity_main);
        android.support.v7.app.ActionBar actionBar=getSupportActionBar();
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
//        setSupportActionBar(myToolbar);
//        getSupportActionBar().setCustomView(LayoutInflater.from(this).inflate(R.layout.actionbar, null));
//        getSupportActionBar().setDisplayShowCustomEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(false);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);
        listView=(ListView)findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                WeChatContents weChatContents = mList.get(position);//注意这里和getItem方法的区别
                Toast.makeText(MainActivity.this, "即将跳转到" + (CharSequence) weChatContents.getContents() + "界面",
                        Toast.LENGTH_SHORT).show();
            }
        });
        initList();
        MyAdapter myAdapter=new MyAdapter(MainActivity.this,R.layout.sublist,mList);
        listView.setAdapter(myAdapter);

        }
public void initList(){
    WeChatContents wc_1=new WeChatContents("去评分");
    mList.add(wc_1);
    WeChatContents wc_2=new WeChatContents("功能介绍");
    mList.add(wc_2);
    WeChatContents wc_3=new WeChatContents("系统通知");
    mList.add(wc_3);
    WeChatContents wc_4=new WeChatContents("帮助与反馈");
    mList.add(wc_4);
    WeChatContents wc_5=new WeChatContents("检查新版本");
    mList.add(wc_5);

}
//        @Override
//             public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
 switch (item.getItemId()) {
            case R.id.back:
                finish();
                return true;
              case android.R.id.home:
              finish();
              return true;
 }

        return super.onOptionsItemSelected(item);
    }
}
