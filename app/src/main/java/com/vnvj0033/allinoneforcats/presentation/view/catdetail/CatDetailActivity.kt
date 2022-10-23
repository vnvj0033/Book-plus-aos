package com.vnvj0033.allinoneforcats.presentation.view.catdetail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.common.di.InCatDetail
import com.vnvj0033.allinoneforcats.databinding.ActivityCatDetailBinding
import com.vnvj0033.allinoneforcats.domain.model.Cat
import com.vnvj0033.allinoneforcats.presentation.presenter.CatDetailPresent
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CatDetailActivity: AppCompatActivity(), CatDetailView.AdapterEvent {

    private lateinit var binding: ActivityCatDetailBinding

    @InCatDetail
    @Inject lateinit var catDetailPresent: CatDetailPresent

    @InCatDetail
    @Inject lateinit var catDetailAdapter: CatDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        catDetailAdapter.setCatDetailView(this)

        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_detail)
        setContentView(binding.root)

        binding.recyclerviewCatListCatDetail.adapter = catDetailAdapter

        val cat : Cat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getParcelable("cat", Cat::class.java) ?: Cat(name = getString(R.string.test_text), description = getString(R.string.test_text))
        } else {
            intent.extras?.getParcelable("cat") ?: Cat(name = getString(R.string.test_text), description = getString(R.string.test_text))
        }

        updateCat(cat)
        lifecycleScope.launch(Dispatchers.IO) {
            catDetailPresent.getCatList(cat.name) {
                updateList(it)
            }
        }
    }

    private fun updateCat(cat: Cat) {
        binding.cat = cat
    }

    private fun updateList(list: List<Cat>) {
        catDetailAdapter.addData(list)
    }

    override fun goToCatDetail(cat: Cat) {
        val intent = Intent(this, CatDetailActivity::class.java).apply {
            putExtra("cat", cat)
        }
        startActivity(intent)
    }
}