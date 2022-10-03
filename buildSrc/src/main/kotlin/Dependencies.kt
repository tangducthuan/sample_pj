/**
 * Created by Thuan Tang on 13/09/2022.
 */
object Dependencies {
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx"
    const val APP_COMPAT = "androidx.appcompat:appcompat"
    const val APP_STARTUP = "androidx.startup:startup-runtime"
    const val BENCHMARK = "androidx.benchmark:benchmark-junit4"
    const val BENCHMARK_MACRO = "androidx.benchmark:benchmark-macro-junit4"
    const val BROWSER = "androidx.browser:browser"
    const val CARDVIEW = "androidx.cardview:cardview"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout"
    const val CORE_KTX = "androidx.core:core-ktx"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android"
    const val COROUTINES_TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test"
    const val EXT_JUNIT = "androidx.test.ext:junit"
    const val FLEXBOX = " com.google.android.flexbox:flexbox"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx"
    const val GLIDE = "com.github.bumptech.glide:glide"
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler"
    const val GSON = "com.google.code.gson:gson"
    const val HILT_ANDROID = "com.google.dagger:hilt-android"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler"
    const val HILT_TESTING = "com.google.dagger:hilt-android-testing"
    const val JUNIT = "junit:junit"
    const val LIFECYCLE_COMPILER = "androidx.lifecycle:lifecycle-compiler"
    const val LIFECYCLE_LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx"
    const val LIFECYCLE_RUNTIME_KTX = "androidx.lifecycle:lifecycle-runtime-ktx"
    const val LIFECYCLE_VIEW_MODEL_KTX = "androidx.lifecycle:lifecycle-viewmodel-ktx"
    const val LOTTIE = "com.airbnb.android:lottie"
    const val MATERIAL = "com.google.android.material:material"
    const val MOCKITO_CORE = "org.mockito:mockito-core"
    const val OKHTTP = "com.squareup.okhttp3:okhttp"
    const val OKHTTP_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor"
    const val PROFILE_INSTALLER = "androidx.profileinstaller:profileinstaller"
    const val ROOM_COMPILER = "androidx.room:room-compiler"
    const val ROOM_KTX = "androidx.room:room-ktx"
    const val ROOM_RUNTIME = "androidx.room:room-runtime"
    const val RULES = "androidx.test:rules"
    const val RUNNER = "androidx.test:runner"
    const val SLIDING_PANE_LAYOUT = "androidx.slidingpanelayout:slidingpanelayout"
    const val TIMBER = "com.jakewharton.timber:timber"
    const val VIEWPAGER2 = "androidx.viewpager2:viewpager2"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core"
    const val NAVIGATION_KTX = "androidx.navigation:navigation-fragment-ktx"
    const val NAVIGATION_DYNAMIC_FEATURE = "androidx.navigation:navigation-dynamic-features-fragment"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx"
    const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose"
    const val COMPOSE_UI = "androidx.compose.ui:ui"
    const val COMPOSE_ACTIVITY = "androidx.activity:activity-compose"
    const val COMPOSE_MATERIAL = "androidx.compose.material:material"
    const val COMPOSE_UI_TOOLING_PREVIEW = "androidx.compose.ui:ui-tooling-preview"
    const val COMPOSE_UI_TOOLING = "androidx.compose.ui:ui-tooling"
    const val COMPOSE_UI_TEST_MANIFEST = "androidx.compose.ui:ui-test-manifest"
    const val COMPOSE_UI_TEST_JUNIT = "androidx.compose.ui:ui-test-junit4"

    val NAVIGATION_DEPS = arrayOf(
        NAVIGATION_UI,
        NAVIGATION_KTX,
        NAVIGATION_DYNAMIC_FEATURE
    )

    val COMPOSE_DEPS = arrayOf(
        COMPOSE_UI,
        COMPOSE_ACTIVITY,
        COMPOSE_MATERIAL,
        COMPOSE_UI_TOOLING_PREVIEW,
        NAVIGATION_COMPOSE
    )

    val COMPOSE_DEBUG_DEPS = arrayOf(
        COMPOSE_UI_TOOLING,
        COMPOSE_UI_TEST_MANIFEST
    )

    val TEST_DEPS = arrayOf(
        JUNIT,
        COROUTINES_TEST
    )
    //Somehow androidTestImplementation not work with BOM platform
    val ANDROID_TEST_DEPS = arrayOf(
        "$EXT_JUNIT:1.1.3",
        "$ESPRESSO_CORE:3.4.0",
        "$COMPOSE_UI_TEST_JUNIT:1.2.1"
    )
}