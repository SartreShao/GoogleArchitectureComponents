package com.tipchou.googlearchitecturecomponents.backend

import com.avos.avoscloud.AVException
import com.avos.avoscloud.AVObject
import com.avos.avoscloud.AVQuery
import com.avos.avoscloud.FindCallback
import com.tipchou.googlearchitecturecomponents.backend.table.UsersTable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by 邵励治 on 2018/4/9.
 * Perfect Code
 */
@Singleton
class WebDao @Inject constructor() {
    fun getUser(userId: String, callback: Callback<UsersTable>) {
        val query = AVQuery<AVObject>("Users")
        query.whereEqualTo("user_id", userId)
        query.findInBackground(object : FindCallback<AVObject>() {
            override fun done(list: MutableList<AVObject>?, e: AVException?) {
                if (e == null) {
                    val usersTableList = arrayListOf<UsersTable>()
                    if (list != null) {
                        for (avObject in list) {
                            val usersTable = UsersTable(avObject)
                            usersTableList.add(usersTable)
                        }
                    }
                    callback.success(usersTableList)
                } else {
                    callback.failure(e)
                }
            }
        })
    }
}


interface Callback<in T> {
    fun success(response: List<T>)
    fun failure(e: AVException?)
}