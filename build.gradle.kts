// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {

    extra.apply {
        set("room_version", "2.5.2")
        set("compose_ui_version","1.2.0")
    }
    repositories {
        // other repositories...
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.1.2")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.48.1")
    }
}

plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.android.library") version "8.0.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.21" apply false
    id("com.google.dagger.hilt.android") version "2.48.1" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}