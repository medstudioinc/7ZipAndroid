package com.pf.a7zipandroid;

/**
 * @author zhaopf
 * @version 1.0
 * @QQ 1308108803
 * @date 2018/2/6
 */
public class ZipCode {

    static {
        System.loadLibrary("native-lib");
    }

    //7zr a xxx.7z xx
    public native static int exec(String cmd);
}