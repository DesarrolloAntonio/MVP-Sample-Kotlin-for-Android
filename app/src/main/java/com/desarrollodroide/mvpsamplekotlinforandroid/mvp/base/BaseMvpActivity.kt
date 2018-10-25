package com.desarrollodroide.mvpsamplekotlinforandroid.mvp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseMvpActivity<in V : BaseMvpView, T : BaseMvpPresenter<V>> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this as V)
    }

    protected abstract var presenter: T

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }
}