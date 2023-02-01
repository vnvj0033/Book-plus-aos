object Apps {
    const val applicationId = "com.vnvj0033.bookplus"
    const val minSdkVersion = 21
    const val targetSdkVersion = 33
    const val compileSdkVersion = 33
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}

object Ver {
    const val buildToolVersion = "7.3.1"
    const val gmsServicesVersion = "4.3.13"
    const val kotlinVersion = "1.7.20"
    const val hiltVersion = "2.42"


    const val retrofitVersion = "2.9.0"
    const val roomVersion = "2.4.3"
    const val glideVersion = "4.13.0"
}

object Lib {
    const val coreKtx = "androidx.core:core-ktx:1.9.0"
    const val junit = "junit:junit:4.13.2"
    const val junitExt = "androidx.test.ext:junit:1.1.4"
    const val espresso = "androidx.test.espresso:espresso-core:3.5.0"

    const val datastore = "androidx.datastore:datastore-preferences:1.0.0"

    const val firebaseBom = "com.google.firebase:firebase-bom:30.1.0"
    const val firebaseMessagingKtx = "com.google.firebase:firebase-messaging-ktx"

    const val hilt = "com.google.dagger:hilt-android:${Ver.hiltVersion}"
    const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Ver.hiltVersion}"

    const val room = "androidx.room:room-runtime:${Ver.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Ver.roomVersion}"

    const val retrofit2 = "com.squareup.retrofit2:retrofit:${Ver.retrofitVersion}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Ver.retrofitVersion}"

    const val composeMaterial3 = "androidx.compose.material3:material3:1.1.0-alpha03"
    const val composePreview = "androidx.compose.ui:ui-tooling-preview:1.4.0-alpha03"
    const val composeUi = "androidx.compose.ui:ui-tooling:1.4.0-alpha03"
    const val coilCompose = "io.coil-kt:coil-compose:2.2.2"
    const val activityCompose = "androidx.activity:activity-compose:1.6.1"
    const val viewmodelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha03"
    const val navigationCompose = "androidx.navigation:navigation-compose:2.5.3"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
}