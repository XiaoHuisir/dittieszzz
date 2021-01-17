package com.dittieszzz.ditties.ditties_zzz.ui;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.adpter.MyViewPagerAdapter;
import com.dittieszzz.ditties.ditties_zzz.base.BaseActivity;
import com.dittieszzz.ditties.ditties_zzz.bean.HomeDetailsBean;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.interfaces.contract.HomeDettailsConstract;
import com.dittieszzz.ditties.ditties_zzz.presenter.HomeDetailsPresenter;
import com.dittieszzz.ditties.ditties_zzz.ui.fragment.AuthorFragment;
import com.dittieszzz.ditties.ditties_zzz.ui.fragment.NoteFragment;
import com.dittieszzz.ditties.ditties_zzz.ui.fragment.TextFragment;
import com.dittieszzz.ditties.ditties_zzz.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

//detailPoems
public class HomeDetailsActivity extends BaseActivity implements HomeDettailsConstract.View, TabLayout.BaseOnTabSelectedListener {

    @BindView(R.id.im_break)
    ImageView imBreak;
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.img_heart)
    ImageView imgHeart;
    @BindView(R.id.vp)
    ViewPager vp;
    private String home_id;
    //TabLayout标签
    private String[] typename = new String[]{"注解", "正文", "作者"};
    private List<Fragment> fragments = new ArrayList<>();
    private MyViewPagerAdapter viewPagerAdapter;
    private NoteFragment noteFragment;
    private AuthorFragment authorFragment;
    private TextFragment textFragment;

    @Override
    protected IBasePresenter getPresenter() {
        return new HomeDetailsPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.home_details_actvity;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        home_id = intent.getStringExtra("home_id");
        //设置TabLayout标签的显示方式
        tab.setTabMode(TabLayout.FOCUSABLES_TOUCH_MODE);
        //循环注入标签
        for (String tabs : typename) {
            tab.addTab(tab.newTab().setText(tabs));
        }
        //设置TabLayout点击事件
        tab.setOnTabSelectedListener(this);
        tab.setSelected(true);
        noteFragment = new NoteFragment();
        authorFragment = new AuthorFragment();
        textFragment = new TextFragment();
        fragments.add(noteFragment);
        fragments.add(textFragment);
        fragments.add(authorFragment);
        viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), typename, fragments);
        vp.setAdapter(viewPagerAdapter);
        tab.setupWithViewPager(vp);

    }
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // 获取 tab 组件
        View view = tab.getCustomView();
        if (null != view && view instanceof TextView) {
            // 改变 tab 选择状态下的字体大小
            ((TextView) view).setTextSize(40);
            // 改变 tab 选择状态下的字体颜色
            ((TextView) view).setTextColor(ContextCompat.getColor(context, R.color.huang_se));
        }
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
        View view = tab.getCustomView();
        if (null != view && view instanceof TextView) {
            // 改变 tab 未选择状态下的字体大小
            ((TextView) view).setTextSize(18);
            // 改变 tab 未选择状态下的字体颜色
            ((TextView) view).setTextColor(ContextCompat.getColor(context, R.color.zxing_viewfinder_mask));
        }

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
    @Override
    protected void initData() {
        ((HomeDetailsPresenter) mPresenter).homeDetailsRean(home_id);
    }

    @Override
    public void homedettails(HomeDetailsBean homeDetailsBean) {
        if (homeDetailsBean != null) {
            String lifetime = homeDetailsBean.getAuthor().getLifetime();//作者
            String notes = homeDetailsBean.getPoems().getNotes();//注解
            HomeDetailsBean.PoemsBean poems = homeDetailsBean.getPoems();
            String content = poems.getContent();//正文
            int authorCount = homeDetailsBean.getAuthorCount();
            String name = poems.getName();
            String dynasty = poems.getDynasty();
            String author = poems.getAuthor();
            if (content != null && name != null && dynasty != null && author != null) {
                SPUtils.put(context, "content", content);
                SPUtils.put(context, "dynasty", dynasty);
                SPUtils.put(context, "name", name);
                SPUtils.put(context, "author", author);
            }
            if (lifetime != null) {
                SPUtils.put(context, "lifetime", lifetime);
                SPUtils.put(context, "authorCount", authorCount);
            }
            if (notes != null) {
                SPUtils.put(context, "notes", notes);

            }
        }
    }


    @OnClick({R.id.im_break, R.id.img_heart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.im_break:
                finish();
                break;
            case R.id.img_heart:
                break;
        }
    }




}
