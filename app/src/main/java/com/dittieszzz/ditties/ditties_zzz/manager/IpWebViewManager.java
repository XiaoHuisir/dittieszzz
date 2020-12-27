package com.dittieszzz.ditties.ditties_zzz.manager;

import android.content.Context;
import android.webkit.WebView;
import android.widget.ProgressBar;

public interface IpWebViewManager {
    void webstart(Context context, ProgressBar progressBar, WebView webView, String path);
    void webstop(Context context,WebView webView);
}
