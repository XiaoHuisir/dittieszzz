package com.dittieszzz.ditties.ditties_zzz.presenter;

import com.dittieszzz.ditties.ditties_zzz.app.Constant;
import com.dittieszzz.ditties.ditties_zzz.base.BasePresenter;
import com.dittieszzz.ditties.ditties_zzz.bean.HomeBean;
import com.dittieszzz.ditties.ditties_zzz.interfaces.IBaseView;
import com.dittieszzz.ditties.ditties_zzz.interfaces.contract.HomeConstract;
import com.dittieszzz.ditties.ditties_zzz.utils.CommonSubscriber;
import com.dittieszzz.ditties.ditties_zzz.utils.HttpUtils;
import com.dittieszzz.ditties.ditties_zzz.utils.RxUtils;

public class HomePresenter extends BasePresenter<HomeConstract.View> implements HomeConstract.Presenter {
    @Override
    public void gethomeinterface(int pagenum) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).homeApi(pagenum)
                .compose(RxUtils.<HomeBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeBean>(mView) {
                    @Override
                    public void onNext(HomeBean homeBean) {
                        if (homeBean != null) {
                            if (mView != null) {
                                mView.gethomeretrun(homeBean);
                            }
                        }
                    }
                }));
    }
}
