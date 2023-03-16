package com.vnvj0033.bookplus.ui.component.state

import com.example.model.Constant
import com.vnvj0033.bookplus.R

data class PlatformsState(
    val platforms: List<PlatformSelectionState> =
        listOf(
            PlatformSelectionState(Constant.Platform.KYOBO, R.drawable.logo_kyobo),
            PlatformSelectionState(Constant.Platform.YES24, R.drawable.logo_yes24),
            PlatformSelectionState(Constant.Platform.ALADIN, R.drawable.logo_aladin)
        ),
    var selectedTitle: String = platforms[0].title
)
