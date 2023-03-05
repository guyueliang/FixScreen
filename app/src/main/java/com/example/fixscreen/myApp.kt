package com.example.fixscreen

import android.app.Application
import android.content.res.Configuration
import android.util.Log
import android.view.Gravity
import android.view.View
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern

class myApp : Application() {
    override fun onCreate() {
        super.onCreate()
//        EasyFloat.with(this).setLayout(R.layout.item_floating) {
//
//            it.addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
//                override fun onLayoutChange(
//                    v: View?,
//                    left: Int,
//                    top: Int,
//                    right: Int,
//                    bottom: Int,
//                    oldLeft: Int,
//                    oldTop: Int,
//                    oldRight: Int,
//                    oldBottom: Int
//                ) {
//
//                    val isPortrait =
//                        resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
//                    Log.d("debug"," application isPortrait=$isPortrait")
//                    val divider = it.findViewById<View>(R.id.divider)
//                    if(!isPortrait){
//                        divider.setBackgroundColor(resources.getColor(R.color.white))
//                        divider.visibility = View.VISIBLE
//                        it.visibility = View.VISIBLE
////                            it.setBackgroundColor(resources.getColor(R.color.purple_200))
//                    }else{
////                            it.setBackgroundColor(resources.getColor(R.color.black))
//                        divider.setBackgroundColor(resources.getColor(R.color.black))
//                        divider.visibility = View.INVISIBLE
//                        it.visibility = View.INVISIBLE
//                    }
//                }
//
//            })
//              }
//            .setTag("fixScreen2")
//            .setShowPattern(ShowPattern.ALL_TIME)
//            .setLocation(300, 200)
//            .setMatchParent(widthMatch = false, heightMatch = true)
//            .setLayoutChangedGravity(Gravity.CENTER_HORIZONTAL)
//            .setImmersionStatusBar(true)
//            .show()
    }
}