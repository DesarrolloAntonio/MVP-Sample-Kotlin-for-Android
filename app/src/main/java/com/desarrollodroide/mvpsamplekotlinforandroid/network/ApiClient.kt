package com.desarrollodroide.mvpsamplekotlinforandroid.network

import android.os.Handler
import com.desarrollodroide.mvpsamplekotlinforandroid.model.Data
import java.util.Timer
import java.util.TimerTask

object ApiClient {

    interface DataLoadListener {
        fun onSuccessResponse(data: List<Data>)
        fun onErrorResponse()
    }

    fun getDataFromServer(listener: DataLoadListener) {
        val handler = Handler()
        val t = Timer()
        t.schedule(object : TimerTask() {
            override fun run() {
                handler.post {
                    val dummyData = (0..99).map { Data("This is a title $it", "This is a subtitle") }
                    listener.onSuccessResponse(dummyData)
                    // If server gives an error, use listener.onErrorResponse();
                }
            }
        }, 2000)
    }
}
