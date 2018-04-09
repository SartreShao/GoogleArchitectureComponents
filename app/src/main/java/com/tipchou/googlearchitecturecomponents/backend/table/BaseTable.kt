package com.tipchou.googlearchitecturecomponents.backend.table

import com.avos.avoscloud.AVObject
import java.util.*

/**
 * Created by 邵励治 on 2018/4/9.
 * Perfect Code
 */
open class BaseTable(avObject: AVObject) {
    var objectId: String? = null
    var updatedAt: Date? = null
    var createdAt: Date? = null

    init {
        objectId = avObject.objectId
        updatedAt = avObject.updatedAt
        createdAt = avObject.createdAt
    }
}
