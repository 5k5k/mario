package com.morladim.mario.framework.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.morladim.mario.databinding.FragmentCategoryBinding

/**
 * tab category
 * @Author 5k5k
 * @Date 2021/12/5
 */
class CategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCategoryBinding.inflate(inflater, container, false)

        return binding.root
    }
}