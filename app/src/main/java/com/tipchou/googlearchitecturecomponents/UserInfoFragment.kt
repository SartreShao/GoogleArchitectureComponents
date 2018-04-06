package com.tipchou.googlearchitecturecomponents

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import com.tipchou.googlearchitecturecomponents.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_user_info.*

/**
 * Created by 邵励治 on 2018/3/28.
 * Perfect Code
 */

class UserInfoFragment : BaseFragment() {

    private var viewModel: UserInfoViewModel? = null

    override fun layoutId(): Int = R.layout.fragment_user_info

    override fun created(bundle: Bundle?) {
        val userId = arguments?.getString(UID_KEY)
        viewModel = ViewModelProviders.of(this).get(UserInfoViewModel().javaClass)
        userId?.let { viewModel?.init(it) }

        viewModel?.getUser()?.observe(this, Observer {
            user_info_fgm_textview.text = it?.userName
        })
    }

    override fun resumed() {
    }

    companion object {
        private const val UID_KEY: String = "uid"
        fun newInstance(userId: String): UserInfoFragment {
            val args = Bundle()
            args.putString(UID_KEY, userId)
            val userInfoFragment = UserInfoFragment()
            userInfoFragment.arguments = args
            return userInfoFragment
        }
    }
}
