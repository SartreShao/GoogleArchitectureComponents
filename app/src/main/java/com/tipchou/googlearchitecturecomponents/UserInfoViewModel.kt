package com.tipchou.googlearchitecturecomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import javax.inject.Inject

/**
 * Created by 邵励治 on 2018/3/28.
 * Perfect Code
 */
class UserInfoViewModel : ViewModel() {
    @Inject
    lateinit var userRepository: UserRepository

    init {
        DaggerMagicBox.create().poke(this)
    }

    private var user: LiveData<User>? = null

    fun init(userId: String) {
        if (user != null) return
        user = userRepository.getUser(userId)
    }

    fun getUser() = user
}
