plugins {
    id(Plugins.dynamicFeaturePlugin)
}

android {
    namespace = "com.example.authentication"
}

dependencies {
    implementation(project(":feature:account"))
}
android {
    namespace = "com.example.authentication"
}
