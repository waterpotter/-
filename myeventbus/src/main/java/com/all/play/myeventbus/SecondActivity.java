package com.all.play.myeventbus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.all.play.myeventbus.bean.MessageOrg;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by 聪明一只哈 on 2018/4/27.
 * Time: 2018/4/27  14:58
 */

public class SecondActivity extends AppCompatActivity {


    private EditText editText;

    public static void start(Context context) {
        Intent intent = new Intent(context, SecondActivity.class);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

    }


    /**
     * 初始化view
     */
    private void initView() {
        editText = (EditText) findViewById(R.id.et_second);
    }

    public void ClickTwo(View v) {
        String et_get = editText.getText().toString().trim();
        Toast.makeText(SecondActivity.this, "第二个页面", Toast.LENGTH_SHORT).show();
        if (v.getId() == R.id.bt_second) {
            // 发布事件
            EventBus.getDefault().post(new MessageOrg(et_get));
            MainActivity.start(SecondActivity.this);
        }

        //this is a test commit
    }

}
