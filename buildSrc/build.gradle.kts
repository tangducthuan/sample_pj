import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}

gradlePlugin {
    plugins {
        register("app-plugin") {
            id = "app-plugin"
            implementationClass = "gradle.AppPlugin"
        }
        register("feature-plugin") {
            id = "feature-plugin"
            implementationClass = "gradle.DynamicFeaturePlugin"
        }
        register("android-library-plugin") {
            id = "android-library-plugin"
            implementationClass = "gradle.AndroidLibraryPlugin"
        }
        register("library-plugin") {
            id = "library-plugin"
            implementationClass = "gradle.LibraryPlugin"
        }
    }
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    compileOnly(gradleApi())
    implementation(kotlin("gradle-plugin", version = "1.8.21"))
    implementation(kotlin("serialization", version = "1.7.10"))
    implementation("com.android.tools.build:gradle:8.0.2")
}
