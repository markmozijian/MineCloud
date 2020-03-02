package markmo.minecloud;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.github.mikephil.charting.data.Entry;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayerStandard;

public class VideoActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {
    private ListView lvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        lvv = (ListView) this.findViewById(R.id.list_vi);
        BmobQuery<mine> bmobQueryvideo = new BmobQuery<mine>();
        //按照时间降序
        bmobQueryvideo.order("-createdAt");
        //返回100条数据，如果不加上这条语句，默认返回10条数据
        bmobQueryvideo.setLimit(100);
        bmobQueryvideo.findObjects(new FindListener<mine>() {  //按行查询，查到的数据放到List<mine>的集合
            @Override
            public void done(List<mine> list2, BmobException e) {
                if (e == null) {

                    VideoAdapter adapter2 = new VideoAdapter(VideoActivity.this, list2);
                    lvv.setAdapter(adapter2);


                }

            }
        });


     lvv.setOnItemClickListener(VideoActivity.this);


    }
   @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        String time1 = (String) ((TextView) view.findViewById(R.id.tv_time1)).getText();
       String number = (String) ((TextView) view.findViewById(R.id.tv_nu)).getText();
        SharedPreferences sp = VideoActivity.this.getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("time1", time1);
       editor.putString("number", number);
        editor.commit();
        Intent intent = new Intent(VideoActivity.this, PlayActivity.class);
        startActivity(intent);
        finish();

    }

    public void backvideo(View view){
        startActivity(new Intent(VideoActivity.this, MainOneActivity.class));

    }

}
