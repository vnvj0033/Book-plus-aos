package com.vnvj0033.allinoneforcats.ui.catdetil

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.FragmentCatDetailBinding
import com.vnvj0033.allinoneforcats.model.Cat

class CatDetailFragment : Fragment() {

    private var _binding: FragmentCatDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_cat_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cat = Cat(name = requireContext().getString(R.string.test_text), description = requireContext().getString(R.string.test_text))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}