package com.doosane.lec.week02;

import java.util.Scanner;
/*
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제
하지만, 오른쪽을 기준으로 정렬한 별(예제 참고)을 출력하시오.
예제 입력 1
5
예제 출력 1
   *
   **
  ***
 ****
*****
 */
public class BOJ2439 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 1; i <= N; i++) {

            for (int j = 0; j <  (N - i); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}

/*
 백준 2439번
 메모리 18532 KB
 시간 288 ms
 */
