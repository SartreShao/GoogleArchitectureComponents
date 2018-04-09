package com.tipchou.googlearchitecturecomponents

import dagger.Component
import javax.inject.Singleton

/**
 * Created by 邵励治 on 2018/4/9.
 * Perfect Code
 */
@Singleton
@Component
interface MagicBox {
    fun poke(userInfoViewModel: UserInfoViewModel)
    fun poke(userRepository: UserRepository)
}