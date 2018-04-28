package com.all.play.myeventbus;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.all.play.myeventbus.bean.MessageOrg;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);

    }

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

        initView();


    }

    private void initView() {
        textView = (TextView) findViewById(R.id.textView);
    }


    public void OnClick(View v){

        Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
        if (v.getId() == R.id.bt) {
            SecondActivity.start(this);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageOrg event) {
        Log.i("test_log", "message is " + event.getMessage());
        // 更新界面
        textView.setText(event.getMessage());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
