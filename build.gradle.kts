buildscript {

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:${Versions.buildToolVersion}")
        classpath ("com.google.gms:google-services:${Versions.gmsServicesVersion}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}")
    }
}


allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

