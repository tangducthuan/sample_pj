plugins {
    id("app-plugin")
    id("kotlin-parcelize")
}

android {
    defaultConfig {
        applicationId = "com.example"
    }

    namespace = "com.example.myapplication"

    dynamicFeatures += setOf(
        ":feature:account",
        ":feature:authentication",
        ":feature:home"
    )
}

dependencies {
    implementation(project(":core"))
}
