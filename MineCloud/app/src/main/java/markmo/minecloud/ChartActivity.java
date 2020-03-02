package markmo.minecloud;



import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListListener;

public class ChartActivity extends AppCompatActivity {
    List<Entry> entries = new ArrayList<>();
    List<Entry> entries2 = new ArrayList<>();
    List<Entry> entries3 = new ArrayList<>();
    List<Entry> entries4 = new ArrayList<>();
    private Button but1;
    private Button but2;
    private Button but3;
    private Button but4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);



        but1=(Button)findViewById(R.id.btn_chart1);
        but2=(Button)findViewById(R.id.btn_chart2);
        but3=(Button)findViewById(R.id.btn_chart3);
        but4=(Button)findViewById(R.id.btn_chart4);

        BmobQuery<mine> bmobQuerChart = new BmobQuery<>();
        //按照时间降序
        bmobQuerChart.order("createdAt");
        //返回100条数据，如果不加上这条语句，默认返回10条数据
        bmobQuerChart.setLimit(100);
        bmobQuerChart.findObjects(new FindListener<mine>() {
            @Override

            public void done(List<mine> object2, BmobException e) {

                if (e == null) {
                    int i = 0;
                    for (mine mines : object2) {

                        entries.add(new Entry(i, Float.parseFloat(mines.getEri())));
                        entries2.add(new Entry(i, Float.parseFloat(mines.getErp())));
                        entries3.add(new Entry(i, Float.parseFloat(mines.getDcq())));
                        entries4.add(new Entry(i, Float.parseFloat(mines.getGc())));
                        i++;

                    }
//


                }
            }
        });





    }
    public void chart1(View view){

        LineChart chart1 = (LineChart) findViewById(R.id.chart1);
        //显示边界
        chart1.setDrawBorders(true);
        //设置数据
        //一个LineDataSet就是一条线
        XAxis xAxis = chart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        Description description = new Description();
        description.setText("电磁辐射强度E/mV");
        description.setTextColor(Color.RED);
        chart1.setDescription(description);

        LineDataSet lineDataSet = new LineDataSet(entries, "电磁辐射强度");
        LineData dat = new LineData(lineDataSet);
        chart1.setData(dat);
        but1.setBackgroundResource(R.drawable.style3_btn);
        but2.setBackgroundResource(R.drawable.style2_btn);
        but3.setBackgroundResource(R.drawable.style2_btn);
        but4.setBackgroundResource(R.drawable.style2_btn);
    }

    public void chart2(View view){

        LineChart chart1 = (LineChart) findViewById(R.id.chart1);
        //显示边界
        chart1.setDrawBorders(true);
        //设置数据
        //一个LineDataSet就是一条线
        XAxis xAxis = chart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        Description description = new Description();
        description.setText("电磁辐射脉冲数N/个");
        description.setTextColor(Color.RED);
        chart1.setDescription(description);

        LineDataSet lineDataSet = new LineDataSet(entries2, "电磁辐射脉冲数");
        LineData dat = new LineData(lineDataSet);
        chart1.setData(dat);
        but1.setBackgroundResource(R.drawable.style2_btn);
        but2.setBackgroundResource(R.drawable.style3_btn);
        but3.setBackgroundResource(R.drawable.style2_btn);
        but4.setBackgroundResource(R.drawable.style2_btn);
    }
    public void chart3(View view){

        LineChart chart1 = (LineChart) findViewById(R.id.chart1);
        //显示边界
        chart1.setDrawBorders(true);
        //设置数据
        //一个LineDataSet就是一条线
        XAxis xAxis = chart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        Description description = new Description();
        description.setText("钻屑量S/（kg·m-1）");
        description.setTextColor(Color.RED);
        chart1.setDescription(description);

        LineDataSet lineDataSet = new LineDataSet(entries3, "钻屑量");
        LineData dat = new LineData(lineDataSet);
        chart1.setData(dat);
        but1.setBackgroundResource(R.drawable.style2_btn);
        but2.setBackgroundResource(R.drawable.style2_btn);
        but3.setBackgroundResource(R.drawable.style3_btn);
        but4.setBackgroundResource(R.drawable.style2_btn);
    }
    public void chart4(View view){

        LineChart chart1 = (LineChart) findViewById(R.id.chart1);
        //显示边界
        chart1.setDrawBorders(true);
        //设置数据
        //一个LineDataSet就是一条线
        XAxis xAxis = chart1.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        Description description = new Description();
        description.setText("瓦斯浓度C/0.1%");
        description.setTextColor(Color.RED);
        chart1.setDescription(description);

        LineDataSet lineDataSet = new LineDataSet(entries4, "瓦斯浓度");
        LineData dat = new LineData(lineDataSet);
        chart1.setData(dat);
        but1.setBackgroundResource(R.drawable.style2_btn);
        but2.setBackgroundResource(R.drawable.style2_btn);
        but3.setBackgroundResource(R.drawable.style2_btn);
        but4.setBackgroundResource(R.drawable.style3_btn);
    }

    public void backchart(View view){
        startActivity(new Intent(ChartActivity.this, MainOneActivity.class));

    }
}


