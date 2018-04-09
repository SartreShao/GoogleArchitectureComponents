package com.tipchou.googlearchitecturecomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.avos.avoscloud.AVException
import com.tipchou.googlearchitecturecomponents.backend.Callback
import com.tipchou.googlearchitecturecomponents.backend.WebDao
import com.tipchou.googlearchitecturecomponents.backend.table.UsersTable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by 邵励治 on 2018/4/6.
 * Perfect Code
 */
@Singleton
class UserRepository @Inject constructor() {

    @Inject
    lateinit var webDao: WebDao

    init {
        DaggerMagicBox.builder().build().poke(this)
    }

    fun getUser(userId: String): LiveData<User> {
        val data: MutableLiveData<User> = MutableLiveData()
        webDao.getUser(userId, object : Callback<UsersTable> {
            override fun success(response: List<UsersTable>) {
                if (!response.isEmpty()) {
                    data.value = response[0].userName?.let { response[0].userId?.let { it1 -> User(it1, it) } }
                }
            }

            override fun failure(e: AVException?) {
            }
        })
        return data
    }
}
