package gradle

import com.android.build.gradle.internal.dsl.InternalLibraryExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import extension.*
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


/**
 * Created by Thuan Tang on 12/09/2022.
 */
class AndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins.apply(
            Plugins.androidLibrary, Plugins.kotlinAndroid, Plugins.kotlinKapt, Plugins.kotlinSerialization
        )

        getByName<InternalLibraryExtension>("android") {
            compileSdk = ConfigVersion.compileSDK
            defaultConfig {
                version = 1
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
            }
            buildTypes {
                getByName("debug") {

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
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
        dependencies {
            implementations(
                project(":core"),
                Dependencies.KTOR_HTTP,
                Dependencies.KOTLIN_SERIALIZATION,
                Dependencies.KOIN_ANDROID,
            )
        }
    }
}