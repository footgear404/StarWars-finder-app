plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.jb_kapt)
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-parcelize")
}

android {
    namespace = "com.semenchuk.details"
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
//  modules
    implementation(project(":core:ui"))
    implementation(project(":core:base"))
    implementation(project(":core:api"))
    implementation(project(":core:storage"))
//    core
    implementation(Dependencies.Core.core_ktx)
    implementation(Dependencies.Core.appcompat)
    implementation(Dependencies.Core.material)
    implementation(Dependencies.Core.navigation_fragment_ktx)
    implementation(Dependencies.Core.navigation_ui_ktx)

    implementation(Dependencies.Core.retrofit)
    implementation(Dependencies.Core.retrofit_converter_moshi)
    implementation(Dependencies.Core.moshi_kotlin)
    implementation(Dependencies.Core.moshi)
    implementation(Dependencies.Core.moshi_kotlin_codegen)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    kapt(Dependencies.Core.moshi_kapt)
//    test
    testImplementation(Dependencies.Core.junit)
    androidTestImplementation(Dependencies.Core.ext_junit)
    androidTestImplementation(Dependencies.Core.espresso_core)

//    Di
    implementation(Dependencies.Di.koin_core)
    implementation(Dependencies.Di.koin_android)
}