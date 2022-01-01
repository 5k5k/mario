package com.morladim.mario.base.viewmodel

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.morladim.mario.BR

/**
 * 通用的加载绑定类
 * @Author 5k5k
 * @Date 2022/1/1
 */
class LoadingViewModel : BaseObservable() {

    @get:Bindable
    var loadingViewVisible: Boolean? by ObservableDelegate(BR.loadingViewVisible, false)

    @get:Bindable
    var contentViewVisible: Boolean? by ObservableDelegate(BR.contentViewVisible, true)

}