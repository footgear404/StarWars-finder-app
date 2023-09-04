object Dependencies {
    object Core {
        const val core_ktx = "androidx.core:core-ktx:1.10.1"
        const val appcompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.9.0"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:2.6.1"
        const val view_model = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1"
        const val navigation_fragment_ktx = "androidx.navigation:navigation-fragment-ktx:2.6.0"
        const val navigation_ui_ktx = "androidx.navigation:navigation-ui-ktx:2.6.0"

        //    Retrofit & Moshi
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofit_converter_moshi = "com.squareup.retrofit2:converter-moshi:2.9.0"
        const val moshi_kotlin = "com.squareup.moshi:moshi-kotlin:1.15.0"
        const val moshi = "com.squareup.moshi:moshi:1.15.0"
        const val moshi_kotlin_codegen = "com.squareup.moshi:moshi-kotlin-codegen:1.15.0"
        const val moshi_kapt = "com.squareup.moshi:moshi-kotlin-codegen:1.15.0"

        //    Room
        const val room_runtime = "androidx.room:room-runtime:2.5.2"
        const val room_ktx = "androidx.room:room-ktx:2.5.2"
        const val room_compiler = "androidx.room:room-compiler:2.5.2"
        const val room_kapt = "androidx.room:room-compiler:2.5.2"

        //    Tests
        const val junit = "junit:junit:4.13.2"
        const val ext_junit = "androidx.test.ext:junit:1.1.5"
        const val espresso_core = "androidx.test.espresso:espresso-core:3.5.1"
    }

    object Di {
        const val koin_core = "io.insert-koin:koin-core:3.1.2"
        const val koin_android = "io.insert-koin:koin-android:3.1.2"
    }

}