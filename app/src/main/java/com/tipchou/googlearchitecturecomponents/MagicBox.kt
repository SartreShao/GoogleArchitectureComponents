package com.tipchou.googlearchitecturecomponents

import dagger.Component

/**
 * Created by 邵励治 on 2018/4/9.
 * Perfect Code
 */
@Component
interface MagicBox {
    fun poke(userInfoViewModel: UserInfoViewModel)
}