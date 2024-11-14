package com.doosane.study01.week01.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Week02_02_BOJ_25501 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim()); // 테스트 케이스의 개수

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String S = reader.readLine().trim();
            Result result = isPalindrome(S);
            output.append(result.isPalindrome).append(" ").append(result.callCount).append("\n");
        }

        System.out.print(output.toString()); // 한 번에 출력
    }

    // 재귀 호출 결과
    static class Result {
        int isPalindrome;
        int callCount;

        Result(int isPalindrome, int callCount) {
            this.isPalindrome = isPalindrome;
            this.callCount = callCount;
        }
    }

    // 팰린드롬 검사 함수
    public static Result isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1, 1);
    }

    // 재귀 함수
    public static Result recursion(String s, int l, int r, int count) {
        if (l >= r) {
            return new Result(1, count);
        } else if (s.charAt(l) != s.charAt(r)) {
            return new Result(0, count);
        } else {
            return recursion(s, l + 1, r - 1, count + 1);
        }
    }
}
