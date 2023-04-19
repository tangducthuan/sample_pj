plugins {
    id(Plugins.dynamicFeaturePlugin)
}

dependencies {
    implementation(project(":feature:account"))
}
android {
    namespace = "com.example.authentication"
}
