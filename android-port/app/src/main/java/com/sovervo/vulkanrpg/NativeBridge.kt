package com.sovervo.vulkanrpg

import android.view.Surface

object NativeBridge {
    init {
        System.loadLibrary("native-lib")
    }

    external fun onSurfaceCreated(surface: Surface)
    external fun onSurfaceChanged(width: Int, height: Int)
    external fun onSurfaceDestroyed()
    external fun onFrame(frameTimeNanos: Long)
    external fun loadScene(sceneJson: String)
}
