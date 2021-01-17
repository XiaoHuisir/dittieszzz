package com.dittieszzz.ditties.ditties_zzz.ui.fragment;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.adpter.HomeIndexAdapter;
import com.dittieszzz.ditties.ditties_zzz.base.BaseFragment;
import com.dittieszzz.ditties.ditties_zzz.bean.HomeBean;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.interfaces.contract.HomeConstract;
import com.dittieszzz.ditties.ditties_zzz.presenter.HomePresenter;
import com.dittieszzz.ditties.ditties_zzz.ui.HomeDetailsActivity;
import com.dittieszzz.ditties.ditties_zzz.ui.SearchActivity;
import com.dittieszzz.ditties.ditties_zzz.utils.NetDownResponse;
import com.dittieszzz.ditties.ditties_zzz.utils.NetRequsetUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//toMainIndex
public class HomeFragment extends BaseFragment implements HomeConstract.View, HomeIndexAdapter.ClickItem {
    @BindView(R.id.relative_search)
    RelativeLayout relativeLayout;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swiperefresh;
    @BindView(R.id.svs)
    NestedScrollView sv;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerview;
    int page = 0;
    private ArrayList<HomeBean.MainPoemsListBean> list;
    private HomeIndexAdapter homeindexAdapter;

    @Override
    protected IBasePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home;
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        homeindexAdapter = new HomeIndexAdapter(list);
        homeindexAdapter.clickItem = this;
        recyclerview.setLayoutManager(new LinearLayoutManager(context));
        recyclerview.setAdapter(homeindexAdapter);
        getIndex();
        swiperefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                getIndex();
            }
        });
        sv.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                if (scrollY > oldScrollY) {

                }
                if (scrollY < oldScrollY) {

                }

                if (scrollY == 0) {

                }

                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    page = page + 1;
                    if (page <=14) {
                    getIndex();
                    }else {
                        Toast.makeText(context, "你太努力了！给你推荐就这么多了，你可以在分类里查看更多诗词。", Toast.LENGTH_SHORT).show();
                    }


                }
            }

        });
    }

    private void getIndex() {
        ((HomePresenter) mPresenter).gethomeinterface(page);
    }

    @OnClick({R.id.relative_search})
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

    @Override
    public void gethomeretrun(HomeBean homeBean) {
        List<HomeBean.MainPoemsListBean> mainPoemsList = homeBean.getMainPoemsList();
        if (mainPoemsList != null && mainPoemsList.size() > 0) {
            list.clear();
            list.addAll(mainPoemsList);
            homeindexAdapter.notifyDataSetChanged();
            swiperefresh.setRefreshing(false);
        }
    }

    @Override
    public void getclickitem(String id) {
//     Toast.makeText(context,id,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, HomeDetailsActivity.class);
        intent.putExtra("home_id",id);
        startActivity(intent);
    }
}
