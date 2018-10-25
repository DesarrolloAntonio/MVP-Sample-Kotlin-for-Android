package com.desarrollodroide.mvpsamplekotlinforandroid.mvp.base



interface BaseMvpPresenter<in V : BaseMvpView> {

    fun attachView(view: V)
    fun detachView()
}