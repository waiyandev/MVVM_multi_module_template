const val kotlinVersion = "1.6.10"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "7.1.2"
        const val hiltVersion = "2.40" //2.38.1
        const val navigationVersion = "2.4.1"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val hiltGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val navigationGradlePlugin = "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigationVersion}"
    const val androidApplication = "com.android.application"
    const val jetBrainKotlin = "org.jetbrains.kotlin.android"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val androidExtensions = "android-extensions"
    const val hiltAndroid = "dagger.hilt.android.plugin"
    const val kaptAndroid = "kapt"
    const val androidLibrary = "com.android.library"
    const val navigation = "androidx.navigation.safeargs"
    const val navigationKotlin = "androidx.navigation.safeargs.kotlin"

}

object AndroidSdk {
    const val min = 21
    const val compile = 31
    const val target = compile
}

object ConfigData {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Libraries {
    private object Versions {
        const val jetpack = "1.4.1"
        const val constraintLayout = "2.1.3"
        const val ktx = "1.7.0"
        const val material = "1.5.0"
        const val hilt = "2.40"
        const val coroutines = "1.4.3"
        const val lifeCycle = "2.4.1"
        const val lifeCycleExt = "2.2.0"
        const val retrofit = "2.9.0"
        const val okhttp3 = "4.9.1"
        const val room = "2.4.2"
        const val timber = "4.7.1"
        const val activity = "1.4.0"
        const val glide = "4.12.0"
        const val hiltCompiler = "1.0.0"
        const val fragment = "1.4.1"
        const val nav = "2.4.1"
        const val recyclerView = "1.1.0"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val hiltViewModel = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hilt}"
    const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
    const val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hilt}"
    const val hiltCompiler = "androidx.hilt:hilt-compiler:${Versions.hiltCompiler}"
    const val coroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    const val coroutineAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val coroutinePlay =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifeCycle}"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"
    const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifeCycle}"
    const val lifeCycleExt = "androidx.lifecycle:lifecycle-extensions:${Versions.lifeCycleExt}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val converterScalar = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
    const val okhttpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"
    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomKapt = "androidx.room:room-compiler:${Versions.room}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"
    const val activityKtx = "androidx.activity:activity-ktx:${Versions.activity}"
    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideKapt = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    const val navFragment = "androidx.navigation:navigation-fragment:${Versions.nav}"
    const val navUi = "androidx.navigation:navigation-fragment:${Versions.nav}"
    const val navFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    const val navUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    const val recyclerViewSelection = "androidx.recyclerview:recyclerview-selection:${Versions.recyclerView}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.13.2"
        const val testRunner = "1.1.0-alpha4"
        const val espresso = "3.4.0"
        const val extJunit = "1.1.3"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}