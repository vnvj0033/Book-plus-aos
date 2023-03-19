plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.vnvj0033.bookplus.data.model"
    compileSdk = Apps.compileSdkVersion
}

dependencies {
    implementation(Lib.coreKtx)

    // Room
    implementation (Lib.room)
    annotationProcessor(Lib.roomCompiler)
    kapt (Lib.roomCompiler)
}