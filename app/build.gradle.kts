@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    compileSdk = Apps.compileSdkVersion

    defaultConfig {
        applicationId = Apps.applicationId
        minSdk = Apps.minSdkVersion
        targetSdk = Apps.targetSdkVersion
        versionCode = Apps.versionCode
        versionName = Apps.versionName

        testInstrumentationRunner = Apps.testInstrumentationRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        debug {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    namespace = "com.vnvj0033.bookplus"
}

dependencies {

    implementation(Dependencies.coreKtx)
    testImplementation(Dependencies.junit)
    androidTestImplementation(Dependencies.junitExt)
    androidTestImplementation(Dependencies.espresso)

    // datastore preferences
    implementation (Dependencies.datastore)

    // firebase
    implementation(Dependencies.firebaseBom)
    implementation(Dependencies.firebaseMessagingKtx)

    // dagger hilt
    implementation (Dependencies.hilt)
    kapt (Dependencies.hiltCompiler)

    // Room
    implementation (Dependencies.room)
    annotationProcessor(Dependencies.roomCompiler)
    kapt (Dependencies.roomCompiler)

    // Retrofit2
    implementation (Dependencies.retrofit2)
    implementation (Dependencies.gson)

    // Compose Material Design 3
    implementation(Dependencies.composeMaterial3)
    // Android Studio Preview support
    implementation(Dependencies.composePreview)
    debugImplementation(Dependencies.composeUi)
    // Compose coil
    implementation(Dependencies.coilCompose)
    // Compose Integration with activities
    implementation(Dependencies.activityCompose)
    // Compose ViewModel
    implementation(Dependencies.viewmodelCompose)
    // Compose Navigation
    implementation(Dependencies.navigationCompose)
    // Compose Hilt
    implementation(Dependencies.hiltNavigationCompose)
}