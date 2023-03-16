plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.model"
    compileSdk = Apps.compileSdkVersion
}

dependencies {

    implementation(Lib.coreKtx)

}