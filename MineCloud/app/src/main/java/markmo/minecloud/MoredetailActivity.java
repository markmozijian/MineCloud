package markmo.minecloud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MoredetailActivity extends AppCompatActivity {

    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moredetail);

        lv = (ListView) this.findViewById(R.id.list_detail);
        BmobQuery<mine> bmobQuery = new BmobQuery<mine>();
        //按照时间降序
        bmobQuery.order("-createdAt");
        //返回100条数据，如果不加上这条语句，默认返回10条数据
        bmobQuery.setLimit(100);
        bmobQuery.findObjects(new FindListener<mine>() {  //按行查询，查到的数据放到List<mine>的集合
            @Override
            public void done(List<mine> list, BmobException e) {
                if (e == null) {

                    MyAdapter adapter = new MyAdapter(MoredetailActivity.this,list);
                    lv.setAdapter(adapter);
                }

            }
        });
    }

    public void backdetail(View view){
        startActivity(new Intent(MoredetailActivity.this, MainOneActivity.class));

    }
}
