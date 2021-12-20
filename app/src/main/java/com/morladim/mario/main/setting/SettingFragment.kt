package com.morladim.mario.main.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.morladim.mario.databinding.FragmentSettingBinding
import io.noties.markwon.Markwon

/**
 *
 * @Author 5k5k
 * @Date 2021/12/5
 */
class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentSettingBinding.inflate(inflater, container, false)

         val markwon = Markwon.create(context!!)

// set markdown
//        markwon.setMarkdown(binding.tv, "**Hello there!**");
        markwon.setMarkdown(binding.tv, "## 详细内容\n" +
                "\n" +
                "+ Hilt\n" +
                "+ Navigation\n" +
                "+ ViewModel\n" +
                "+ LiveData\n" +
                "+ Lifecycle");
        return binding.root
    }
}