package com.example.fixscreen

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.CompoundButton
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.materialswitch.MaterialSwitch
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.interfaces.OnPermissionResult
import com.lzf.easyfloat.permission.PermissionUtils
import com.lzf.easyfloat.utils.DisplayUtils

class MainActivity2 : AppCompatActivity() {
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var  switch:Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("debug","onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(!PermissionUtils.checkPermission(this)){
            requestPermission();
        }
        val seekbar = findViewById<SeekBar>(R.id.seekBar)
//        val divider = findViewById<View>(R.id.divider)
        switch = findViewById<Switch>(R.id.switch2)


        EasyFloat.with(this).setLayout(R.layout.item_floating)
            .setTag("fixScreen")
            .setShowPattern(ShowPattern.ALL_TIME)
            .setLocation(100,200)
            .setMatchParent(widthMatch = false,heightMatch = true)
            .setLayoutChangedGravity(Gravity.CENTER_HORIZONTAL)
            .setImmersionStatusBar(true)
            .show()

        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//
//                Log.d("debug","value=$progress")
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
        switch.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.d("debug","test")
                if(switch.isChecked){
                    Log.d("debug","can't drag")
//                   Toast.makeText(, "checked", Toast.LENGTH_SHORT).show()
                    EasyFloat.dragEnable(false,"fixScreen")
                }else{

//                   Toast.makeText(this, "unChecked", Toast.LENGTH_SHORT).show()
                    Log.d("debug","can drag")
                    EasyFloat.dragEnable(true,"fixScreen")
                }
            }

        })


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        EasyFloat.updateFloat("fixScreen",DisplayUtils.getScreenWidth(this)/2,0)
        // Checks the orientation of the screen
        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("debug","onDestroy")
//        EasyFloat.dismiss("fixScreen")
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