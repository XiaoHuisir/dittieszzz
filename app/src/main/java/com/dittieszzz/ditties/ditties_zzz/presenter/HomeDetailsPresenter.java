package com.dittieszzz.ditties.ditties_zzz.presenter;

import com.dittieszzz.ditties.ditties_zzz.app.Constant;
import com.dittieszzz.ditties.ditties_zzz.base.BasePresenter;
import com.dittieszzz.ditties.ditties_zzz.bean.HomeBean;
import com.dittieszzz.ditties.ditties_zzz.bean.HomeDetailsBean;
import com.dittieszzz.ditties.ditties_zzz.interfaces.contract.HomeDettailsConstract;
import com.dittieszzz.ditties.ditties_zzz.utils.CommonSubscriber;
import com.dittieszzz.ditties.ditties_zzz.utils.HttpUtils;
import com.dittieszzz.ditties.ditties_zzz.utils.RxUtils;

public class HomeDetailsPresenter extends BasePresenter<HomeDettailsConstract.View> implements HomeDettailsConstract.Presenter {
    @Override
    public void homeDetailsRean(String id) {
        addSubscribe(HttpUtils.getMyServer(Constant.BaseUrl).homedetailsApi(id)
                .compose(RxUtils.<HomeDetailsBean>rxScheduler())
                .subscribeWith(new CommonSubscriber<HomeDetailsBean>(mView) {
                    @Override
                    public void onNext(HomeDetailsBean homeDetailsBean) {
                        if (homeDetailsBean != null) {
                            if (mView != null) {
                                mView.homedettails(homeDetailsBean);
                            }
                        }
                    }
                }));

    }

}
