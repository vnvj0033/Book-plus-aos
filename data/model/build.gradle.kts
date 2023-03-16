plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vnvj0033.bookplus.data.model"
    compileSdk = Apps.compileSdkVersion
}

dependencies {
    implementation(Lib.coreKtx)
}