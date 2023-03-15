plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.vnvj0033.bookplus.data.data.datasource"
}

dependencies {

    // Room
    implementation (Lib.room)
    kapt (Lib.roomCompiler)

    // Retrofit2
    implementation (Lib.retrofit2)
    implementation (Lib.gson)
}