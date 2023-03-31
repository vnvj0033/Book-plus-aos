package com.vnvj0033.bookplus.ui

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
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vnvj0033.bookplus.data.model.Platform

/**
 * 클릭시 배경 변경, 이벤트는 외부로 호이스팅
 * */
@Composable
fun PlatformSelectionList(
    platform: Platform = platforms[0],
    click : (Platform) -> Unit = {}
) {
    var selectedTitle by remember { mutableStateOf(platform.name) }

    Column {
        Text(
            text = "PLATFORMS",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        LazyRow(Modifier.fillMaxWidth()) {
            items(platforms) { platform ->
                val isSelected = selectedTitle == platform.name

                PlatformSelection(
                    platform = platform,
                    isSelected = isSelected
                ) { selectedPlatform ->
                    click.invoke(selectedPlatform)
                    selectedTitle = selectedPlatform.name
                }
            }
        }
    }

}


@Composable
fun PlatformSelection(
    platform: Platform,
    isSelected: Boolean = false,
    click: (Platform) -> Unit = {}
) {
    val image = painterResource(platform.resource)
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
            .clickable { click.invoke(platform) }
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
            text = platform.name.uppercase(),
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .paddingFromBaseline(top = 24.dp, bottom = 8.dp)
                .sizeIn(maxWidth = maxSize)
        )
    }
}

private val platforms: List<Platform> =
    listOf(
        Platform.KYOBO,
        Platform.YES24,
        Platform.ALADIN
    )

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewPlatformSelectionList() {
        PlatformSelectionList()
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun PreviewPlatformSelection() {
    PlatformSelection(platforms[0])

}
