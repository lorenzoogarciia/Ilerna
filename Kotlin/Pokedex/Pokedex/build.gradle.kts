// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.library") version "8.1.2" apply false
    kotlin("jvm") version "1.9.21" apply false
    kotlin("android") version "1.9.0" apply false
    id("com.google.devtools.ksp") version "1.9.21-1.0.15" apply false
}

buildscript{
    dependencies{
        classpath(kotlin("gradle-plugin", version = "1.9.21"))
    }
}