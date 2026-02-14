package com.sovervo.vulkanrpg.scene

import android.content.Context

object SceneLoader {
    fun loadExampleSceneJson(context: Context): String {
        context.assets.open("scenes/example_scene.json").bufferedReader().use {
            return it.readText()
        }
    }
}
