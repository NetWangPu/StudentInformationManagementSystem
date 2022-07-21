package com.xitong.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.xitong.Bean.contacts;
import com.xitong.R;

import java.util.List;


public class ContactsAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<contacts> list;
    public ContactsAdapter(Context context, List<contacts> list){
        this.layoutInflater=LayoutInflater.from(context);
        this.list=list;
    }

    @Override
    public int getCount() {
        return list==null ? 0 : list.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.contacts_item_layout,null);
            viewHolder=new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        contacts noteInfo=(contacts) getItem(position);
        viewHolder.tvStuNumber.setText(noteInfo.getStuNumber());
        viewHolder.tvName.setText(noteInfo.getName());
        viewHolder.tvSex.setText(noteInfo.getSex());
        viewHolder.tvZuanYe.setText(noteInfo.getZhuangye());
        viewHolder.tvPhoneNumber.setText(noteInfo.getPhoneNumber());
        return convertView;
    }
    class ViewHolder{
        TextView tvStuNumber;
        TextView tvName;
        TextView tvSex;
        TextView tvZuanYe;
        TextView tvPhoneNumber;
        public ViewHolder(View view){
            tvStuNumber = (TextView) view.findViewById(R.id.item_stuNumber);
            tvName=(TextView) view.findViewById(R.id.item_name);
            tvSex=(TextView) view.findViewById(R.id.item_sex);
            tvZuanYe=(TextView) view.findViewById(R.id.item_zhuanye);
            tvPhoneNumber=(TextView) view.findViewById(R.id.item_phoneNumber);
        }
    }
}
