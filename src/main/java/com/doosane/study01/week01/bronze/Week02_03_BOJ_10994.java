package com.doosane.study01.week01.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week02_03_BOJ_10994 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = n * 4 - 3;
        for(int i = 0 ; i < size; i++) {
            for(int j = 0; j < size; j++) {
                arr[i][j] = ' ';

            }
        }
        drawStar(0 , 0, size);
        printArray(size);
    }
    static void drawStar(int x, int y, int size) {
        if (size < 1) return;
        for(int i = 0 ; i < size; i++ ) {
            arr[x + i][y] = '*';
            arr[x][y + i] = '*';
            arr[x + size - 1][y + i] = '*';
            arr[x + i][y + size - 1] = '*';
        }
        drawStar(x + 2, y + 2, size - 4);
    }
    static void printArray(int size) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size ; i ++) {
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}


