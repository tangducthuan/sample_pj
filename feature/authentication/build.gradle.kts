plugins {
    id("feature-plugin")
}

android {
    namespace = "com.example.authentication"
}

dependencies {
    implementation(project(":feature:account"))
}
