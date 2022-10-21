package com.vnvj0033.allinoneforcats.presentation.view.catdetail

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
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
class CatDetailActivity: AppCompatActivity(), CatDetailEvent {

    private lateinit var binding: ActivityCatDetailBinding

    @InCatDetail
    @Inject lateinit var catDetailPresent: CatDetailPresent

    @InCatDetail
    @Inject lateinit var catDetailAdapter: CatDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        catDetailPresent.catDetailEvent = this
        catDetailAdapter.catDetailEvent = this

        super.onCreate(savedInstanceState)


        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_detail)
        setContentView(binding.root)

        binding.recyclerviewCatListCatDetail.adapter = catDetailAdapter

        val cat : Cat = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getParcelable("cat", Cat::class.java) ?: Cat(name = getString(R.string.test_text), description = getString(R.string.test_text))
        } else {
            intent.extras?.getParcelable("cat") ?: Cat(name = getString(R.string.test_text), description = getString(R.string.test_text))
        }

        lifecycleScope.launch(Dispatchers.IO) {
            updateCat(cat)
            catDetailPresent.updateCatList(cat.name)
        }
    }

    override fun updateCat(cat: Cat) {
        Log.d("testsyyoo", "updateCat")
        binding.cat = cat
    }

    override fun updateList(list: List<Cat>) {
        Log.d("testsyyoo", "updateList")

        catDetailAdapter.addData(list)
    }

    override fun goToCatDetail(cat: Cat) {
        Log.d("testsyyoo", "goToCatDetail")

        val intent = Intent(this, CatDetailActivity::class.java).apply {
            putExtra("cat", cat)
        }
        startActivity(intent)
    }
}