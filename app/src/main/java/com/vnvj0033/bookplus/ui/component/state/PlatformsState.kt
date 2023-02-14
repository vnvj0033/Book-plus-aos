package com.vnvj0033.bookplus.ui.component.state

import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.domain.model.Constant

data class PlatformsState(
    val platforms: List<PlatformSelectionState> =
        listOf(
            PlatformSelectionState(Constant.Platform.kyobo, R.drawable.logo_kyobo),
            PlatformSelectionState(Constant.Platform.yes24, R.drawable.logo_yes24),
            PlatformSelectionState(Constant.Platform.aladin, R.drawable.logo_aladin)
        ),
    var selectedTitle: String = platforms[0].title
)
