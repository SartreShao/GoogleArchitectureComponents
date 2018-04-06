package com.tipchou.googlearchitecturecomponents.base

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager

/**
 * Created by 邵励治 on 2018/3/26.
 * Perfect Code
 */
abstract class BaseActivity : AppCompatActivity() {
    @LayoutRes
    protected abstract fun layoutId(): Int

    protected abstract fun created(bundle: Bundle?)

    protected abstract fun resume()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(layoutId())
        supportActionBar?.hide()
//        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        created(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        resume()
    }
}