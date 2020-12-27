package com.dittieszzz.ditties.ditties_zzz.app;


import android.os.Environment;

import java.io.File;

/**
 * Created by zhanghui on 20-3-30.
 */
public class Constant {
//    public static final String BaseUrl = "http://192.168.124.6:8080/"; //识缘  （局域网）  TODO  张文端
//        public static final String BaseUrl = "http://192.168.124.7:8080/"; //识缘  （局域网）  TODO  李聪
//    public static final String BaseUrl = "http://api.mb.knowfate.com.cn/shiyuanshop-0.0.1-SNAPSHOT/"; //识缘 （服务器）
//    public static final String BaseUrl = "http://api.mb.knowfate.com.cn:8080/shiyuanshop-0.0.1-SNAPSHOT/"; //new 识缘 （服务器）
    public static final String BaseUrl = "https://api.mb.knowfate.com.cn:8080/"; //new 识缘 （ssl 服务器）


    //    public static final String URl = "http://123.206.58.124:8025/index/user/login";
    public static final String URl = "http://sc.minxj.com/api/";
    //    public static final String BaseUr = "http://123.206.58.124:8025/"; //TODO IW
    public static final String IndexBaseUrl = "http://www.sosoapi.com/pass/mock/";
    public static final String ResUrl = "http://images.ciotimes.com/"; //七牛图片地址

    //网络缓存的地址
    public static final String PATH_DATA = MyApp.mApp.getCacheDir().getAbsolutePath() + File.separator + "data";

    public static final String PATH_CACHE = PATH_DATA + "/cilo";//shiyuan

    public static final String PATH_PDF = MyApp.mApp.getFilesDir().getAbsolutePath() + "/pdfs/";
    public static final String PATH_APK = MyApp.mApp.getFilesDir().getAbsolutePath() + "/apks/";
    public static String DEFAULT_SAVE_IMAGE_PATH = Environment
            .getExternalStorageDirectory()
            + File.separator
            + "com.example.myapplication"
            + File.separator + "user_img" + File.separator;


    public static String token = "";
    public static final int MYCOLLECTION = 110; //我的收藏
    public static final int OFFLINEDOWNLOAD = 111;//离线下载
    public static final int FEEDBACK = 112;//意见反馈
    public static final int BOUTS = 113;//关于我们

}
