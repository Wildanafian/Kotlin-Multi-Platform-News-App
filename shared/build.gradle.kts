plugins {
    alias(libs.plugins.kotlinMultiplatform)
    id("co.touchlab.skie")
    alias(libs.plugins.androidLibrary)
//    id("org.jetbrains.kotlin.plugin.serialization")
    id("kotlinx-serialization")
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.ktor.client.core)
            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation (libs.ktor.client.logging)

            implementation (libs.napier)

            implementation(libs.koin.core)

            implementation(libs.multiplatform.settings)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
            implementation(libs.kotlinx.coroutines.core)

            implementation(libs.koin.core)
        }
    }
}

android {
    namespace = "com.wildan.newsappkmm"
    compileSdk = 34
    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
