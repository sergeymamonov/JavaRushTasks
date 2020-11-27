package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        } else if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();
            BufferedReader readerFile = new BufferedReader(new FileReader(file));
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            int max = 0;
            while (readerFile.ready()) {
                String x = readerFile.readLine().substring(0, 8).trim();
                if (Integer.parseInt(x) > max) max = Integer.parseInt(x);
            }

            String posle = (String.format(System.lineSeparator() + "%-8d%-30s%-8.2f%-4d", max + 1, args[1], Float.parseFloat(args[2]), Integer.parseInt(args[3])));
            writer.write(String.valueOf(posle));
            writer.close();
            readerFile.close();
            reader.close();
        }
    }
}
