package com.desarrollodroide.mvpsamplekotlinforandroid.ui

import com.desarrollodroide.mvpsamplekotlinforandroid.model.Data
import com.desarrollodroide.mvpsamplekotlinforandroid.mvp.base.BaseMvpPresenter
import com.desarrollodroide.mvpsamplekotlinforandroid.mvp.base.BaseMvpView

object MainActivityContract {

    interface View : BaseMvpView {
         fun dataLoadedSuccess(data: List<Data>)
         fun dataLoadedError()
    }

    interface Presenter : BaseMvpPresenter<View> {
         fun getData()
    }
}