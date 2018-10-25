package com.desarrollodroide.mvpsamplekotlinforandroid.ui

import com.desarrollodroide.mvpsamplekotlinforandroid.model.Data
import com.desarrollodroide.mvpsamplekotlinforandroid.mvp.base.BaseMvpPresenterImpl
import com.desarrollodroide.mvpsamplekotlinforandroid.network.ApiClient

class MainActivityPresenter : BaseMvpPresenterImpl<MainActivityContract.View>(), MainActivityContract.Presenter {

    override fun getData() {
        mView?.showLoading()
        ApiClient.getDataFromServer(object : ApiClient.DataLoadListener {
            override fun onSuccessResponse(data: List<Data>) {
                mView?.hideLoading()
                mView?.dataLoadedSuccess(data)
            }

            override fun onErrorResponse() {
                mView?.hideLoading()
                mView?.dataLoadedError()
            }
        })
    }
}