package com.vnvj0033.allinoneforcats.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.FragmentCatChoicesBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CatChoicesFragment : Fragment() {

    private var _binding: FragmentCatChoicesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatChoicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewCatChoices.adapter = CatListAdapter()

        binding.contentUserInfo.root.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}