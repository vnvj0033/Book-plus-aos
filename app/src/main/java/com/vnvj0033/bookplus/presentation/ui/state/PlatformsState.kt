package com.vnvj0033.bookplus.presentation.ui.state

import com.vnvj0033.bookplus.R

class PlatformsState {
    private val kyobo = PlatformSelectionState("kyobo", R.drawable.logo_kyobo)
    private val yes24 = PlatformSelectionState("yes24", R.drawable.logo_yes24)
    private val aladin = PlatformSelectionState("aladin", R.drawable.logo_aladin)

    val platforms = listOf(kyobo, yes24, aladin, kyobo, yes24, aladin)

    var selectedTitle = "kyobo"


}
