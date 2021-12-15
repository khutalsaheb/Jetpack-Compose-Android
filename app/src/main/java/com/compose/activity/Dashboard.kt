package com.compose.activity

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.compose.ui.theme.typography
import com.compose.data.DataProvider
import com.compose.data.model.Puppy
import com.compose.utils.PuppyImage

@Composable
fun Dashboard() {
    val puppies = remember { DataProvider.puppyList }
    Column {

        TopAppBar(
            title = {
                Text(text = "Pets Dashboard")
            },
            /*navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn")
            }
        },
        */

        )

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
        ) {
            items(
                items = puppies,
                itemContent = {
                    PuppyListItem(puppy = it)
                })
        }
    }
}

@Composable
fun PuppyListItem(puppy: Puppy) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 2.dp,
        backgroundColor = Color.White,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))

    ) {
        Row {
            PuppyImage(puppy)
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Name: ${puppy.title}", style = typography.h6)
                Text(
                    text = "Age/Sex: ${puppy.age} Months - ${puppy.sex} ", style = typography.caption
                )

            }
        }
    }
}


