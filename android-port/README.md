# VulkanRPG Android Skeleton

Native Android (Kotlin + NDK Vulkan) skeleton for porting the browser-based JS engine.

## Included

- Android app module with Kotlin activity + `SurfaceView` render loop.
- JNI bridge to native C++ renderer.
- Vulkan initialization skeleton: instance, Android surface, physical/logical device, swapchain, render pass, framebuffers, command buffers, sync objects.
- Minimal frame loop with clear pass and placeholder draw call path.
- Scene system stub loading JSON from assets.
- Shader source files and utility scripts for SPIR-V compilation.

## Dependencies

- Android Studio (Ladybug+ recommended)
- Android SDK Platform 34
- Android NDK r26+
- CMake 3.22.1+
- Vulkan-capable Android device/emulator
- `glslangValidator` (optional, for shader compilation scripts)

## Build

```bash
cd android-port
./gradlew assembleDebug
```

Install:

```bash
./gradlew installDebug
```

## Current status / next steps

This skeleton focuses on architecture and Vulkan bring-up. To reach feature parity incrementally:

1. Complete graphics pipeline creation from `app/src/main/cpp/shaders/spv/*.spv`.
2. Add vertex/index buffers for quad rendering.
3. Add texture upload + sampler descriptors.
4. Parse `example_scene.json` into native sprite entities.
5. Apply transform matrices per sprite and camera.

## Structure overview

See:
- `app/src/main/java/com/sovervo/vulkanrpg/` for lifecycle + JNI + scene loader.
- `app/src/main/cpp/` for Vulkan engine.
- `app/src/main/assets/` for scene and texture inputs.
- `tools/shaders/` for shader pipeline scripts.
