plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("kotlinx-serialization")
}

android {
    compileSdkVersion(AppConfiguration.compileSdk)
    buildToolsVersion(AppConfiguration.buildToolsVersion)

    defaultConfig {
        applicationId = "com.github.pedrodimoura.giphyland"
        minSdkVersion(AppConfiguration.minSdk)
        targetSdkVersion(AppConfiguration.targetSdk)
        versionCode = AppConfiguration.versionCode
        versionName = AppConfiguration.versionName

        testInstrumentationRunner = AppConfiguration.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(AppConfiguration.defaultProguardFile),
                AppConfiguration.proguardRules
            )
            buildConfigField("String", "BASE_URL", System.getenv("BASE_URL"))
            buildConfigField("String", "API_KEY_HEADER", System.getenv("API_KEY_HEADER"))
            buildConfigField("String", "API_KEY", System.getenv("API_KEY"))
        }
        getByName("debug") {
            isMinifyEnabled = false
            val properties = org.jetbrains.kotlin.konan.properties.Properties()
            val file: File = rootProject.file("debug.properties")
            properties.load(file.inputStream())

            buildConfigField("String", "BASE_URL", properties.getProperty("baseUrl"))
            buildConfigField("String", "API_KEY_HEADER", properties.getProperty("apiKeyHeader"))
            buildConfigField("String", "API_KEY", properties.getProperty("apiKey"))
        }
    }
    compileOptions {
        sourceCompatibility(AppConfiguration.javaCompatibilityVersion)
        targetCompatibility(AppConfiguration.javaCompatibilityVersion)
    }
    kotlinOptions {
        jvmTarget = AppConfiguration.jvmTarget
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Libs.kotlinStdLib)

    implementation(project(LocalLibs.networking))

    implementation(Libs.coreKtx)
    implementation(Libs.appCompat)

    implementation(Libs.coil)
    implementation(Libs.coilGifDecoder)

    implementation(Libs.fragmentKtx)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)

    implementation(Libs.lifecycleViewModelKtx)
    implementation(Libs.lifecycleLiveDataKtx)

    implementation(Libs.coroutinesAndroid)

    // Dagger Hilt
    implementation(Libs.hiltAndroid)
    kapt(Libs.hiltCompiler)
    androidTestImplementation(TestLibs.hiltAndroidTesting)
    kaptAndroidTest(TestLibs.hiltCompiler)
    testImplementation(TestLibs.hiltAndroidTesting)
    kaptTest(TestLibs.hiltCompiler)

    // Check if is necessary
    debugImplementation(TestLibs.fragmentTesting)

    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espressoCore)
}