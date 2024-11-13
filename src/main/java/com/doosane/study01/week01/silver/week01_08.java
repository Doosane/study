package com.doosane.study01.week01.silver;

import java.util.Scanner;

public class week01_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 배열의 크기 N, M 입력
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 배열 선언 및 초기화
        int[][] A = new int[N + 1][M + 1];
        int[][] P = new int[N + 1][M + 1];

        // 배열 A 입력
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 누적 합 배열 P 생성
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                P[i][j] = A[i][j] + P[i-1][j] + P[i][j-1] - P[i-1][j-1];
            }
        }

        // 합을 구할 부분의 개수 K 입력
        int K = sc.nextInt();

        // 주어진 부분 영역의 합 구하기
        for (int k = 0; k < K; k++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            // 부분 배열의 합 계산하여 출력
            int result = P[x][y] - P[i-1][y] - P[x][j-1] + P[i-1][j-1];
            System.out.println(result);
        }

        sc.close();
    }
}
