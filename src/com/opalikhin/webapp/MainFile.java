package com.opalikhin.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class MainFile {
    public static void main(String[] args) {
        String filePath = "./.gitignore";

        File file = new File(filePath);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        File dir = new File("./src/com/opalikhin/webapp");
        System.out.println(dir.getName());
        printDir(dir);

        try (FileInputStream fis = new FileInputStream(filePath)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printDir (File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getName());
                if (f.isDirectory()) {
                    printDir(f);
                }
            }
        }
    }
}
