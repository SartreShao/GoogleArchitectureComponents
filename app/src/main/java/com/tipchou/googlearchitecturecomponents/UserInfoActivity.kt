package com.tipchou.googlearchitecturecomponents

import android.os.Bundle
import android.support.v4.app.FragmentTransaction
import com.tipchou.googlearchitecturecomponents.base.BaseActivity

class UserInfoActivity : BaseActivity() {
    override fun created(bundle: Bundle?) {
        setUpFragment()
    }

    override fun resume() {}

    override fun layoutId(): Int = R.layout.activity_user_info

    private fun setUpFragment() {
        if (supportFragmentManager.findFragmentById(R.id.user_info_act_framelayout) == null) {
            val fragmentTransaction: FragmentTransaction? = supportFragmentManager.beginTransaction()
            val fragment = UserInfoFragment.newInstance("1")
            fragmentTransaction?.add(R.id.user_info_act_framelayout, fragment)
            fragmentTransaction?.commit()
        }
    }
}
