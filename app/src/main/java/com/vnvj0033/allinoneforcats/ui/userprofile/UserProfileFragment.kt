package com.vnvj0033.allinoneforcats.ui.userprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.FragmentUserProfileBinding
import com.vnvj0033.allinoneforcats.model.Cat
import com.vnvj0033.allinoneforcats.model.User

class UserProfileFragment : Fragment(), UserProfileEvent {

    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    private val catListAdapter = CatListAdapter(userProfileEvent = this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerviewCatChoices.adapter = catListAdapter
        catListAdapter.addCat(arrayListOf<Cat>().apply { for (i in 0..100) add(Cat()) })

        updateUser(User())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun goToCatDetail(cat: Cat) {
        findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
    }

    override fun updateUser(user: User) {
        binding.contentUserInfo.user = user
    }
}

