package com.doosane.lec.week01.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/**
 * 문제 11478
 * 서로 다른 부분 문자열의 개수
 */
public class BOJ11478 {
    public static void main(String[] args) throws IOException {
        // 입력 문자열 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();

        // Set을 사용해서 서로 다른 부분 문자열을 저장
        Set<String> uniqueSubstrings = new HashSet<>();

        // 문자열의 모든 부분 문자열을 찾아서 Set에 추가
        int n = S.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                uniqueSubstrings.add(S.substring(i,j));
            }
        }

        // Set의 크기 = 서로 다른 부분 문자열의 개수
        System.out.println(uniqueSubstrings.size());
    }
}
