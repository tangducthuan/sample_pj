package extension

import org.gradle.api.Project

inline fun <reified T> Project.getByName(name: String, block: T.() -> Unit) =
    (extensions.findByName(name) as? T)?.block()