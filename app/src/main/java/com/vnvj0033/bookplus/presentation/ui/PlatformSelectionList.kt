package com.vnvj0033.bookplus.presentation.ui

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
import com.vnvj0033.bookplus.presentation.presenter.PlatformSelectionListViewModel
import com.vnvj0033.bookplus.presentation.ui.state.PlatformSelectionState

@Composable
fun PlatformSelectionList() {

    val viewmodel = PlatformSelectionListViewModel()

    PlatformSelectionList(viewmodel.platforms)
}

@Composable
fun PlatformSelectionList(platforms: List<PlatformSelectionState>) {

    Column() {
        Text(
            text = "PLATFORMS",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        LazyRow(Modifier.fillMaxWidth()) {
            items(platforms) { platform ->
                PlatformSelection(platform) {

                }
            }
        }
    }

}


@Composable
fun PlatformSelection(
    state: PlatformSelectionState,
    click: () -> Unit = {}
) {
    val image = painterResource(state.imageResource)
    val maxSize = 88.dp
    val selectedColor = Color.Transparent

    Column(
        modifier = Modifier
            .background(selectedColor)
            .padding(8.dp)
            .clickable {  },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier
                .size(maxSize)
                .clip(CircleShape)
                .background(Color.LightGray)
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
        PlatformSelectionList()
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
