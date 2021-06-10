import org.gradle.api.JavaVersion

object AppConfiguration {
    const val compileSdk = 30
    const val minSdk = 21
    const val targetSdk = 30
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "30.0.3"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val defaultProguardFile = "proguard-android-optimize.txt"
    const val proguardRules = "proguard-rules.pro"

    const val jvmTarget = "1.8"

    val javaCompatibilityVersion = JavaVersion.VERSION_1_8

    val apiKeyHeader = Field("String", "API_KEY_HEADER", "\"api_key\"")
    val apiKey = Field("String", "API_KEY", "\"nPUSUTIwiRPQT4s6ljxTP0E5I4TiaTWs\"")
    val baseUrl = Field("String", "BASE_URL", "\"https://api.giphy.com/v1/\"")
}

data class Field<T>(val type: String, val name: String, val value: T)