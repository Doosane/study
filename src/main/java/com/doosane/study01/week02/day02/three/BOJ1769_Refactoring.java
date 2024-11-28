package com.doosane.study01.week02.day02.three;

import java.io.*;
public class BOJ1769_Refactoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        sumPrint(X);
    }
    private static void sumPrint(String X) {
        int count = 0;
        while(X.length() > 1) {
            int sum = 0;
            for(int i = 0; i < X.length(); i++ ) {
                sum += Integer.parseInt(Character.toString(X.charAt(i)));
            }
            X = Integer.toString(sum);
            count++;
        }
        printResult(X,count);
    }
    private static void printResult(String X, int count) {
        int result = Integer.parseInt(X);
        if( result  % 3 == 0)
            System.out.println(count + "\n" + "YES");
        else
            System.out.println(count + "\n" + "NO");
    }
}