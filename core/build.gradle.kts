import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

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

    implementation(Libraries.ktxCore)
    implementation(Libraries.appCompat)
    implementation(Libraries.material)

    implementation(Libraries.hilt)
//    kapt(Libraries.hiltCompiler)
    kapt(Libraries.hiltKapt)

    implementation(Libraries.viewModelKtx)
    implementation(Libraries.liveDataKtx)
    implementation(Libraries.runtimeKtx)
    implementation(Libraries.lifeCycleExt)

    implementation(Libraries.coroutineAndroid)
    implementation(Libraries.coroutinesCore)
    implementation(Libraries.coroutinePlay)

    implementation(Libraries.retrofit)
    implementation(Libraries.gson)
    implementation(Libraries.converterScalar)
    implementation(Libraries.okhttpLoggingInterceptor)

    implementation(Libraries.roomKtx)
    implementation(Libraries.roomRuntime)
    kapt(Libraries.roomKapt)


    implementation(Libraries.timber)

    implementation(Libraries.glide)
    kapt(Libraries.glideKapt)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.extJunit)
    androidTestImplementation(TestLibraries.espresso)
}

kapt {
    correctErrorTypes = true
}