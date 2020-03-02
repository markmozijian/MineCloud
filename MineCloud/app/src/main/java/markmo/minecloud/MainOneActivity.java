package markmo.minecloud;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobRealTimeData;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.BmobQuery;

import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.ValueEventListener;

public class MainOneActivity extends Activity {
    private TextView tunnel;
    private TextView rock;
    private TextView gas;
    private TextView anchor;
    BmobRealTimeData data = new BmobRealTimeData();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);
        tunnel=(TextView)findViewById(R.id.tvtunnel);
        rock=(TextView)findViewById(R.id.tvrock);
        gas=(TextView)findViewById(R.id.tvgas);
        anchor=(TextView)findViewById(R.id.tvanchor);
        initdata();

        }


    public void back(View view){

        Intent intent1 = new Intent();
        intent1.setClass(MainOneActivity.this, LoginActivity.class);
        MainOneActivity.this.startActivity(intent1);
    }

    //* 查询数据


   /* public void queryData(View view) {
        BmobQuery<mine> query = new BmobQuery<mine>();
        query.getObject("dDW8111p", new QueryListener<mine>() {
            @Override
            public void done(mine mine, BmobException e) {
                if (e==null){show(mine.toString());}
            }
        });

    }*/
    public void queryData(View view){
    BmobQuery<mine> query = new BmobQuery<>();
//查询playerName叫“比目”的数据

//返回50条数据，如果不加上这条语句，默认返回10条数据
    query.setLimit(100);
//执行查询方法
    query.findObjects(new FindListener<mine>() {
        @Override
        public void done(List<mine> object, BmobException e) {

            if (e == null) {
                Toast.makeText(MainOneActivity.this, "查询成功：共" + object.size() + "条数据。", Toast.LENGTH_LONG).show();

                for (mine mine : object) {


                    if(mine.getEri().compareTo("22")<0){tunnel.setText(mine.getEri());tunnel.setTextColor(Color.BLACK);}
                    if(mine.getEri().compareTo("22")>=0){tunnel.setText(mine.getEri());tunnel.setTextColor(Color.RED);}

                    if(mine.getErp().compareTo("13")<0){rock.setText(mine.getErp());rock.setTextColor(Color.BLACK);}
                    if(mine.getErp().compareTo("13")>=0){rock.setText(mine.getErp());rock.setTextColor(Color.RED);}

                    if(mine.getDcq().compareTo("06")<0){gas.setText(mine.getDcq());gas.setTextColor(Color.BLACK);}
                        if(mine.getDcq().compareTo("06")>=0){gas.setText(mine.getDcq());gas.setTextColor(Color.RED);}

                    if(mine.getGc().compareTo("10")<0){anchor.setText(mine.getGc());anchor.setTextColor(Color.BLACK);}
                    if(mine.getGc().compareTo("10")>=0){anchor.setText(mine.getGc());anchor.setTextColor(Color.RED);}


                }

            } else {
                Log.i("bmob", "失败：" + e.getMessage() + "," + e.getErrorCode());
            }
        }
    });}

    public void moredetail(View view){
startActivity(new Intent(MainOneActivity.this, MoredetailActivity.class));

    }


    public void chart(View view){
        startActivity(new Intent(MainOneActivity.this, ChartActivity.class));

    }

    public void video(View view){
        startActivity(new Intent(MainOneActivity.this, VideoActivity.class));

    }



    public void initdata(){


        this.data.start(new ValueEventListener() {


            @Override
            public void onConnectCompleted(Exception e) {
                if (data.isConnected()) {
                    //设置监听的表名
                    data.subTableUpdate("mine");
                    Log.d("test", "链接成功");
                }
            }

            @Override
            public void onDataChange(JSONObject jsonObject) {

                if (BmobRealTimeData.ACTION_UPDATETABLE.equals(jsonObject.optString("action"))) {

                    Log.d("test", "(" + jsonObject.optString("action") + ")" + "数据：" + data);


                    JSONObject data = jsonObject.optJSONObject("data");

                    mine LocalInfo = new mine(data.optString("eri"), data.optString("erp"), data.optString("dcq"), data.optString("gc"));
                    if (LocalInfo.getEri().compareTo("22")<0) {
                        tunnel.setText(LocalInfo.getEri());
                        tunnel.setTextColor(Color.BLACK);
                    }
                    if (LocalInfo.getEri().compareTo("22")>= 0) {
                        tunnel.setText(LocalInfo.getEri());
                        tunnel.setTextColor(Color.RED);
                    }
                    if (LocalInfo.getErp().compareTo("13") <0) {
                        rock.setText(LocalInfo.getErp());
                        rock.setTextColor(Color.BLACK);
                    }
                    if (LocalInfo.getErp().compareTo("13") >= 0) {
                        rock.setText(LocalInfo.getErp());
                        rock.setTextColor(Color.RED);
                    }
                    if (LocalInfo.getDcq().compareTo("06") <0) {
                        gas.setText(LocalInfo.getDcq());
                        gas.setTextColor(Color.BLACK);
                    }
                    if (LocalInfo.getDcq().compareTo("06") >= 0) {
                        gas.setText(LocalInfo.getDcq());
                        gas.setTextColor(Color.RED);
                    }
                    if (LocalInfo.getGc().compareTo("10") <0) {
                        anchor.setText(LocalInfo.getGc());
                        anchor.setTextColor(Color.BLACK);
                    }
                    if (LocalInfo.getGc().compareTo("10") >= 0) {
                        anchor.setText(LocalInfo.getGc());
                        anchor.setTextColor(Color.RED);
                    }

                    if(LocalInfo.getEri().compareTo("22")<0&&LocalInfo.getErp().compareTo("13") < 0&&LocalInfo.getDcq().compareTo("06") <0&&LocalInfo.getGc().compareTo("10") <0){showsafe();}
                    if(LocalInfo.getEri().compareTo("22")>=0||LocalInfo.getErp().compareTo("13")  >= 0 ||LocalInfo.getDcq().compareTo("06") >= 0||LocalInfo.getGc().compareTo("10")>= 0){notice();showunsafe();}
                }
            }


        });}

    public void notice() {
        //设置获取哪个服务
        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainOneActivity.this);

        builder.setSmallIcon(R.drawable.icon);        //设置图标
        builder.setContentTitle("可能出现危险情况！");                    //设置标题
        builder.setContentText("点击查看详情");                 //消息内容
        builder.setWhen(System.currentTimeMillis());         //发送时间
        builder.setDefaults(Notification.DEFAULT_ALL);      //设置默认的提示音，振动方式，灯光
        builder.setAutoCancel(true);                         //打开程序后图标消失
        builder.setPriority(Notification.PRIORITY_HIGH); //设置该通知优先级
        builder.setVisibility(Notification.VISIBILITY_PUBLIC);//设置通知的显示等级
        //跳转活动
        Intent intent =new Intent (MainOneActivity.this,MainOneActivity.class);
        PendingIntent pi = PendingIntent.getActivities(MainOneActivity.this, 0, new Intent[]{intent}, PendingIntent.FLAG_CANCEL_CURRENT);
        builder.setContentIntent(pi);
        //创建通知栏对象，显示通知信息

       manager.notify(1, builder.build());

    }

public void showsafe(){Toast.makeText(MainOneActivity.this, "云端数据已更新,暂无异常", Toast.LENGTH_LONG).show();}

    public void showunsafe(){Toast.makeText(MainOneActivity.this, "云端数据已更新,可能出现危险情况！", Toast.LENGTH_LONG).show();}


}

