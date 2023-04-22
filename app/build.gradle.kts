@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.vnvj0033.bookplus"
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildToolsVersion = "33.0.0"
}

dependencies {
    implementation(project(":main"))
    implementation(project(":service:fcm"))

    testImplementation(Lib.junit)
    androidTestImplementation(Lib.junitExt)
    androidTestImplementation(Lib.espresso)

    // firebase
    implementation(platform(Lib.firebaseBom))
    implementation(Lib.firebaseMessagingKtx)
    
    // splash screen
    implementation(Lib.splashScreen)

    // dagger hilt
    implementation (Lib.hilt)
    kapt (Lib.hiltCompiler)

}