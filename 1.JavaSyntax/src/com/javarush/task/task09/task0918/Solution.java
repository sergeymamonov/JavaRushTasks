package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import java.io.IOException;
import java.rmi.RemoteException;

public class Solution {
    public static void main(String[] args) {
    }

    static class MyException extends IOException {
    }

    static class MyException2 extends RemoteException {
    }

    static class MyException3 extends NullPointerException {
    }

    static class MyException4 extends RuntimeException{
    }
}

