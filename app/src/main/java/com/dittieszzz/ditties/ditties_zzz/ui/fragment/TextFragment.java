package com.dittieszzz.ditties.ditties_zzz.ui.fragment;

import android.widget.TextView;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.base.BaseFragment;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.utils.SPUtils;

import butterknife.BindView;

public class TextFragment extends BaseFragment {

    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_dynasty)
    TextView tv_dynasty;
    @BindView(R.id.tv_author)
    TextView tv_author;
    @BindView(R.id.tv_content)
    TextView tv_content;


    @Override
    protected void initView() {
//            SPUtils.put(context,"content",content);
//                SPUtils.put(context,"dynasty",dynasty);
//                SPUtils.put(context,"name",name);
//                SPUtils.put(context,"author",author);
        String content = (String) SPUtils.get(context, "content", "");
        String name = (String) SPUtils.get(context, "name", "");
        String author = (String) SPUtils.get(context, "author", "");
        String dynasty = (String) SPUtils.get(context, "dynasty", "");
        tv_author.setText(author);
        String s1 = content.replaceAll("。", "。\n").replaceAll(" ", "")
                .replaceAll("？", "？\n");
        String trim = s1.trim();
        tv_content.setText(trim);
        tv_dynasty.setText(dynasty);
        tvName.setText(name);
    }

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_text;
    }
}
