package com.vnvj0033.bookplus.presentation.ui

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
    state: FilterState = FilterState(),
    selectedString: (String) -> Unit = {}
) {
    var displayText by remember {
        if (state.option.isEmpty()) {
            mutableStateOf("")
        } else {
            mutableStateOf(state.option[0])
        }
    }

    Box {
        Column {
            TextField(
                modifier = Modifier.width(160.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent
                ),
                value = displayText,
                onValueChange = { displayText = it },
                readOnly = false,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = state.isOpen)
                },
                singleLine = true,
                )

            DropDownList(
                requestToOpen = state.isOpen,
                list = state.option,
                dismissRequest = { state.isOpen = it },
                selectedString = {
                    displayText = it
                    selectedString.invoke(it)
                })
        }
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Transparent)
                .padding(10.dp)
                .clickable(onClick = { state.isOpen = true }))
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

class FilterState {
    val option = mutableStateListOf<String>()
    var isOpen by mutableStateOf(false)
}

@Preview
@Composable
private fun Preview() {
    val state = FilterState()

    state.option.addAll(listOf("test1", "test2", "test3"))
    AppTheme {
        Filter(state)
    }
}