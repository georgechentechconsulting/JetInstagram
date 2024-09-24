package com.vipulasri.jetinstagram.ui.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.data.StoriesRepository
import com.vipulasri.jetinstagram.model.currentUser
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.home.StoriesSection

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Profile() {
    Scaffold(
        topBar = { ProfileToolbar() },
        content = {
            ProfileContent()
        }
    )
}

@Composable
fun ProfileToolbar() {
    TopAppBar(
        title = {
            Text(text = "Profile", style = MaterialTheme.typography.h6)
        },
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.onBackground,
        elevation = 0.dp
    )
}

@Composable
fun ProfileContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {
        ProfileHeader()
        Spacer(modifier = Modifier.height(16.dp))

        // Profile Actions Buttons
        ProfileActions()
        Spacer(modifier = Modifier.height(16.dp))

        Divider(color = Color.Gray) // Divider line
        Spacer(modifier = Modifier.height(16.dp))

        // Adding Stories Section here
        val stories by StoriesRepository.observeStories()
        StoriesSection(stories)
    }
}

@Composable
fun ProfileHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically // Align items vertically in the center
    ) {
        // Profile Picture on the left
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, Color.Gray, CircleShape)
        ) {
            Image(
                painter = rememberImagePainter(currentUser.image),
                contentDescription = "Profile Picture",
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(CircleShape)
            )
        }

        Spacer(modifier = Modifier.width(16.dp)) // Add spacing between the profile picture and stats

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f), // Make the column take remaining space
            verticalArrangement = Arrangement.Center, // Align items vertically in the center of the column
            horizontalAlignment = Alignment.Start // Align items to the start of the column
        ) {
            // Displaying user name and username
            Text(text = currentUser.name, style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(8.dp)) // Add space below the name and username

            ProfileStats(followers = "0", following = "0", posts = "0")
        }
    }
}


@Composable
fun ProfileStats(followers: String, following: String, posts: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        ProfileStatItem(label = "Posts", value = posts)
        ProfileStatItem(label = "Followers", value = followers)
        ProfileStatItem(label = "Following", value = following)
    }
}

@Composable
fun ProfileStatItem(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp) // Add some padding between items
    ) {
        Text(text = value, style = MaterialTheme.typography.h6)
        Text(text = label, style = MaterialTheme.typography.body2)
    }
}

@Composable
fun ProfileActions() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        // Edit Profile Button
        Button(
            onClick = { /* Handle edit profile action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Edit Profile")
        }

        Spacer(modifier = Modifier.width(8.dp)) // Add some space between buttons

        // Share Profile Button
        Button(
            onClick = { /* Handle share profile action */ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White, contentColor = Color.Black),
            modifier = Modifier.weight(1f)
        ) {
            Text(text = "Share Profile")
        }
    }
}
