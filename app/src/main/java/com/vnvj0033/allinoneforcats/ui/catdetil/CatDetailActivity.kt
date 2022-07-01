package com.vnvj0033.allinoneforcats.ui.catdetil

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
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

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("testsyyoo", "onCreate")
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_cat_detail)
        setContentView(binding.root)

        catDetailRepository = CatDetailRepository()
        catDetailPresent = CatDetailPresent(catDetailEvent = this, catDetailRepository)

        lifecycleScope.launch {
            catDetailPresent.updateCatProfile()
        }
    }

    override fun updateCat(cat: Cat) {
        binding.cat = Cat(name = getString(R.string.test_text), description = getString(R.string.test_text))
    }

    override fun loadList() { }
}