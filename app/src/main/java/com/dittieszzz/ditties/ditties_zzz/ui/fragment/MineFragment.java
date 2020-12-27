package com.dittieszzz.ditties.ditties_zzz.ui.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.app.Constant;
import com.dittieszzz.ditties.ditties_zzz.base.BaseFragment;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.ui.AllMineActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MineFragment extends BaseFragment {
    @BindView(R.id.tv_myCollection)
    TextView tvMyCollection;
    @BindView(R.id.tv_offlineDownload)
    TextView tvOfflineDownload;
    @BindView(R.id.tv_feedback)
    TextView tvFeedback;
    @BindView(R.id.tv_bouts)
    TextView tvBouts;
    Unbinder unbinder;
    private Intent intent;

    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.mine;
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.tv_myCollection, R.id.tv_offlineDownload, R.id.tv_feedback, R.id.tv_bouts})
    public void onViewClicked(View view) {
        intent = new Intent(context, AllMineActivity.class);
        switch (view.getId()) {
            case R.id.tv_myCollection:
                intent.putExtra("AllMINEACTIVITY", Constant.MYCOLLECTION);
                break;
            case R.id.tv_offlineDownload:
                intent.putExtra("AllMINEACTIVITY",Constant.OFFLINEDOWNLOAD);
                break;
            case R.id.tv_feedback:
                intent.putExtra("AllMINEACTIVITY",Constant.FEEDBACK);
                break;
            case R.id.tv_bouts:
                intent.putExtra("AllMINEACTIVITY",Constant.BOUTS);
                break;
        }
            startActivity(intent);
    }
}
