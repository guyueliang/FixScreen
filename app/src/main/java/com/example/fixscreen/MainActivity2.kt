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
import androidx.appcompat.app.AppCompatActivity
import com.lzf.easyfloat.EasyFloat
import com.lzf.easyfloat.enums.ShowPattern
import com.lzf.easyfloat.interfaces.OnPermissionResult
import com.lzf.easyfloat.permission.PermissionUtils
import com.lzf.easyfloat.utils.DisplayUtils

class MainActivity2 : AppCompatActivity() {
     companion object {
        const val fixScreen1:String = "fixScreen"
        const val fixScreen2:String = "fixScreen2"
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switch1: Switch
    private lateinit var switch2: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("debug", "onCreate()")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!PermissionUtils.checkPermission(this)) {
            requestPermission();
        }
        val seekbar1 = findViewById<SeekBar>(R.id.seekBar1)
//        val divider = findViewById<View>(R.id.divider)
        switch1 = findViewById<Switch>(R.id.switch1)

        val seekBar2 = findViewById<SeekBar>(R.id.seekBar2)
        switch2 = findViewById(R.id.switch2)


        //条纹1只在竖屏下显示
        EasyFloat.with(this)
            .setLayout(R.layout.item_floating) {
                it.addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                    override fun onLayoutChange(
                        v: View?,
                        left: Int,
                        top: Int,
                        right: Int,
                        bottom: Int,
                        oldLeft: Int,
                        oldTop: Int,
                        oldRight: Int,
                        oldBottom: Int
                    ) {
                        //left,right,top,bottom是view自身边界，而不是位置
//                        Log.d("debug","new pos:left=$left,top=$top,right=$right,bottom=$bottom")
//                        Log.d("debug","old pos: oldLeft=$oldLeft,oldTop=$oldTop,oldRight=$oldRight,oldBottom=$oldBottom")

                        var x = DisplayUtils.getScreenSize(applicationContext).x //屏幕宽度
                        var y = DisplayUtils.getScreenSize(applicationContext).y//屏幕高度
                        val divider = it.findViewById<View>(R.id.divider)
                        if(x>y){
                            //横屏
//                            divider.setBackgroundColor(resources.getColor(R.color.black))
                            divider.visibility = View.INVISIBLE

                        }else{
                            //竖屏
//                            divider.setBackgroundColor(resources.getColor(R.color.black))
                            divider.visibility = View.VISIBLE
                        }
                        Log.d("debug","screenSize:x=$x,y=$y")
//                        val floatView = EasyFloat.getFloatView("fixScreen")
//
//                        var posx = (floatView?.x)?.toInt()
//                        var posy = (floatView?.y)?.toInt();
//                        Log.d("debug","view pos:posx=$posx,posy=$posy")
//
//                        val divider = it.findViewById<View>(R.id.divider)
//                        var dposx = divider.x
//                        var dposy = divider.y
//                        Log.d("debug","divider pos:posx=$dposx,posy=$dposy")
                        //下面的方法只能在activity界面内实现
//                        val isPortrait =
//                            resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT
//                        Log.d("debug","isPortrait=$isPortrait")
//                        val divider = it.findViewById<View>(R.id.divider)
//                        if(!isPortrait){
//                            divider.setBackgroundColor(resources.getColor(R.color.purple_200))
////                            divider.visibility = View.VISIBLE
////                            it.visibility = View.VISIBLE
////                            it.setBackgroundColor(resources.getColor(R.color.purple_200))
//                        }else{
////                            it.setBackgroundColor(resources.getColor(R.color.black))
//                            divider.setBackgroundColor(resources.getColor(R.color.black))
////                            divider.visibility = View.INVISIBLE
////                            it.visibility = View.INVISIBLE
//                        }
                    }

                })

            }
            .setTag(fixScreen1)
            .setShowPattern(ShowPattern.ALL_TIME)
            .setLocation(100, 200)
            .setMatchParent(widthMatch = false, heightMatch = true)
            .setLayoutChangedGravity(Gravity.CENTER_HORIZONTAL)
            .setImmersionStatusBar(true)
            .show()



        seekbar1.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
//
//                Log.d("debug","value=$progress")
                val floatView = EasyFloat.getFloatView(fixScreen1)
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
        switch1.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Log.d("debug", "test")
                if (switch1.isChecked) {
                    Log.d("debug", "can't drag")
//                   Toast.makeText(, "checked", Toast.LENGTH_SHORT).show()
                    EasyFloat.dragEnable(false, fixScreen1)
                } else {

//                   Toast.makeText(this, "unChecked", Toast.LENGTH_SHORT).show()
                    Log.d("debug", "can drag")
                    EasyFloat.dragEnable(true, fixScreen1)
                }
            }

        })

        //条纹2只在横屏下显示
        EasyFloat.with(this)
            .setLayout(R.layout.item_floating) {
                it.addOnLayoutChangeListener(object : View.OnLayoutChangeListener{
                    override fun onLayoutChange(
                        v: View?,
                        left: Int,
                        top: Int,
                        right: Int,
                        bottom: Int,
                        oldLeft: Int,
                        oldTop: Int,
                        oldRight: Int,
                        oldBottom: Int
                    ) {
                        var x = DisplayUtils.getScreenSize(applicationContext).x //屏幕宽度
                        var y = DisplayUtils.getScreenSize(applicationContext).y//屏幕高度
                        val divider = it.findViewById<View>(R.id.divider)
                        if(x>y){
                            //横屏
//                            divider.setBackgroundColor(resources.getColor(R.color.purple_200))
                            divider.visibility = View.VISIBLE

                        }else{
                            //竖屏
//                            divider.setBackgroundColor(resources.getColor(R.color.purple_200))
                            divider.visibility = View.INVISIBLE
                        }
                        Log.d("debug","screenSize:x=$x,y=$y")

                    }

                })

            }
            .setTag(fixScreen2)
            .setShowPattern(ShowPattern.ALL_TIME)
            .setLocation(100, 200)
            .setMatchParent(widthMatch = false, heightMatch = true)
            .setLayoutChangedGravity(Gravity.CENTER_HORIZONTAL)
            .setImmersionStatusBar(true)
            .show()

        seekBar2.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val floatView = EasyFloat.getFloatView(fixScreen2)
                val divider = floatView?.findViewById<View>(R.id.divider)
                if (divider != null) {
                    val layoutparams = divider.layoutParams
                    layoutparams.width = progress
                    divider.layoutParams = layoutparams
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
        switch2.setOnCheckedChangeListener(object : CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                if (switch2.isChecked) {
                    Log.d("debug", "can't drag")
//                   Toast.makeText(, "checked", Toast.LENGTH_SHORT).show()
                    EasyFloat.dragEnable(false, fixScreen2)
                } else {

//                   Toast.makeText(this, "unChecked", Toast.LENGTH_SHORT).show()
                    Log.d("debug", "can drag")
                    EasyFloat.dragEnable(true, fixScreen2)
                }
            }

        })


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

//        EasyFloat.updateFloat("fixScreen", DisplayUtils.getScreenWidth(this) / 2, 0)
        // Checks the orientation of the screen
//        if (newConfig.orientation === Configuration.ORIENTATION_LANDSCAPE) {
//            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
//        } else if (newConfig.orientation === Configuration.ORIENTATION_PORTRAIT) {
//            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
//        }
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("debug", "onDestroy")
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