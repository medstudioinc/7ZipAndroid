cmake_minimum_required(VERSION 3.4.1)

# 设置动态库路径
set(LIB_DIR ${CMAKE_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI})
# 添加动态库
add_library(lib7zr SHARED IMPORTED)
set_target_properties(lib7zr PROPERTIES IMPORTED_LOCATION ${LIB_DIR}/lib7zr.so)

# 根据Android.mk引入头文件
# 设置头文件查找目录
include_directories(src/main/cpp/lib7zr/CPP/7zip/Archive
    src/main/cpp/lib7zr/CPP/7zip/Archive/7z
    src/main/cpp/lib7zr/CPP/7zip/Archive/BZip2
    src/main/cpp/lib7zr/CPP/7zip/Archive/Common
    src/main/cpp/lib7zr/CPP/7zip/Archive/GZip
    src/main/cpp/lib7zr/CPP/7zip/Archive/Cab
    src/main/cpp/lib7zr/CPP/7zip/Archive/Lzma
    src/main/cpp/lib7zr/CPP/7zip/Archive/Tar
    src/main/cpp/lib7zr/CPP/7zip/Archive/Zip
    src/main/cpp/lib7zr/CPP/7zip/Archive/Split
    src/main/cpp/lib7zr/CPP/7zip/Archive/Z
    src/main/cpp/lib7zr/CPP/7zip/Compress
    src/main/cpp/lib7zr/CPP/7zip/Crypto
    src/main/cpp/lib7zr/CPP/7zip/UI/Console
    src/main/cpp/lib7zr/CPP/7zip/UI/Common
    src/main/cpp/lib7zr/CPP/Windows
    src/main/cpp/lib7zr/CPP/Common
    src/main/cpp/lib7zr/CPP/7zip/Common
    src/main/cpp/lib7zr/C
    src/main/cpp/lib7zr/CPP/myWindows
    src/main/cpp/lib7zr/CPP
    src/main/cpp/lib7zr/CPP/include_windows)

# 系统的 library
add_library( native-lib SHARED src/main/cpp/native-lib.cpp )

# 链接库
target_link_libraries( native-lib
                       lib7zr
                       log )