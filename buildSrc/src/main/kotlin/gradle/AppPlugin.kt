package gradle

import Plugins
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import extension.*
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions


/**
 * Created by Thuan Tang on 12/09/2022.
 */
class AppPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins.apply(
            Plugins.androidApplication, Plugins.kotlinAndroid, Plugins.kotlinKapt
        )

        getByName<BaseAppModuleExtension>("android") {
            compileSdk = ConfigVersion.compileSDK
            defaultConfig {
                minSdk = ConfigVersion.minSDK
                targetSdk = ConfigVersion.targetSDK
                versionCode = 1
                versionName = "1.0"
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables {
                    useSupportLibrary = true
                }
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
            }
            buildFeatures {
                compose = true
            }
            composeOptions {
                kotlinCompilerExtensionVersion = ConfigVersion.kotlinCompilerExtensionVersion
            }
            packagingOptions {
                resources {
                    excludes += setOf(
                        "/META-INF/{AL2.0,LGPL2.1}"
                    )
                }
            }
            buildTypes {
                getByName("debug") {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
                getByName("release") {
                    isMinifyEnabled = true
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
        getByName<KotlinJvmOptions>("kotlinOptions") {
            jvmTarget = "1.8"
        }

        dependencies {
            implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
            implementations(

            )
            apis(
                platform(project(":dependencies")),
                Dependencies.CORE_KTX,
                Dependencies.LIFECYCLE_RUNTIME_KTX,
                Dependencies.COROUTINES_CORE,
                Dependencies.COROUTINES_ANDROID,
                *Dependencies.COMPOSE_DEPS
            )
            testImplementations(*Dependencies.TEST_DEPS)
            androidTestImplementations(*Dependencies.ANDROID_TEST_DEPS)
            debugImplementations(*Dependencies.COMPOSE_DEBUG_DEPS)
        }
    }
}