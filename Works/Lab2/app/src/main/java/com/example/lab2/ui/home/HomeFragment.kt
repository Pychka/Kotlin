package com.example.lab2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.MyFeel
import com.example.lab2.databinding.FragmentDashboardBinding
import com.example.lab2.databinding.FragmentHomeBinding
import com.example.lab2.recadapters.FeelRecycler
import com.example.lab2.recadapters.MyState
import com.example.lab2.recadapters.StateRecycler

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.feelRec.adapter = FeelRecycler(requireContext(), MyFeel().list)
        binding.stateRect.adapter = StateRecycler(requireContext(), MyState().state_list)
        return binding.root
    }
}