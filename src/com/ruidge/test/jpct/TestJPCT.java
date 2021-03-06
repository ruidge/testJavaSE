package com.ruidge.test.jpct;

import com.threed.jpct.DeSerializer;
import com.threed.jpct.Object3D;
import com.threed.jpct.Texture;
import com.threed.jpct.TextureManager;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class TestJPCT {
    public static void main(String[] args) {
//        serialFu();
//        serialMascot();
//        serialLantern();
//        serialCake();
        serialBox();
    }

    private static void serialBox() {
        String mascotPath = "file/apple.3ds";
        float mascotScale = 1f / 5;
        try {
            FileInputStream fuStream = new FileInputStream(mascotPath);
            Object3D object3D = JPCTUtil.load3DModel(fuStream, mascotScale);
            object3D.compile();
            object3D.strip();
            object3D.build();
            DeSerializer deSerializer = new DeSerializer();
            deSerializer.serialize(object3D, new FileOutputStream("file/apple.3ds.serial"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serialCake() {
        String mascotPath = "file/cake3.3ds";
        float mascotScale = 1f / 5;
        try {
            FileInputStream fuStream = new FileInputStream(mascotPath);
            Object3D object3D = JPCTUtil.load3DModel(fuStream, mascotScale);
            object3D.compile();
            object3D.strip();
            object3D.build();
            DeSerializer deSerializer = new DeSerializer();
            deSerializer.serialize(object3D, new FileOutputStream("file/cake.3ds.serial"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serialMascot() {
        String mascotPath = "file/mascot3.3ds";
        float mascotScale = 1f / 5;
        try {
            FileInputStream fuStream = new FileInputStream(mascotPath);
            Object3D object3D = JPCTUtil.load3DModel(fuStream, mascotScale);
            object3D.compile();
            object3D.strip();
            object3D.build();
            DeSerializer deSerializer = new DeSerializer();
            deSerializer.serialize(object3D, new FileOutputStream("file/mascot.3ds.serial"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void serialFu() {
        String fuPath = "file/fu3.3ds";
        float fuScale = 1f / 5;
        String textureFu = "TextureFu";
        try {
            FileInputStream fuStream = new FileInputStream(fuPath);
//            Texture texture = new Texture(JPCTUtil.getTextureBitmap(fuStream));
//            TextureManager.getInstance().addTexture(textureFu, texture);
            Object3D object3D = JPCTUtil.load3DModel(fuStream, fuScale);
//            object3D.setTexture(textureFu);
            object3D.compile();
            object3D.strip();
            object3D.build();
            DeSerializer deSerializer = new DeSerializer();
            deSerializer.serialize(object3D, new FileOutputStream("file/fu.3ds.serial"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void serialLantern() {
        String fuPath = "file/lantern3.3ds";
        float fuScale = 1f / 5;
        try {
            FileInputStream fuStream = new FileInputStream(fuPath);
            Object3D object3D = JPCTUtil.load3DModel(fuStream, fuScale);
            object3D.compile();
            object3D.strip();
            object3D.build();
            DeSerializer deSerializer = new DeSerializer();
            deSerializer.serialize(object3D, new FileOutputStream("file/lantern.3ds.serial"), true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void zipFu() {
        String fuPath = "file/fu.3ds.serial";
        try {
            FileOutputStream fos = new FileOutputStream("file/fu.3ds.serial.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(fuPath);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static void zipMascot() {
        String mascotPath = "file/mascot2.3ds.serial";
        try {
            FileOutputStream fos = new FileOutputStream("file/mascot2.3ds.serial.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(mascotPath);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private static void zipLantern() {
        String mascotPath = "file/lantern1.3ds.serial";
        try {
            FileOutputStream fos = new FileOutputStream("file/lantern1.3ds.serial.zip");
            ZipOutputStream zipOut = new ZipOutputStream(fos);
            File fileToZip = new File(mascotPath);
            FileInputStream fis = new FileInputStream(fileToZip);
            ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
            zipOut.putNextEntry(zipEntry);
            final byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            zipOut.close();
            fis.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }
}

