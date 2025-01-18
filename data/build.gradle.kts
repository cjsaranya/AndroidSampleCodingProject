plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    packaging {
        resources {
            excludes += "META-INF/gradle/incremental.annotation.processors"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.hilt.android)
    implementation(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose) // Hilt navigation for Compose
    implementation(libs.hilt.android)
    implementation(libs.material)
    testImplementation(libs.junit)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson) // For Gson converter
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging) // For logging HTTP requests
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}