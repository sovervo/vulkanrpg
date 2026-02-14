package com.sovervo.vulkanrpg.scene

object ExampleScene {
    val fallback = Scene(
        name = "fallback",
        sprites = listOf(
            Sprite(
                id = "hero",
                texture = "textures/hero.png",
                x = 100f,
                y = 120f,
                scaleX = 1f,
                scaleY = 1f,
                rotationDeg = 0f
            )
        )
    )
}
