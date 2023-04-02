@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.vnvj0033.bookplus.feature.home"
    compileSdk = Apps.compileSdkVersion

    defaultConfig {
        minSdk = Apps.minSdkVersion
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":data:model"))
    implementation(project(":ui"))
    implementation(project(":data:repository"))
    implementation(project(":feature:detail"))

    // dagger hilt
    implementation (Lib.hilt)
    kapt (Lib.hiltCompiler)

    // Compose Material Design 3
    implementation(Lib.composeMaterial3)
    // Android Studio Preview support
    implementation(Lib.composePreview)
    debugImplementation(Lib.composeUi)
    // Compose coil
    implementation(Lib.coilCompose)
    // Compose Integration with activities
    implementation(Lib.activityCompose)
    // Compose ViewModel
    implementation(Lib.viewmodelCompose)
    // Compose Navigation
    implementation(Lib.navigationCompose)
    // Compose Hilt
    implementation(Lib.hiltNavigationCompose)
}