
plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.jetBrainKotlin)
    kotlin(BuildPlugins.kaptAndroid)
    id(BuildPlugins.hiltAndroid)
}

android {
    compileSdkVersion(AndroidSdk.compile)


    defaultConfig {
        applicationId = "com.showti.temphilt.multi"
//        minSdk = AndroidSdk.min
//        targetSdk = AndroidSdk.target
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = ConfigData.versionCode
        versionName = ConfigData.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        dataBinding = true
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

}

dependencies {

    implementation(project(":core"))
    implementation(project(":features"))
//    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)
    implementation(Libraries.material)
    implementation(Libraries.hilt)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
//    kapt(Libraries.hiltCompiler)
    kapt(Libraries.hiltKapt)

    implementation(Libraries.activityKtx)
    implementation(Libraries.fragmentKtx)

    implementation(Libraries.viewModelKtx)
    implementation(Libraries.liveDataKtx)
    implementation(Libraries.runtimeKtx)
    implementation(Libraries.lifeCycleExt)

    implementation(Libraries.coroutineAndroid)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinePlay)

    implementation(Libraries.glide)
    kapt(Libraries.glideKapt)

    implementation(Libraries.navFragment)
    implementation(Libraries.navUi)
    implementation(Libraries.navFragmentKtx)
    implementation(Libraries.navUiKtx)


    testImplementation (TestLibraries.junit4)
    androidTestImplementation (TestLibraries.testRunner)
    androidTestImplementation (TestLibraries.espresso)
}

kapt {
    correctErrorTypes = true
}