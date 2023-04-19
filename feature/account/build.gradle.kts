plugins {
    id(Plugins.dynamicFeaturePlugin)
}

dependencies {
    api(project(":data:account"))
}
android {
    namespace = "com.example.account"
}
