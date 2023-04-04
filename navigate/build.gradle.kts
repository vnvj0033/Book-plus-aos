plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.vnvj0033.bookplus.navigate"
    compileSdk = Apps.compileSdkVersion
}

dependencies {
    implementation(project(":data:model"))
    implementation(project(":feature:detail"))

    implementation(Lib.coreKtx)
}