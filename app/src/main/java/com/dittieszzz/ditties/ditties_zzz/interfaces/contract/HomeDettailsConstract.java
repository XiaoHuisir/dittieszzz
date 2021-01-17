package com.dittieszzz.ditties.ditties_zzz.interfaces.contract;

import com.dittieszzz.ditties.ditties_zzz.bean.HomeDetailsBean;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBasePresenter;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBaseView;

public interface HomeDettailsConstract {
    interface View extends IBaseView{
        void  homedettails(HomeDetailsBean homeDetailsBean);

    }
    interface Presenter extends IBasePresenter<View>{
        void  homeDetailsRean(String id);
    }
}
