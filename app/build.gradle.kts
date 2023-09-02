plugins {
    id(Plugins.application)
    id(Plugins.android)
}

android {
    namespace = Configs.applicationId
    compileSdk = Configs.compileSdk

    defaultConfig {
        applicationId = Configs.applicationId
        minSdk = Configs.minSdk
        targetSdk = Configs.targetSdk
        versionCode = Configs.versionCode
        versionName = Configs.versionName

        testInstrumentationRunner = Configs.testInstrumentationRunner
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
    implementation(project(":core:api"))
    implementation(project(":feature:search"))
    implementation(project(":feature:favorite"))

//    core
    implementation(Dependencies.Core.core_ktx)
    implementation(Dependencies.Core.appcompat)
    implementation(Dependencies.Core.material)
    implementation(Dependencies.Core.constraintlayout)
    implementation(Dependencies.Core.livedata)
    implementation(Dependencies.Core.view_model)
    implementation(Dependencies.Core.navigation_fragment_ktx)
    implementation(Dependencies.Core.navigation_ui_ktx)
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")

//    Di
    implementation(Dependencies.Di.koin_core)
    implementation(Dependencies.Di.koin_android)


//    test
    testImplementation(Dependencies.Core.junit)
    androidTestImplementation(Dependencies.Core.ext_junit)
    androidTestImplementation(Dependencies.Core.espresso_core)
}