package com.tipchou.googlearchitecturecomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

/**
 * Created by 邵励治 on 2018/3/28.
 * Perfect Code
 */
class UserInfoViewModel : ViewModel() {
    private var userId: String? = null
    private var user: LiveData<User>? = null

    fun init(userId: String) {
        this.userId = userId
    }

    fun getUser() = user
}
