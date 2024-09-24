package com.vipulasri.jetinstagram.ui.add

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat

@Composable
fun Add() {
    val context = LocalContext.current
    var cameraPermissionGranted by remember { mutableStateOf(false) }
    var shouldOpenCamera by remember { mutableStateOf(false) }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            cameraPermissionGranted = true
            shouldOpenCamera = true
        } else {
            Toast.makeText(context, "Camera permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    LaunchedEffect(Unit) {
        when (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA)) {
            PackageManager.PERMISSION_GRANTED -> {
                cameraPermissionGranted = true
                shouldOpenCamera = true
            }
            else -> {
                permissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    if (shouldOpenCamera) {
        OpenCamera()
        shouldOpenCamera = false
    }
}

@Composable
fun OpenCamera() {
    val context = LocalContext.current
    val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

    if (cameraIntent.resolveActivity(context.packageManager) != null) {
        context.startActivity(cameraIntent)
    } else {
        Toast.makeText(context, "No camera application found", Toast.LENGTH_SHORT).show()
    }
}
