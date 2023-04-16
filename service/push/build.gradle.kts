plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vnvj0033.bookplus.service.push"
    compileSdk = Apps.compileSdkVersion
}

dependencies {
    implementation(project(":data:datasource"))

    // firebase
    implementation(platform(Lib.firebaseBom))
    implementation(Lib.firebaseMessagingKtx)

    // coroutine
    implementation(Lib.coroutine)
}