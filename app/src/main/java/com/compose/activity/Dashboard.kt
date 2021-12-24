package com.compose.activity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose.components.ItemDogCard
import com.compose.components.TopBar
import com.compose.data.DataProvider
import com.compose.utils.Screen

@Composable
fun Dashboard(navController: NavController) {
    val puppies = remember { DataProvider.puppyList }

    LazyColumn(Modifier.background(color = colorResource(id = com.compose.R.color.bg))) {
        item {
            TopBar()
            Spacer(modifier = Modifier.height(8.dp))
        }
        items(items = puppies) {
            ItemDogCard(dog = it, onItemClicked = { puppy ->
                navController.navigate("${Screen.Details.route}/${puppy.id}")
            })
        }
        /* items(
                items = puppies,
                itemContent = {
                    ItemDogCard(it,
                        onItemClicked = { dog ->
                            navController.navigate("${Screen.Details.route}/${dog.id}")
                        }
                    )
                })*/
    }
}

/*  val puppies = remember { DataProvider.puppyList }
    Column {

        TopAppBar(
            title = {
                Text(text = "Pets Dashboard")
            })
        *//*navigationIcon = {
        IconButton(onClick = { }) {
            Icon(imageVector = Icons.Filled.Menu, contentDescription = "Menu Btn")
        }
    },
    *//*
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
                    text = "Age/Sex: ${puppy.age} Months -"+GenderTag(puppy.sex),
                    style = typography.caption
                )

            }
        }
    }
}

*/
