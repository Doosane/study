package com.doosane.lec.week01.gold;
import java.io.*;

/**
 * 최대 공통 부분 수열 (Longest Common Subsequence, LCS) 문제 해결
 */
public class BOJ17218 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int N = s1.length();
        int M = s2.length();

        // dp 배열 초기화: dp[i][j]는 s1의 첫 i 문자와 s2의 첫 j 문자의 LCS 길이
        int[][] dp = new int[N + 1][M + 1];

        // 동적 계획법으로 dp 배열 채우기
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 문자 일치하면 이전 값에 1을 더함
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 일치하지 않으면 최대값
                }
            }
        }

        // LCS 길이를 추적하며 문자열을 구성
        StringBuilder lcs = new StringBuilder();
        int i = N, j = M;

        while (i > 0 && j > 0) {
            // 일치하는 문자가 있으면 그 문자를 LCS에 추가
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--; // 두 문자열의 인덱스 모두 감소
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                // dp[i-1][j]가 더 크면 s1에서 문자를 하나 줄임
                i--;
            } else {
                // dp[i][j-1]가 더 크면 s2에서 문자를 하나 줄임
                j--;
            }
        }

        // LCS는 뒤에서부터 추적했으므로 문자열을 뒤집어 출력
        System.out.println(lcs.reverse().toString());
    }
}
