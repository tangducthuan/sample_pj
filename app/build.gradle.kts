plugins {
    id("app-plugin")
}

android {
    dynamicFeatures += setOf(
        ":feature:account",
        ":feature:authentication",
        ":feature:home"
    )
}

dependencies {
    implementation(project(":core"))
}
