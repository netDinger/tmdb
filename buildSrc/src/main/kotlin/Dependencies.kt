/**
 * Created by <Pyae Phyo Kyaw>
 * To define plugins
 */
object BuildPlugins {
    val android by lazy { "com.android.tools.build:gradle:${Versions.gradlePlugin}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
}

/**
 * To define dependencies
 */
object Dependencies {
    // val appCompat by lazy { "androidx.appcompat:appcompat:${Versions.appCompat}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}" }
    val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }

    //for testing
    //testImplementation
    val junit by lazy { "junit:junit:${Versions.jUnit}" }

    //androidTestImplementation
    val junitExt by lazy { "androidx.test.ext:junit:${Versions.junitExt}" }
    val uiJunit by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val espresso by lazy { "androidx.test.espresso:espresso-core:${Versions.espresso}" }

    //debugImplementation
    val uiTooling by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val uiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }
    //val mockito by lazy { "org.mockito.kotlin:mockito-kotlin:${Versions.mockito}" }

    const val composeUi = "androidx.compose.ui:ui:${Versions.compose}"
    const val composeActivity = "androidx.activity:activity-compose:${Versions.composeActivity}"
    const val material3 = "androidx.compose.material3:material3:${Versions.material3}"
    const val iconExt = "androidx.compose.material:material-icons-extended:${Versions.materialIcon}"
    const val uiPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose}"
    const val runTimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.runtimeKtx}"
    const val navigation = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    const val composeNavigation = "androidx.navigation:navigation-compose:${Versions.navigation}"
    const val composeConstraint = "androidx.constraintlayout:constraintlayout-compose:${Versions.constraintLayout}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

}

object Dagger {
    const val dagger = "com.google.dagger:hilt-android:${Versions.dagger}"

    //kapt
    const val daggerCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
    const val daggerCompose = "androidx.hilt:hilt-navigation-compose:${Versions.hilt}"
}

object JetpackComponents {
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.lifecycle}"
    val paging by lazy { "androidx.paging:paging-compose:${Versions.paging}" }

    val room by lazy { "androidx.room:room-runtime:${Versions.room}" }

    //annotationProcessor
    val roomAnnotation by lazy { "androidx.room:room-compiler:${Versions.room}" }

    // Coil
    const val coil = "io.coil-kt:coil-compose:${Versions.coil}"

    //DataStore
    const val datastore = "androidx.datastore:datastore-preferences:${Versions.dataStore}"
}

object Network {
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val okhttp3 = "com.squareup.okhttp3:okhttp:${Versions.okhttp3}"
    const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp3}"

}

