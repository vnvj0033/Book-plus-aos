plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("dagger.hilt.android.plugin")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.repository"
}

dependencies {
    implementation(project(mapOf("path" to ":data:model")))
    implementation(Lib.hilt)
    kapt(Lib.hiltCompiler)
}