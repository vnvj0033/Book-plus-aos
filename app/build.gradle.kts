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

    namespace = "com.vnvj0033.bookplus"
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    testImplementation("junit:junit:${Versions.junitVersion}")
    androidTestImplementation("androidx.test.ext:junit:1.1.4")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.0")

    // datastore preferences
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // firebase
    implementation(platform("com.google.firebase:firebase-bom:30.1.0"))
    implementation("com.google.firebase:firebase-messaging-ktx")

    // dagger hilt
    implementation ("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt ("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")

    // Room
    implementation ("androidx.room:room-runtime:${Versions.roomVersion}")
    annotationProcessor("androidx.room:room-compiler:${Versions.roomVersion}")
    kapt ("androidx.room:room-compiler:${Versions.roomVersion}")

    // Retrofit2
    implementation ("com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}")
    implementation ("com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}")

    // Compose Material Design 3
    implementation("androidx.compose.material3:material3:1.1.0-alpha03")
    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.2")
    debugImplementation("androidx.compose.ui:ui-tooling:1.3.2")
    // Compose coil
    implementation("io.coil-kt:coil-compose:2.2.2")
    // Compose Integration with activities
    implementation("androidx.activity:activity-compose:1.6.1")
    // Compose ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1")
    // Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.5.3")
}