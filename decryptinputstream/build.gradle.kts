plugins {
    id("com.android.library")
}

android {
    compileSdkVersion(31)
    buildToolsVersion = "30.0.3"

    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
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
}

fun gzip(intput: File, output: File) {
    val bos = ByteArrayOutputStream(FileInputStream(input))
    GZIPOutputStream(bos).bufferedWriter(UTF_8).use { it.write(content) }
    return bos.toByteArray()
}

tasks.register("myTask") {
    doFirst {
        val input = File(projectDir, "src/main/font/font")
        val output = File(projectDir, "src/main/font/font.gz")
        println("myTask")
    }
}

dependencies {

    testImplementation("junit:junit:4.13.2")
    testImplementation("com.google.truth:truth:1.0.1")
    testImplementation("com.google.truth.extensions:truth-java8-extension:1.0.1")
    testImplementation("com.google.guava:guava:27.0.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}