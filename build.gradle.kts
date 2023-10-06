buildscript {

}
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

plugins {
    id("com.google.devtools.ksp") version("1.9.10-1.0.13")
}
