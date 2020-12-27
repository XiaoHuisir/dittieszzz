package com.dittieszzz.ditties.ditties_zzz.ui;


import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.dittieszzz.ditties.ditties_zzz.R;
import com.dittieszzz.ditties.ditties_zzz.app.MyApp;
import com.dittieszzz.ditties.ditties_zzz.base.BaseActivity;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.utils.WebViewUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class AllMineActivity extends BaseActivity {

    @BindView(R.id.line_back)
    LinearLayout lineBack;
    @BindView(R.id.tv_tilte)
    TextView tvTilte;
    @BindView(R.id.relative_show)
    RelativeLayout relativeShow;
    @BindView(R.id.relat1)
    RelativeLayout relat1;
    @BindView(R.id.line_collection)
    LinearLayout lineCollection;
    @BindView(R.id.line_download)
    LinearLayout lineDownload;
    @BindView(R.id.web_feedback)
    WebView webFeedback;
    @BindView(R.id.line_feedback)
    LinearLayout lineFeedback;
    @BindView(R.id.imag_v)
    ImageView imagV;
    @BindView(R.id.tv_v)
    TextView tvV;
    @BindView(R.id.line_bouts)
    RelativeLayout lineBouts;
    @BindView(R.id.txt_User_Agreement)
    TextView txtUserAgreement;
    @BindView(R.id.txt_Areement)
    TextView txtAreement;
    @BindView(R.id.web_progressBar)
    ProgressBar webProgressBar;
    private static final int MYCOLLECTION = 110; //我的收藏
    private static final int OFFLINEDOWNLOAD = 111;//离线下载
    private static final int FEEDBACK = 112;//意见反馈
    private static final int BOUTS = 113;//关于我们
    private  String webpach="http://bc.knowfate.com.cn/aboutus.html";
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MYCOLLECTION:
                    lineCollection.setVisibility(View.VISIBLE);
                    break;
                case OFFLINEDOWNLOAD:
                    lineDownload.setVisibility(View.VISIBLE);
                    break;
                case FEEDBACK:
                    lineFeedback.setVisibility(View.VISIBLE);
                    new WebViewUtils().webstart(context,webProgressBar,webFeedback,webpach);
                    break;
                case BOUTS:
                    lineBouts.setVisibility(View.VISIBLE);
                    break;
            }
        }
    };


    @Override
    protected IBasePresenter getPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_all_mine;
    }

    @Override
    protected void initView() {

        int type = MyApp.getIpMineManager().type(context,getIntent().getIntExtra("AllMINEACTIVITY", 0));
        switch (type) {
            case MYCOLLECTION:
                tvTilte.setText(R.string.mycollection);
                handler.sendEmptyMessage(MYCOLLECTION);
                break;
            case OFFLINEDOWNLOAD:
                tvTilte.setText(R.string.offlinedownload);
                handler.sendEmptyMessage(OFFLINEDOWNLOAD);
                break;
            case FEEDBACK:
                tvTilte.setText(R.string.feedback);
                handler.sendEmptyMessage(FEEDBACK);
                break;
            case BOUTS:
                tvTilte.setText(R.string.bouts);
                handler.sendEmptyMessage(BOUTS);
                break;

        }
    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.line_back, R.id.txt_User_Agreement, R.id.txt_Areement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.line_back:
                finish();
                break;
            case R.id.txt_User_Agreement:
                Toast.makeText(context, "用户协议", Toast.LENGTH_SHORT).show();
                break;
            case R.id.txt_Areement:
                break;
        }
    }
//    onDestroy


    @Override
    protected void onDestroy() {
        new WebViewUtils().webstop(context,webFeedback);
        super.onDestroy();
    }
}
