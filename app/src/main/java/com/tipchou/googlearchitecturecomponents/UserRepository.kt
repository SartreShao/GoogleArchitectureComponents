package com.tipchou.googlearchitecturecomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.avos.avoscloud.*

/**
 * Created by 邵励治 on 2018/4/6.
 * Perfect Code
 */
class UserRepository {
    fun getUser(userId: String): LiveData<User> {
        val data: MutableLiveData<User> = MutableLiveData()
        val query = AVQuery<AVObject>("Users")
        query.whereEqualTo("user_id", userId)
        query.findInBackground(object : FindCallback<AVObject>() {
            override fun done(list: MutableList<AVObject>?, e: AVException?) {
                if (e == null) {
                    if (list?.size != 0) {
                        val user: User? = list?.get(0)?.getString("user_name")?.let { User(userId, it) }
                        data.value = user
                    }
                }
            }
        })
        return data
    }
}
