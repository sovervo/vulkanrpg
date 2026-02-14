#include <jni.h>
#include <android/native_window_jni.h>

#include "engine/Renderer.h"

static Renderer g_renderer;

extern "C" JNIEXPORT void JNICALL
Java_com_sovervo_vulkanrpg_NativeBridge_onSurfaceCreated(JNIEnv* env, jobject /*thiz*/, jobject surface) {
    ANativeWindow* window = ANativeWindow_fromSurface(env, surface);
    g_renderer.onSurfaceCreated(window);
    ANativeWindow_release(window);
}

extern "C" JNIEXPORT void JNICALL
Java_com_sovervo_vulkanrpg_NativeBridge_onSurfaceChanged(JNIEnv* /*env*/, jobject /*thiz*/, jint width, jint height) {
    g_renderer.onSurfaceChanged(static_cast<uint32_t>(width), static_cast<uint32_t>(height));
}

extern "C" JNIEXPORT void JNICALL
Java_com_sovervo_vulkanrpg_NativeBridge_onSurfaceDestroyed(JNIEnv* /*env*/, jobject /*thiz*/) {
    g_renderer.onSurfaceDestroyed();
}

extern "C" JNIEXPORT void JNICALL
Java_com_sovervo_vulkanrpg_NativeBridge_onFrame(JNIEnv* /*env*/, jobject /*thiz*/, jlong frameTimeNanos) {
    g_renderer.onFrame(static_cast<uint64_t>(frameTimeNanos));
}

extern "C" JNIEXPORT void JNICALL
Java_com_sovervo_vulkanrpg_NativeBridge_loadScene(JNIEnv* env, jobject /*thiz*/, jstring sceneJson) {
    const char* chars = env->GetStringUTFChars(sceneJson, nullptr);
    g_renderer.loadScene(chars ? chars : "");
    if (chars) {
        env->ReleaseStringUTFChars(sceneJson, chars);
    }
}
