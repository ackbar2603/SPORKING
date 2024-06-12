plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-parcelize")
    id("kotlin-kapt")
//    id("com.google.dagger.hilt.android")
    id ("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")

}

android {
    namespace = "com.example.spork"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.spork"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    //AsyncImage
    implementation("io.coil-kt:coil-compose:2.6.0")

    //Navigation
    implementation("androidx.navigation:navigation-compose:$2.7.7")

    //Icon Extended
    implementation ("androidx.compose.material:material-icons-extended:1.6.7")

    //Preferences Data Store
    implementation ("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.preference:preference-ktx:1.2.1")

    //{FIREBASE}
    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-analytics")

//    implementation(platform("androidx.compose:compose-bom:2024.05.00"))


    implementation("com.google.dagger:hilt-android:2.48.1")
    kapt("com.google.dagger:hilt-android-compiler:2.48.1")

//    implementation("androidx.hilt:hilt-navigation-fragment:1.2.0")
//    implementation("androidx.hilt:hilt-work:1.2.0")

//    implementation ("com.google.dagger:hilt-android:2.42")
//    kapt ("com.google.dagger:hilt-android-compiler:2.42")
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")

    //Google Shit
//    implementation ("androidx.credentials:credentials:1.2.2")
//    implementation ("androidx.credentials:credentials-play-services-auth:1.2.2")
//    implementation ("com.google.android.libraries.identity.googleid:googleid:1.5.0-alpha01")

    implementation("com.google.android.gms:play-services-auth:21.2.0")




    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.datastore.preferences.core.jvm)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}