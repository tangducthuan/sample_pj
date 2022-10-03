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
class LibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins.apply(
            Plugins.androidLibrary, Plugins.kotlinAndroid, Plugins.kotlinKapt
        )

        getByName<InternalLibraryExtension>("android") {
            compileSdk = ConfigVersion.compileSDK
            defaultConfig {
                targetSdk = ConfigVersion.targetSDK
                version = 1
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_1_8
                targetCompatibility = JavaVersion.VERSION_1_8
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
            jvmTarget = "1.8"
        }
        dependencies {
            implementations(

            )
        }
    }
}