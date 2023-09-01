plugins {
    id(Plugins.library)
    id(Plugins.android)
}

android {
    namespace = "com.semenchuk.favorite"
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.minSdk

        testInstrumentationRunner = Configs.testInstrumentationRunner
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
        sourceCompatibility = Configs.javaVersion
        targetCompatibility = Configs.javaVersion
    }
    kotlinOptions {
        jvmTarget = Configs.jvmTarget
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(project(":core:ui"))

    implementation(Dependencies.Core.core_ktx)
    implementation(Dependencies.Core.appcompat)
    implementation(Dependencies.Core.material)
    implementation(Dependencies.Core.navigation_fragment_ktx)
    implementation(Dependencies.Core.navigation_ui_ktx)
    testImplementation(Dependencies.Core.junit)
    androidTestImplementation(Dependencies.Core.ext_junit)
    androidTestImplementation(Dependencies.Core.espresso_core)
}