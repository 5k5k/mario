package com.morladim.mario.kotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.morladim.mario.R
import com.morladim.mario.databinding.FragmentKotlinBinding
import com.morladim.mario.main.menu.db.MenuDatabaseRepository
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 *
 * @Author 5k5k
 * @Date 2021/12/6
 */
@AndroidEntryPoint
class KotlinFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentKotlinBinding.inflate(inflater, container, false)


        return binding.root
    }

    @Inject
    lateinit var menuDatabaseRepository: MenuDatabaseRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val b1 = view.findViewById<Button>(R.id.b1)
        val b2 = view.findViewById<Button>(R.id.b2)
        b1.setOnClickListener {
            menuDatabaseRepository.setAndroid0()
        }
        b2.setOnClickListener{
            menuDatabaseRepository.setAndroid1()
        }

    }
}