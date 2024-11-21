package com.doosane.lec.week02;
import java.util.Scanner;

public class BOJ7726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                matrix[i][j] = sc.nextInt();

        sc.close();

        // 행렬 부분합 계산
        int[][] prefixSum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = matrix[i - 1][j - 1]
                        + prefixSum[i - 1][j]
                        + prefixSum[i][j - 1]
                        - prefixSum[i - 1][j - 1];
            }
        }

        // 최대 부분합 계산
        int result = findMaxSum(prefixSum, N, M, K);

        // 결과 출력
        System.out.println(result);
    }

    static int findMaxSum(int[][] prefixSum, int N, int M, int K) {
        int maxSum = Integer.MIN_VALUE;

        for (int r1 = 0; r1 < N; r1++) {
            for (int c1 = 0; c1 < M; c1++) {
                for (int r2 = r1; r2 < N; r2++) {
                    for (int c2 = c1; c2 < M; c2++) {
                        int submatrixSum = getSubmatrixSum(prefixSum, r1, c1, r2, c2);
                        maxSum = Math.max(maxSum, submatrixSum);
                    }
                }
            }
        }

        // 최대값 반환
        return maxSum;
    }

    // 부분합 계산: 주어진 영역의 합을 계산
    static int getSubmatrixSum(int[][] prefixSum, int r1, int c1, int r2, int c2) {
        return prefixSum[r2 + 1][c2 + 1] -
                prefixSum[r1][c2 + 1] -
                prefixSum[r2 + 1][c1] +
                prefixSum[r1][c1];
    }
}