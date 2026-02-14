#pragma once

#include "VulkanContext.h"
#include <android/native_window.h>
#include <string>

class Renderer {
public:
    bool onSurfaceCreated(ANativeWindow* window);
    void onSurfaceChanged(uint32_t width, uint32_t height);
    void onSurfaceDestroyed();
    void onFrame(uint64_t frameTimeNanos);
    void loadScene(const std::string& json);

private:
    VulkanContext context_;
    uint64_t lastFrameNanos_ = 0;
};
