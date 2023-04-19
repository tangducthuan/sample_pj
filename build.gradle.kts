tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

plugins {
    id("com.google.devtools.ksp") version("1.8.20-1.0.11")
}
