package com.doosane.study01.week01.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 실버
BOJ 10994 번
별찍기 문제
재귀
 */
public class Week02_03_BOJ_10994 {
   static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int size = n * 4 - 3;
        arr = new char[size][size];
        for(int i = 0 ; i < size ; i ++) {
            for(int j = 0; j < size; j++) {
                arr[i][j] = ' ';
            }
        }
        showStar(0, 0, size);
        show(size);
    }

    static void showStar(int x, int y , int size ) {
        if (size < 1) return;
        for (int i = 0 ; i < size; i ++ ) {
            arr[x + i][y] = '*';
            arr[x][y+i] = '*';
            arr[x + size - 1][y + i] = '*';
            arr[x + i][y + size - 1] = '*';
        }
        showStar(x + 2, y + 2 , size - 4);
    }

    static void show(int size) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size;i ++) {
            sb.append(arr[i]);
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}