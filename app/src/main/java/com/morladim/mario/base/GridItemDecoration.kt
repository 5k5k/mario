package com.morladim.mario.base

import android.graphics.Rect
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

/**
 * 适用于GridLayout，样式为所有item之间固定大小间隔，整体的外侧间距不在这里做
 * @Author fireman
 * @Date 2021/12/21
 */
class GridItemDecoration() : RecyclerView.ItemDecoration() {

    constructor(spanCount: Int, spacing: Int) : this() {
        this.spanCount = spanCount
        this.spacing = spacing
    }

    constructor(
        spanCount: Int,
        spacing: Int,
        startFromSize: Int,
        endFromSize: Int
    ) : this(spanCount, spacing) {
        this.startFromSize = startFromSize
        this.endFromSize = endFromSize
    }

    /**
     * 每行个数
     */
    private var spanCount = 2

    /**
     * 间距
     */
    private var spacing = 8

    /**
     * 不处理的头部数量
     */
    var startFromSize = 0

    /**
     * 不处理的尾部数量
     */
    var endFromSize = 0

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        var position = parent.getChildAdapterPosition(view)
        //头尾不处理
        if (position < startFromSize || state.itemCount - endFromSize > position) {
            return
        }
        // 减掉不设置间距的position
        position -= startFromSize
        var column: Int = position % spanCount

        // 瀑布流获取列方式不一样
        val layoutParams: ViewGroup.LayoutParams = view.layoutParams
        if (layoutParams is StaggeredGridLayoutManager.LayoutParams) {
            column = layoutParams.spanIndex
        }
        outRect.left = if (column == 0) 0 else spacing
        outRect.right = 0
        if (position >= spanCount) {
            outRect.top = spacing
        }

    }
}