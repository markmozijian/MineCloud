package markmo.minecloud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 123 on 2018/6/10.
 */
public class VideoAdapter extends BaseAdapter {
    private Context context ;
    private List<mine> list;
    public VideoAdapter(Context context, List<mine> list){
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
            convertView = inflater.inflate(R.layout.list_video, null);//实例化一个布局文件
            viewHolder = new ViewHolder();

            viewHolder.tv_time = (TextView)convertView.findViewById(R.id.tv_time1);
            viewHolder.tv_location = (TextView)convertView.findViewById(R.id.tv_location1);
            viewHolder.tv_number = (TextView)convertView.findViewById(R.id.tv_nu);
            convertView.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tv_time.setText(list.get(position).getCreatedAt());
        viewHolder.tv_location.setText(list.get(position).getLocation());
        viewHolder.tv_number.setText(list.get(position).getNumber());
        viewHolder.tv_number.setTextColor(00000000);
        return convertView;
    }
    class ViewHolder{

        TextView tv_time;
        TextView tv_location;
        TextView tv_number;
    }
}
