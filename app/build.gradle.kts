plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = 30

    defaultConfig {
        applicationId = "com.lucianomazzutti.nevernote"
        minSdk = 21
        targetSdk = 30
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            isDebuggable = false
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(Kotlin.stdlib)
    implementation(Kotlin.reflect)
    implementation(Coroutines.core)
    implementation(Coroutines.android)
    implementation(Lifecycle.viewModel)
    implementation(Lifecycle.runtime)
    implementation(Lifecycle.liveData)
    implementation(Koin.android)
    implementation(AndroidX.appcompat)
    implementation(AndroidX.ktx)
    implementation(Firebase.core)
    implementation(Firebase.analytics)
    implementation(Timber.timber)
}