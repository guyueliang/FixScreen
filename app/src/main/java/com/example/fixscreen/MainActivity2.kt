package com.example.fixscreen

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.interfaces.OnPermissionResult
import com.lzf.easyfloat.permission.PermissionUtils
import com.lzf.easyfloat.utils.DisplayUtils

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!PermissionUtils.checkPermission(this)){
            requestPermission();
        }
        val seekbar = findViewById<SeekBar>(R.id.seekBar)
//        val divider = findViewById<View>(R.id.divider)




        EasyFloat.with(this).setLayout(R.layout.item_floating)
            .setTag("fixScreen")
            .setShowPattern(ShowPattern.ALL_TIME)
            .setMatchParent(widthMatch = false,heightMatch = true)
            .setImmersionStatusBar(true)
            .show()

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//
                Log.d("debug","value=$progress")
                val floatView = EasyFloat.getFloatView("fixScreen")
                val divider = floatView?.findViewById<View>(R.id.divider)
                if (divider != null) {
                    val layoutparams = divider.layoutParams
                    layoutparams.width = progress
                    divider.layoutParams = layoutparams
                }

//                var posx = (floatView?.x)?.toInt()
//                var posy = (floatView?.y)?.toInt();
//                var width = floatView?.width
//                var  height = floatView?.height
//                if (posx != null) {
//                    if (posy != null) {
//                        if (width != null) {
//                            if (height != null) {
//                                EasyFloat.updateFloat("fixScreen", x = posx, y = posy,width = width, height = height)
//                            }
//                        }
//                    }
//                }

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
//
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
//
            }
        })

    }
    /**
     * 主动申请浮窗权限
     */
    private fun requestPermission() {
        PermissionUtils.requestPermission(this, object : OnPermissionResult {
            override fun permissionResult(isOpen: Boolean) {
                Log.d("debug", "isOpened:$isOpen");
            }
        })
    }
}