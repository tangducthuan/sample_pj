package gradle

import Plugins
import com.android.build.gradle.internal.dsl.DynamicFeatureExtension
import extension.*
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions


/**
 * Created by Thuan Tang on 12/09/2022.
 */
class DynamicFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins.apply(
            Plugins.dynamicFeature, Plugins.kotlinAndroid, Plugins.ksp
        )

        getByName<DynamicFeatureExtension>("android") {
            compileSdk = ConfigVersion.compileSDK
            defaultConfig {
                minSdk = ConfigVersion.minSDK
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_17
                targetCompatibility = JavaVersion.VERSION_17
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
        }
        getByName<KotlinJvmOptions>("kotlinOptions") {
            jvmTarget = "17"
        }
        dependencies {
            implementations(
                project(":app"),
            )
            testImplementations(*Dependencies.TEST_DEPS)
            androidTestImplementations(*Dependencies.ANDROID_TEST_DEPS)
            debugImplementations(*Dependencies.COMPOSE_DEBUG_DEPS)
        }
    }
}