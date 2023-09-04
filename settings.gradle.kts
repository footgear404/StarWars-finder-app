pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "StarWars-finder-app"
include(":app")
include(":core:ui")
include(":core:base")
include(":core:api")
include(":core:storage")
include(":feature:search")
include(":feature:favorite")
include(":feature:details")
