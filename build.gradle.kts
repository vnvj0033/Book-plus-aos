buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.4.1")
        classpath ("com.google.gms:google-services:${Ver.gmsServicesVersion}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Ver.kotlinVersion}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Ver.hiltVersion}")
    }
}


allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

