package com.ruidge.test;

import java.io.File;
import java.math.BigDecimal;

public class TestFile {

    public static void main(String[] args) {

        String path = "/abc/edf/f.jpg";
        File file = new File(path);
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        System.out.println(file.getPath());

    }

}
