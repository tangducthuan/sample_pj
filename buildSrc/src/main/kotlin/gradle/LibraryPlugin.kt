package gradle

import Dependencies
import Plugins
import extension.*
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies


/**
 * Created by Thuan Tang on 12/09/2022.
 */
class LibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        plugins.apply(
            Plugins.library, Plugins.jvm
        )

        dependencies {
            implementations(
                platform(project(":dependencies")),
            )
            apis(
                Dependencies.KOTLIN_SERIALIZATION
            )
        }
    }
}