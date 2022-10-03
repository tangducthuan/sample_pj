package extension

import org.gradle.api.artifacts.Dependency
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.implementation(dependency: Any): Dependency? =
    add("implementation", dependency)

fun DependencyHandlerScope.implementations(vararg dependencies: Any) =
    dependencies.forEach { implementation(it) }

fun DependencyHandlerScope.api(dependency: Any): Dependency? =
    add("api", dependency)

fun DependencyHandlerScope.apis(vararg dependencies: Any) =
    dependencies.forEach { api(it) }

fun DependencyHandlerScope.testImplementation(dependency: Any): Dependency? =
    add("testImplementation", dependency)

fun DependencyHandlerScope.testImplementations(vararg dependencies: Any) =
    dependencies.forEach { testImplementation(it) }

fun DependencyHandlerScope.androidTestImplementation(dependency: Any): Dependency? =
    add("androidTestImplementation", dependency)

fun DependencyHandlerScope.androidTestImplementations(vararg dependencies: Any) =
    dependencies.forEach { androidTestImplementation(it) }

fun DependencyHandlerScope.debugImplementation(dependency: Any): Dependency? =
    add("debugImplementation", dependency)

fun DependencyHandlerScope.debugImplementations(vararg dependencies: Any) =
    dependencies.forEach { debugImplementation(it) }
