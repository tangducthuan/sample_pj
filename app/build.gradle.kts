plugins {
    id(Plugins.appPlugin)
}

android {
    dynamicFeatures += setOf(
        ":feature:account",
        ":feature:authentication",
        ":feature:home"
    )
    namespace = "com.example.myapplication"
}

dependencies {
}
