package com.morladim.mario.androiditem

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.morladim.mario.androiditem.db.AndroidItemEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
/**
 *
 * @Author 5k5k
 * @Date 2021/12/17
 */
@HiltViewModel
class AndroidItemViewModel @Inject constructor(private val repository: AndroidItemRepository) :
    ViewModel() {

    fun getPagingData(): Flow<PagingData<AndroidItemEntity>> {
        return repository.getPagingData().cachedIn(viewModelScope)
    }
}