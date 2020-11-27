package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName1 = bufferedReader.readLine();
            String fileName2 = bufferedReader.readLine();
            String fileName3 = bufferedReader.readLine();

            FileInputStream inputStream = new FileInputStream(fileName1);
            FileOutputStream outputStream1 = new FileOutputStream(fileName2);
            FileOutputStream outputStream2 = new FileOutputStream(fileName3);

            int count = inputStream.available();

            if(count % 2 == 0) {
                for (int i = 0; i < count / 2; ++i)
                    outputStream1.write(inputStream.read());
            }
            else {
                for(int i = 0; i < count / 2 + 1; ++i)
                    outputStream1.write(inputStream.read());
            }

            while(inputStream.available() > 0)
                outputStream2.write(inputStream.read());

            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        }
        catch (IOException e) {
        }
    }
}
