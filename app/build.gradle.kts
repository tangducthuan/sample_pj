plugins {
    id(Plugins.appPlugin)
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
    namespace = "com.example.myapplication"
}

dependencies {
}
