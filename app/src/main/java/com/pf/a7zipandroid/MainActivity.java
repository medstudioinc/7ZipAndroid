package com.pf.a7zipandroid;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File src = new File(Environment.getExternalStorageDirectory(), "7-Zip");
        File out = new File(Environment.getExternalStorageDirectory(), "7-Zip.7z");
        File out2 = new File(Environment.getExternalStorageDirectory(), "7-Zip_code");
        ZipCode.exec("7zr a " + out.getAbsolutePath() + " " + src.getAbsolutePath() + " -mx=9");
        ZipCode.exec("7zr x " + out.getAbsolutePath() + " -o" + out2.getAbsolutePath());
    }

    /**
     * 将可执行文件拷贝到app私有目录下
     *
     * @param view
     */
    public void load(View view) {
        boolean result = ZipHelper.loadBinary(this, "7zr");
        Toast.makeText(this, "加载7zr 结果:" + result, Toast.LENGTH_SHORT).show();
    }

    /**
     * 压缩
     * 7z a  [输出文件] [待压缩文件/目录] -mx=9
     * 7z a /sdcard/7-Zip.7z /sdcard/7-Zip -mx=9
     *
     * @param view
     */
    public void pack(View view) {
        File src = new File(Environment.getExternalStorageDirectory(), "7-Zip");
        File out = new File(Environment.getExternalStorageDirectory(), "7-Zip.7z");
        String strCommand = "7zr a " + out.getAbsolutePath() + " " + src.getAbsolutePath() + " -mx=9";
        ZipHelper.execute(this, strCommand, new ZipHelper.OnResultListener() {
            @Override
            public void onSuccess(String msg) {
                Log.e(TAG, "执行成功");
            }

            @Override
            public void onFailure(int errorno, String msg) {
                Log.e(TAG, "执行失败:");
                Log.e(TAG, " 错误代码:" + errorno);
                Log.e(TAG, " 错误输出:" + msg);
            }

            @Override
            public void onProgress(String msg) {
                Log.e(TAG, "正在执行:" + msg);
            }
        });
    }

    /**
     * 解压
     * 7z x [压缩文件]  -o[输出目录]
     *
     * @param view
     */
    public void unpack(View view) {
        File src = new File(Environment.getExternalStorageDirectory(), "7-Zip.7z");
        File out = new File(Environment.getExternalStorageDirectory(), "7-Zip-unpack");
        String strCommand = "7zr x " + src.getAbsolutePath() + " -o" + out.getAbsolutePath();
        ZipHelper.execute(this, strCommand, new ZipHelper.OnResultListener() {
            @Override
            public void onSuccess(String msg) {
                Log.e(TAG, "执行成功");
            }

            @Override
            public void onFailure(int errorno, String msg) {
                Log.e(TAG, "执行失败:");
                Log.e(TAG, " 错误代码:" + errorno);
                Log.e(TAG, " 错误输出:" + msg);
            }

            @Override
            public void onProgress(String msg) {
                Log.e(TAG, "正在执行:" + msg);
            }
        });
    }
}