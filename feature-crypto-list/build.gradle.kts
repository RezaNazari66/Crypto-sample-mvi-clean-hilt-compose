plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.junit)
    alias(libs.plugins.kotlin)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ktlint)
}

android {
    compileSdk = 33
    namespace = "com.rezanazari.feature_crypto_list"

    defaultConfig {
        minSdk = 24
        targetSdk = 33

        testInstrumentationRunner = "eu.krzdabrowski.starter.core.utils.HiltTestRunner"
    }

    buildFeatures {
        compose = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            consumerProguardFiles("proguard-rules.pro")
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true

        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    kotlinOptions {
        freeCompilerArgs = listOf(
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api"
        )
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    sourceSets {
        getByName("androidTest") {
            java.srcDir(project(":core").file("src/androidTest/java"))
        }
        getByName("test") {
            java.srcDir(project(":core").file("src/test/java"))
        }
    }
}

dependencies {
    implementation(project(":core"))

    implementation(platform(libs.compose.bom))
    implementation(libs.accompanist.swipe.refresh)
    implementation(libs.coil)
    implementation(libs.compose.material3)
    implementation(libs.hilt)
    implementation(libs.kotlin.coroutines)
    implementation(libs.navigation)
    implementation(libs.navigation.hilt)
    implementation(libs.retrofit)
    implementation(libs.timber)
    kapt(libs.hilt.compiler)
    implementation(libs.moshi)
    coreLibraryDesugaring(libs.desugar)
}
