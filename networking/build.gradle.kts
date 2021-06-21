plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdkVersion(AppConfiguration.compileSdk)
    buildToolsVersion(AppConfiguration.buildToolsVersion)

    defaultConfig {
        minSdkVersion(AppConfiguration.minSdk)
        targetSdkVersion(AppConfiguration.targetSdk)
        versionCode = AppConfiguration.versionCode
        versionName = AppConfiguration.versionName

        testInstrumentationRunner = AppConfiguration.androidTestInstrumentation
    }

    compileOptions {
        sourceCompatibility(AppConfiguration.javaCompatibilityVersion)
        targetCompatibility(AppConfiguration.javaCompatibilityVersion)
    }
    kotlinOptions {
        jvmTarget = AppConfiguration.jvmTarget
    }
}

dependencies {
    implementation(Libs.kotlinStdLib)
    implementation(Libs.coreKtx)

    api(Libs.retrofit)

    api(Libs.okHttp)
    api(Libs.loggingInterceptor)
    testImplementation(TestLibs.mockWebServer)

    api(Libs.gson)
    api(Libs.gsonRetrofitConverter)

    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espressoCore)
}