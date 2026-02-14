package com.sovervo.vulkanrpg.scene

data class Scene(
    val name: String,
    val sprites: List<Sprite>
)

data class Sprite(
    val id: String,
    val texture: String,
    val x: Float,
    val y: Float,
    val scaleX: Float,
    val scaleY: Float,
    val rotationDeg: Float
)
