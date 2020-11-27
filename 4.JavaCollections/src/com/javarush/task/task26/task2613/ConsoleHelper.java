package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String line = bis.readLine();
            if ("exit".equalsIgnoreCase(line)) {
                throw new InterruptOperationException();
            }
            return line;

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        System.out.println(res.getString("choose.currency.code"));
        String code;
        while (true) {
            code = readString();
            if (code.length() != 3) {
                System.out.println(res.getString("invalid.data"));
                continue;
            } else {
                break;
            }
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String params;
        while (true) {
            System.out.println("Insert nominal and amount");
            params = readString();
            if (params == null || !params.matches("^[1-9]\\d*\\s[1-9]\\d*")) {
                System.out.println(res.getString("choose.denomination.and.count.format"));
                continue;
            } else {
                break;
            }
        }
        return params.split(" ");
    }

    public static Operation askOperation() throws InterruptOperationException {
        System.out.println(res.getString("choose.operation"));
        int operation;
        while (true) {
            operation = Integer.parseInt(readString());
            if (operation == 0) {
                throw new IllegalArgumentException();
            }
            if (operation < 0 || operation > 4) {
                System.out.println(res.getString("invalid.data"));
                continue;
            } else {
                break;
            }
        }
        return Operation.getAllowableOperationByOrdinal(operation);
    }

    public static void printExitMessage() {
        System.out.println("Bye");
    }
}
