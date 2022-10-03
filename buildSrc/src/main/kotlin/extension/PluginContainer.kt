package extension

import org.gradle.api.plugins.PluginContainer


/**
 * Created by Thuan Tang on 12/09/2022.
 */
fun PluginContainer.apply(vararg ids: String) = ids.forEach { apply(it) }