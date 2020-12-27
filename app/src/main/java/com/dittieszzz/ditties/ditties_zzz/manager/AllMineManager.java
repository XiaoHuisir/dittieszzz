package com.dittieszzz.ditties.ditties_zzz.manager;

import android.content.Context;

import com.dittieszzz.ditties.ditties_zzz.app.MyApp;

public class AllMineManager  implements IPMineManager{
    public AllMineManager(MyApp mApp) {

    }

    @Override
    public int type(Context context,int type) {
        return type;
    }
}
