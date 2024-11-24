package com.doosane.lec.week01.gold;
import java.io.*;

/**
 * 최대 공통 부분 수열 (Longest Common Subsequence, LCS) 문제 해결
 * 문제 분석 :
 */
public class BOJ17218 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        // LCS 길이를 저장하는 DP 배열을 계산
        int[][] dp = calculateLCSLength(s1, s2);

        // LCS 문자열을 추적하여 결과를 얻기
        String lcs = getLCSString(s1, s2, dp);

        // 결과 출력
        System.out.println(lcs);
    }

    /**
     * 주어진 두 문자열에 대해 LCS의 길이를 계산하는 DP 테이블을 생성
     * @param s1 첫 번째 문자열
     * @param s2 두 번째 문자열
     * @return LCS 길이를 계산한 DP 테이블
     */
    private static int[][] calculateLCSLength(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // 문자 일치하면 이전 값에 1을 더함
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // 일치하지 않으면 최대값
                }
            }
        }
        return dp;
    }

    /**
     * LCS 길이를 추적하여 LCS 문자열을 반환
     * @param s1 첫 번째 문자열
     * @param s2 두 번째 문자열
     * @param dp LCS 길이를 저장한 DP 테이블
     * @return LCS 문자열
     */
    private static String getLCSString(String s1, String s2, int[][] dp) {
        StringBuilder lcs = new StringBuilder();
        int i = s1.length(), j = s2.length();

        // LCS 길이를 추적하며 문자열을 구성
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));  // 일치하면 문자 추가
                i--;  // 두 문자열의 인덱스 모두 감소
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;  // dp[i-1][j]가 더 크면 s1에서 문자를 하나 줄임
            } else {
                j--;  // dp[i][j-1]가 더 크면 s2에서 문자를 하나 줄임
            }
        }

        return lcs.reverse().toString();  // LCS는 뒤에서부터 추적했으므로 뒤집어서 반환
    }
}
