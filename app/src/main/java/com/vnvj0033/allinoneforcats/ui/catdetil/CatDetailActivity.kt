package com.vnvj0033.allinoneforcats.ui.catdetil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.vnvj0033.allinoneforcats.R
import com.vnvj0033.allinoneforcats.databinding.ActivityCatDetailBinding
import com.vnvj0033.allinoneforcats.model.Cat
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CatDetailActivity: AppCompatActivity(), CatDetailEvent {

    private lateinit var binding: ActivityCatDetailBinding

    private lateinit var catDetailRepository: CatDetailRepository
    private lateinit var catDetailPresent: CatDetailPresent

    private val  catDetailAdapter = CatDetailAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_detail)
        setContentView(binding.root)

        catDetailRepository = CatDetailRepository()
        catDetailPresent = CatDetailPresent(catDetailEvent = this, catDetailRepository)

        binding.recyclerviewCatListCatDetail.adapter = catDetailAdapter


        lifecycleScope.launch {
            catDetailPresent.updateCatProfile()
            catDetailPresent.updateCatList()
        }
    }

    override fun updateCat(cat: Cat) {
        binding.cat = Cat(name = getString(R.string.test_text), description = getString(R.string.test_text))
    }

    override fun updateList(list: List<Cat>) {
        catDetailAdapter.addData(list)
    }

    override fun goToCatDetail(cat: Cat) {
//        val intent = Intent(this, CatDetailActivity::class.java)
//        startActivity(Intent(this, CatDetailActivity::class.java))
    }
}