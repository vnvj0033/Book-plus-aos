package com.vnvj0033.allinoneforcats.ui.catdetil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.ActivityCatDetailBinding
import com.vnvj0033.allinoneforcats.model.Cat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class CatDetailActivity: AppCompatActivity(), CatDetailEvent {

    private lateinit var binding: ActivityCatDetailBinding

    @Inject lateinit var catDetailPresent: CatDetailPresent

    @Inject lateinit var catDetailAdapter: CatDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        DaggerCatDetailComponent.build().setCatDetailEvent(this).inject(this)
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_detail)
        setContentView(binding.root)

        binding.recyclerviewCatListCatDetail.adapter = catDetailAdapter

        val cat : Cat = intent.extras?.getParcelable("cat", Cat::class.java) ?: Cat(name = getString(R.string.test_text), description = getString(R.string.test_text))
        lifecycleScope.launch {
            updateCat(cat)
            catDetailPresent.updateCatList(cat.name)
        }
    }

    override fun updateCat(cat: Cat) {
        binding.cat = cat
    }

    override fun updateList(list: List<Cat>) {
        catDetailAdapter.addData(list)
    }

    override fun goToCatDetail(cat: Cat) {
        val intent = Intent(this, CatDetailActivity::class.java).apply {
            putExtra("cat", cat)
        }
        startActivity(intent)
    }
}