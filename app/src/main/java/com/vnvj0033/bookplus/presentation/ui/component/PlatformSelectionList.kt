package com.vnvj0033.bookplus.presentation.ui.component

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.R
import com.vnvj0033.bookplus.presentation.ui.AppTheme
import com.vnvj0033.bookplus.presentation.ui.state.PlatformSelectionState
import com.vnvj0033.bookplus.presentation.ui.state.PlatformsState

/**
 * 클릭시 배경 변경, 이벤트는 외부로 호이스팅
 * */
@Composable
fun PlatformSelectionList(
    state: PlatformsState,
    click: (String) -> Unit = {}
) {

    Column() {
        Text(
            text = "PLATFORMS",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        LazyRow(Modifier.fillMaxWidth()) {
            items(state.platforms) { platform ->
                val isSelected = state.selectedTitle == platform.title

                PlatformSelection(
                    state = platform,
                    isSelected = isSelected
                ) { selectTitle ->
                    state.selectedTitle = selectTitle
                    click.invoke(selectTitle)
                }
            }
        }
    }

}


@Composable
fun PlatformSelection(
    state: PlatformSelectionState,
    isSelected: Boolean = false,
    click: (String) -> Unit = {}
) {
    val image = painterResource(state.imageResource)
    val maxSize = 88.dp
    val background =
        if (isSelected) Color(145, 208, 187)
        else Color.Transparent
    val imageBackground =
        if (isSelected) Color.White
        else Color.LightGray

    Column(
        modifier = Modifier
            .background(background)
            .clickable { click.invoke(state.title) }
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(maxSize)
                .clip(CircleShape)
                .background(imageBackground)
        )
        Text(
            text = state.title.uppercase(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .sizeIn(maxWidth = maxSize)
        )
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewPlatformSelectionList() {
    AppTheme {
        PlatformSelectionList(PlatformsState())
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewPlatformSelection() {
    val kyobo = PlatformSelectionState("kyobo", R.drawable.logo_kyobo)

    AppTheme {
        PlatformSelection(kyobo)
    }
}
