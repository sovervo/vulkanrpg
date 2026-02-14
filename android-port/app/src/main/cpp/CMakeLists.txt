cmake_minimum_required(VERSION 3.22.1)
project(vulkanrpg_native)

set(CMAKE_CXX_STANDARD 20)

add_library(native-lib SHARED
    native-lib.cpp
    engine/VulkanContext.cpp
    engine/Renderer.cpp
)

find_library(log-lib log)
find_library(android-lib android)
find_library(vulkan-lib vulkan)


target_include_directories(native-lib PRIVATE ${CMAKE_CURRENT_SOURCE_DIR})

target_compile_definitions(native-lib PRIVATE VK_USE_PLATFORM_ANDROID_KHR=1)

target_link_libraries(native-lib
    ${log-lib}
    ${android-lib}
    ${vulkan-lib})
