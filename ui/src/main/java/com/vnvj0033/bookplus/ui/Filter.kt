package com.vnvj0033.bookplus.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Filter(
    option: List<String> = emptyList(),
    selectedString: (String) -> Unit = {}
) {
    var isOpen by remember { mutableStateOf(false) }

    var displayText by remember {
        if (option.isEmpty()) {
            mutableStateOf("")
        } else {
            mutableStateOf(option[0])
        }
    }

    Box {
        Column {
            TextField(
                modifier = Modifier.width(160.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                value = displayText,
                onValueChange = { displayText = it },
                readOnly = true,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isOpen)
                },
                singleLine = true)

            DropDownList(
                requestToOpen = isOpen,
                list = option,
                dismissRequest = { isOpen = it },
                selectedString = { selectText ->
                    if (displayText != selectText) {
                        displayText = selectText
                        selectedString.invoke(selectText)
                    }
                })
        }
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(onClick = { isOpen = true }))
    }
}


@Composable
fun DropDownList(
    requestToOpen: Boolean = false,
    list: List<String>,
    dismissRequest: (Boolean) -> Unit,
    selectedString: (String) -> Unit
) {
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),
        expanded = requestToOpen,
        onDismissRequest = { dismissRequest(false) },
    ) {
        list.forEach {
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                text = {
                    Text(
                        text = it,
                        modifier = Modifier
                            .wrapContentWidth()
                            .align(Alignment.Start))
                },
                onClick = {
                    dismissRequest(false)
                    selectedString(it)
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    Filter(listOf("1", "2", "3", "4"))

}