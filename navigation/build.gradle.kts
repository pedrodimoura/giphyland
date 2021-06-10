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

        testInstrumentationRunner(AppConfiguration.androidTestInstrumentation)
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(AppConfiguration.defaultProguardFile),
                AppConfiguration.proguardRules
            )
        }
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
    implementation(Libs.appCompat)

    testImplementation(TestLibs.junit)
    androidTestImplementation(TestLibs.extJunit)
    androidTestImplementation(TestLibs.espressoCore)
}