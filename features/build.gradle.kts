plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.jetBrainKotlin)
    id(BuildPlugins.hiltAndroid)
    kotlin(BuildPlugins.kaptAndroid)
}

android {
    compileSdk = 31

    defaultConfig {
        minSdk = 21
        targetSdk = 31

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
    }

}

dependencies {
    implementation(project(":core"))
    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
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

    implementation(Libraries.recyclerViewSelection)

    implementation(Libraries.navFragment)
    implementation(Libraries.navUi)
    implementation(Libraries.navFragmentKtx)
    implementation(Libraries.navUiKtx)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.extJunit)
    androidTestImplementation(TestLibraries.espresso)
}

kapt {
    correctErrorTypes = true
}