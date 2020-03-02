package markmo.minecloud;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 123 on 2018/5/12.
 */
public class MyAdapter extends BaseAdapter {
    private Context context ;
    private List<mine> list;
    public MyAdapter(Context context, List<mine> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_view, null);//实例化一个布局文件
            viewHolder = new ViewHolder();
            viewHolder.tv_tunnelpressure = (TextView)convertView.findViewById(R.id.tv_tunnelpressure);
            viewHolder.tv_rockpressure = (TextView)convertView.findViewById(R.id.tv_rockpressure);
            viewHolder.tv_gas = (TextView)convertView.findViewById(R.id.tv_gas);
            viewHolder.tv_anchor = (TextView)convertView.findViewById(R.id.tv_anchor);
            viewHolder.tv_time = (TextView)convertView.findViewById(R.id.tv_time);
            viewHolder.tv_location = (TextView)convertView.findViewById(R.id.tv_location);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv_tunnelpressure.setText(list.get(position).getEri());
        viewHolder.tv_rockpressure.setText(list.get(position).getErp());
        viewHolder.tv_gas.setText(list.get(position).getDcq());
        viewHolder.tv_anchor.setText(list.get(position).getGc());
        viewHolder.tv_time.setText(list.get(position).getCreatedAt());
        viewHolder.tv_location.setText(list.get(position).getLocation());
        return convertView;
    }
    class ViewHolder{
        TextView tv_tunnelpressure;
        TextView tv_rockpressure;
        TextView tv_gas;
        TextView tv_anchor;
        TextView tv_time;
        TextView tv_location;
    }
}


