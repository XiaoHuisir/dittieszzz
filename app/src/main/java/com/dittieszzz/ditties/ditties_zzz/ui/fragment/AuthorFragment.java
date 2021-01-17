package com.dittieszzz.ditties.ditties_zzz.ui.fragment;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.base.BaseFragment;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.utils.SPUtils;

import butterknife.BindView;

public class AuthorFragment extends BaseFragment {
    @BindView(R.id.tvauthor)
    TextView tvauthor;
    @BindView(R.id.tv_always)
    TextView tvAlways;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_author;
    }

    @Override
    protected void initData() {
        super.initData();
    }

    @Override
    protected void initView() {
//         SPUtils.put(context,"lifetime",lifetime);
//                SPUtils.put(context,"authorCount",authorCount);
        String lifetime = (String) SPUtils.get(context, "lifetime", "");
        final int authorCount = (int) SPUtils.get(context, "authorCount", 0);
        tvauthor.setText(lifetime);
        tvAlways.setText("共收录了"+authorCount+"篇诗文>>");
        tvAlways.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"共收录了:"+authorCount,Toast.LENGTH_SHORT).show();
            }
        });
    }
}
