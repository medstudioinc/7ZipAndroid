//
// Created by zhaopf on 2018/2/6.
//
#include <7zTypes.h>

#ifndef INC_7ZIPANDROID_NATIVE_LIB_H
#define INC_7ZIPANDROID_NATIVE_LIB_H

// 表示这个函数在别的地方实现
// src/main/cpp/lib7zr/CPP/7Zip/UI/Console/Main.cpp
extern int MY_CDECL main
        (
#ifndef _WIN32
        int numArgs, char *args[]
#endif
);

/**
 * 将命令分割
 * @param cmd
 * @param args
 * @param pString
 */
void strArgs(const char *cmd, int &numArgs, char argv[66][1024]);

#endif //INC_7ZIPANDROID_NATIVE_LIB_H