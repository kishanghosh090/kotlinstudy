plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.composecrashcourse"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.composecrashcourse"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {
    implementation(libs.material)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    val camerax_version = "1.3.2"

    implementation("androidx.camera:camera-core:$camerax_version")
    implementation ("androidx.camera:camera-camera2:$camerax_version")
    implementation ("androidx.camera:camera-lifecycle:$camerax_version")
    implementation ("androidx.camera:camera-view:$camerax_version")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")
    // CameraX
    // Core coroutines library
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.x.x")
    // Android-specific coroutine utilities
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.x.x")

    // Optional: For lifecycle-aware scopes (recommended for UI layers)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.x.x")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.x.x")


    // Retrofit (core library)
    implementation("com.squareup.retrofit2:retrofit:3.0.0")

    // Converter library (Gson is common, but Moshi or others can be used)
    implementation("com.squareup.retrofit2:converter-gson:3.0.0")

    // Optional: OkHttp logging interceptor for network call logging (useful for debugging)
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Optional: Kotlin Coroutines for asynchronous operations with suspend functions
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

}