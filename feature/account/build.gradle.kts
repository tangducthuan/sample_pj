plugins {
    id("feature-plugin")
}

android {
    namespace = "com.example.account"
}

dependencies {
    api(project(":data:account"))
}
