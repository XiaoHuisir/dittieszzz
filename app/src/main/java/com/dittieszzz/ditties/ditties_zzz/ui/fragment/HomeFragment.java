package com.dittieszzz.ditties.ditties_zzz.ui.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.base.BaseFragment;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.ui.SearchActivity;

import butterknife.BindView;
import butterknife.OnClick;


public class HomeFragment extends BaseFragment {
   @BindView(R.id.relative_search)
    RelativeLayout relativeLayout;
    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home;
    }

    @Override
    protected void initView() {


    }
 @OnClick({ R.id.relative_search})
 public void onViewClicked(View view) {
  switch (view.getId()) {
   case R.id.relative_search:
    Intent intent = new Intent(context, SearchActivity.class);
    startActivity(intent);
    break;

  }
 }
    @Override
    protected void initData() {

    }
}
