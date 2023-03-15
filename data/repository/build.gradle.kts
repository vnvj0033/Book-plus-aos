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
    implementation(project(":data:model"))
    implementation(Lib.hilt)
    kapt(Lib.hiltCompiler)
}