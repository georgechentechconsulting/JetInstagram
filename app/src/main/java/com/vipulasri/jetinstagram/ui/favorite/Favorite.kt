package com.vipulasri.jetinstagram.ui.favorites

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.Favorite
import com.vipulasri.jetinstagram.ui.components.icon

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalFoundationApi
@Composable
fun Favorite() {
    // Sample data for favorite posts
    val favoritePosts = remember { mutableStateListOf<Favorite>() }

    // Add sample favorite posts
    favoritePosts.addAll(
        listOf(
            Favorite(
                id = "1",
                image = "https://randomuser.me/api/portraits/men/1.jpg",
                caption = "random 1"
            ),
            Favorite(
                id = "2",
                image = "https://randomuser.me/api/portraits/men/2.jpg",
                caption = "random 2"
            ),
            Favorite(
                id = "3",
                image = "https://randomuser.me/api/portraits/men/3.jpg",
                caption = "random 3"
            )
        )
    )

    Scaffold(
        topBar = { FavoritesToolbar() }
    ) {
        LazyColumn {
            items(favoritePosts.size) { index ->
                val post = favoritePosts[index]
                FavoritePostItem(
                    favorite = post,
                    onRemove = { favoritePosts.remove(post) } // Remove post on click
                )
            }
        }
    }
}

@Composable
private fun FavoritesToolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Favorites",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
        Icon(
            painter = painterResource(id = R.drawable.ic_dm), // Direct messages icon
            contentDescription = "Direct Messages",
            modifier = Modifier.icon()
        )
    }
}

@Composable
private fun FavoritePostItem(
    favorite: Favorite,
    onRemove: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = onRemove),
        elevation = 4.dp
    ) {
        Column {
            Image(
                painter = rememberImagePainter(favorite.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = favorite.caption,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
