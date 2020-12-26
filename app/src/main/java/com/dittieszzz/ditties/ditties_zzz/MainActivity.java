package com.dittieszzz.ditties.ditties_zzz;


import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dittieszzz.ditties.ditties_zzz.base.BaseActivity;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.ui.fragment.ClassifyFragment;
import com.dittieszzz.ditties.ditties_zzz.ui.fragment.HomeFragment;
import com.dittieszzz.ditties.ditties_zzz.ui.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @BindView(R.id.tl)
    TabLayout mTl;
    @BindView(R.id.fl)
    FrameLayout mFl;

    private FragmentManager manager;
    Fragment homeFragment;
    Fragment classifyFragment;
    Fragment mineFragment;
    int curType;
    private int numNot;
    boolean indxler = false;

    private int currentBottomPosition;
    private int targetBottomPosition;

    private List<Fragment> fragmentList = new ArrayList<>();

    private void initFragment() {
        manager = getSupportFragmentManager();
        mTl.addTab(mTl.newTab().setText("首页").setIcon(R.drawable.home));
        mTl.addTab(mTl.newTab().setText("分类").setIcon(R.drawable.classify));
        mTl.addTab(mTl.newTab().setText("我的").setIcon(R.drawable.mine));
        homeFragment = new HomeFragment();
        classifyFragment = new ClassifyFragment();
        mineFragment = new MineFragment();

        fragmentList.add(homeFragment);
        fragmentList.add(classifyFragment);
        fragmentList.add(mineFragment);


    }


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        manager = getSupportFragmentManager();
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        }
        initFragment();
        manager.beginTransaction().add(R.id.fl, fragmentList.get(0)).commit();
        mTl.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                curType = position;
                showFragment(position);


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


    @Override
    protected void initData() {

    }

    private void showFragment(int type) {
        FragmentTransaction fragmentTransaction = manager.beginTransaction();
        switch (type) {
            case 0:
                targetBottomPosition = 0;
                if (currentBottomPosition == 0) {
                    return;
                }
                fragmentTransaction.hide(fragmentList.get(currentBottomPosition));
                if (!fragmentList.get(targetBottomPosition).isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragmentList.get(targetBottomPosition));
                }
                fragmentTransaction.show(fragmentList.get(targetBottomPosition)).commit();
                currentBottomPosition = 0;
                break;
            case 1:
                targetBottomPosition = 1;
                if (currentBottomPosition == 1) {
                    return;
                }
                fragmentTransaction.hide(fragmentList.get(currentBottomPosition));
                if (!fragmentList.get(targetBottomPosition).isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragmentList.get(targetBottomPosition));
                }
                fragmentTransaction.show(fragmentList.get(targetBottomPosition)).commit();
                currentBottomPosition = 1;

                break;
            case 2:
                targetBottomPosition = 2;
                if (currentBottomPosition == 2) {
                    return;
                }
                fragmentTransaction.hide(fragmentList.get(currentBottomPosition));
                if (!fragmentList.get(targetBottomPosition).isAdded()) {
                    fragmentTransaction.add(R.id.fl, fragmentList.get(targetBottomPosition));
                }
                fragmentTransaction.show(fragmentList.get(targetBottomPosition)).commit();
                currentBottomPosition = 2;
                break;
        }
    }




}
