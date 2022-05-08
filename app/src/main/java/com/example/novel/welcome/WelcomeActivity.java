package com.example.novel.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.novel.MainActivity;
import com.example.novel.R;

public class WelcomeActivity extends AppCompatActivity {
    /***
     * 欢迎界面
     */
    Handler handler =new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               Intent intent = new Intent();
               intent.setClass(WelcomeActivity.this, MainActivity.class);
               startActivity(intent);
               //界面切换动画可以使用这个方法
                //overridePendingTransition();
               finish();
            }
        },3000);
    }
}