#include "Renderer.h"

bool Renderer::onSurfaceCreated(ANativeWindow* window) {
    const uint32_t width = static_cast<uint32_t>(ANativeWindow_getWidth(window));
    const uint32_t height = static_cast<uint32_t>(ANativeWindow_getHeight(window));
    return context_.initialize(window, width, height);
}

void Renderer::onSurfaceChanged(uint32_t width, uint32_t height) {
    context_.resize(width, height);
}

void Renderer::onSurfaceDestroyed() {
    context_.destroy();
}

void Renderer::onFrame(uint64_t frameTimeNanos) {
    float seconds = 0.0f;
    if (lastFrameNanos_ != 0) {
        seconds = static_cast<float>(frameTimeNanos - lastFrameNanos_) / 1'000'000'000.0f;
    }
    lastFrameNanos_ = frameTimeNanos;
    context_.renderFrame(seconds);
}

void Renderer::loadScene(const std::string& /*json*/) {
    // Scene parsing stub. JSON payload from Kotlin is accepted and will be wired
    // into sprite entities in the next iteration.
}
