package com.vnvj0033.allinoneforcats.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.FragmentCatChoicesBinding
import com.vnvj0033.allinoneforcats.model.Cat

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CatChoicesFragment : Fragment() {

    private var _binding: FragmentCatChoicesBinding? = null
    private val binding get() = _binding!!

    private val catListAdapter = CatListAdapter()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatChoicesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewCatChoices.adapter = catListAdapter
        binding.recyclerviewCatChoices.layoutManager = GridLayoutManager(requireContext(), 2)
        catListAdapter.addCat(arrayListOf<Cat>().apply { for (i in 0..100) add(Cat()) })

        binding.contentUserInfo.root.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}