plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vnvj0033.bookplus.common.util"
    compileSdk = Apps.compileSdkVersion
}

dependencies {
    implementation(Lib.coroutine)
    implementation(Lib.viewmodelCompose)

}