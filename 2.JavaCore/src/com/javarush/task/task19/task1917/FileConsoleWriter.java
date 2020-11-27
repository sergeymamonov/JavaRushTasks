package com.javarush.task.task19.task1917;

import java.io.*;

/* 
Свой FileWriter
*/

public class FileConsoleWriter {
    private FileWriter fileWriter;
    private BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out));


    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        consoleWriter.write(cbuf, off, len);
        consoleWriter.flush();
    }

    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        consoleWriter.write(c);
        consoleWriter.flush();
    }

    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        consoleWriter.write(str);
        consoleWriter.flush();
    }

    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        consoleWriter.write(str, off, len);
        consoleWriter.flush();
    }

    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        consoleWriter.write(cbuf);
        consoleWriter.flush();
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }

    public static void main(String[] args) {

    }
}