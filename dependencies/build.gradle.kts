
plugins {
    `java-platform`
    `maven-publish`
}

val appcompat = "1.5.1"
val activity = "1.6.0"
val appStartup = "1.1.1"
val cardview = "1.0.0"
val benchmark = "1.1.0"
val browser = "1.4.0"
val constraintLayout = "2.1.4"
val core = "1.10.1"
val coroutines = "1.6.4"
val espresso = "3.4.0"
val flexbox = "3.0.0"
val fragment = "1.3.0"
val glide = "4.13.2"
val gson = "2.9.1"
val hilt = "2.43.2"
val junit = "4.13.2"
val junitExt = "1.1.3"
val lifecycle = "2.5.1"
val lottie = "5.2.0"
val material = "1.6.1"
val mockito = "4.8.0"
val okhttp = "4.10.0"
val profileInstaller = "1.2.0"
val room = "2.5.0"
val rules = "1.4.0"
val runner = "1.4.0"
val slidingpanelayout = "1.2.0"
val timber = "5.0.1"
val viewpager2 = "1.0.0"
val compose = "1.4.3"
val splash_screen = "1.0.0"
val ktor = "2.2.4"
val kotlin_serialization = "1.5.1"
val koin = "3.4.0"
val koin_compose = "3.4.4"

dependencies {
    constraints {
        api("${Dependencies.ACTIVITY_KTX}:$activity")
        api("${Dependencies.APP_COMPAT}:$appcompat")
        api("${Dependencies.APP_STARTUP}:$appStartup")
        api("${Dependencies.CARDVIEW}:$cardview")
        api("${Dependencies.BENCHMARK}:$benchmark")
        api("${Dependencies.BENCHMARK_MACRO}:$benchmark")
        api("${Dependencies.BROWSER}:$browser")
        api("${Dependencies.CONSTRAINT_LAYOUT}:$constraintLayout")
        api("${Dependencies.CORE_KTX}:$core")
        api("${Dependencies.COROUTINES_CORE}:$coroutines")
        api("${Dependencies.COROUTINES_ANDROID}:$coroutines")
        api("${Dependencies.COROUTINES_TEST}:$coroutines")
        api("${Dependencies.FLEXBOX}:$flexbox")
        api("${Dependencies.FRAGMENT_KTX}:$fragment")
        api("${Dependencies.GLIDE}:$glide")
        api("${Dependencies.GLIDE_COMPILER}:$glide")
        api("${Dependencies.GSON}:$gson")
        api("${Dependencies.HILT_ANDROID}:$hilt")
        api("${Dependencies.HILT_COMPILER}:$hilt")
        api("${Dependencies.HILT_TESTING}:$hilt")
        api("${Dependencies.JUNIT}:$junit")
        api("${Dependencies.LIFECYCLE_COMPILER}:$lifecycle")
        api("${Dependencies.LIFECYCLE_LIVE_DATA_KTX}:$lifecycle")
        api("${Dependencies.LIFECYCLE_RUNTIME_KTX}:$lifecycle")
        api("${Dependencies.LIFECYCLE_VIEW_MODEL_KTX}:$lifecycle")
        api("${Dependencies.LOTTIE}:$lottie")
        api("${Dependencies.MATERIAL}:$material")
        api("${Dependencies.MOCKITO_CORE}:$mockito")
        api("${Dependencies.PROFILE_INSTALLER}:$profileInstaller")
        api("${Dependencies.ROOM_KTX}:$room")
        api("${Dependencies.ROOM_RUNTIME}:$room")
        api("${Dependencies.OKHTTP}:$okhttp")
        api("${Dependencies.OKHTTP_LOGGING_INTERCEPTOR}:$okhttp")
        api("${Dependencies.RULES}:$rules")
        api("${Dependencies.RUNNER}:$runner")
        api("${Dependencies.SLIDING_PANE_LAYOUT}:$slidingpanelayout")
        api("${Dependencies.TIMBER}:$timber")
        api("${Dependencies.VIEWPAGER2}:$viewpager2")
        api("${Dependencies.COMPOSE_ACTIVITY}:$activity")
        api("${Dependencies.SPLASH_SCREEN}:$splash_screen")
        api("${Dependencies.KTOR_HTTP}:$ktor")
        api("${Dependencies.KOTLIN_SERIALIZATION}:$kotlin_serialization")
        api("${Dependencies.KOIN_ANDROID}:$koin")
        api("${Dependencies.KOIN_CORE_COROUTINES}:$koin")
        api("${Dependencies.KOIN_ANDROID_COMPOSE}:$koin_compose")
    }
}

publishing {
    publications {
        create<MavenPublication>("myPlatform") {
            from(components["javaPlatform"])
        }
    }
}