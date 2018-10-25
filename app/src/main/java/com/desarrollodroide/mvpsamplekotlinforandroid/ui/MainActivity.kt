package com.desarrollodroide.mvpsamplekotlinforandroid.ui

import android.app.ProgressDialog
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.desarrollodroide.mvpsamplekotlinforandroid.R
import com.desarrollodroide.mvpsamplekotlinforandroid.adapter.MyAdapter
import com.desarrollodroide.mvpsamplekotlinforandroid.model.Data
import com.desarrollodroide.mvpsamplekotlinforandroid.mvp.base.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMvpActivity<MainActivityContract.View, MainActivityContract.Presenter>(), MainActivityContract.View {

    override var presenter: MainActivityContract.Presenter = MainActivityPresenter()
    private lateinit var progress: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progress = ProgressDialog.show(this, "", "Please...wait", true)
        presenter.getData()
    }

    /**************
     *   MVP      *
     **************/

    override fun dataLoadedSuccess(data: List<Data>) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = MyAdapter(data)
    }

    override fun dataLoadedError() {
        // Show error
    }

    override fun showLoading() { progress.show() }

    override fun hideLoading() { progress.hide() }
}
