package com.morladim.mario.leetcode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.morladim.mario.databinding.FragmentLeetcodeBinding
import dagger.hilt.android.AndroidEntryPoint

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
@AndroidEntryPoint
class LeetCodeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLeetcodeBinding.inflate(inflater, container, false)
        return binding.root
    }

}