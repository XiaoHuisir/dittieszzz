package com.dittieszzz.ditties.ditties_zzz.adpter;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.base.BaseAdapter;
import com.dittieszzz.ditties.ditties_zzz.bean.HomeBean;
import com.dittieszzz.ditties.ditties_zzz.utils.NoDoubleClickListener;

import java.util.List;

public class HomeIndexAdapter extends BaseAdapter {
    public ClickItem clickItem;

    public HomeIndexAdapter(List<HomeBean.MainPoemsListBean> mDatas) {
        super(mDatas);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.adpater_home_index;
    }

    @Override
    protected void bindData(BaseViewHolder holder, int positon, Object o) {
        TextView tvName = (TextView) holder.getView(R.id.tv_name);
        TextView tvContent = (TextView) holder.getView(R.id.tv_content);
        TextView tvDynasty = (TextView) holder.getView(R.id.tv_dynasty);
        LinearLayout lineInxdle = (LinearLayout) holder.getView(R.id.line_inxdle);
        HomeBean.MainPoemsListBean listBean = (HomeBean.MainPoemsListBean) mDatas.get(positon);
        tvName.setText(listBean.getName());
        String getcontent = listBean.getContent();
        String s1 = getcontent.replaceAll("。", "。\n").replaceAll(" ","");
        String trim = s1.trim();
        tvContent.setText(trim);
        tvDynasty.setText(listBean.getDynasty());
        lineInxdle.setTag(((HomeBean.MainPoemsListBean) mDatas.get(positon)).getId());
        lineInxdle.setOnClickListener(new NoDoubleClickListener() {
            @Override
            protected void onNoDoubleClick(View v) {
                String id = (String) v.getTag();
                clickItem.getclickitem(id);
            }
        });


    }

    public interface ClickItem {
        void getclickitem(String id);
    }

}
