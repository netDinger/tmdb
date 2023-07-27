/**
 * To define build configuration
 * such as build variant, build flavor, sdk versions
 */

object BuildConfigs {
    const val compileSdk = 33
    const val minSdk = 23
    const val targetSdk = 33

    private const val versionMajor = 0
    private const val versionMinor = 0
    private const val versionPatch = 0
    private const val versionBuild = 1
    private const val versionFlavor = "Beta"

    const val versionName =
        "$versionMajor.$versionMinor.$versionPatch.$versionBuild($versionFlavor)"
    const val versionCode =
        (versionMajor * 10000) + (versionMinor * 1000) + (versionPatch * 100) + versionBuild

    const val debugTag = "(All-in-one)"
}