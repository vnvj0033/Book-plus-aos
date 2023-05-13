plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.vnvj0033.bookplus.data.datasource"
    compileSdk = Apps.compileSdkVersion
}

dependencies {
    implementation(project(":data:model"))

    // Room
    implementation(Lib.room)
    implementation(Lib.roomKtx)
    annotationProcessor(Lib.roomCompiler)

    // Retrofit2
    implementation (Lib.retrofit2)
    implementation (Lib.gson)
    implementation(Lib.retrofitCoroutinesAdapter)

    // hilt
    implementation(Lib.hilt)
    kapt(Lib.hiltCompiler)


    implementation(Lib.coroutine)

    // datastore preferences
    implementation (Lib.datastore)
}