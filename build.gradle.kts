// Top-level build file where you can add configuration options common to all sub-projects/modules.

// Porta il plugin Kotlin alla versione del campo kotlin del catalogo: senza, il plugin Android 9 usa il Kotlin 2.2.10 che porta con sé
buildscript {
    dependencies {
        classpath(libs.kotlin.gradle.plugin)
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false
}