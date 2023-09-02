import org.gradle.api.JavaVersion

object Configs {
    const val compileSdk = 33
    const val applicationId = "com.semenchuk.starwars_finder_app"
    const val minSdk = 26
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    val javaVersion = JavaVersion.VERSION_18
    const val jvmTarget = "18"

    object BuildTypes {
        const val isMinifyEnabled = true
        const val proguard_file = "proguard-android-optimize.txt"
        const val proguard_rules = "proguard-rules.pro"

    }
}
