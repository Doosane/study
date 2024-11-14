package com.doosane.lec.week02;
/*
BOJ 10818
 */

import java.util.Scanner;

public class Week02_02_BOJ_10818 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 정수의 개수

        int min = Integer.MAX_VALUE; // 최솟값을 저장할 변수
        int max = Integer.MIN_VALUE; // 최댓값을 저장할 변수

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt(); // 정수 입력

            if (num < min) {
                min = num; // 새로운 최솟값
            }

            if (num > max) {
                max = num; // 새로운 최댓값
            }

        }

        System.out.println(min + " " + max); // 최솟값과 최댓값 출력
        sc.close();

    }
}


