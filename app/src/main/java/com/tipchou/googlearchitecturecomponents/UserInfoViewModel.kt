package com.tipchou.googlearchitecturecomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by 邵励治 on 2018/3/28.
 * Perfect Code
 */
class UserInfoViewModel : ViewModel() {
    private var user: LiveData<User>? = null
    private var userRepository: UserRepository? = UserRepository()

    fun init(userId: String) {
        if (user != null) return
        user = userRepository?.getUser(userId)
    }

    fun getUser() = user
}

