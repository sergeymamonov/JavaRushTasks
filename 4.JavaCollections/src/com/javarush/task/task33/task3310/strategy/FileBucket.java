package com.javarush.task.task33.task3310.strategy;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileBucket {
    Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile("tmpFile", ".tmp");
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
        }

        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        long fileSize = 0L;
        try {
            fileSize = Files.size(path);
        } catch (IOException e) {

        }
        return fileSize;
    }

    public void putEntry(Entry entry) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path));
            objectOutputStream.writeObject(entry);
            objectOutputStream.close();
        } catch (IOException e) {

        }
    }

    public Entry getEntry() {
        Entry entry = null;
        if (getFileSize() > 0) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path));
                entry = (Entry) objectInputStream.readObject();
                objectInputStream.close();
            } catch (Exception e) {
            }
        }
        return entry;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {

        }
    }
}
