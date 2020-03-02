package markmo.minecloud;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import cn.bmob.sms.BmobSMS;
import cn.bmob.v3.Bmob;

public class StartActivity extends Activity {//StartActivity类头部

    @Override
    protected void onCreate(Bundle savedInstanceState) {//onCreate()方法头部
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Bmob.initialize(this, "6af28bae587a17a0f1d45c79ea423ba7");
        BmobSMS.initialize(this, "6af28bae587a17a0f1d45c79ea423ba7");
        Timer timer=new Timer();//创建Timer对象，用于设置启动界面显示的时间
        //创建TimerTask对象，用于实现启动界面跳转到主界面
        TimerTask timerTask=new TimerTask() {
            @Override
            public void run() {
                //从启动界面跳转到主界面
                startActivity(new Intent(StartActivity.this,LoginActivity.class));
                finish();
            }
        };

        timer.schedule(timerTask,2000);//启动界面显示2s后跳转


    }//onCreate()方法尾部
}//StartActivity类尾部
