package dong.relativelayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Administrator on 2015/12/11.
 */
public class MyAdapter extends ArrayAdapter<WeChatContents> {
    private int resourceid;
    public MyAdapter(Context context, int resource, List<WeChatContents> objects) {
        super(context, resource, objects);
        resourceid=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        WeChatContents weChatContents=getItem(position);
        View view= LayoutInflater.from(getContext()).inflate(resourceid, null);
        TextView textView=(TextView)view.findViewById(R.id.subtext);
        textView.setText(weChatContents.getContents().toString());
        return view;

    }
}
