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
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }

        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2"
    }

    dataBinding {
        isEnabled = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.8.0-alpha01")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.2")
    implementation("androidx.preference:preference:1.2.0")
    testImplementation("junit:junit:${Versions.junitVersion}")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

    // firebase
    implementation(platform("com.google.firebase:firebase-bom:30.1.0"))
    implementation("com.google.firebase:firebase-messaging-ktx")

    // dagger hilt
    implementation ("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt ("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")

    //Glide
    implementation ("com.github.bumptech.glide:glide:${Versions.glideVersion}")
    annotationProcessor ("com.github.bumptech.glide:compiler:${Versions.glideVersion}")

    // Preferences DataStore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    // Room
    implementation ("androidx.room:room-runtime:${Versions.roomVersion}")
    annotationProcessor("androidx.room:room-compiler:${Versions.roomVersion}")
    kapt ("androidx.room:room-compiler:${Versions.roomVersion}")

    // Retrofit2
    implementation ("com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}")
    implementation ("com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}")

    // Hilt
    implementation ("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt ("com.google.dagger:hilt-compiler:${Versions.hiltVersion}")

    // Compose Material Design 3
    implementation("androidx.compose.material3:material3:1.0.0-rc01")
    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview:1.2.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.1")
    // Compose glide
    implementation("io.coil-kt:coil-compose:2.2.2")
}