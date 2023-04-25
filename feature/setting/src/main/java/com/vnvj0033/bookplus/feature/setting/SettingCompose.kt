package com.vnvj0033.bookplus.feature.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.vnvj0033.bookplus.ui.AppTheme

@Composable
fun SettingCompose(
    viewModel: SettingViewModel = hiltViewModel()
) {

    Column {
        MenuTitle("menu")
        Section("section")
    }

}

@Composable
private fun Section(text: String) {


    var checked by remember { mutableStateOf(true) }

    Row(modifier = Modifier
        .toggleable(checked) { checked = !checked }
        .semantics {
            stateDescription =
                if (checked) "ON" else "OFF"
        }
    ){
        Text(text = text)
        Switch(checked = checked,
            onCheckedChange = null

        )
    }
}

@Composable
private fun MenuTitle(text: String) {
    Text(
        text = text,
        modifier = Modifier.semantics { heading() },
        color = Color.Magenta
    )
}

@Preview
@Composable
fun Preview() {
    AppTheme {
        SettingCompose()
    }
}