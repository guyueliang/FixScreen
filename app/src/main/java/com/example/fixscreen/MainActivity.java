package com.example.fixscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.enums.ShowPattern;

//import com.petterp.floatingx.FloatingX;
//import com.petterp.floatingx.assist.helper.AppHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EasyFloat.with(this).setLayout(R.layout.item_floating)
                .setShowPattern(ShowPattern.ALL_TIME)

                .show();


    }
}