package com.xitong;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.xitong.database.SQLiteHelper;

public class AddStudent extends AppCompatActivity {
    EditText edstunumber;
    EditText edname;
    EditText edsex;
    EditText edzhuanye;
    EditText edphoneNumber;
    Button tijiao;
    SQLiteHelper mSQLiteHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);
        mSQLiteHelper= new SQLiteHelper(this); //创建数据库
        edstunumber = findViewById(R.id.edt_stuNumber);
        edname = findViewById(R.id.edt_name);
        edsex = findViewById(R.id.edt_sex);
        edzhuanye = findViewById(R.id.edt_zhuanye);
        edphoneNumber = findViewById(R.id.edt_phonenumber);
        tijiao = findViewById(R.id.tijao);

        tijiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                插入数据后返回
                mSQLiteHelper.insertData(
                        edstunumber.getText().toString(),
                        edname.getText().toString(),
                        edsex.getText().toString(),
                        edzhuanye.getText().toString(),
                        edphoneNumber.getText().toString());
                Intent intent = new Intent();
                intent.setClass(AddStudent.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}