package com.pf.a7zipandroid;

import android.content.Context;
import android.os.Build;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author zhaopf
 * @version 1.0
 * @QQ 1308108803
 * @date 2018/2/6
 */
public class CommandUtils {
    /**
     * 拷贝文件
     *
     * @param context
     * @param binary
     * @return
     */
    public static boolean copyAssets2File(Context context, String binary) {
        // /data/data/package
        File filesDirectory = context.getFilesDir();
        boolean ret = false;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            //根据cpu 拷贝不同的可执行文件
            if (Build.CPU_ABI.startsWith("armeabi") || Build.CPU_ABI.equals("x86")) {
                is = context.getAssets().open("lib7zr/" + Build.CPU_ABI + "/" + binary);
            } else {
                return false;
            }
            fos = new FileOutputStream(new File(filesDirectory, binary));
            byte[] buffer = new byte[2048];
            int n;
            while ((n = is.read(buffer)) != -1) {
                fos.write(buffer, 0, n);
            }
            fos.flush();
            ret = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != fos) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return ret;
    }

    public static String inputStream2String(InputStream inputStream) {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            StringBuilder sb = new StringBuilder();
            while ((str = r.readLine()) != null) {
                sb.append(str);
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}