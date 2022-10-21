package com.vnvj0033.allinoneforcats.presentation.view.userprofile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.common.di.InUserProfile
import com.vnvj0033.allinoneforcats.databinding.FragmentUserProfileBinding
import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.domain.model.User
import com.vnvj0033.allinoneforcats.presentation.presenter.UserPresenter
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserProfileFragment : Fragment(), UserProfileEvent {

    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    @InUserProfile
    @Inject lateinit var catListAdapter: CatListAdapter

    @InUserProfile
    @Inject lateinit var userPresenter: UserPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_profile, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerviewCatChoices.adapter = catListAdapter.apply {
            userProfileEvent = this@UserProfileFragment
        }

        lifecycleScope.launch {
            userPresenter.loadData { cats, user ->
                updateUser(user)
                updateCatList(cats)
            }

        }

        binding.contentUserInfo.imageviewProfileUserProfileContent.setOnClickListener {
            findNavController().navigate(R.id.action_UserProfileFragment_to_ScreenTestActivity)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun goToCatDetail(cat: Cat) {
        findNavController().navigate(R.id.action_userProfile_to_catDetail)
    }

    override fun updateUser(user: User) {
        binding.contentUserInfo.user = user
    }

    override fun updateCatList(cats: List<Cat>) {
        catListAdapter.addCats(cats)
    }
}

