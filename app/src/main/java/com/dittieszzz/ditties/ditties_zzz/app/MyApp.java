package com.dittieszzz.ditties.ditties_zzz.app;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.dittieszzz.ditties.ditties_zzz.base.BaseActivity;
import com.dittieszzz.ditties.ditties_zzz.manager.AllMineManager;
import com.dittieszzz.ditties.ditties_zzz.manager.IPMineManager;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;

import me.jessyan.autosize.AutoSize;
import me.jessyan.autosize.AutoSizeConfig;


public class MyApp extends Application {
    public static MyApp mApp;
    private static  AllMineManager allMineManager;
    private static IPMineManager ipMineManager;
    private float width;//设计图屏幕宽度 单位dp
    private Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("MyApplication", "onCreate: ");
        mApp = this;
        context = getApplicationContext();
        //屏幕适配
        AutoSizeConfig.getInstance().setCustomFragment(true);
        AutoSize.initCompatMultiProcess(mApp);
    }

    //static 代码段可以防止内存泄露
    static {

        //设置全局的Header构建器
        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                layout.setPrimaryColorsId(android.R.color.white);//全局设置主题颜色
                return new ClassicsHeader(context);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });
        //设置全局的Footer构建器
        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() {
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                //指定为经典Footer，默认是 BallPulseFooter
                return new ClassicsFooter(context).setDrawableSize(20);
            }
        });

    }
    public static IPMineManager getIpMineManager(){
        if (allMineManager==null){

                if (allMineManager==null){
            allMineManager=new AllMineManager(mApp);


            }
        }
        return allMineManager;
    }
}
