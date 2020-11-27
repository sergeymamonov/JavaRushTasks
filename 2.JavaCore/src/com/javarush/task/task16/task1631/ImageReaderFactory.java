package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader reader = null;
//        try {
        if(type == null) {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        else {
            switch (type) {
                case BMP:
                    reader = new BmpReader();
                    break;
                case JPG:
                    reader = new JpgReader();
                    break;
                case PNG:
                    reader = new PngReader();
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестный тип картинки");
            }
        }
//        catch (IllegalArgumentException e) {
//            e.printStackTrace();
//        }
        return reader;
    }
}
