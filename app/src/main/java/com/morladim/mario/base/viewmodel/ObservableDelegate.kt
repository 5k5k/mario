package com.morladim.mario.base.viewmodel

import androidx.databinding.BaseObservable
import kotlin.reflect.KProperty

/**
 * 用于可变值的databinding中的属性代理
 * @Author 5k5k
 * @Date 2022/1/1
 */
class ObservableDelegate<T : BaseObservable, V>(val id: Int, var value: V) {

    operator fun getValue(thisRef: T, property: KProperty<*>): V {
        return value
    }

    operator fun setValue(thisRef: T, property: KProperty<*>, value: V) {
        this.value = value
        thisRef.notifyPropertyChanged(id)
    }
}