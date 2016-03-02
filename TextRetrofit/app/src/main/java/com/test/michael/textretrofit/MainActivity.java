package com.test.michael.textretrofit;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.test.michael.textretrofit.entity.DailyStories;
import com.test.michael.textretrofit.respository.NetRepository;

/**
 * 测试Retrofit网络请求方式，请求知乎日报一个ＵＲＬ,显示到UI上
 */
public class MainActivity extends AppCompatActivity {
    private TextView title,id,image,date;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestForLatestNews(view);
            }
        });
        initView();
    }
    public void initView(){
        title = (TextView) findViewById(R.id.title_tv);
        id = (TextView) findViewById(R.id.text_id);
        image = (TextView) findViewById(R.id.image_url_tv);
        date = (TextView) findViewById(R.id.date_tv);

    }

    /**
     *http://stackoverflow.com/questions/19951466/java-net-unknownhostexception-unable-to-resolve-host-url-no-address-associ
     * @param view
     */
    public void requestForLatestNews(final View view){
        TestRetrofitApplication.getNetRepository().getLatestDailyStories(new NetRepository.Callback<DailyStories>
                () {
            @Override
            public void success(DailyStories stories, String url) {
                title.setText("标题：" + stories.getStories().get(0).getTitle());
                id.setText("id:" + stories.getStories().get(0).getId());
                image.setText("image_url:" + stories.getStories().get(0).getImages().get(0));
                date.setText("date:" + stories.getDate());
                Snackbar.make(view, "请求成功", Snackbar.LENGTH_SHORT).show();
            }

            @Override
            public void failure(Exception e, String url) {
                Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_SHORT).show();
            }

        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
