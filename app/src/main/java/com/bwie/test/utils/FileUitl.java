package com.bwie.test.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUitl {
    private static final String TAG = "FileUitl";


    // 清空文件内容
    public static final void clearFileContent(String path) {
        File f = new File(path);
        if (f.exists() && f.isFile()) {
            try {
                FileWriter wf = new FileWriter(f);
                wf.write("");
                wf.flush();
                wf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
