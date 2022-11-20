package com.vnvj0033.allinoneforcats.presentation.view.detail

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.vnvj0033.allinoneforcats.domain.model.DetailCat
import com.vnvj0033.allinoneforcats.presentation.presenter.DetailViewModel

class DetailActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel: DetailViewModel by viewModels()
        val bundle = intent.extras ?: Bundle()

        if (bundle.containsKey("cat")) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                viewModel.state.cat = bundle.getParcelable("cat", DetailCat::class.java) ?: DetailCat()
            } else {
                viewModel.state.cat = bundle.getParcelable("cat") ?: DetailCat()
            }
        }

        setContent {
            DetailUI(viewModel)
        }
    }
}
