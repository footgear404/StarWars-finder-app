plugins {
    id(Plugins.library)
    id(Plugins.android)
    id(Plugins.jb_kapt)
}

android {
    namespace = "com.semenchuk.storage"
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
    implementation(project(":core:base"))
    implementation(project(":core:api"))
//    core
    implementation(Dependencies.Core.core_ktx)
    implementation(Dependencies.Core.appcompat)
    implementation(Dependencies.Core.material)
    implementation(Dependencies.Core.navigation_fragment_ktx)
    implementation(Dependencies.Core.navigation_ui_ktx)

    //    Room
    implementation(Dependencies.Core.room_runtime)
    implementation(Dependencies.Core.room_ktx)
    annotationProcessor(Dependencies.Core.room_compiler)
    kapt(Dependencies.Core.room_kapt)

//    test
    testImplementation(Dependencies.Core.junit)
    androidTestImplementation(Dependencies.Core.ext_junit)
    androidTestImplementation(Dependencies.Core.espresso_core)

//    Di
    implementation(Dependencies.Di.koin_core)
    implementation(Dependencies.Di.koin_android)
}