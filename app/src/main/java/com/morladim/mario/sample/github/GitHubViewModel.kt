package com.morladim.mario.sample.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.morladim.mario.sample.github.model.Repo
import com.morladim.mario.sample.github.model.GitHubRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
/**
 *
 * @Author 5k5k
 * @Date 2021/12/16
 */
//https://www.wanandroid.com/blog/show/2
//https://github.com/winlee28/Jetpack-WanAndroid
//https://developer.android.com/codelabs/android-paging
//java并发编程的艺术
//https://www.kotlincn.net/docs/reference/coroutines/coroutines-guide.html
//https://madnight.github.io/githut/#/pushes/2021/3
//https://developer.android.com/kotlin/ktx?hl=zh-cn#groovy
//https://juejin.cn/post/6880226310959038478
//https://www.jianshu.com/p/8f915ba6c5a7
//https://blog.csdn.net/qq_37381177/article/details/115393813?spm=1001.2101.3001.6650.2&utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2.highlightwordscore&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7ECTRLIST%7Edefault-2.highlightwordscore
//https://juejin.cn/post/6899330633844129805
//markdown4j
//https://github.com/noties/Markwon
//https://noties.io/Markwon/docs/v4/core/getting-started.html#longer-one
//https://qiita.com/que9/items/52725c3caf33f2a9b44e
@HiltViewModel
class GitHubViewModel @Inject constructor(private val repoRepository: GitHubRepository): ViewModel() {

    fun getPagingData(): Flow<PagingData<Repo>> {
        return repoRepository.getPagingData().cachedIn(viewModelScope)
    }

}
