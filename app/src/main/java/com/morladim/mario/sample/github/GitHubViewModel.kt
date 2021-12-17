package com.morladim.mario.sample.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.morladim.mario.network.Repo
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
@HiltViewModel
class GitHubViewModel @Inject constructor(): ViewModel() {

//    @Inject
//    lateinit var repoRepository: RepoRepository

    val repoRepository = RepoRepository()


    fun getPagingData(): Flow<PagingData<Repo>> {
        return repoRepository.getPagingData().cachedIn(viewModelScope)
    }

}
//private static final int CURRENT_STACK = 5 + 2;
//private static final int PREVIOUS_STACK = 4 + 2;

//private static String[] getAutoJumpLogInfos() {
//    String[] infos = new String[]{"", "", ""};
//    StackTraceElement[] elements = Thread.currentThread().getStackTrace();
//    if (elements.length < CURRENT_STACK) {
//        return infos;
//    } else {
//        infos[0] = elements[PREVIOUS_STACK].getClassName().substring(
//            elements[PREVIOUS_STACK].getClassName().lastIndexOf(".") + 1);
//        infos[1] = elements[PREVIOUS_STACK].getMethodName() + "()";
//        infos[2] = " at (" + elements[PREVIOUS_STACK].getClassName() + ".java:"
//        + elements[PREVIOUS_STACK].getLineNumber() + ")";
//        return infos;
//    }
//}