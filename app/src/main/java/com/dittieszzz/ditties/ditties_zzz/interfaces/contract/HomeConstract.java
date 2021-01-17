package com.dittieszzz.ditties.ditties_zzz.interfaces.contract;

import com.dittieszzz.ditties.ditties_zzz.bean.HomeBean;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBaseView;

public interface HomeConstract {
    interface View extends IBaseView{
        void gethomeretrun(HomeBean homeBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void  gethomeinterface(int pagenum);
    }
}
