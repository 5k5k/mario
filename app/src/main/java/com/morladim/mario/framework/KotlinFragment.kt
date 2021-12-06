package com.morladim.mario.framework

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.morladim.mario.databinding.FragmentKotlinBinding

/**
 *
 * @Author 5k5k
 * @Date 2021/12/6
 */
class KotlinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentKotlinBinding.inflate(inflater, container, false)


        return binding.root
    }
}