package com.sovervo.vulkanrpg

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {
    private lateinit var surfaceView: VulkanSurfaceView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        surfaceView = VulkanSurfaceView(this)
        setContentView(surfaceView)
    }

    override fun onResume() {
        super.onResume()
        surfaceView.onResumeView()
    }

    override fun onPause() {
        surfaceView.onPauseView()
        super.onPause()
    }
}
