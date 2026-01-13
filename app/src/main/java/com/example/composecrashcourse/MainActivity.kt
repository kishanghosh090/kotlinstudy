package com.example.composecrashcourse

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val age = ""

//        GlobalScope.launch {
//            delay(3000)
//            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//        }
//        GlobalScope.launch(Dispatchers.IO) {
////            print(doNetworkCall())
//            val ans = doNetworkCall()
//            withContext(Dispatchers.Main){
//                Log.d("MainActivity", "onCreate: $ans")
//                Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//
//
//                Toast.makeText(this@MainActivity, ans, Toast.LENGTH_SHORT).show()
//            }
//            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
//        }
//        Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")

        runBlocking {
            launch(Dispatchers.IO) {
                Log.d("MainActivity", "onCreate: Hello from coroutine-- ${Thread.currentThread().name}")
                delay(3000)
                Log.d("MainActivity", "onCreate: Hello from coroutine- ${Thread.currentThread().name}")
                withContext(Dispatchers.Main){
                    Log.d("MainActivity", "onCreate: Hello from coroutine-- ${Thread.currentThread().name}")
                    Toast.makeText(this@MainActivity, "ans", Toast.LENGTH_SHORT).show()

                }
            }
            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
            delay(5000)
            Log.d("MainActivity", "onCreate: Hello from coroutine ${Thread.currentThread().name}")
        }
        setContent {
            Text(
                modifier = Modifier
                            .fillMaxSize()
                            .padding(12.dp),
                text = "hello"
            )
        }
    }

    suspend fun doNetworkCall(): String{
        delay(3000)
        return "this is the data from db"
    }
}

@Composable
fun CameraApp() {
    val context = LocalContext.current
    var hasPermission by remember { mutableStateOf(false) }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { granted ->
        hasPermission = granted
    }

    LaunchedEffect(Unit) {
        if (ContextCompat.checkSelfPermission(
                context,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            hasPermission = true
        } else {
            launcher.launch(Manifest.permission.CAMERA)
        }
    }

    if (hasPermission) {
        CameraScreen()
    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Camera permission required")
        }
    }
}

@Composable
fun CameraScreen() {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current

    val imageCapture = remember {
        ImageCapture.Builder().build()
    }

    Box(modifier = Modifier.fillMaxSize()) {

        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { ctx ->
                val previewView = PreviewView(ctx)

                val preview = Preview.Builder().build()
                preview.setSurfaceProvider(previewView.surfaceProvider)

                val cameraSelector =
                    CameraSelector.DEFAULT_BACK_CAMERA

                val cameraProviderFuture =
                    ProcessCameraProvider.getInstance(ctx)

                cameraProviderFuture.addListener({
                    val cameraProvider =
                        cameraProviderFuture.get()

                    cameraProvider.unbindAll()

                    cameraProvider.bindToLifecycle(
                        lifecycleOwner,
                        cameraSelector,
                        preview,
                        imageCapture
                    )
                }, ContextCompat.getMainExecutor(ctx))

                previewView
            }
        )

        FloatingActionButton(
            onClick = {
                takePhoto(imageCapture, context)
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(24.dp)
        ) {
            Icon(Icons.Default.Add, contentDescription = null)
        }
    }
}

fun takePhoto(
    imageCapture: ImageCapture,
    context: Context
) {
    val contentValues = ContentValues().apply {
        put(MediaStore.MediaColumns.DISPLAY_NAME, "IMG_${System.currentTimeMillis()}")
        put(MediaStore.MediaColumns.MIME_TYPE, "image/jpeg")
        put(MediaStore.Images.Media.RELATIVE_PATH, "Pictures/CameraX")
    }

    val outputOptions = ImageCapture.OutputFileOptions.Builder(
        context.contentResolver,
        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        contentValues
    ).build()

    imageCapture.takePicture(
        outputOptions,
        ContextCompat.getMainExecutor(context),
        object : ImageCapture.OnImageSavedCallback {

            override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                Toast.makeText(
                    context,
                    "Photo saved to gallery 📸",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onError(exception: ImageCaptureException) {
                Toast.makeText(
                    context,
                    "Error: ${exception.message}",
                    Toast.LENGTH_LONG
                ).show()
                Log.e("CAMERA", "Capture failed", exception)
            }
        }
    )
}
