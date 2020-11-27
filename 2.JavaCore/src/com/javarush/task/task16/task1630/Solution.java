package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);

        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        try {
            f.setFileName(fileName);
        } catch (IOException e) {
            //e.printStackTrace();
        }
        f.start();
        //add your code here - добавьте код тут
        f.join();

        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName) throws IOException;

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName;
        private String fileContent="";

        @Override
        public void setFileName(String fullFileName) throws IOException {
            this.fullFileName = fullFileName;

        }

        @Override
        public String getFileContent() {
            return fileContent;
        }



        @Override
        public void run() {
            try {
                FileReader fileReader = new FileReader(fullFileName);
                Scanner scanner = new Scanner(fileReader);
                while (scanner.hasNextLine()) {
                    if ("".equals(fileContent)) {
                        fileContent = fileContent + scanner.nextLine();
                    } else {
                        fileContent = fileContent + " " + scanner.nextLine();
                    }
                }
                fileReader.close();
            }
            catch (IOException e) {
                //e.printStackTrace();
            }


        }
    }
}
