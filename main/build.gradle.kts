@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vnvj0033.bookplus.main"
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
    implementation(project(":feature:home"))
    implementation(project(":feature:subscript"))
    implementation(project(":feature:favoritegenre"))

    implementation(project(":ui"))

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