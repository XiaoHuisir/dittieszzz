package com.dittieszzz.ditties.ditties_zzz.interfaces;



public interface IBasePresenter<V extends IBaseView> {
    void attchView(V view);
    void detachView();
}
