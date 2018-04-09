package com.tipchou.googlearchitecturecomponents.backend.table

import com.avos.avoscloud.AVObject

/**
 * Created by 邵励治 on 2018/4/9.
 * Perfect Code
 */
class UsersTable(avObject: AVObject) : BaseTable(avObject) {
    var userId: String? = null
    var userName: String? = null

    init {
        userId = avObject.getString("user_id")
        userName = avObject.getString("user_name")
    }
}
