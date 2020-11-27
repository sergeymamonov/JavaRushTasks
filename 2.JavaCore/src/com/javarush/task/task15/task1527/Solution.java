package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        String[] params;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String url = bufferedReader.readLine();
            String dutyParams = url.substring(url.indexOf("?") + 1);
            params = dutyParams.split("&");

            for (int i = 0; i < params.length; i++) {
                String param = params[i];
                if (param.contains("=")) {
                    String pureParam = param.substring(0, param.indexOf("="));
                    params[i] = pureParam;
                }
            }

            for (String param : params) {
                System.out.print(param + " ");
            }

            System.out.println("\n");

            for (String param : params) {
                if (param.equals("obj")) {
                    String dutyObjValue = dutyParams.substring(dutyParams.indexOf("obj=")+4);
                    String objValue = dutyObjValue.substring(0, dutyObjValue.indexOf("&"));
                    try {
                        Double value = Double.parseDouble(objValue);
                        alert((double)value);
                    }
                    catch (Exception e) {
                        alert(objValue);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
