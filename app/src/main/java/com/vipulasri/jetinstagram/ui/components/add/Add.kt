package com.vipulasri.jetinstagram.ui.addpost

/*
@Composable
fun AddPostScreen(onPostAdded: (Post) -> Unit, imagePicker: ActivityResultLauncher<Intent>) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var caption by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Add New Post", style = MaterialTheme.typography.h5)

        Spacer(modifier = Modifier.height(16.dp))

        // Display selected image
        imageUri?.let {
            Image(
                painter = rememberImagePainter(it),
                contentDescription = "Selected Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )
        } ?: run {
            Text(text = "No Image Selected", style = MaterialTheme.typography.body2)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Button to select image
        Button(onClick = {
            imagePicker.launch(Intent(Intent.ACTION_PICK).apply {
                type = "image/*"
            })
        }) {
            Text(text = "Select Image")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Caption input
        BasicTextField(
            value = caption,
            onValueChange = { caption = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            decorationBox = { innerTextField ->
                Row(
                    Modifier
                        .border(1.dp, MaterialTheme.colors.onSurface.copy(alpha = 0.5f))
                        .padding(8.dp)
                ) {
                    innerTextField()
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Submit button to add the post
        Button(onClick = {
            // Create a Post object and call onPostAdded
            if (imageUri != null) {
                val newPost = Post(
                    id = System.currentTimeMillis().toString(), // Simple ID generation
                    imageUri = imageUri.toString(),              // Use imageUri here
                    caption = caption
                )
                onPostAdded(newPost) // Trigger the callback
            }
        }) {
            Text(text = "Add Post")
        }
    }*/