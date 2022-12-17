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
fun Filter() {
    val countryList = listOf(
        "United state",
        "Australia",
        "Japan",
        "India",
    )
    var text by remember { mutableStateOf("default123123123123") }
    var isOpen by remember { mutableStateOf(false) }
    val openCloseOfDropDownList: (Boolean) -> Unit = {
        isOpen = it
    }
    val userSelectedString: (String) -> Unit = {
        text = it
    }
    Box {
        Column {
            TextField(
                value = text,
                onValueChange = { text = it },
                readOnly = false,
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isOpen)
                },
                singleLine = true,
                modifier = Modifier.width(160.dp))

            DropDownList(
                requestToOpen = isOpen,
                list = countryList,
                openCloseOfDropDownList,
                userSelectedString)
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
    request: (Boolean) -> Unit,
    selectedString: (String) -> Unit
) {
    DropdownMenu(
        modifier = Modifier.fillMaxWidth(),
        expanded = requestToOpen,
        onDismissRequest = { request(false) },
    ) {
        list.forEach {
            DropdownMenuItem(
                modifier = Modifier.fillMaxWidth(),
                text = { Text(it, modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.Start)) },
                onClick = {
                    request(false)
                    selectedString(it)
                }
            )
        }
    }
}

@Preview
@Composable
private fun Preview() {
    AppTheme {
        Filter()
    }
}