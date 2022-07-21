package com.xitong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.xitong.R;
import com.xitong.Bean.contacts;
import com.xitong.adapter.ContactsAdapter;
import com.xitong.database.SQLiteHelper;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView add;
    ListView listView;
    List<contacts> list;
    SQLiteHelper mSQLiteHelper;
    ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (ImageView)findViewById(R.id.add);
        listView = (ListView)findViewById(R.id.listview);
        mSQLiteHelper= new SQLiteHelper(this); //创建数据库
        //初始化内容
        showQueryData();
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AddStudent.class);
                startActivity(intent);
            }
        });
    }
    /***
     * 更新数据
     */
    private void showQueryData(){
        if (list!=null){
            list.clear();
        }
        //从数据库中查询数据(保存的标签)
        list = mSQLiteHelper.query();
        adapter = new ContactsAdapter(this, list);
        listView.setAdapter(adapter);
    }
    //当页面重新启动时
    @Override
    protected void onRestart() {
        super.onRestart();
        showQueryData();
    }

}