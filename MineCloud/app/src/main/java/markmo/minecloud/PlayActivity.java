package markmo.minecloud;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class PlayActivity extends AppCompatActivity {
    String time1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        SharedPreferences sp = getSharedPreferences("data", MODE_PRIVATE);
        time1 = sp.getString("time1", "");//第一个参数为默认值
       String number = sp.getString("number", "");//第二个参数为默认值
        BmobQuery<mine> queryvideo = new BmobQuery<mine>();
//查询playerName叫“比目”的数据
        queryvideo.setLimit(100);
        queryvideo.addWhereEqualTo("number", number);

//执行查询方法
        queryvideo.findObjects(new FindListener<mine>() {
            @Override
            public void done(List<mine> object, BmobException e) {
                if (e == null) {

                    for (mine list3 : object) {

                        JCVideoPlayerStandard jcVideoPlayerStandard = (JCVideoPlayerStandard) findViewById(R.id.videoplayer);
                        jcVideoPlayerStandard.setUp(list3.getVideo().getFileUrl(), JCVideoPlayerStandard.SCREEN_LAYOUT_NORMAL, time1);
                    }
                }
            }
        });












    }



    public void backlist(View view){
        startActivity(new Intent(PlayActivity.this, VideoActivity.class));

    }

    @Override
    public void onBackPressed() {
        if (JCVideoPlayer.backPress()){
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }
}
