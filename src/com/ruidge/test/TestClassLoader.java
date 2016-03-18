package com.ruidge.test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class TestClassLoader {

    //http://blog.csdn.net/xyang81/article/details/7292380#0-tsina-1-29883-397232819ff9a47a7b7e80a40613cfe1
    
    private Object mObject;

    public void setmTestClassLoader(Object object) {
        System.out.println("setmTestClassLoader");
        this.mObject = object;
    }

    public static void main(String[] args) {
        String path = "D:\\com\\ruidge\\haha.class";
        ClassLoader loader = new TestClassLoader().getClass().getClassLoader();
        try {
            Class<?> clazz = loader.loadClass("java.lang.String");
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                // System.out.println(m.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ClassLoader fileLoader = new LocalFileClassLoader(path);
        ClassLoader fileLoaderB = new LocalFileClassLoader(path);
        try {
            Class<?> clazz = fileLoader.loadClass("com.ruidge.TestClassLoader");
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                // System.out.println(m.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ClassLoader sysLoader = ClassLoader.getSystemClassLoader();
        try {
            Class<?> clazz = sysLoader.loadClass("com.ruidge.TestSort");
            Method[] methods = clazz.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println(m.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("-------------------------");
        try {
            Class<?> clazz1 = loader.loadClass("com.ruidge.TestClassLoader");
            Class<?> clazz2 = fileLoader.loadClass("com.ruidge.TestClassLoader");
            Class<?> clazz3 = sysLoader.loadClass("com.ruidge.TestClassLoader");
            System.out.println(clazz1 == clazz2);
            System.out.println(clazz1 == clazz3);
            System.out.println(clazz2 == clazz3);
            Object instance1 = clazz1.newInstance();
            Object instance2 = clazz2.newInstance();
            Object instance3 = clazz3.newInstance();
            clazz1.getMethod("setmTestClassLoader", Object.class).invoke(instance1, instance2);
            clazz1.getMethod("setmTestClassLoader", Object.class).invoke(instance1, instance3);
            clazz2.getMethod("setmTestClassLoader", Object.class).invoke(instance2, instance3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        try {
            Class<?> class1 = fileLoader.loadClass("com.ruidge.TestClassLoader");
            Class<?> classB = fileLoaderB.loadClass("com.ruidge.TestClassLoader");
            Object instance1 = class1.newInstance();
            Object instance2 = classB.newInstance();
            class1.getMethod("setmTestClassLoader", Object.class).invoke(instance1, instance2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("-------------------------");
        ClassLoader cl = fileLoader;
        while(cl != null){
            System.out.println(cl.getClass());
            cl = cl.getParent();
        }
        System.out.println(cl);
    }

    static class LocalFileClassLoader extends ClassLoader {
        private String filePath;

        public LocalFileClassLoader(String filePath) {
            this.filePath = filePath;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            System.out.println("调用自定义的findClass()");
            Class<?> clazz;
            byte[] data = getByteData(filePath);
            if (data == null) {
                throw new ClassNotFoundException();
            }
            clazz = defineClass("haha", data, 0, data.length);
            return clazz;
        }

        private byte[] getByteData(String filePath2) {
            InputStream is = null;
            try {
                is = new FileInputStream(new File(filePath));
                byte[] buff = new byte[1024 * 4];
                int len = -1;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((len = is.read(buff)) != -1) {
                    baos.write(buff, 0, len);
                }
                return baos.toByteArray();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return null;
        }
    }
}
