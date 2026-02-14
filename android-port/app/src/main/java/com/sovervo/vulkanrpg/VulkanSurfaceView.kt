package com.sovervo.vulkanrpg

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.Choreographer
import android.view.Surface
import android.view.SurfaceHolder
import android.view.SurfaceView
import com.sovervo.vulkanrpg.scene.SceneLoader

class VulkanSurfaceView(context: Context) : SurfaceView(context), SurfaceHolder.Callback, Choreographer.FrameCallback {
    private val mainHandler = Handler(Looper.getMainLooper())
    @Volatile private var running = false

    init {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        val surface: Surface = holder.surface
        NativeBridge.onSurfaceCreated(surface)
        NativeBridge.loadScene(SceneLoader.loadExampleSceneJson(context))
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        NativeBridge.onSurfaceChanged(width, height)
    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        NativeBridge.onSurfaceDestroyed()
    }

    fun onResumeView() {
        running = true
        Choreographer.getInstance().postFrameCallback(this)
    }

    fun onPauseView() {
        running = false
    }

    override fun doFrame(frameTimeNanos: Long) {
        if (!running) return
        NativeBridge.onFrame(frameTimeNanos)
        mainHandler.post {
            Choreographer.getInstance().postFrameCallback(this)
        }
    }
}
