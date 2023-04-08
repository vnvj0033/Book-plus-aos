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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildToolsVersion = "33.0.0"
}

dependencies {
    implementation(project(":feature:home"))
    implementation(project(":feature:detail"))
    implementation(project(":feature:subscript"))
    implementation(project(":feature:favoritegenre"))


    implementation(project(":data:model"))
    implementation(project(":data:repository"))
    implementation(project(":ui"))

    implementation(Lib.coreKtx)
    testImplementation(Lib.junit)
    androidTestImplementation(Lib.junitExt)
    androidTestImplementation(Lib.espresso)

    // splash screen
    implementation(Lib.splashScreen)

    // datastore preferences
    implementation (Lib.datastore)

    // firebase
    implementation(platform(Lib.firebaseBom))
    implementation(Lib.firebaseMessagingKtx)

    // dagger hilt
    implementation (Lib.hilt)
    kapt (Lib.hiltCompiler)

    // Room
    implementation (Lib.room)
    annotationProcessor(Lib.roomCompiler)
    kapt (Lib.roomCompiler)

    // Retrofit2
    implementation (Lib.retrofit2)
    implementation (Lib.gson)

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