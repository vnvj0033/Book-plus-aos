package com.vnvj0033.bookplus.ui.state

import com.vnvj0033.bookplus.R

data class PlatformsState(
    val platforms: List<PlatformSelectionState> =
        listOf(
            PlatformSelectionState("kyobo", R.drawable.logo_kyobo),
            PlatformSelectionState("yes24", R.drawable.logo_yes24),
            PlatformSelectionState("aladin", R.drawable.logo_aladin)
        ),
    var selectedTitle: String = platforms[0].title
)
